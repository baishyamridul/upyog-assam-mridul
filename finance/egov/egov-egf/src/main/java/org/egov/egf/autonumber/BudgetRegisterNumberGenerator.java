package org.egov.egf.autonumber;

import org.egov.model.budget.BudgetRegister;
import org.springframework.stereotype.Service;

@Service
public interface BudgetRegisterNumberGenerator {

    public String getNextNumber(BudgetRegister budgetRegister);

}
