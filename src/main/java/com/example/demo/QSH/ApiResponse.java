package com.example.demo.QSH;



import lombok.Getter;

import java.util.List;

@Getter
public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;
    private List<T> dataList;
    public ApiResponse(int status,String message){
        this.status=status;
        this.message=message;
    }
    public ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public ApiResponse(int status, String message ,List<T> dataList) {
        this.status = status;
        this.message = message;
        this.dataList=dataList;
    }

}