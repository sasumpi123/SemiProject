package com.animalinfo.dao;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class AnimalinfoDaoImpl implements AnimalinfoDao {
	static String key = "ServiceKey=sYdjwrDlfLUG1ag8cyB1pWEn342MlpcTgWfkGV5VHMiNAGDeomSaVE78iAKPxUZxe5PyDaLTL00DT0v728aUtQ%3D%3D";
	// 시도 별 유기동물수
	@Override
	public Map<String, Integer> selectLoactionAll() {

		Map<String, Integer> map = new HashMap<>();

		BufferedReader br = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		try {
			String http = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?";
			URL url = new URL(http + "numOfRows=" + 9854 + "&" + key);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
			String result = "";
			String line;

			while (((line = br.readLine()) != null)) {
				result += line.trim();
			}
			InputSource is = new InputSource(new StringReader(result));

			builder = factory.newDocumentBuilder();
			doc = builder.parse(is);
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expr = xpath.compile("//items/item");
			NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				NodeList child = nodeList.item(i).getChildNodes();

				for (int j = 0; j < child.getLength(); j++) {
					Node node = child.item(j);
					// xml데이터를 탐색하면서 원하는 값에 해당하는 데이터들을 dto담는다
					if (node.getNodeName().equals("orgNm")) {
						String res[] = node.getTextContent().split(" ");
						if (map.containsKey(res[0]) == false) {
							map.put(res[0], 1);
						} else {
							map.put(res[0], map.get(res[0]) + 1);
						}
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return map;
	}
	// 구군 별 유기동물 수
	@Override
	public Map<String, Integer> selectLocation(String sido) {

		int locationNumber = LocationData.sidoNumber(sido);
		Map<String, Integer> map = new HashMap<>();
		BufferedReader br = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		try {
			String http = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?upr_cd=";
			URL url = new URL(http + locationNumber + "&numOfRows=" + 10000 + "&" + key);

			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();

			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
			String result = "";
			String line;

			while (((line = br.readLine()) != null)) {
				result += line.trim();
			}

			InputSource is = new InputSource(new StringReader(result));

			builder = factory.newDocumentBuilder();
			doc = builder.parse(is);
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expr = xpath.compile("//items/item");
			NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			System.out.println(nodeList.getLength());
			for (int i = 0; i < nodeList.getLength(); i++) {
				NodeList child = nodeList.item(i).getChildNodes();
				for (int j = 0; j < child.getLength(); j++) {
					Node node = child.item(j);
					// xml데이터를 탐색하면서 원하는 값에 해당하는 데이터들을 dto담는다
					if (node.getNodeName().equals("orgNm")) {
						String res[] = node.getTextContent().split(" ");
						if (map.containsKey(res[1]) == false) {
							map.put(res[1], 1);
						} else {
							map.put(res[1], map.get(res[1]) + 1);
						}
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return map;
	}
	// 종 별 유기동물 수
	@Override
	public Map<String, Integer> selectKindAll() {
		BufferedReader br = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		Map<String, Integer> map = new HashMap<>();
		try {
			String http = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?";
			URL url = new URL(http + "numOfRows=" + 10000 + "&" + key);

			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();

			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
			String result = "";
			String line;

			while (((line = br.readLine()) != null)) {
				result += line.trim();
			}

			InputSource is = new InputSource(new StringReader(result));

			builder = factory.newDocumentBuilder();
			doc = builder.parse(is);
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expr = xpath.compile("//items/item");
			NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				NodeList child = nodeList.item(i).getChildNodes();

				for (int j = 0; j < child.getLength(); j++) {
					Node node = child.item(j);
					// xml데이터를 탐색하면서 원하는 값에 해당하는 데이터들을 dto담는다

					if (node.getNodeName().equals("kindCd")) {
						String res[] = node.getTextContent().split(" ");
						
						if (map.containsKey(res[0]) == false) {
							map.put(res[0], 1);
						} else {
							map.put(res[0], map.get(res[0]) + 1);
						}
					}

				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return map;
	}

	// 고양이 / 개 / 기타 별 유기동물 수
	@Override
	public Map<String, Integer> selectKindAnimal(String kind) {
		int upkind = LocationData.getKindUp(kind);
		BufferedReader br = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		Map<String, Integer> map = new HashMap<>();
		try {
			String http = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?";
			URL url = new URL(http + "upkind=" + upkind + "&numOfRows=" + 10000 + "&" + key);

			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();

			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
			String result = "";
			String line;

			while (((line = br.readLine()) != null)) {
				result += line.trim();
			}

			InputSource is = new InputSource(new StringReader(result));

			builder = factory.newDocumentBuilder();
			doc = builder.parse(is);
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expr = xpath.compile("//items/item");
			NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				NodeList child = nodeList.item(i).getChildNodes();

				for (int j = 0; j < child.getLength(); j++) {
					Node node = child.item(j);
					// xml데이터를 탐색하면서 원하는 값에 해당하는 데이터들을 dto담는다
					if (node.getNodeName().equals("kindCd")) {
						String res[] = node.getTextContent().split(" ");
						
						if (map.containsKey(res[1]) == false) {
							map.put(res[1], 1);
						} else {
							map.put(res[1], map.get(res[1]) + 1);
						}
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return map;
	}

	// 유기 상태 별 동물 수
	@Override
	public Map<String, Integer> selectState() {
		Map<String, Integer> map = new HashMap<>();

		BufferedReader br = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		try {
			String http = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?";
			URL url = new URL(http + "numOfRows=" + 9854 + "&" + key);

			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();

			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
			String result = "";
			String line;

			while (((line = br.readLine()) != null)) {
				result += line.trim();
			}

			InputSource is = new InputSource(new StringReader(result));

			builder = factory.newDocumentBuilder();
			doc = builder.parse(is);
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expr = xpath.compile("//items/item");
			NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				NodeList child = nodeList.item(i).getChildNodes();

				for (int j = 0; j < child.getLength(); j++) {
					Node node = child.item(j);
					// xml데이터를 탐색하면서 원하는 값에 해당하는 데이터들을 dto담는다
					if (node.getNodeName().equals("processState")) {
						if (map.containsKey(node.getTextContent()) == false) {
							map.put(node.getTextContent(), 1);
						} else {
							map.put(node.getTextContent(), map.get(node.getTextContent()) + 1);
						}
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return map;
	}

}