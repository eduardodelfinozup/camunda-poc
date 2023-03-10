package application.camunda.task.product;

import application.camunda.config.TaskDelegate;
import application.camunda.util.VariableStaticUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import static application.camunda.util.VariableStaticUtil.*;

@Component
public class CustomerCompletTask extends TaskDelegate {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());

    public void execute(DelegateExecution delegateExecution) throws Exception {
        setVariableSubscriptionId(delegateExecution);
        LOGGER.info("PROCESSO COMPLETADO COM SUCESSO");

    }
}
