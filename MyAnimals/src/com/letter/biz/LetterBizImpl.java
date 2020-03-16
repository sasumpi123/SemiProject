package com.letter.biz;

import java.util.List;

import com.letter.dao.LetterDao;
import com.letter.dao.LetterDaoImpl;
import com.letter.dto.LetterDto;

public class LetterBizImpl implements LetterBiz {
	
	private LetterDao dao = new LetterDaoImpl();

	@Override
	public List<LetterDto> sendList(String id) {
		// TODO Auto-generated method stub
		return dao.sendList(id);
	}

	@Override
	public List<LetterDto> receiveList(String id) {
		// TODO Auto-generated method stub
		return dao.receiveList(id);
	}

	@Override
	public LetterDto selectOne(String id, int seq) {
		int res = dao.letter_read(id, seq);
		if(res > 0) {
			return dao.selectOne(id, seq);			
		} else {
			return null;
		}
	}

	@Override
	public int insert_letter(LetterDto dto) {
		// TODO Auto-generated method stub
		return dao.insert_letter(dto);
	}

	@Override
	public int delete_letter(String id, String[] seqs) {
		// TODO Auto-generated method stub
		return dao.delete_letter(id, seqs);
	}

}
