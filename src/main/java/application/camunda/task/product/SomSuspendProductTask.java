package application.camunda.task.product;

import application.camunda.config.TaskDelegate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

@Component
public class SomSuspendProductTask extends TaskDelegate {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("SUSPENDENDO A SUBSCRIPTION NO SOM");
        delegateExecution.getVariable( "SUB-ID");
        LOGGER.info("SUBSCRIPTION ID SUB-123456  SUSPENSA COM SUCESSO!!");
    }
}
