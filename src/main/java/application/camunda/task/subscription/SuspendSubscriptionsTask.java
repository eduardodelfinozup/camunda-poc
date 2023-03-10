package application.camunda.task.subscription;

import application.camunda.config.TaskDelegate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import static application.camunda.service.CamundaPocUtilService.*;

@Component
public class SuspendSubscriptionsTask extends TaskDelegate {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String statusSub = geVariabletShouldReverseSubscriptionPayment(delegateExecution);
        LOGGER.info("statusSub {}", statusSub);
        if(statusSub.equalsIgnoreCase("true")){
            LOGGER.info("[ EXECUTE O CACELAMENTO DO PAYMENT ]");
            getVariableSubId(delegateExecution);
        }
    }
}
