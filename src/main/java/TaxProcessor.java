import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;

@Slf4j
public class TaxProcessor {

    private static final DecimalFormat DECIMAL_FORMAT_00 = new DecimalFormat("#.00");
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#");


    public static void processTax(ContractType contractType, double income){
        log.info(contractType.name());
        log.info("Income " + income);

        SocTaxesWithIncome socTaxesWithIncome = TaxCalculator.calculateIncome(income);
        displaySocialTaxes(socTaxesWithIncome);

        //FIXME: originally only reassigned in Civil type
        income = socTaxesWithIncome.getIncome();

        SocHealthSecurityTax socHealthSecurityTax = TaxCalculator.calculateOtherTaxes(income);

        //FIXME: originally only calculated in Civil type but used in both
        double taxDeductibleExpenses = TaxCalculator.calculateDeductibleExpenses(income);

        double taxedIncome = Double.parseDouble(DECIMAL_FORMAT.format(income - taxDeductibleExpenses));

        double advanceTax = TaxCalculator.calculateAdvanceTax(taxedIncome);

        double taxFreeIncome = 0;

        double advanceTaxPaid = TaxCalculator.calculateAdvanceTaxPaid(advanceTax, socHealthSecurityTax.getSocHealth2(), taxFreeIncome);

        double advanceTaxPaidRounded = Double.parseDouble(DECIMAL_FORMAT.format(advanceTaxPaid));

        double netIncome = TaxCalculator.calculateNetIncome(income, socTaxesWithIncome, socHealthSecurityTax, advanceTaxPaidRounded);

    }

    private static void displaySocialTaxes(SocTaxesWithIncome socTaxes) {
        log.info("Social security tax = " + DECIMAL_FORMAT_00.format(socTaxes.getSocSecurity()));
        log.info("Health social security tax = " + DECIMAL_FORMAT_00.format(socTaxes.getSocHealthSecurity()));
        log.info("Sickness security tax = " + DECIMAL_FORMAT_00.format(socTaxes.getSocSickSecurity()));
    }
}
