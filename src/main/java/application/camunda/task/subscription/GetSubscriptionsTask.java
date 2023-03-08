package application.camunda.task.subscription;

import application.camunda.config.TaskDelegate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

@Component
public class GetSubscriptionsTask extends TaskDelegate {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());

    public void execute(DelegateExecution delegateExecution) throws Exception {

        LOGGER.info("COMEÇAR A VALIDAÇÃO SE ESTA SUSPENSA OU NÃO...");
        delegateExecution.setVariable("SUB-ID", "SUB-123456");
        delegateExecution.setVariable("STATUS_SUB", false);

    }
}
