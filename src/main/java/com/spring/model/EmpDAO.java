package com.spring.model;

import java.util.List;

/*
 * EmpDAO 인터페이스 특징
 * 1. 호출하는 클래스오 실제 DB에 접근하는 구현 클래스와의 직접적인 의존관계를 느슨하게 하기 위해서 인터페이스를 사용함.
 * 2.DB 검색 목록을 호출하는 메서드는 List(EmpDTO) 타입으로 리턴받게 함.
 * 3.DB 접근을 위해서 관련 예외를 던진다.
 */

public interface EmpDAO {
	List<EmpDTO> getEmpList();			 //전체 리스트 추상 메서드
	EmpDTO empCont(int empno); 		//상세내역 조회 추상 메서드
	int empInsert(EmpDTO dto); 			//사원을 등록하는 추상 메서드
	int empUpdate(EmpDTO dto);			//시ㅏ월의 정보를 수정하는 추상 메서드.
	int empDelete(int empno);					//사유ㅓㅗㄴ읗 emp테이블에서 삭제하는 추상 메서드.
	
	
	
}
