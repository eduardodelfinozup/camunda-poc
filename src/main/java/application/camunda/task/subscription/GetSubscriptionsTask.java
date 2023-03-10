package application.camunda.task.subscription;

import application.camunda.config.TaskDelegate;
import application.camunda.service.CamundaPocUtilService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

import static application.camunda.service.CamundaPocUtilService.*;
import static application.camunda.util.MessagesUtil.*;

@Component
public class GetSubscriptionsTask extends TaskDelegate {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());

    private final String DEFINITION_KEY = SUSPEND_PRODUCTS_START;
    private CamundaPocUtilService comunadaPocUtilService;


    @Autowired
    public GetSubscriptionsTask(CamundaPocUtilService comunadaProcUtil) {
        this.comunadaPocUtilService = comunadaProcUtil;
    }

    public void execute(DelegateExecution delegateExecution) throws Exception {
        ProcessInstance processInstance = comunadaPocUtilService.findExecutionByDefinitionKey(DEFINITION_KEY);
        LOGGER.info("[ processInstance ] = {}", processInstance);
        String subIsSuspende = processInstance.getCaseInstanceId();
        boolean flagSubscriptionIsSuspended = comunadaPocUtilService.isSubscriptionStatusSuspende(subIsSuspende);
        LOGGER.info("[ STATUS-SUB-ID = {} ]", flagSubscriptionIsSuspended);

        if (subIsSuspende.equalsIgnoreCase("true")) {
            LOGGER.info("[ O STATUS DO SUBSCRIPTION ESTA (SUSPENDE) ENTÃO EXECUTE ( SUSPENDER SUBSCRIPTION ) ]");
        }
        boolean flagSholdReverse = getFlag();
        setVariableSubscriptionId(delegateExecution);
        setVariableBussinesKey(delegateExecution);
        if(!flagSubscriptionIsSuspended){
            setVariableSubscriptionIsSuspended(delegateExecution, flagSubscriptionIsSuspended);
            LOGGER.info("[ subscriptionIsSuspended ] = {}", flagSubscriptionIsSuspended);

            seteVariableSholdReverseSubscriptionPayment(delegateExecution, flagSholdReverse);
            LOGGER.info("[ shouldReverseSubscriptionPayment ] = {}", flagSholdReverse);

        }else{
            setVariableSubscriptionIsSuspended(delegateExecution, flagSubscriptionIsSuspended);
            LOGGER.info("[ subscriptionIsSuspended ] = {}", flagSubscriptionIsSuspended);
        }
    }
}
