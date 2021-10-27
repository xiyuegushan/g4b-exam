package com.g4b.g4bexam.commons;

import java.util.HashMap;
import java.util.Map;

public final class JsonResponse<T> {

    private String state;
    private String returnCode;
    private String returnMsg;
    private T data;

    public JsonResponse() {
    }

    private JsonResponse(String state, String returnCode, String returnMsg, T data) {
        super();
        this.state = state;
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.data = data;
    }

    public String isState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static JsonResponse success() {
        return JsonResponse.create(Constants.SUCCESSFUL_STATUS, Constants.SUCCESSFUL_CODE, "successful", null);
    }

    public static <T> JsonResponse<T> success(T data) {
        return JsonResponse.create(Constants.SUCCESSFUL_STATUS, Constants.SUCCESSFUL_CODE, "successful", data);
    }

    public static <T> JsonResponse<T> success(String msg, T data) {
        return JsonResponse.create(Constants.SUCCESSFUL_STATUS, Constants.SUCCESSFUL_CODE, msg, data);
    }

    public static <T> JsonResponse<Map<T, T>> map(T... elements) {
        if (elements.length % 2 != 0) {
            throw new IllegalArgumentException("Length is illegal.");
        }

        Map<T, T> map = new HashMap<T, T>();
        for (int i = 0; i < elements.length; i++) {
            map.put(elements[i], elements[++i]);
        }

        return JsonResponse.create(Constants.SUCCESSFUL_STATUS, Constants.SUCCESSFUL_CODE, "successful", map);
    }

    public static JsonResponse fail() {
        return JsonResponse.create(Constants.FAULTED_STATUS, Constants.SYSTEM_ERROR_CODE, "faulted", null);
    }

    public static JsonResponse fail(String msg) {
        return JsonResponse.create(Constants.FAULTED_STATUS, Constants.SYSTEM_ERROR_CODE, msg, null);
    }

    public static <T> JsonResponse<T> fail(String msg, T data) {
        return JsonResponse.create(Constants.FAULTED_STATUS, Constants.SYSTEM_ERROR_CODE, msg, data);
    }

    public static <T> JsonResponse<T> fail(String returnCode, String msg) {
        return JsonResponse.create(Constants.FAULTED_STATUS, returnCode, msg, null);
    }

    public static <T> JsonResponse<T> fail(String returnCode, String msg, T data) {
        return JsonResponse.create(Constants.FAULTED_STATUS, returnCode, msg, data);
    }

    public static <T> JsonResponse<T> create(String state, String returnCode, String msg, T data) {
        return new JsonResponse<T>(state, returnCode, msg, data);
    }

    public static JsonResponse create(String state, String returnCode, String msg) {
        return create(state, returnCode, msg, null);
    }

    public static JsonResponse create(String state, String returnCode) {
        return create(state, returnCode, null, null);
    }

}
