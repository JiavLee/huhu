package top.banbianjia.cloud.member.exception;

import com.alibaba.druid.sql.visitor.functions.Insert;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 抛出的服务异常
 */
@Data
@AllArgsConstructor
public class ServiceException extends RuntimeException {
    private Integer code;
    private String msg;
    private Object data;

    public ServiceException(String msg) {
        this.code = 4001;
        this.msg = msg;
    }
}
