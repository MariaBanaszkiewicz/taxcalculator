import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;

@Slf4j
public class TaxProcessor {

    private final TaxCalculator taxCalculator;
    private final TaxLogger taxLogger;

    public TaxProcessor(TaxCalculator taxCalculator, TaxLogger taxLogger){
        this.taxCalculator = taxCalculator;
        this.taxLogger = taxLogger;
    }


    public void processTax(){

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

        taxCalculator.calculateTaxFreeIncome();

        taxCalculator.calculateAdvanceTaxPaid();
        taxLogger.displayAdvanceTaxPaid();

        taxCalculator.calculateNetIncome();
        taxLogger.displayNetIncome();

    }

}
