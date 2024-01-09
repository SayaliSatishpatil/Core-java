package utils;

import java.util.Collections;
import java.util.List;

import com.code.Department;
import com.code.Doctor;

public class DoctorListUtils {

	public static void highestPaidDoctor(List<Doctor>docList) {
		Doctor doctor = docList.stream()
		.max((p1,p2)->((Double)p1.getSalary()).compareTo(p2.getSalary()))
		.orElseThrow();
		System.out.println(doctor);
		
		
	}

public static void sortOnExperience(List<Doctor>list) {
		list.stream()
		.sorted((p1,p2)->((Integer)p1.getExperience()).compareTo(p2.getExperience()))
		.forEach(p->System.out.println(p));
	}
	
	public static void orthopedicsDoctors(List<Doctor>list) {
		Department dept = Department.valueOf("ortho".toUpperCase());
		list.stream()
		.filter(p->p.getDept()==dept)
		.forEach(p->System.out.println(p));
	}
	
}

