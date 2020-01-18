package co.four.grade.dto;


public class GradeDto{ //서장원
	
	private int grade_id;
	private String student_id;
	private String student_name;
	private String subject_id;
	private String subject_name;
	private String student_grade;

	public GradeDto() {
		
	}

	public int getGrade_id()
	{
		return grade_id;
	}

	public void setGrade_id(int grade_id)
	{
		this.grade_id = grade_id;
	}

	public String getStudent_id()
	{
		return student_id;
	}

	public void setStudent_id(String student_id)
	{
		this.student_id = student_id;
	}

	public String getStudent_name()
	{
		return student_name;
	}

	public void setStudent_name(String student_name)
	{
		this.student_name = student_name;
	}

	public String getSubject_id()
	{
		return subject_id;
	}

	public void setSubject_id(String subject_id)
	{
		this.subject_id = subject_id;
	}

	public String getSubject_name()
	{
		return subject_name;
	}

	public void setSubject_name(String subject_name)
	{
		this.subject_name = subject_name;
	}

	public String getStudent_grade()
	{
		return student_grade;
	}

	public void setStudent_grade(String student_grade)
	{
		this.student_grade = student_grade;
	}

	
	
	
}
