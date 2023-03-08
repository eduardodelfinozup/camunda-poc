package application.camunda.task.subscription;

import application.camunda.config.TaskDelegate;
import application.camunda.service.CamundaPocUtilService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetSubscriptionsTask extends TaskDelegate {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());

    private final String DEFINITION_KEY = "SUSPEND_PRODUCT";
    private CamundaPocUtilService comunadaPocUtilService;


    @Autowired
    public GetSubscriptionsTask(CamundaPocUtilService comunadaProcUtil) {
        this.comunadaPocUtilService = comunadaProcUtil;
    }

    public void execute(DelegateExecution delegateExecution) throws Exception {
        ProcessInstance processInstance = comunadaPocUtilService.findExecutionByDefinitionKey(DEFINITION_KEY);
        LOGGER.info("[ processInstance ] = {}", processInstance);
        String subIsSuspende = processInstance.getCaseInstanceId();
        String businessKey = processInstance.getBusinessKey();
        boolean should_Reverse_Subscription_Payment = comunadaPocUtilService.isSubscriptionStatusSuspende(subIsSuspende);
        LOGGER.info("[ STATUS-SUB-ID = {} ]", should_Reverse_Subscription_Payment);

        if (subIsSuspende.equalsIgnoreCase("true")) {
            LOGGER.info("[ O STATUS DO SUBSCRIPTION ESTA (SUSPENDE) ENTÃO EXECUTE ( SUSPENDER PRODUTO ) ]");
        }
        delegateExecution.setVariable("SUB-ID", "SUB-123456");
        delegateExecution.setVariable("shouldReverseSubscriptionPayment", should_Reverse_Subscription_Payment);
        delegateExecution.setVariable("businessKey", businessKey);

        LOGGER.info("[ shouldReverseSubscriptionPayment ] = {}", subIsSuspende);
    }
}
