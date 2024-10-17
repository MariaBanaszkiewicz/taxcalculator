public class SocTaxesWithIncome {
	private final double socSecurity;
	private final double socHealthSecurity;
	private final double socSickSecurity;
	private final double income;

	public SocTaxesWithIncome(double socSecurity, double socHealthSecurity, double socSickSecurity, double income) {
		this.socSecurity = socSecurity;
		this.socHealthSecurity = socHealthSecurity;
		this.socSickSecurity = socSickSecurity;
		this.income = income;
	}

	public double getSocSecurity() {
		return socSecurity;
	}

	public double getSocHealthSecurity() {
		return socHealthSecurity;
	}

	public double getSocSickSecurity() {
		return socSickSecurity;
	}

	public double getIncome() {
		return income;
	}
}
