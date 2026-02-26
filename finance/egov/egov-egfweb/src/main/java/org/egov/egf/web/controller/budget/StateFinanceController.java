package org.egov.egf.web.controller.budget;


import org.apache.log4j.Logger;
import org.egov.egf.statefinance.model.BudgetRegisterRequestWrapper;
import org.egov.egf.statefinance.model.BudgetRegisterWrapper;
import org.egov.egf.web.controller.microservice.VoucherController;
import org.egov.infra.microservice.models.ResponseInfo;
import org.egov.model.budget.register.BudgetRegisterActionsDTO;
import org.egov.model.service.BudgetRegisterWorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StateFinanceController {

    private static final Logger LOGGER = Logger.getLogger(StateFinanceController.class);

    @Autowired
    private BudgetRegisterWorkflowService budgetRegisterWorkflowService;


    @PostMapping(value = "/rest/budget/stateaction")
    @ResponseBody
    public Map<String, Object> handleStateAction(@RequestBody @Valid BudgetRegisterActionsDTO budgetRegisterActionsDTO, final BindingResult bindingResult) throws Exception {

        String message = "Budget action handled successfully !";

        try {
            budgetRegisterWorkflowService.handleBudgetActionFromState(budgetRegisterActionsDTO, bindingResult);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RestClientException("Something went wrong !");
        }

//        try {
//            budgetRegisterWorkflowService.handleBudgetActionFromState(budgetRegisterActionsDTO, bindingResult);
//            if (bindingResult.hasErrors()) {
//                //
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RestClientException("Something went wrong !");
////            responseInfo.setStatus(String.valueOf(HttpStatus.UNPROCESSABLE_ENTITY.value()));
////            message = "Something went wrong!";
//        }


        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setStatus(String.valueOf(HttpStatus.OK.value()));


        Map<String, Object> response = new HashMap<>();
        response.put("ResponseInfo", responseInfo);
        response.put("message", message);

        return response;

    }


}
