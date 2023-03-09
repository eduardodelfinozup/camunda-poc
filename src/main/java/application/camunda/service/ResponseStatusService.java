package application.camunda.service;

import application.camunda.response.SuspendSubResp;
import application.camunda.util.ResponseEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ResponseStatusService {
    private ResponseEntityUtil responseEntityUtil;

    @Autowired
    public ResponseStatusService(ResponseEntityUtil responseEntityUtil) {
        this.responseEntityUtil = responseEntityUtil;
    }

    public ResponseEntity<?> responseStatusService(SuspendSubResp responseInit, HttpStatus httpStatus) {
        return responseEntityUtil.resposeStatus(responseInit, httpStatus);
    }
}
