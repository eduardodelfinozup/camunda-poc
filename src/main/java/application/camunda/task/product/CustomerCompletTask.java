package application.camunda.task.product;

import application.camunda.config.TaskDelegate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import static application.camunda.util.MessagesUtil.*;

@Component
public class CustomerCompletTask extends TaskDelegate {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());
    public void execute(DelegateExecution delegateExecution) throws Exception {
        delegateExecution.setVariable(SUB_ID, SUBSCRIPTION_ID);
        LOGGER.info("PROCESSO COMPLETADO COM SUCESSO");

    }
}
