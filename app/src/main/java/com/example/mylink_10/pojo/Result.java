package com.example.mylink_10.pojo;

public class Result {
    private String code;
    private String error;
    private String data;

//    Object data;

    public Result() {
    }

    public Result(String code, String error, String data) {
        this.code = code;
        this.error = error;
        this.data = data;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", error='" + error + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
