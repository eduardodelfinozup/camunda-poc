package application.camunda.response;

import static application.camunda.util.MessagesUtil.*;

public class SuspendSubResp {

    private String idProcesso;
    private String subscriptionStatus;
    private String message;

    public SuspendSubResp() {
    }

    public SuspendSubResp(String idProcesso, String subscriptionStatus, String message) {
        this.idProcesso = idProcesso;
        this.subscriptionStatus = subscriptionStatus;
        this.message = message;
    }

    public SuspendSubResp(String idProcesso, String status) {
        this.idProcesso = idProcesso;
        this.subscriptionStatus = subIsActive(status);
        this.message = MESSAGE_PROCESSO_CONCLUIDO;

    }

    public SuspendSubResp ValidateResp(String idProcesso, String status, String message) {
        return new SuspendSubResp(idProcesso, status, message);
    }

    public String getIdProcesso() {
        return idProcesso;
    }

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public String getMessage() {
        return message;
    }

    private String subIsActive(String status) {
        return status.equalsIgnoreCase(BOOLEAN_TRUE) ? SUSPENDE : ACTIVE;
    }
}
