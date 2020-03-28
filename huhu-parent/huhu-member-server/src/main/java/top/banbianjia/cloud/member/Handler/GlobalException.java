package top.banbianjia.cloud.member.Handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.banbianjia.cloud.common.exception.Problems;
import top.banbianjia.cloud.common.exception.ServiceException;
import top.banbianjia.cloud.common.response.ResultResponse;


@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ServiceException.class)
    public Object serviceException(ServiceException e) {
        e.printStackTrace();
        return new ResultResponse(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Object exception(Exception e) {
        e.printStackTrace();
        return new ResultResponse(Problems.ERROR_500, e.getMessage());
    }
}