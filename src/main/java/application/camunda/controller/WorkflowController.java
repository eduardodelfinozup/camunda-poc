package application.camunda.controller;

import application.camunda.request.SuspendSubRequest;
import application.camunda.response.SuspendSubResp;
import application.camunda.service.ResponseStatusService;
import application.camunda.service.WorkflowService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static application.camunda.util.ControllerStatic.responseStatus;
import static application.camunda.util.MessagesUtil.ID_PROCESSO_ERROR;
import static application.camunda.util.MessagesUtil.MESSAGE_ERROR_422;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(value = "/workflow")
public class WorkflowController {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());
    protected WorkflowService workflowService;
    protected ResponseStatusService responseStatusService;

    @Autowired
    public WorkflowController(WorkflowService workflowService, ResponseStatusService resposeStatus) {
        this.workflowService = workflowService;
        this.responseStatusService = resposeStatus;
    }

    @PostMapping("/cor-predilect")
    @ResponseStatus(OK)
    public String startCorPredilect() {
        return workflowService.corPredilectStart();
    }

    @PostMapping(value = "/suspend-products-workflow", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> sendMessage(@RequestBody SuspendSubRequest req) {
        SuspendSubResp responseInit = workflowService.suspendProductStart(req);
        if (WorkflowService.suspendSubRespStatusIsNull(responseInit)) {
            return responseStatus(responseInit, responseStatusService, INTERNAL_SERVER_ERROR);
        } else if (responseInit == null) {
            return responseStatus(new SuspendSubResp(ID_PROCESSO_ERROR, req.getStatus()), responseStatusService, UNPROCESSABLE_ENTITY);
        } else if (responseInit.getMessage().equalsIgnoreCase(MESSAGE_ERROR_422)) {
            return responseStatus(responseInit, responseStatusService, UNPROCESSABLE_ENTITY);
        } else {
            return responseStatus(responseInit, responseStatusService, OK);
        }
    }
}
