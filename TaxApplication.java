package com.bartoszwalter.students.taxes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class TaxApplication {

	private static final DecimalFormat df00 = new DecimalFormat("#.00");
	private static final DecimalFormat df = new DecimalFormat("#");

	public static void main(String[] args) {

		double income = 0;

		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr));

			System.out.print("Enter income: ");
			income = Double.parseDouble(br.readLine());

			System.out.print("Contract Type: (E)mployment, (C)ivil: ");
			contractType = br.readLine().charAt(0);

		} catch (Exception ex) {
			System.out.println("Incorrect");
			System.err.println(ex);
			return;
		}

		if (contractType == 'E') {
			processEmployment(income);
		} else if (umowacontractType == 'C') {
			processContract(income);
		} else {
			System.out.println("Unknown type of contract!");
		}
	}

	private static void processEmployment(double income) {
		System.out.println("EMPLOYMENT");
		System.out.println("Income " + income);

		SocTaxesWithIncome socTaxesWithIncome = TaxCalculator.calculateIncome(income);
		System.out.println("Social security tax "
				+ df00.format(socTaxesWithIncome.getSocSecurity()));
		System.out.println("Health social security tax    "
				+ df00.format(socTaxesWithIncome.getSocHealthSecurity()));
		System.out.println("Sickness social security tax  "
				+ df00.format(socTaxesWithIncome.getSocSickSecurity()));
		System.out.println("Income basis for health social security: "
				+ income);

		SocHealthSecurityTax socHealthSecurityTax = TaxCalculator.calculateOtherTaxes(income);
		System.out.println("Health social security tax: 9% = "
				+ df00.format(socHealthSecurityTax.getSocHealth1()) + " 7,75% = " + df00.format(socHealthSecurityTax.getSocHealth2()));
		System.out.println("Tax deductible expenses " + taxDeductibleExpenses);
		double taxFreeIncome = 0;

		double taxedIncome = Double.parseDouble(df.format(income - taxDeductibleExpenses));
		System.out.println("income " + taxedIncome + " rounded " + df.format(taxedIncome));

		double advanceTax = TaxCalculator.calculateAdvanceTax(taxedIncome);
		System.out.println("Advance tax 18 % = " + advanceTax);
		System.out.println("Tax free income = " + taxFreeIncome);

		double taxPaid = advanceTax - taxFreeIncome;
		System.out.println("Reduced tax = " + df00.format(taxPaid));
		double advanceTaxPaid = TaxCalculator.calculateAdvanceTaxPaid(advanceTax, socHealthSecurityTax.getSocHealth2(), taxFreeIncome);

		double advanceTaxPaidRounded = Double.parseDouble(df.format(advanceTaxPaid));
		System.out.println("Advance tax paid = " + df00.format(advanceTaxPaid) + " rounded = " + df.format(advanceTaxPaidRounded));

		double netIncome = TaxCalculator.calculateNetIncome(income, socTaxesWithIncome, socHealthSecurityTax, advanceTaxPaidRounded);
		System.out.println("Net income = " + df00.format(netIncome));
	}

	private static void processContract(double income) {
		System.out.println("income " + income);
		SocTaxesWithIncome socTaxesWithIncome = TaxCalculator.calculateIncome(income);
		System.out.println("Social security tax = "
				+ df00.format(socTaxesWithIncome.getSocSecurity()));
		System.out.println("Health social security tax = "
				+ df00.format(socTaxesWithIncome.getSocHealthSecurity()));
		System.out.println("Sickness social security tax = "
				+ df00.format(socTaxesWithIncome.getSocSickSecurity()));
		System.out
				.println("Income for calculating health security tax: " + income);

		SocHealthSecurityTax socHealthSecurityTax = TaxCalculator.calculateOtherTaxes(income);
		System.out.println("Health security tax: 9% = "
				+ df00.format(socHealthSecurityTax.getSocHealth1()) + " 7,75% = " + df00.format(socHealthSecurityTax.getSocHealth2()));
		double taxFreeIncome = 0;
		double taxDeductibleExpenses = (income * 20) / 100;
		System.out.println("Tax deductible expenses = " + taxDeductibleExpenses);

		double taxedIncome = Double.parseDouble(df.format(income - taxDeductibleExpenses));
		System.out.println("income to be taxed = " + taxedIncome + " rounded = " + df.format(taxedIncome));

		double advanceTax = TaxCalculator.calculateAdvanceTax(taxedIncome);
		System.out.println("Advance tax 18 % = " + advanceTax);
		System.out.println("Already paid tax = " + df00.format(taxPaid));
		double advanceTaxPaid = TaxCalculator.calculateAdvanceTaxPaid(advanceTax, socHealthSecurityTax.getSocHealth2(), taxFreeIncome);
		double advanceTaxPaidRounded = Double.parseDouble(df.format(advanceTaxPaid));
		System.out.println("Advance tax  = " + df00.format(advanceTaxPaid) + " rounded = " + df.format(advanceTaxPaidRounded));

		double netIncome = TaxCalculator.calculateNetIncome(income, socTaxesWithIncome, socHealthSecurityTax, advanceTaxPaidRounded);
		System.out.println("Net income = " + df00.format(netIncome));
	}
}
