package top.banbianjia.cloud.member.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCode {
    private Integer code;
    private String msg;


    public static ResponseCode LOGIN_ERROR = new ResponseCode(4001, "账号或密码错误");
    public static ResponseCode LOGIN_SUCCESS = new ResponseCode(1001, "登录成功");

}
