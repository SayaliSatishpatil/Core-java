package utils;

import java.time.LocalDate;
import java.util.Map;
import com.code.Customer;
import com.code.MessPlan;
import Custom_Exception.CustomerCustomException;
import static com.code.Customer.calculatePlanEndDate;

public class validationRules {

	public static String validateEmail(String email) throws CustomerCustomException {
		if (!email.matches("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"))
			throw new CustomerCustomException("Invalid Email!!");
		return email;
	}

	// Validate Customer check for Duplication
	// Validatecustomer login if not exist or invalid mail & invalid password

	public static void checkForDuplicateEmail(String email, String password, Map<String, Customer> cust)
			throws CustomerCustomException {
		email = validateEmail(email);
		Customer newCustomer = new Customer(email);
		if (cust.containsKey(email))
			throw new CustomerCustomException("This email Id has already taken !! ");

	}

	// ParseValidatePlan , registration amount must be match with plan
	public static MessPlan validaeAndParsePlan(String plan) throws CustomerCustomException {
		return MessPlan.valueOf(plan.toUpperCase());
	}

	public static void validateRegistrationAmount(MessPlan messplan, double registratinAmount,
			Map<String, Customer> custNewMap) throws CustomerCustomException {
		if (registratinAmount != messplan.getCharges())
			throw new CustomerCustomException("Registration amount must match with plan !!");
	}

	public static void validatePhoneNumber(String phoneNumber) throws CustomerCustomException {
		if (!phoneNumber.matches("^[0-9]{10}$"))
			throw new CustomerCustomException("phone number should be 10 digit number!! ");
	}

	public static Customer validateAllInputs(String firstName, String lastname, String email, String password,
			String address, LocalDate registrationDate, String phoneNumber, String plan,
			double final_Amount, Map<String, Customer> custMap) throws CustomerCustomException {
		checkForDuplicateEmail(email, password, custMap);
		MessPlan newPlan = validaeAndParsePlan(plan);
		validateRegistrationAmount(newPlan, final_Amount, custMap);
		validatePhoneNumber(phoneNumber);
		return new Customer(firstName, lastname, email, password, address, registrationDate, phoneNumber,
				newPlan, final_Amount);
	
}
}
//abc xyz abc12@gmail.com abc123 akurdi 2023 05 04 1234568790 yearly 32000
