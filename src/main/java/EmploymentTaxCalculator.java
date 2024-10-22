public class EmploymentTaxCalculator extends TaxCalculator{

    public EmploymentTaxCalculator(TaxedIncome taxedIncome) {
        super(taxedIncome);
    }

    @Override
    void calculateDeductibleExpenses() {
        taxedIncome.setTaxDeductibleExpenses(111.25);
    }

    @Override
    void calculateTaxFreeIncome() {
        taxedIncome.setTaxFreeIncome(46.33);
    }


}
