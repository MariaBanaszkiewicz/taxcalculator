package com.bartoszwalter.students.taxes.src.main.java;

import java.text.DecimalFormat;

public class TaxCalculator {

	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#");

	private final TaxedIncome taxedIncome;

	public TaxCalculator(TaxedIncome taxedIncome){
		this.taxedIncome = taxedIncome;
	}

	void calculateAdvanceTaxPaid() {
		taxedIncome.setAdvanceTaxPaid(Double.parseDouble(DECIMAL_FORMAT.format(taxedIncome.getAdvanceTax() - taxedIncome.getSocHealth7p75Percent() - taxedIncome.getTaxFreeIncome())));
	}

	void calculateAdvanceTax() {
		taxedIncome.setAdvanceTax((taxedIncome.getIncomeAfterDeductions() * 18) / 100);
	}

	void calculateSecurityTaxes() {
		Double income = taxedIncome.getDeclaredIncome();
		taxedIncome.setSocSecurity((income * 9.76) / 100);
		taxedIncome.setSocHealthSecurity((income * 1.5) / 100);
		taxedIncome.setSocSickSecurity((income * 2.45) / 100);
		taxedIncome.setIncomeReducedBySecurityTaxes(income
				- taxedIncome.getSocSecurity()
				- taxedIncome.getSocHealthSecurity()
				- taxedIncome.getSocSickSecurity());

	}

	void calculateSocHealthTaxes() {
		Double income = taxedIncome.getIncomeReducedBySecurityTaxes();
		taxedIncome.setSocHealth9Percent((income * 9) / 100);
		taxedIncome.setSocHealth7p75Percent((income * 7.75) / 100);
	}

	void calculateNetIncome() {
		taxedIncome.setNetIncome(taxedIncome.getIncomeReducedBySecurityTaxes() - taxedIncome.getSocHealth9Percent() - taxedIncome.getAdvanceTaxPaid());
	}

	void calculateDeductibleExpenses() {
		taxedIncome.setTaxDeductibleExpenses((taxedIncome.getIncomeReducedBySecurityTaxes() * 20) / 100);
	}

	void calculateIncomeAfterDeductions(){
		taxedIncome.setIncomeAfterDeductions(Double.parseDouble(DECIMAL_FORMAT.format(taxedIncome.getIncomeReducedBySecurityTaxes() - taxedIncome.getTaxDeductibleExpenses())));
	}
}
