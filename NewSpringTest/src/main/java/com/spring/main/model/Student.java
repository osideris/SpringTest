package com.spring.main.model;

public class Student {
	private int SchoolYr;
    private String Campus;
    private int StudentID;
    private String EntryDate;
    private int GradeLevel;
    private String Name;
    
    public Student() {
    	
    }

	public Student(int schoolYr, String campus, int studentID, String entryDate, int gradeLevel, String name) {
		this.SchoolYr = schoolYr;
		this.Campus = campus;
		this.StudentID = studentID;
		this.EntryDate = entryDate;
		this.GradeLevel = gradeLevel;
		this.Name = name;
	}

	public int getSchoolYr() {
		return SchoolYr;
	}

	public void setSchoolYr(int schoolYr) {
		SchoolYr = schoolYr;
	}

	public String getCampus() {
		return Campus;
	}

	public void setCampus(String campus) {
		Campus = campus;
	}

	public int getStudentID() {
		return StudentID;
	}

	public void setStudentID(int studentID) {
		StudentID = studentID;
	}

	public String getEntryDate() {
		return EntryDate;
	}

	public void setEntryDate(String entryDate) {
		EntryDate = entryDate;
	}

	public int getGradeLevel() {
		return GradeLevel;
	}

	public void setGradeLevel(int gradeLevel) {
		GradeLevel = gradeLevel;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
    
    

}