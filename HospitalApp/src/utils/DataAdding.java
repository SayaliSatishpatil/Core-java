package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.code.Department;
import com.code.Doctor;

public class DataAdding {
public static List populateDoctors() {
	
	List<Doctor>list=new ArrayList<>();
	
//ORTHO, PEDIATRICS, PHYSIIOTHEROPY, GASTROLOGY
	
//(int doctorId, String doctorName, String email, String degree, LocalDate dateOfJoining, double salary,
//	Department dept, int age, String contactNumber, int deptNumber, String specialization, String address)
	list.add(new Doctor(01,"Alex123","Alex","alex123@gmail.com","MBBS",LocalDate.of(2002, 10, 20),150000.00,Department.GASTROLOGY,32,"1234567890","pune"));
	list.add(new Doctor(02,"Sayali123","Sayali","sayali123@gmail.com","MBBS",LocalDate.of(2007, 05, 27),158000.00,Department.ORTHO,27,"1287567890","akurdi"));
	list.add(new Doctor(03,"Pradnya123","Pradnya","pradnya123@gmail.com","BHMS",LocalDate.of(2012, 02, 17),100000.00,Department.PEDIATRICS,30,"1984567890","sangli"));
	list.add(new Doctor(04,"Pooja123","Pooja","pooja123@gmail.com","BDS",LocalDate.of(2023, 07, 30),50000.00,Department.PHYSIIOTHEROPY,28,"1474567890","Kolhapur"));
	list.add(new Doctor(05,"Prachi123","Prachi","prachi123@gmail.com","BAMS",LocalDate.of(2005, 12, 20),200000.00,Department.GASTROLOGY,27,"1238467890","akola"));
	list.add(new Doctor(06,"Rey123","Rey","rey123@gmail.com","MD",LocalDate.of(2023,07, 03),300000.00,Department.ORTHO,25,"1234569290","karad"));

	
	return list;
}
}
