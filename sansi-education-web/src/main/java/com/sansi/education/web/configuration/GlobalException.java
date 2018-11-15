package com.sansi.education.web.configuration;

import com.sansi.education.common.Response;
import com.sansi.education.exceptions.BusinessException;
import com.sansi.education.web.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

/**全局异常捕获
 * @author yihang.lv 2018/8/22、17:06
 */
@ControllerAdvice
@ResponseBody
public class GlobalException {

    @Autowired
    private IpUtil ipUtil;

    /**
     * 处理所有业务异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = BusinessException.class)
    public Response handleBusinessException(BusinessException e){
        return Response.error(Integer.valueOf(e.getErrorCode()),e.getErrorMessage(),ipUtil.getIp());
    }

    /**
     * 统一异常处理
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = Exception.class )
    public Response handleException(Exception e) {
        return Response.error(ipUtil.getIp());
    }

    /**
     * 捕获MethodArgumentNotValidException
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object bindException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();

        String errorMesssage = "校验失败:";

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMesssage += fieldError.getDefaultMessage() + ", ";
        }
        HashMap<String,Object> objectHashMap = new HashMap<>();
        objectHashMap.put("success",false);
        objectHashMap.put("errorCode",400);
        objectHashMap.put("errorMsg",errorMesssage);
        return objectHashMap;
    }
}
