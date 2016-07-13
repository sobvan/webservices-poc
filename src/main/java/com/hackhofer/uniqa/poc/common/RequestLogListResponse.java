package com.hackhofer.uniqa.poc.common;

import java.util.List;

/**
 * Created by istvan on 13/07/16.
 */
public class RequestLogListResponse {
    List<RequestLog> requestLogs;

    public RequestLogListResponse() {
    }

    public RequestLogListResponse(List<RequestLog> requestLogs) {
        this.requestLogs = requestLogs;
    }

    public List<RequestLog> getRequestLogs() {
        return requestLogs;
    }

    public void setRequestLogs(List<RequestLog> requestLogs) {
        this.requestLogs = requestLogs;
    }
}
