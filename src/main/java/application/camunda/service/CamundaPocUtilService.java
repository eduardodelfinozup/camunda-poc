package application.camunda.service;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CamundaPocUtilService {
    private RuntimeService runtimeService;

    @Autowired
    public CamundaPocUtilService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public ProcessInstance findExecutionByDefinitionKey(String definitionKey) {
        return runtimeService.createProcessInstanceQuery()
                .processDefinitionKey(definitionKey)
                .singleResult();
    }

    public ProcessInstance findExecutionByDefinitionKey(String businessKey, String definitionKey) {
        return runtimeService.createProcessInstanceQuery()
                .processInstanceBusinessKey(businessKey, definitionKey)
                .singleResult();
    }

    public boolean isSubscriptionStatusSuspende(String flag) {
        return flag.equalsIgnoreCase("true") ? true : false;
    }

    public void killProcess(String processId, String definitionKey) {
        runtimeService.deleteProcessInstance(processId, definitionKey);
    }
}
