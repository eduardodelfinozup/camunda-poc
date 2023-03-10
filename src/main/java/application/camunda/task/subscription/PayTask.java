package application.camunda.task.subscription;

import application.camunda.config.TaskDelegate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import static application.camunda.util.VariableStaticUtil.getVariableSubId;

@Component
public class PayTask extends TaskDelegate {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());

    public void execute(DelegateExecution delegateExecution) throws Exception {
        getVariableSubId(delegateExecution);
        LOGGER.info("PAY CANCELADO E FINALIZADO...");
    }
}
