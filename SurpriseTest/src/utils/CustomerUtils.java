package utils;
import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import com.code.Customer;
import com.code.MessPlan;

import Custom_Exception.CustomerCustomException;

public class CustomerUtils {
	public static Customer signIn(String email, String password,Map<String , Customer> cust) throws CustomerCustomException {
		Customer customer = cust.get(email);
		if(customer!= null) {
			if(password.equals(customer.getPassword())){
				return customer;
			}
			else throw new CustomerCustomException("Wrong password !!");
//			}
		}
		else throw new CustomerCustomException("Wrong email id !!");
	}
	
	
	
	
//	public static Customer signIn(String email,String password,Map<String,Customer>map) throws CustomerCustomException{
//		Customer cust = new Customer(email);
//		boolean status = map.containsKey(email);
//		if(status==true) {
//			if(password.equals(map.get(email).getPassword()))
//				return map.get(email);
//			else throw new CustomerCustomException("Wrong password !!");
//		}
//		else throw new CustomerCustomException("Wrong email id !!");
//	}
	
	public static void changePassword(String email,String password, String newPassword, Map<String,Customer>map) throws CustomerCustomException {
		signIn(email,password,map);
		map.values().stream()
		.forEach(p->p.getPassword().replace(password,newPassword ));
	//	.forEach(p->p.getPassword().replace(password, newPassword));
	}
	
	public static void sortByFirstName(Map<String,Customer> custMap) {
		custMap.values().stream().sorted((p1,p2)->p1.getFirstName().compareTo(p2.getFirstName()))
		.forEach(p->System.out.println(p));
	}
	
	public static void sortByPlan(Map<String,Customer> custMap) {
		custMap.values().stream().sorted((p1,p2)->p1.getPlan().compareTo(p2.getPlan()))
		.forEach(p->System.out.println(p));
	}
	
	public static void sortByRegistrationDate(Map<String,Customer>map) {
		map.values().stream()
		.sorted((p1,p2)->p1.getRegistrationDate().compareTo(p2.getRegistrationDate()));
	}
	
	public static void unSubscribeCustomer(Map<String,Customer>map) throws CustomerCustomException {
		//signIn(email,password,map);
		map.values().removeIf(p->p.getPlanEndDate().isBefore(LocalDate.now()));
	}
	
	public static void displayCustomers (Map<String,Customer> custMap) {
		custMap.values()
		.stream()
		.forEach(p->System.out.println(p));
		}
	
	public static void displayCustomersInJan(Map<String,Customer> custMap) {
		custMap.values().stream()
		.filter(p->p.getRegistrationDate().getMonthValue()==1)
		.forEach(p->System.out.println(p.getEmail()));
	}
	
	public static void displayCountOfMonthlyCustomers(Map<String,Customer> custMap) {
		long count = custMap.values().stream()
		.filter(p->p.getPlan().equals(MessPlan.MONTHLY)).count();
			System.out.println("Count of Monthly mess Customers: "+count);
	}
	
	public static void displayCustomerInAkurdi(Map<String,Customer>custMap) {
		custMap.values().stream()
		.filter(p->p.getAddress().equalsIgnoreCase("Akurdi"))
		.forEach(p->System.out.println(p));
		}
	
	public static void discountForYearlyCustomers(Map<String,Customer>custMap) {
		custMap.values().stream()
		.filter(p->p.getPlan().equals(MessPlan.YEARLY))
	    .forEach(p->p.setFinal_Amount(p.getFinal_Amount()*0.80));
	}
	
	public static void modifyFirstName(Map<String,Customer>custMap) {
		custMap.values().stream()
		.forEach(p->p.setFirstName(p.getFirstName().replace(p.getFirstName().charAt(0),p.getFirstName().toUpperCase().charAt(0))));
	}
	
	
//	public static void modifyFirstName(Map<String,Customer>custMap) {
//		custMap.values()
//		.forEach(p->p.setFirstName(p.getFirstName().replace(p.getFirstName().charAt(0),p.getFirstName().toUpperCase().charAt(0))));
//	}
}