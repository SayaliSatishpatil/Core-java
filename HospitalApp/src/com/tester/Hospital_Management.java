package com.tester;
import java.time.LocalDate;
import java.util.*;

import com.code.Department;
import com.code.Doctor;
import static utils.DataAdding.populateDoctors;
import static utils.ValidationOfRules.validateAllInputs;
import static utils.ValidationOfRules.signIn;
import static utils.DoctorListUtils.orthopedicsDoctors;
import static utils.DoctorListUtils.highestPaidDoctor;
import static utils.DoctorListUtils.sortOnExperience;
import static utils.IOUtils.storeDetails;
import static utils.IOUtils.reStoreDetails;
import static utils.IOUtils.reStoreDeatailsInBinary;
import static utils.IOUtils.storeDetailsInBinary;

public class Hospital_Management {

	public static void main(String[] args) {
try(Scanner sc = new Scanner(System.in)){
	int ch;
	List<Doctor>doctorList=populateDoctors();
	System.out.println("Enter your choice from following : ");
do {
	System.out.println("\n1.SIGN IN\n"
			+ "2.Add a new Doctor record in collection.\n"
			+ "3.Display name of specified Doctor from list of Doctors having highest salary.\n"
			+ "4.Sort all doctor details on the basis of experience\n"
			+ "5.Search all Doctors who are Orthopedics.\n"
			+ "6.display data\n"
			+ "7.Store data into a file\n"
			+ "8.re-store data from file\n"
			+ "9.Store data into a file in binary form\n"
			+ "10.re-Store data from a binary file\\n"
			+ "0.Exit from application.");
	ch=sc.nextInt();
	try {
		switch(ch) {
		case 1 :
			System.out.println("SIGN IN");
			System.out.println("Enter your id and passcode");
			signIn(sc.nextInt(),sc.next(),doctorList);
			
			break;
		case 2 :
			System.out.println("Add a new Doctor record in collection");
			System.out.println("Enter doctor detais as per : ");
			System.out.println("doctorId,passCode,doctorName,email,degree,dateOfJoining(yyyy mm dd),salary,\r\n"
					+ "Department(ORTHO, PEDIATRICS, PHYSIIOTHEROPY, GASTROLOGY),age,contactNumber"
					+ ",address");
			Doctor newDoc = validateAllInputs(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.next(),LocalDate.of(sc.nextInt(),sc.nextInt(),sc.nextInt()),sc.nextDouble(),sc.next(),sc.nextInt(),sc.next(),sc.next(),doctorList);
			doctorList.add(newDoc);
			System.out.println("New doctor added successfully!!");
			break;
		case 3 :
			System.out.println("Display name of specified Doctor from list of Doctors having highest salary");
			highestPaidDoctor(doctorList);
			break;
		case 4 :
			System.out.println("Sort all doctor details on the basis of experience");
			sortOnExperience(doctorList);
	
			break;
		case 5 :
			System.out.println("Search all Doctors who are Orthopedics");
			orthopedicsDoctors(doctorList);
			break;
			
		case 6 :
			doctorList.stream().forEach(p->System.out.println(p));
			break;
			
		case 7 :
			System.out.println("Enter file name in which you want to store data !!");
			storeDetails(sc.next(), doctorList);
			break;
			
			
		case 8 :
			System.out.println("Enter file name from which you want to get data !!");
			reStoreDetails(sc.next(),doctorList);
			break;
			
		case 9 : 
			System.out.println("Enter the file in which you want to store data in binay form");
			storeDetailsInBinary(sc.next(),doctorList);
			break;
			
		case 10 :
			System.out.println("Enter binary file name ");
			reStoreDeatailsInBinary(sc.next());
			break;
			
		case 0 :
			System.out.println("You chose to exit the application!!");
			break;
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}while(ch!=0);
	
}
}
}
