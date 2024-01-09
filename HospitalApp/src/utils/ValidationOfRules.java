package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.code.Department;
import com.code.Doctor;

import CustomException.DoctorCustomException;

public class ValidationOfRules {
	
	
	public static Department validateDepartment(String d) {
		return Department.valueOf(d.toUpperCase());
	}

	
	public static Doctor signIn(int docId,String passCode ,List<Doctor>newList) throws DoctorCustomException {
	Doctor newDoctor = new Doctor(docId);
	int index = newList.indexOf(newDoctor);
	if(index != -1) {
		if(passCode.equals((newList.get(index)).getPassCode()))
			return newDoctor;
		else throw new DoctorCustomException("Wrong passcode !!");
	}
	else throw new DoctorCustomException("Invalid Id");
	}
	
	public static Doctor checkForDuplicateDocId(int docId,String passCode ,List<Doctor>newList) throws DoctorCustomException {
		Doctor newDoc = new Doctor(docId);
		int i = newList.indexOf(newDoc);
		if(i != -1)
			throw new DoctorCustomException("You cant have duplicate id !!");
		else 
			return newDoc;

	}
	
	public static void validateContactNumber(String number) throws DoctorCustomException {
		if(!number.matches("^[0-9]{10}$"))
			throw new DoctorCustomException("Contact number should be 10 digits number only !!");
	}
	
	public static void checkForDuplicateEmail(String email, List<Doctor>docList) throws DoctorCustomException {
		Doctor doc = new Doctor(email);
		int index = docList.indexOf(doc);
		if(index != -1)
			 throw new DoctorCustomException("You cant have duplicate email id !!");
	}

	
	public static Doctor validateAllInputs(int doctorId,String passCode, String doctorName, String email, String degree, LocalDate dateOfJoining, double salary,
		String dept, int age, String contactNumber, String address,List<Doctor>newList) throws DoctorCustomException {
		Department newDept =validateDepartment(dept);
	    checkForDuplicateDocId(doctorId,passCode,newList);
	    validateContactNumber(contactNumber);
	    checkForDuplicateEmail(email,newList);
		return new Doctor(doctorId,passCode,doctorName,email,degree,dateOfJoining,salary,newDept,age,contactNumber,address);
		}
	
}


//7 priyesh123 priyesh priyesh123@gmail.com MBBS 2008 10 02 200000 ORTHO 28 1726354876 10 karad
