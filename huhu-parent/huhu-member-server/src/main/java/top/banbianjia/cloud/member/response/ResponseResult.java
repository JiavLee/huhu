package top.banbianjia.cloud.member.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseResult {
    private Integer code;
    private String msg;
    private Object data;

    public ResponseResult(ResponseCode responseCode) {
        this(responseCode.getCode(), responseCode.getMsg(), null);
    }

}
