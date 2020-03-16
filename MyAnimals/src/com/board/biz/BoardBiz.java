package com.board.biz;

import java.util.List;

import com.board.dao.BoardDao;
import com.board.dto.BoardDto;
import com.board.dto.PagingDto;

public class BoardBiz {
	
	private BoardDao dao = new BoardDao();

	public List<BoardDto> selectList(PagingDto dto) {
		
		int page = dto.getPage();
		int rows = dto.getRows();
		
		int to = rows*(page-1)+1;
		int from = rows*page;
		return dao.selectList(to,from);
	}

	public BoardDto selectOne(int boardno) {
		this.updateHit(boardno);
		return dao.selectOne(boardno);
	}

	public int insert(BoardDto dto) {
		return dao.insert(dto);
	}

	public int update(BoardDto dto) {

		return dao.update(dto);
	}

	public int delete(int boardno) {
		return dao.delete(boardno);
	}
	
	

	public int insert_answer(BoardDto dto) {
		
		int updateRes = dao.answerUpdate(dto.getBoard_seq());
		int insertRes = dao.answerInsert(dto);
		System.out.println(updateRes);
		System.out.println(insertRes);

		return updateRes + insertRes;
	}

	public int updateHit(int boardno) {

		return dao.updateHit(boardno);
	}
	
	public int totalPage(int rows) {
		
		int totalpage= (int)Math.ceil((double)dao.totalPage()/rows);
		System.out.println(totalpage);
		
		return totalpage;
	}

}
