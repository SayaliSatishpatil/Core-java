package com.code;

public enum MessPlan {
//	Messplan(Plan : enum) Plans Are as follows:-
//	 Monthly (3000), Quarterly (11700), Half Year (17500), Yearly (32000)
	MONTHLY(3000),QUARTERLY(11700),HALF_YEAR(17500),YEARLY(32000);
	private double charges;

	private MessPlan(double charges) {
		this.charges = charges;
	}

	public double getCharges() {
		return charges;
	}

	public String toString() {
		return "Messplan : "+name().toLowerCase()+" charges : "+charges;
	}
}
