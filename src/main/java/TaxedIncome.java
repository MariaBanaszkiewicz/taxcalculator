package com.bartoszwalter.students.taxes.src.main.java;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaxedIncome {

    private final ContractType contractType;

    private final Double declaredIncome;

    private Double socSecurity;

    private Double socHealthSecurity;

    private Double socSickSecurity;

    private Double incomeReducedBySecurityTaxes;

    private Double socHealth9Percent;

    private Double socHealth7p75Percent;

    private Double taxDeductibleExpenses;

    private Double incomeAfterDeductions;

    private Double advanceTax;

    private Double taxFreeIncome;

    private Double advanceTaxPaid;

    private Double netIncome;


    public TaxedIncome(ContractType contractType, Double declaredIncome) {
        this.contractType = contractType;
        this.declaredIncome = declaredIncome;
    }
}
