//Create a java application for Hospital management system using list.
//Doctor class contains :(DocID int, Dname string, email string, Degree string, joining_date sdf, salary double, experience int, 
//Department: enum(ORTHO, PEDIATRICS, PHYSIIOTHEROPY, GASTROLOGY)
//Accept at least 5 Doctor details from user (add joining date after 10 May 2001)
//Store n restore above Doctor Class details in a bin file using object streams.
//Supply following options
//BUT none of the options should be available before login
//Credentials For user: admin, admin
//Date of joining should be after 10 May 2001. (Perform custom exception handling)
//•SIGN IN
//•Add a new Doctor record in collection.
//•Display name of specified Doctor from list of Doctors having highest salary.
//•Sort all doctor details on the basis of experience
//•Search all Doctors who are Orthopedics.
//•Exit from application.

package com.code;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Doctor implements Serializable{
//	Doctor entity
//	DocName
//	Age
//	Contact_no
//	Dept_no,  spealization
//	Address

private int DoctorId;
private String passCode;
private String DoctorName;
private String email;
private String degree;
private LocalDate dateOfJoining;
private int experience;
private double salary;
private Department dept;
private int age;
private String ContactNumber;
private int deptNumber;
private String address;
public Doctor(int doctorId,String passCode, String doctorName, String email, String degree, LocalDate dateOfJoining, double salary,
		Department dept, int age, String contactNumber, String address) {
	super();
	DoctorId = doctorId;
	this.passCode=passCode;
	DoctorName = doctorName;
	this.email = email;
	this.degree = degree;
	this.dateOfJoining = dateOfJoining;
	this.experience=Period.between(dateOfJoining , LocalDate.now()).getYears();
	this.salary = salary;
	this.dept = dept;
	this.age = age;
	ContactNumber = contactNumber;
	this.deptNumber = dept.getDeptNumber();
	this.address = address;
	
}
public Doctor(int docId) {
	this.DoctorId=docId;
}
public Doctor(String email) {
	this.email=email;
}
public int getExperience() {
	return experience;
}
public void setExperience(int experience) {
	this.experience = experience;
}
public String getPassCode() {
	return passCode;
}
public void setPassCode(String passCode) {
	this.passCode = passCode;
}

@Override
public boolean equals(Object obj) {
	if(obj instanceof Doctor)
		return this.DoctorId==((Doctor)obj).DoctorId;
		
	return false;
	
}

@Override
public String toString() {
	return "Doctor [DoctorId=" + DoctorId + "Pass code="+passCode+", DoctorName=" + DoctorName + ", email=" + email + ", degree=" + degree
			+ ", dateOfJoining=" + dateOfJoining + "Experience=" + experience + ", salary=" + salary + ", dept=" + dept + ", age=" + age
			+ ", ContactNumber=" + ContactNumber + ", deptNumber=" + deptNumber +", address=" + address + "]\n";
}
public int getDoctorId() {
	return DoctorId;
}
public String getDoctorName() {
	return DoctorName;
}
public String getEmail() {
	return email;
}
public String getDegree() {
	return degree;
}
public LocalDate getDateOfJoining() {
	return dateOfJoining;
}
public double getSalary() {
	return salary;
}
public Department getDept() {
	return dept;
}
public int getAge() {
	return age;
}
public String getContactNumber() {
	return ContactNumber;
}
public int getDeptNumber() {
	return deptNumber;
}

public String getAddress() {
	return address;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public void setDeptNumber(int deptNumber) {
	this.deptNumber = deptNumber;
}
public void setAddress(String address) {
	this.address = address;
}






}
