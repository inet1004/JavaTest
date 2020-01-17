package co.four.grade.service;

import java.util.List;

import co.four.grade.dto.GradeDto;

public interface Service{

	public List<GradeDto> allSelect();

	public GradeDto select(GradeDto dto);

	public int insert(GradeDto dto);

	public int update(GradeDto dto);

	public int delete(GradeDto dto);
}
