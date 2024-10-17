public class TaxCalculator {

	static double calculateAdvanceTaxPaid(double advanceTax, double socHealth2, double taxFreeIncome) {
		return advanceTax - socHealth2 - taxFreeIncome;
	}

	static double calculateAdvanceTax(double income) {
		return (income * 18) / 100;
	}

	static SocTaxesWithIncome calculateIncome(double income) {
		double socSecurity = (income * 9.76) / 100;
		double socHealthSecurity = (income * 1.5) / 100;
		double socSickSecurity = (income * 2.45) / 100;
		return new SocTaxesWithIncome(socSecurity, socHealthSecurity, socSickSecurity,
				(income - socSecurity - socHealthSecurity - socSickSecurity));
	}

	static SocHealthSecurityTax calculateOtherTaxes(double income) {
		double socHealth1 = (income * 9) / 100;
		double socHealth2 = (income * 7.75) / 100;
		return new SocHealthSecurityTax(socHealth1, socHealth2);
	}

	static double calculateNetIncome(double income, SocTaxesWithIncome socTaxesWithIncome,
																	 SocHealthSecurityTax socHealthSecurityTax, double advanceTaxPaid) {
		return income - ((socTaxesWithIncome.getSocSecurity() + socTaxesWithIncome.getSocHealthSecurity()
				+ socTaxesWithIncome.getSocSickSecurity()) + socHealthSecurityTax.getSocHealth1() + advanceTaxPaid);
	}

	static double calculateDeductibleExpenses(double income) {
		return (income * 20) / 100;
	}
}
