package application.camunda.service;

import application.camunda.request.SuspendSubRequest;
import application.camunda.response.SuspendSubResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static application.camunda.util.ControllerStatic.statusIsNull;
import static application.camunda.util.ControllerStatic.validateStatus;
import static application.camunda.util.MessagesUtil.*;

@Service
public class WorkflowService {
    private CamundaPocUtilService camundaPocUtilService;

    @Autowired
    public WorkflowService(CamundaPocUtilService camundaPocUtilService) {
        this.camundaPocUtilService = camundaPocUtilService;
    }

    public String corPredilectStart() {
        return camundaPocUtilService.startProcessFluxoCorPredilect();
    }

    public SuspendSubResp suspendProductStart(SuspendSubRequest req) {
        return isStartSuspendProduct(req);
    }

    public static boolean suspendSubRespStatusIsNull(SuspendSubResp suspendSubResp) {
        return suspendSubResp.getSubscriptionStatus().equalsIgnoreCase("null");
    }

    private SuspendSubResp isStartSuspendProduct(SuspendSubRequest req) {
        SuspendSubResp resp = new SuspendSubResp();
        if (statusIsNull(req)) {
            return resp.ValidateResp(ID_PROCESSO_ERROR, STATUS_IS_NULL, MESSAGE_ERROR_500);
        } else if (!validateStatus(req)) {
            return resp.ValidateResp(ID_PROCESSO_ERROR, req.getStatus(), MESSAGE_ERROR_422);
        } else {
            String idProcesso = camundaPocUtilService.startProcessFluxoSuspendProduct(req);
            return new SuspendSubResp(idProcesso, req.getStatus());
        }
    }
}
