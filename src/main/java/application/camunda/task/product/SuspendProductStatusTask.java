package application.camunda.task.product;

import application.camunda.config.TaskDelegate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import static application.camunda.util.MessagesUtil.*;

@Component
public class SuspendProductStatusTask extends TaskDelegate {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("SUSPENDENDO O ( PRODUTO )");
        delegateExecution.getVariable(SUB_ID);
        LOGGER.info("PRODUCT STATUS SUSPENSO COM SUCESSO!!");
    }
}
