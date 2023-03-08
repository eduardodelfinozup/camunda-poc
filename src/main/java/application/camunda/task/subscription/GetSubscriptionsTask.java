package application.camunda.task.subscription;

import application.camunda.commons.CamundaPocUtil;
import application.camunda.config.TaskDelegate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetSubscriptionsTask extends TaskDelegate {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());
    private CamundaPocUtil comunadaProcUtil;

    @Autowired
    public GetSubscriptionsTask(CamundaPocUtil comunadaProcUtil) {
        this.comunadaProcUtil = comunadaProcUtil;
    }

    public void execute(DelegateExecution delegateExecution) throws Exception {
        ProcessInstance processInstance = comunadaProcUtil.findExecutionByDefinitionKey("SUSPEND_PRODUCT");
        LOGGER.info("[ processInstance ] = {}", processInstance);
        String subIsSuspende = processInstance.getCaseInstanceId();
        String businessKey = processInstance.getBusinessKey();
        boolean should_Reverse_Subscription_Payment = comunadaProcUtil.isSubscriptionStatusSuspende(subIsSuspende);
        LOGGER.info("[ STATUS-SUB-ID = {} ]", should_Reverse_Subscription_Payment);

        if(subIsSuspende.equalsIgnoreCase("true")){
            LOGGER.info("[ O STATUS DO SUBSCRIPTION ESTA (SUSPENDE) ENTÃO EXECUTE APENAS O SUSPENDER PRODUTO ]");
        }
        delegateExecution.setVariable("SUB-ID", "SUB-123456");
        delegateExecution.setVariable("shouldReverseSubscriptionPayment", should_Reverse_Subscription_Payment);
        delegateExecution.setVariable("businessKey", businessKey);

        LOGGER.info("[ shouldReverseSubscriptionPayment ] = {}", subIsSuspende);
    }
}
