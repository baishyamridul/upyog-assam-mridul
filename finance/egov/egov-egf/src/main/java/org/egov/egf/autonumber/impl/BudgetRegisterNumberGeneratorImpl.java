package org.egov.egf.autonumber.impl;

import org.egov.commons.CFinancialYear;
import org.egov.commons.dao.FinancialYearDAO;
import org.egov.egf.autonumber.BudgetRegisterNumberGenerator;
import org.egov.infra.persistence.utils.GenericSequenceNumberGenerator;
import org.egov.model.budget.BudgetRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

@Service
public class BudgetRegisterNumberGeneratorImpl implements BudgetRegisterNumberGenerator {

    @Autowired
    private FinancialYearDAO financialYearDAO;

    @Autowired
    private GenericSequenceNumberGenerator genericSequenceNumberGenerator;

    @Override
    public String getNextNumber(BudgetRegister budgetRegister) {

        String budgetRegisterNumber = "";

        String sequenceName = "";

        sequenceName = "seq_budgetregister_" + budgetRegister.getCurrentFinancialYear().getFinYearRange();

        Serializable nextSequence = genericSequenceNumberGenerator.getNextSequence(sequenceName);

        budgetRegisterNumber = String.format("%s/%02d/%s", "BR", nextSequence, budgetRegister.getFinancialYear().getFinYearRange());

        return budgetRegisterNumber;

    }
}
