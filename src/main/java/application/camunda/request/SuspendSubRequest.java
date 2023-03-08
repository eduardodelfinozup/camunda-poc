package application.camunda.request;

public class SuspendSubRequest {
    private String status;


    public SuspendSubRequest() {
    }
    public SuspendSubRequest(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
