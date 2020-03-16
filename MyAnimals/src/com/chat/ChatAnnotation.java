/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.chat;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;


@ServerEndpoint(value = "/websocket/chat")
public class ChatAnnotation {
	
	// WebSocket Servlet을 생성하면 @onOpen, @onClose, @onMessage, @onError 4개의 메소드를 구현해줘야 한다.

    private static final Log log = LogFactory.getLog(ChatAnnotation.class);
    
    // 아이디 설정
    private static final String GUEST_PREFIX = "번째 손님이 ";
    // 번호 설정
    private static final AtomicInteger connectionIds = new AtomicInteger(1);
    // Set객체로 접속자 관리
    private static final Set<ChatAnnotation> connections =
            new CopyOnWriteArraySet<>();

    private final String nickname;
    private Session session;

    public ChatAnnotation() {
    	// nickname을 내가 설정한 이름과 번호로 설정해서 구분짓는다.
        nickname = connectionIds.getAndIncrement() + GUEST_PREFIX;
    }


    // session이 열렸을 때 connections(Set)에 추가하고 화면에 메세지 보내기
    @OnOpen
    public void start(Session session) {
        this.session = session;
        connections.add(this);
        String message = String.format("* %s %s", nickname, "입장하셨습니다.");
        broadcast(message);
    }


    // session이 닫혔을 때 connections(Set)에서 제거하고 화면에 메세지 보내기
    @OnClose
    public void end() {
        connections.remove(this);
        String message = String.format("* %s %s",
                nickname, "퇴장하셨습니다.");
        broadcast(message);
    }


    // Client에서 메세지를 보냈을 때 해당 메세지가 올바른지 filter를 사용해서 유효성 검사 하기
    @OnMessage
    public void incoming(String message) {
        // Never trust the client (절대 client를 믿지마라)
        String filteredMessage = String.format("%s",
                HTMLFilter.filter(message.toString()));
        broadcast(filteredMessage);
    }



    // Error가 발생했을 때 해당 에러에 대한 메세지를 보내기
    @OnError
    public void onError(Throwable t) throws Throwable {
        log.error("Chat Error: " + t.toString(), t);
    }


    // connections(Set)객체에 들어있는 접속자들 모두에게 동기화(sunchronized)하면서 메세지 보내기
    // try/catch로 메세지를 보내는 과정에서 오류가 발생하면 해당 client를 connections(Set)객체에서 제거하고
    // 해당 client의 session(접속)을 닫는다.
    private static void broadcast(String msg) {
        for (ChatAnnotation client : connections) {
            try {
                synchronized (client) {
                    client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
                log.debug("Chat Error: Failed to send message to client", e);
                connections.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                    // Ignore
                }
                String message = String.format("* %s %s",
                        client.nickname, "has been disconnected.");
                broadcast(message);
            }
        }
    }
}
