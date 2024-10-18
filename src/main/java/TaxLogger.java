package com.bartoszwalter.students.taxes.src.main.java;

import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;

@Slf4j
public class TaxLogger {

    private static final DecimalFormat DECIMAL_FORMAT_00 = new DecimalFormat("#.00");
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#");

    private final TaxedIncome taxedIncome;

    public TaxLogger(TaxedIncome taxedIncome) {
        this.taxedIncome = taxedIncome;
    }

    void displayContractTypeAndDeclaredIncome() {
        log.info(taxedIncome.getContractType().name());
        log.info("Income " + taxedIncome.getDeclaredIncome());
    }


     void displaySocialTaxes() {
        log.info("Social security tax = " + DECIMAL_FORMAT_00.format(taxedIncome.getSocSecurity()));
        log.info("Health social security tax = " + DECIMAL_FORMAT_00.format(taxedIncome.getSocHealthSecurity()));
        log.info("Sickness security tax = " + DECIMAL_FORMAT_00.format(taxedIncome.getSocSickSecurity()));
        log.info("Income for calculating health security tax: " + taxedIncome.getIncomeReducedBySecurityTaxes());

    }

    void displayHealthSecTaxes(){
        log.info("Health security tax: 9% = " + DECIMAL_FORMAT_00.format(taxedIncome.getSocHealth9Percent())
                + " 7,75% = " + DECIMAL_FORMAT_00.format(taxedIncome.getSocHealth7p75Percent()));
    }

    void displayTaxDeductibleExpenses() {
        log.info("Tax deductible expenses = " + taxedIncome.getTaxDeductibleExpenses());
    }

    void displayIncomeAfterDeductions() {
        log.info("income to be taxed = " + DECIMAL_FORMAT.format(taxedIncome.getIncomeAfterDeductions()));
    }

    void displayAdvanceTax(){
        log.info("Advance tax 18 % = " + taxedIncome.getAdvanceTax());
    }

    void displayAdvanceTaxPaid() {
        log.info("Advance tax paid = " + DECIMAL_FORMAT.format(taxedIncome.getAdvanceTaxPaid()));
    }

    void displayNetIncome() {
        log.info("Net income = " + DECIMAL_FORMAT_00.format(taxedIncome.getNetIncome()));
    }
}
