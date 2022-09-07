package com.felix.rice.component.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;


/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-09-04
 */
@Data
public class WebResponse<T> implements Serializable {
    private static final long serialVersionUID = 2346229433865794028L;
    private static final Integer SUCCESS = 1;
    private static final Integer FAIL = -1;
    private static final String SUCCESS_MSG = "success";
    private static final String FAIL_MSG = "fail";
    private final Integer result;
    private String message;
    private Integer code;
    private T data;
    private long currentTime;
    private long costTime;
    public WebResponse(Integer result, String msg) {
        this.result = result;
        this.message = msg;
        this.currentTime = System.currentTimeMillis();
    }
    public  WebResponse() {
        this(SUCCESS, SUCCESS_MSG);
    }

    public WebResponse(T data) {
        this(SUCCESS, SUCCESS_MSG);
        this.data = data;
    }

    public static <T> WebResponse<T> success(T data) {
        return new WebResponse<>(data);
    }

    public static <T> WebResponse<T> fail(T data) {
        WebResponse<T> response = new WebResponse<>(FAIL, FAIL_MSG);
        response.setData(data);
        return response;
    }

    public static <T> WebResponse<T> fail() {
        return new WebResponse<>(FAIL, FAIL_MSG);
    }

    public static <T> WebResponse<T> fail(String msg) {
        return new WebResponse<>(FAIL, msg);
    }

    public WebResponse<T> withCode(int code) {
        this.code = code;
        return this;
    }

    public WebResponse<T> withData(T data) {
        this.data = data;
        return this;
    }

    @SuppressWarnings({"unchecked"})
    public WebResponse<T> withData(String key, Object value) {
        Map<String, Object> map = (Map<String, Object>) this.getData();
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(key, value);
        return this;
    }
}
