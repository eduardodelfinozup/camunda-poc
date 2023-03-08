package application.camunda.task.subscription;

import application.camunda.config.TaskDelegate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

@Component
public class SuspendSubscriptionsTask extends TaskDelegate {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String statusSub = delegateExecution.getVariable("shouldReverseSubscriptionPayment").toString();
        LOGGER.info("statusSub {}", statusSub);
        if(statusSub.equalsIgnoreCase("false")){
            LOGGER.info("[ O STATUS DO SUBSCRIPTION ESTA (ACTIVE) ENTÃO EXECUTE O CACELAMENTO DO PAYMENT ]");
            delegateExecution.getVariable( "SUB-ID");
        }
    }
}
