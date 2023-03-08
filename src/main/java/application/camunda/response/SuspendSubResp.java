package application.camunda.response;

public class SuspendSubResp {

    private String idProcesso;
    private String status;

    public SuspendSubResp(String idProcesso, String status) {
        this.idProcesso = idProcesso;
        this.status = status;
    }

    public String getIdProcesso() {
        return idProcesso;
    }

    public String isValue() {
        return status;
    }
}
