package application.camunda.controller;

import application.camunda.request.SuspendSubRequest;
import application.camunda.response.SuspendSubResp;
import application.camunda.service.WorkflowService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/workflow")
public class WorkflowController {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());
    protected WorkflowService workflowService;

    public WorkflowController(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    @PostMapping("/cor-predilect")
    @ResponseStatus(HttpStatus.OK)
    public String startCorPredilect() {
        return workflowService.corPredilectStart();
    }
    @PostMapping(value = "/suspend-products-workflow", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> sendMessage(@RequestBody SuspendSubRequest req) {
        SuspendSubResp suspendSubResp = workflowService.suspendProduct(req);
        if (suspendSubResp == null) {
            LOGGER.info("============= O START DO PROCESSO FALHOU... ==============");
        }
        return new ResponseEntity<SuspendSubResp>(suspendSubResp, HttpStatus.OK);
    }
}
