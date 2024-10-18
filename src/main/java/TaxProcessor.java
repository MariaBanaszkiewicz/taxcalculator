import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;

@Slf4j
public class TaxProcessor {




    public static void processTax(TaxedIncome taxedIncome){


        TaxCalculator taxCalculator = new TaxCalculator(taxedIncome);
        TaxLogger taxLogger = new TaxLogger(taxedIncome);

        taxLogger.displayContractTypeAndDeclaredIncome();

        taxCalculator.calculateSecurityTaxes();
        taxLogger.displaySocialTaxes();

        taxCalculator.calculateSocHealthTaxes();
        taxLogger.displayHealthSecTaxes();

        taxCalculator.calculateDeductibleExpenses();
        taxLogger.displayTaxDeductibleExpenses();

        taxCalculator.calculateIncomeAfterDeductions();
        taxLogger.displayIncomeAfterDeductions();

        taxCalculator.calculateAdvanceTax();
        taxLogger.displayAdvanceTax();

        taxedIncome.setTaxFreeIncome(0d);

        taxCalculator.calculateAdvanceTaxPaid();
        taxLogger.displayAdvanceTaxPaid();

        taxCalculator.calculateNetIncome();
        taxLogger.displayNetIncome();

    }

}
