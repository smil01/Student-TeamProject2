package main.member.jUnit;

import org.junit.jupiter.api.Test;

import main.member.DAO.memberDAO;
import main.member.DTO.memberDTO;

class memberTest {

	memberDAO dao = memberDAO.getDao();
	
	/**
	 * 회원가입
	 */
	@Test
	void test() {
		dao.insert(new memberDTO("test", "test", "test")); // 중복 주의
	}
	
	

}
