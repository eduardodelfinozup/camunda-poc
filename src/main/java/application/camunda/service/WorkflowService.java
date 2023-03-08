package application.camunda.service;

import application.camunda.request.SuspendSubRequest;
import application.camunda.response.SuspendSubResp;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowService {
    private final String COR_PREDILECT_START = "cor_predilect";
    private final String SUSPEND_PRODUCTS_START = "SUSPEND_PRODUCT";
    private final String BUSSSINESSkEY = "STAR-CAMUNDA-POC";

    private RuntimeService runtimeService;

    @Autowired
    public WorkflowService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public String corPredilectStart() {
        return runtimeService.startProcessInstanceByKey(COR_PREDILECT_START).getId();
    }

    public SuspendSubResp suspendProduct(SuspendSubRequest req) {
        return validateRequest(req);
    }

    private SuspendSubResp validateRequest(SuspendSubRequest req) {
        SuspendSubResp resp = new SuspendSubResp();
        if (req.getStatus() == null) {
            return resp.ValidateResp("[ processo null ]", "null", "O status não pode ser null ( precisa passar uma String true ou false)");
        } else if (!validateStatus(req)) {
            return resp.ValidateResp("[ processo null ]", req.getStatus(), "O status precisa ser true ou false");
        } else {
            String idProcesso = runtimeService.startProcessInstanceByKey(SUSPEND_PRODUCTS_START, BUSSSINESSkEY, req.getStatus()).getId();
            return new SuspendSubResp(idProcesso, req.getStatus());
        }
    }

    private static boolean validateStatus(SuspendSubRequest req) {
        return req.getStatus().equalsIgnoreCase("true") || req.getStatus().equalsIgnoreCase("false");
    }
}
