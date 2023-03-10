package application.camunda.service;

import application.camunda.request.SuspendSubRequest;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

import static application.camunda.util.MessagesUtil.*;

@Service
public class CamundaPocUtilService {
    private RuntimeService runtimeService;

    @Autowired
    public CamundaPocUtilService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public String startProcessFluxoCorPredilect() {
        return runtimeService.startProcessInstanceByKey(COR_PREDILECT_START).getId();
    }

    public String startProcessFluxoSuspendProduct(SuspendSubRequest req) {
        return runtimeService.startProcessInstanceByKey(SUSPEND_PRODUCTS_START, BUSSINESSkEY, req.getStatus()).getId();
    }

    public ProcessInstance findExecutionByDefinitionKey(String definitionKey) {
        return runtimeService.createProcessInstanceQuery()
                .processDefinitionKey(definitionKey)
                .singleResult();
    }

    public ProcessInstance findExecutionByBusinessKeyAndDefinitionKey(String businessKey, String definitionKey) {
        return runtimeService.createProcessInstanceQuery()
                .processInstanceBusinessKey(businessKey, definitionKey)
                .singleResult();
    }

    public boolean isSubscriptionStatusSuspende(String flag) {
        return flag.equalsIgnoreCase("true") ? true : false;
    }

    public void killProcess(String processId, String definitionKey) {
        runtimeService.deleteProcessInstance(processId, definitionKey);
    }

    public static void seteVariableSholdReverseSubscriptionPayment(DelegateExecution delegateExecution, boolean flagSholdReverse) {
        delegateExecution.setVariable(SHOLD_REBERSE_SUBSCRIPTION_PAYMENT, flagSholdReverse);
    }

    public static void setVariableSubscriptionIsSuspended(DelegateExecution delegateExecution, boolean flagSubscriptionIsSuspended) {
        delegateExecution.setVariable(SUBSCRIPTION_IS_SUSPENDED, flagSubscriptionIsSuspended);
    }
    public static void setVariableSubscriptionId(DelegateExecution delegateExecution) {
        delegateExecution.setVariable(SUB_ID, SUBSCRIPTION_ID);
    }
    public static void setVariableBussinesKey(DelegateExecution delegateExecution) {
        delegateExecution.setVariable("businessKey", BUSSINESSkEY);
    }

    public static void getVariableSubId(DelegateExecution delegateExecution) {
        delegateExecution.getVariable(SUB_ID);
    }

    public static String geVariabletShouldReverseSubscriptionPayment(DelegateExecution delegateExecution) {
        return delegateExecution.getVariable(SHOLD_REBERSE_SUBSCRIPTION_PAYMENT).toString();
    }

    public static  int gerarValor(){
        Random gerador = new Random();
        return gerador.nextInt();
    }
    public static  boolean getFlag(){
        int valor = gerarValor();
        return valor > 0 ? true : false;
    }

}
