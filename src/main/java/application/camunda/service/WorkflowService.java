package application.camunda.service;

import application.camunda.request.SuspendSubRequest;
import application.camunda.response.SuspendSubResp;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowService {

    private RuntimeService runtimeService;
    @Autowired
    public WorkflowService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public String corPredilectStart() {
        return runtimeService.startProcessInstanceByKey("cor_predilect").getId();
    }

    public SuspendSubResp suspendProduct(SuspendSubRequest req) {
        String idProcesso = runtimeService.startProcessInstanceByKey("SUSPEND_PRODUCT", req.getStatus()).getId();
        return new SuspendSubResp(idProcesso, req.getStatus());
    }

}
