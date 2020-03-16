package com.reply.biz;

import java.util.List;

import com.reply.dao.ReplyDao;
import com.reply.dto.ReplyDto;

public class ReplyBiz {
	private ReplyDao dao = new ReplyDao();

	public List<ReplyDto> selectList(int board_seq) {

		return dao.selectList(board_seq);
	}

	

	public int insert(ReplyDto dto) {

		return dao.insert(dto);
	}

	public int update(ReplyDto dto) {

		return dao.update(dto);
	}

	public int delete(int reply_seq) {

		return dao.delete(reply_seq);
	}

}
