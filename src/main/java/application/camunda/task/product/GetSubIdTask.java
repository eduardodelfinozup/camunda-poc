package application.camunda.task.product;

import application.camunda.config.TaskDelegate;
import application.camunda.service.WorkflowService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static application.camunda.util.MessagesUtil.SUBSCRIPTION_ID;
import static application.camunda.util.VariableStaticUtil.setVariableSubscriptionId;

@Component
public class GetSubIdTask extends TaskDelegate {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());
    protected WorkflowService workflowService;

    @Autowired
    public GetSubIdTask(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("BUSCANDO A SUBSCRIPTION ID {}", SUBSCRIPTION_ID);
        setVariableSubscriptionId(delegateExecution);
        String businessKey = delegateExecution.getBusinessKey();
        LOGGER.info("[ businessKey ]: {} ", businessKey);
    }
}
