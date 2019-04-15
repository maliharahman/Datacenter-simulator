package core;

import domain.Response;

import java.util.ArrayList;
import java.util.List;

public class ResponseDataHandler {
    private static final ResponseDataHandler responseDataHandler = new ResponseDataHandler();
    public List<Response> responseList = new ArrayList<Response>();

    private ResponseDataHandler() {
    }

    public static ResponseDataHandler getResponseDataHandlerInstance() {
        return responseDataHandler;
    }

    public List<Response> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Response> responseList) {
        this.responseList = responseList;
    }
}
