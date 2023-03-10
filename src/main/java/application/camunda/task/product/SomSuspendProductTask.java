package application.camunda.task.product;

import application.camunda.config.TaskDelegate;
import application.camunda.service.CamundaPocUtilService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import static application.camunda.service.CamundaPocUtilService.*;
import static application.camunda.util.MessagesUtil.*;

@Component
public class SomSuspendProductTask extends TaskDelegate {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("SUSPENDENDO A SUBSCRIPTION NO ( SOM )");
        getVariableSubId(delegateExecution);
        LOGGER.info("SUBSCRIPTION ID {}  SUSPENSA COM SUCESSO!!", SUBSCRIPTION_ID);
    }
}
