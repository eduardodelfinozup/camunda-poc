package application.camunda.response;

public class SuspendSubResp {

    private String idProcesso;
    private String subscriptionStatus;

    public SuspendSubResp(String idProcesso, String status) {
        this.idProcesso = idProcesso;
        this.subscriptionStatus = subIsActive(status);

    }

    public String getIdProcesso() {
        return idProcesso;
    }

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    private String subIsActive(String status) {
        return status.equalsIgnoreCase("true")?  "SUSPENDE":  "ACTIVE";
    }
}
