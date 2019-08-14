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
	
	/**
	 * 로그인
	 */
	@Test
	void test2() {
		memberDTO dto = dao.select(new memberDTO(null, "테스트", "테스트"));
		System.out.println(dto);
	}

}
