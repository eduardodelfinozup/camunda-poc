package application.camunda.task.corpredilect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import application.camunda.config.TaskDelegate;
import application.camunda.enums.CorInput;


@Component
public class ConsultCor extends TaskDelegate {

    protected final Logger LOGGER = LogManager.getLogger(this.getClass());

    public void execute(DelegateExecution delegateExecution) throws Exception {

        String COR_PREDILECT = "RED";

        if(COR_PREDILECT.equals(CorInput.RED.name())){
            LOGGER.info("Cor RED selecionada ...");
            delegateExecution.setVariable("COR_ESCOLHIDA", true);
        }else {
            LOGGER.info("Cor GREEN selecionada ...");
            delegateExecution.setVariable("COR_ESCOLHIDA",false);
        }

    }
}
