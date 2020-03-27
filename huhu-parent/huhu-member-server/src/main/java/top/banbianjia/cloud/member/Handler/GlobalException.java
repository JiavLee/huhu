package top.banbianjia.cloud.member.Handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.banbianjia.cloud.member.exception.ServiceException;

import java.rmi.ServerException;

/**
 * 全局异常捕捉
 */
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ServerException.class)
    public Object serviceException(Exception e) {
        e.printStackTrace();
        return new ServiceException(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Object exception(Exception e) {
        e.printStackTrace();
        return new ServiceException(e.getMessage());
    }
}
