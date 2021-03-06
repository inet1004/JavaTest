package co.four.grade.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import co.four.grade.dto.GradeDto;
import co.four.grade.serviceImple.GradeServiceImpl;

public class Menu
{
	GradeServiceImpl serviceImpl = new GradeServiceImpl();
	Scanner sc = new Scanner( System.in );
	GradeDto dto;

	/*
	 * 메뉴화면 시작
	 */
	public void start()
	{
		mainMenu();
	}

	private void mainMenu() //박석규
	{
		int choice;
		boolean b = true;
			do {
			System.out.println("=== 성적 관리 ===");
			System.out.println(" 1. 성적 관리 ");
			System.out.println(" 2. 종       료 ");
			System.out.println("=============");
			int n=0;
			do {
				if(n>0) System.out.println("!! 입력 오류입니다. !!");
				System.out.print("작업 번호를 입력하세요. > ");
				choice = sc.nextInt();
				n++;
			} while (choice != 1 && choice != 2);
			sc.nextLine();
			System.out.println();
			System.out.println();
			switch (choice)
			{

			case 1:
				subMenu();
				break;

			case 2:
				b = false;
				System.out.println( "프로그램이 종료 되었습니다." );
				break;

			}

		} while ( b );
	}

	private void subMenu() //박석규
	{
		int choice;
		boolean b = true;
		do {
			System.out.println("=== 성적 작업 ===");
			System.out.println(" 1. 전체 보기 ");
			System.out.println(" 2. 조회 하기 ");			
			System.out.println(" 3. 성적 입력 ");
			System.out.println(" 4. 성적 수정 ");
			System.out.println(" 5. 성적 삭제 ");
			System.out.println(" 6. 홈으로 가기 ");
			System.out.println("=============");
			int n=0;
			do {
				if(n>0) System.out.println("!! 입력 오류입니다. !!");
				System.out.print("작업 번호를 입력하세요. > ");
				choice = sc.nextInt();
				n++;
			} while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6);

			
			sc.nextLine();
			System.out.println();
			System.out.println();

			switch (choice) {
			case 1:
				
				allSelect();
				break;

			case 2:
				allSelect();
				selectGrade();
				break;

			case 3:
				allSelect();
				insertGrade();
				break;

			case 4:
				allSelect();
				modifyGrade();
				break;

			case 5:
				allSelect();
				deleteGrade();
				break;

			case 6:
				b = false;
				break;

			}
		} while (b);
	}

	/*
	 * Grade테이블의 내용 전부다 출력
	 */
	private void allSelect() //서장원
	{
		List<GradeDto> list = serviceImpl.allSelect();

		if( list.size() < 1 )
		{
			System.out.println( "성적 정보가 없습니다" );
		} else
		{
			System.out.println("=============================Grade 목록===================================");
			for( GradeDto dto : list )
			{
				System.out.printf( "Grade_id : %d, Student_id : %s, Subject_id : %s, Student_grade : %s\n",
						dto.getGrade_id(), dto.getStudent_id(), dto.getSubject_id(), dto.getStudent_grade() );
			}
			System.out.println("=========================================================================");
			
		}
	}

	/*
	 * DB에 데이터를 추가하는 메소드
	 */
	private void insertGrade()
	{
		// TODO : 김지애씨 작업부분

		dto = new GradeDto();
		do
		{
			System.out.print( "성적번호를 입력해주세요 > " );
			dto.setGrade_id( sc.nextInt() );
			sc.nextLine();
			boolean b = serviceImpl.isCheckId( dto.getGrade_id() );
			if( !b )
			{
				System.out.println( "이미 존재하는 번호 입니다." );
			} else
			{
				System.out.println( "입력한 번호는 사용가능한 번호 입니다." );
				break;
			}
		} while ( true );
		System.out.print( "학번을 입력하세요 > " );
		dto.setStudent_id( sc.nextLine() );
		System.out.print( "학과 코드를 입력하세요 > " );
		dto.setSubject_id( sc.nextLine() );
		System.out.print( "성적을 입력하세요 > " );
		dto.setStudent_grade( sc.nextLine() );
		int n = serviceImpl.insert( dto );
		if( n != 0 )
		{
			System.out.println( "정상적으로 입력되었습니다." );
			allSelect();
		} else
			System.out.println( "입력이 실패했습니다." );
	}

	/*
	 * DB에 데이터를 수정하는 메소드
	 */
	private void modifyGrade()
	{
		// TODO : 서장원씨 작업부분
		int gradeID = 0;
		while ( true )
		{
			try
			{

				System.out.print( "수정할 성적의 ID를 입력하세요 > " );
				gradeID = sc.nextInt();
				sc.nextLine();
				break;
			} catch ( InputMismatchException e )
			{
				sc.nextLine();
				System.out.println( "잘못 입력된 데이터 입니다. 숫자를 입력해주세요 " );
			}

		}

		String grade;
		while ( true )
		{
			System.out.print( "수정할 성적을 입력하세요(A, B, C, D, F) > " );
			grade = sc.nextLine();
			grade = grade.toUpperCase();
			if( isAvailableModifyData( grade ) )
			{
				break;
			}

			System.out.println( "잘못된 성적 값을 입력하셨습니다" );
		}
		GradeDto dto = new GradeDto();
		dto.setGrade_id( gradeID );
		dto.setStudent_grade( grade );

		int result = serviceImpl.update( dto );

		if( result != 0 )
		{
			System.out.println( "데이터 수정 성공" );
		} else
		{
			System.out.println( "데이터 수정 실패" );
		}

	}

	/*
	 * DB에 데이터를 삭제하는 메소드
	 */
	private void deleteGrade()
	{
		// TODO : 박석규씨 작업부분
		while (true) {
			dto = new GradeDto();
			GradeDto dto = new GradeDto();
			System.out.print("삭제할 Grade_id를 입력하세요 > " );
			
			dto.setGrade_id(sc.nextInt());
			sc.nextLine();
			int n = serviceImpl.delete(dto);
			if (n > 0) {
				serviceImpl.delete(dto);
				allSelect();
				System.out.println("삭제가 완료되었습니다.");
				System.out.println("메뉴로 가실려면 엔터를 누르세요.");
				sc.nextLine();
//				dto.toString();
				break;
			} else {
				System.out.println("입력한 번호는 사용 불가능한 번호 입니다.");
				System.out.println("메뉴로 가실려면 엔터를 누르세요.");
				sc.nextLine();
				break;
			}
		}
	}

	/*
	 * DB에 데이터를 조회하는 메소드
	 */
	private void selectGrade()
	{
		// TODO : 김민석씨 작업부분
		
		GradeDto dto = new GradeDto();
		System.out.print("검색할 성적 번호를 입력하세요 > ");
		dto.setGrade_id(sc.nextInt());
		sc.nextLine();
		dto = serviceImpl.select(dto);
		
		System.out.println();
		System.out.println("===========================검색 결과=============================");
		System.out.print( "grade_id : "+dto.getGrade_id() + " " );
		System.out.print( "student_id : "+dto.getStudent_id() + " " );
		System.out.print( "student_name : "+dto.getStudent_name() + " " );
		System.out.println( "subject_name : "+dto.getSubject_name() + " " );
		System.out.println("===============================================================");
	}

	private boolean isAvailableModifyData(String grade) //서장원
	{
		if( grade == null || !grade.equals( "A" ) && !grade.equals( "B" ) && !grade.equals( "C" )
				&& !grade.equals( "D" ) && !grade.equals( "F" ) )
			return false;

		return true;
	}
	
	
}
