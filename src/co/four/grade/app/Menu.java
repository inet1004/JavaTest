package co.four.grade.app;

import java.sql.SQLException;
import java.util.List;

import co.four.grade.dto.GradeDto;
import co.four.grade.serviceImple.GradeServiceImpl;

public class Menu
{
	GradeServiceImpl serviceImpl = new GradeServiceImpl();
	
	/*
	 * 메뉴화면 시작
	 */
	public void start() {
		
		mainMenu();
		
	}
	
	private void mainMenu() {
		
	}
	
	private void subMenu() {
		
	}
	
	/*
	 * Grade테이블의 내용 전부다 출력
	 */
	private void allSelect() {
		List<GradeDto> list = serviceImpl.allSelect();
		for(GradeDto dto : list) {
			System.out.printf( "Grade_id : %d, Student_id : %s, Subject_id : %s, Student_grade : %s\n",
					dto.getGrade_id(), dto.getStudent_id(), dto.getSubject_id(), dto.getStudent_grade() );
		}
	}
	
	/*
	 * DB에 데이터를 추가하는 메소드
	 */
	private void insertGrade() {
		//TODO : 김지애씨 작업부분
	}
	
	/*
	 * DB에 데이터를 수정하는 메소드
	 */
	private void modifyGrade() {
		//TODO : 서장원씨 작업부분
	}
	
	/*
	 * DB에 데이터를 삭제하는 메소드
	 */
	private void deleteGrade() {
		//TODO : 박석규씨 작업부분
	}
	
	/*
	 * DB에 데이터를 조회하는 메소드
	 */
	private void selectGrade() {
		//TODO : 김민석씨 작업부분
	}
}
