import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class TaxApplication {



	public static void main(String[] args) {

		double income = 0;
		ContractType contractType;

		try {
			income = obtainIncomeInput();
			contractType = obtainContractTypeInput();
		} catch (Exception ex) {
			System.out.println("Incorrect");
			System.err.println(ex);
			return;
		}

		if (contractType != null){
			TaxProcessor.processTax(contractType, income);
		} else {
			System.out.println("Unknown type of contract!");
		}
	}

	private static double obtainIncomeInput() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter income: ");
		return Double.parseDouble(reader.readLine());
	}

	private static ContractType obtainContractTypeInput() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Contract Type: (E)mployment, (C)ivil: ");
		return ContractType.valueOfLabel(reader.readLine().trim().toUpperCase().charAt(0));
	}
//TODO: to be removed after moving logging into another class
//
//	private static void processEmploymentTaxes(double income) {
//		System.out.println("EMPLOYMENT");
//		System.out.println("Income " + income);
//
//		SocTaxesWithIncome socTaxesWithIncome = TaxCalculator.calculateIncome(income);
//		displaySocialTaxes(socTaxesWithIncome);
//		System.out.println("Income basis for health social security: " + income);
//
//		SocHealthSecurityTax socHealthSecurityTax = TaxCalculator.calculateOtherTaxes(income);
//		System.out.println("Health social security tax: 9% = " + DECIMAL_FORMAT_00.format(socHealthSecurityTax.getSocHealth1())
//				+ " 7,75% = " + DECIMAL_FORMAT_00.format(socHealthSecurityTax.getSocHealth2()));
//		System.out.println("Tax deductible expenses " + taxDeductibleExpenses);
//		double taxFreeIncome = 0;
//
//		double taxedIncome = Double.parseDouble(DECIMAL_FORMAT.format(income - taxDeductibleExpenses));
//		System.out.println("income " + taxedIncome + " rounded " + DECIMAL_FORMAT.format(taxedIncome));
//
//		double advanceTax = TaxCalculator.calculateAdvanceTax(taxedIncome);
//		System.out.println("Advance tax 18 % = " + advanceTax);
//		System.out.println("Tax free income = " + taxFreeIncome);
//
//		double taxPaid = advanceTax - taxFreeIncome;
//		System.out.println("Reduced tax = " + DECIMAL_FORMAT_00.format(taxPaid));
//		double advanceTaxPaid = TaxCalculator.calculateAdvanceTaxPaid(advanceTax, socHealthSecurityTax.getSocHealth2(), taxFreeIncome);
//
//		double advanceTaxPaidRounded = Double.parseDouble(DECIMAL_FORMAT.format(advanceTaxPaid));
//		System.out.println("Advance tax paid = " + DECIMAL_FORMAT_00.format(advanceTaxPaid) + " rounded = " + DECIMAL_FORMAT.format(advanceTaxPaidRounded));
//
//		double netIncome = TaxCalculator.calculateNetIncome(income, socTaxesWithIncome, socHealthSecurityTax, advanceTaxPaidRounded);
//		System.out.println("Net income = " + DECIMAL_FORMAT_00.format(netIncome));
//	}
//
//	private static void processCivilTaxes(double income) {
//		System.out.println("income " + income);
//		SocTaxesWithIncome socTaxesWithIncome = TaxCalculator.calculateIncome(income);
//		displaySocialTaxes(socTaxesWithIncome);
//		System.out.println("Income for calculating health security tax: " + income);
//
//		SocHealthSecurityTax socHealthSecurityTax = TaxCalculator.calculateOtherTaxes(income);
//		System.out.println("Health security tax: 9% = " + DECIMAL_FORMAT_00.format(socHealthSecurityTax.getSocHealth1())
//				+ " 7,75% = " + DECIMAL_FORMAT_00.format(socHealthSecurityTax.getSocHealth2()));
//		double taxFreeIncome = 0;
//		double taxDeductibleExpenses = (income * 20) / 100;
//		System.out.println("Tax deductible expenses = " + taxDeductibleExpenses);
//
//		double taxedIncome = Double.parseDouble(DECIMAL_FORMAT.format(income - taxDeductibleExpenses));
//		System.out.println("income to be taxed = " + taxedIncome + " rounded = " + DECIMAL_FORMAT.format(taxedIncome));
//
//		double advanceTax = TaxCalculator.calculateAdvanceTax(taxedIncome);
//		System.out.println("Advance tax 18 % = " + advanceTax);
//		System.out.println("Already paid tax = " + DECIMAL_FORMAT_00.format(taxPaid));
//		double advanceTaxPaid = TaxCalculator.calculateAdvanceTaxPaid(advanceTax, socHealthSecurityTax.getSocHealth2(), taxFreeIncome);
//		double advanceTaxPaidRounded = Double.parseDouble(DECIMAL_FORMAT.format(advanceTaxPaid));
//		System.out.println("Advance tax  = " + DECIMAL_FORMAT_00.format(advanceTaxPaid) + " rounded = " + DECIMAL_FORMAT.format(advanceTaxPaidRounded));
//
//		double netIncome = TaxCalculator.calculateNetIncome(income, socTaxesWithIncome, socHealthSecurityTax, advanceTaxPaidRounded);
//		System.out.println("Net income = " + DECIMAL_FORMAT_00.format(netIncome));
//	}


}
