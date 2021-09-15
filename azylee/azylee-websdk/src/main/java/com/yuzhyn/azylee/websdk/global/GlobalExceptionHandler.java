package com.yuzhyn.azylee.websdk.global;


import com.yuzhyn.azylee.core.datas.exceptions.ExceptionTool;
import com.yuzhyn.azylee.core.logs.Alog;
import com.yuzhyn.azylee.websdk.model.trans.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseData exception(Exception ex) {
        ResponseData responseData = ResponseData.error(ex.getMessage());
        String exString = ExceptionTool.getStackTrace(ex);
        responseData.putDataMap("exception", exString);
        responseData.putDataMap("by", "全局异常捕获");
        Alog.e(exString);
        return responseData;
    }
}