package co.four.grade.serviceImple;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.four.grade.dto.GradeDto;
import co.four.grade.service.DAO;
import co.four.grade.service.Service;

public class GradeServiceImpl extends DAO implements Service
{
	
	final String ALL_SELECT = "SELECT * FROM GRADE";
	
	@Override
	public List<GradeDto> allSelect()
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
		return null;
	}

	@Override
	public int insert(GradeDto dto)
	{
		//TODO : 김지애씨 작업부분
		return 0;
	}

	@Override
	public int update(GradeDto dto)
	{
		//TODO : 서장원씨 작업부분
		return 0;
	}

	@Override
	public int delete(GradeDto dto)
	{
		//TODO 박석규씨 작업부분
		return 0;
	}

}
