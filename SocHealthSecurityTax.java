package com.bartoszwalter.students.taxes;

public class SocHealthSecurityTax {

	private final double socHealth1;
	private final double socHealth2;

	public SocHealthSecurityTax(double socHealth1, double socHealth2) {
		this.socHealth1 = socHealth1;
		this.socHealth2 = socHealth2;
	}

	public double getSocHealth1() {
		return socHealth1;
	}

	public double getSocHealth2() {
		return socHealth2;
	}
}
