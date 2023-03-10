package application.camunda.util;

import application.camunda.request.SuspendSubRequest;
import application.camunda.response.SuspendSubResp;
import application.camunda.service.ResponseStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static application.camunda.util.MessagesUtil.BOOLEAN_FALSE;
import static application.camunda.util.MessagesUtil.BOOLEAN_TRUE;

public class ControllerStatic {
    public static ResponseEntity<?> responseStatus(SuspendSubResp responseInit, ResponseStatusService responseStatusService, HttpStatus httpStatus) {
        return responseStatusService.responseStatusService(responseInit, httpStatus);
    }

    public static boolean statusIsNull(SuspendSubRequest req) {
        return req.getStatus() == null;
    }

    public static boolean validateStatus(SuspendSubRequest req) {
        return req.getStatus().equalsIgnoreCase(BOOLEAN_TRUE) || req.getStatus().equalsIgnoreCase(BOOLEAN_FALSE);
    }
}
