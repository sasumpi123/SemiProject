package com.letter.biz;

import java.util.List;

import com.letter.dto.LetterDto;

public interface LetterBiz {
	
	// 받은쪽지(받은사람에  member_id)
	public List<LetterDto> sendList(String id);
	// 보낸쪽지(보낸사람에 member_id)
	public List<LetterDto> receiveList(String id);
	// 쪽지 상세정보(Letter_Read를 'Y'로 update)
	public LetterDto selectOne(String id, int seq);
	// 쪽지 작성
	public int insert_letter(LetterDto dto);
	// 쪽지 삭제
	public int delete_letter(String id, String[] seqs);

}
