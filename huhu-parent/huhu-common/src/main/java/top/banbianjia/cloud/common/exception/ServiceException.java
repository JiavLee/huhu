package top.banbianjia.cloud.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ServiceException extends RuntimeException {
    private Integer code;
    private String msg;
    private Object data;

    public ServiceException(Integer code, String message) {
        super(message);
        this.msg = message;
        this.code = code;
    }

    /**
     * @param msg 错误信息，默认错误码为500
     */
    public ServiceException(String msg) {
        super(msg);
        this.code = Problems.ERROR_500;
        this.msg = msg;
    }

    public ServiceException(Integer code) {
        super();
        this.code = code;
    }

}
