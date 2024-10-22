public class CivilTaxCalculator extends TaxCalculator {

    public CivilTaxCalculator(TaxedIncome taxedIncome) {
        super(taxedIncome);
    }

    @Override
    void calculateDeductibleExpenses() {
    	taxedIncome.setTaxDeductibleExpenses((taxedIncome.getIncomeReducedBySecurityTaxes() * 20) / 100);
    }

    @Override
    void calculateTaxFreeIncome() {
        taxedIncome.setTaxFreeIncome(0d);
    }
}
