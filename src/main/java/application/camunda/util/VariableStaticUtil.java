package application.camunda.util;

import org.camunda.bpm.engine.delegate.DelegateExecution;

import java.util.Random;

import static application.camunda.util.MessagesUtil.*;

public class VariableStaticUtil {
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
