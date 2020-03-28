package top.banbianjia.cloud.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ResultResponse extends CodeMsg {
    private Object data;

    public ResultResponse(Integer code, String msg) {
        super(code, msg);
    }


    public ResultResponse(Integer code, String msg, Object data) {
        super(code, msg);
        this.data = data;
    }
}
