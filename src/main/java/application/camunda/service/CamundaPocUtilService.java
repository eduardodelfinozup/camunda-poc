package application.camunda.service;

import application.camunda.request.SuspendSubRequest;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static application.camunda.util.MessagesUtil.*;

@Service
public class CamundaPocUtilService {
    private RuntimeService runtimeService;

    @Autowired
    public CamundaPocUtilService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public String startProcessFluxoCorPredilect() {
        return runtimeService.startProcessInstanceByKey(COR_PREDILECT_START).getId();
    }

    public String startProcessFluxoSuspendProduct(SuspendSubRequest req) {
        return runtimeService.startProcessInstanceByKey(SUSPEND_PRODUCTS_START, BUSSINESSkEY, req.getStatus()).getId();
    }

    public ProcessInstance findExecutionByDefinitionKey(String definitionKey) {
        return runtimeService.createProcessInstanceQuery()
                .processDefinitionKey(definitionKey)
                .singleResult();
    }

    public ProcessInstance findExecutionByBusinessKeyAndDefinitionKey(String businessKey, String definitionKey) {
        return runtimeService.createProcessInstanceQuery()
                .processInstanceBusinessKey(businessKey, definitionKey)
                .singleResult();
    }
    public void killProcess(String processId, String definitionKey) {
        runtimeService.deleteProcessInstance(processId, definitionKey);
    }
}
