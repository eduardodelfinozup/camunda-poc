package application.camunda.task.corpredilect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import application.camunda.config.TaskDelegate;
import application.camunda.enums.CorInput;

@Component
public class verifyRed extends TaskDelegate {

    protected final Logger LOGGER = LogManager.getLogger(this.getClass());

    public void execute(DelegateExecution delegateExecution) throws Exception {

        // TODO: SETA A CONDIÇÃO REASON_ID  VALUE: RED
       delegateExecution.getVariable(CorInput.RED.name());
       LOGGER.info("Cor RED capiturado com sucesso");
    }
}
