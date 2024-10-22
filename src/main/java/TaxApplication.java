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

		if (contractType == null ) {
			System.out.println("Unknown type of contract!");
			return;
		}

		TaxedIncome taxedIncome = new TaxedIncome(contractType, income);
		TaxCalculator taxCalculator =
		switch(contractType) {
			case CIVIL -> new CivilTaxCalculator(taxedIncome);
			case EMPLOYMENT -> new EmploymentTaxCalculator(taxedIncome);
		};
		TaxProcessor taxProcessor = new TaxProcessor(taxCalculator, new TaxLogger(taxedIncome));

		taxProcessor.processTax();

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

}
