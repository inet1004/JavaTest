package co.four.grade.serviceImple;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.four.grade.dto.GradeDto;
import co.four.grade.service.DAO;
import co.four.grade.service.Service;

public class GradeServiceImpl extends DAO implements Service
{
	
	private final String ALL_SELECT = "SELECT * FROM GRADE";
	private final String UPDATE = "UPDATE GRADE SET student_grade = ? WHERE grade_id = ?";
	private final String DELETE = "DELETE FROM GRADE WHERE GRADE_ID = ?";  //박석규
	private final String INSERT = "INSERT INTO GRADE (GRADE_ID, STUDENT_ID, SUBJECT_ID, STUDENT_GRADE) " 
			+ "VALUES (?, ?, ?, ?)";
	private final String SELECT = "select grade.grade_id, grade.student_id, student.student_name, subject.subject_name, student_grade " + 
			"from grade " + 
			"join student on grade.student_id = student.student_id " + 
			"join subject on grade.subject_id = subject.subject_code " + 
			"where grade.grade_id = ?";
	@Override
	public List<GradeDto> allSelect() //서장원
	{
		List<GradeDto> list = new ArrayList<GradeDto>();
		try
		{
			psmt = conn.prepareStatement( ALL_SELECT );
			rs = psmt.executeQuery();
			GradeDto dto;
			while( rs.next() ) {
				dto = new GradeDto();
				dto.setGrade_id( rs.getInt( "grade_id" ));
				dto.setStudent_id( rs.getString( "student_id" ) );
				dto.setSubject_id( rs.getString( "subject_id" ) );
				dto.setStudent_grade(rs.getString( "student_grade" ));
				
				list.add( dto );
			}
			
		} catch ( SQLException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return list;
	}

	
	@Override
	public GradeDto select(GradeDto dto)
	{
		//TODO :김민석씨 작업부분
		try {
			psmt = conn.prepareStatement(SELECT);
			psmt.setInt(1, dto.getGrade_id());
			rs = psmt.executeQuery();
			dto = new GradeDto();
			if(rs.next()) {
				dto.setGrade_id(rs.getInt( "grade_id" ));
				dto.setStudent_id(rs.getString("student_id"));
				dto.setStudent_name(rs.getString("student_name"));
				dto.setSubject_name(rs.getString("subject_name"));
				dto.setStudent_grade(rs.getString("student_grade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insert(GradeDto dto)
	{
		//TODO : 김지애씨 작업부분
		int n = 0;
		try {
			psmt = conn.prepareStatement(INSERT);
			psmt.setInt(1, dto.getGrade_id());
			psmt.setString(2, dto.getStudent_id());
			psmt.setString(3, dto.getSubject_id());
			psmt.setString(4, dto.getStudent_grade());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int update(GradeDto dto)
	{
		
		//TODO : 서장원씨 작업부분
		int n = 0;
		try
		{
			psmt = conn.prepareStatement( UPDATE );
			psmt.setString(1, dto.getStudent_grade());
			psmt.setInt( 2,  dto.getGrade_id() );
			n = psmt.executeUpdate();	
		} catch ( SQLException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int delete(GradeDto dto)
	{
		//TODO 박석규씨 작업부분
		int n = 0;
		try {
			psmt = conn.prepareStatement(DELETE);
			psmt.setInt(1, dto.getGrade_id());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	

	public boolean isCheckId(int id) { 	//김지애
		boolean b = true;
		String sql = "SELECT * FROM GRADE WHERE GRADE_ID = ?";
		try {
	         psmt = conn.prepareStatement(sql);
	         psmt.setInt(1, id);
	         rs = psmt.executeQuery();
	         if (rs.next())
	            b = false;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
		return b;
		
	}

}
