package com.code;

public enum Department {
	ORTHO(10), PEDIATRICS(20), PHYSIIOTHEROPY(30), GASTROLOGY(40);
	private int deptNumber;

	private Department(int deptNumber) {
		this.deptNumber = deptNumber;
	}
	
	public String toString() {
		return "Department name :"+name().toLowerCase() +"department number : "+deptNumber;
	}

	public int getDeptNumber() {
		return deptNumber;
	}

	public void setDeptNumber(int deptNumber) {
		this.deptNumber = deptNumber;
	}
}
