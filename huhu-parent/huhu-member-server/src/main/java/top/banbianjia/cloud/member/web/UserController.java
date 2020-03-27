package top.banbianjia.cloud.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.banbianjia.cloud.member.domain.User;
import top.banbianjia.cloud.member.exception.ServiceException;
import top.banbianjia.cloud.member.response.ResponseResult;
import top.banbianjia.cloud.member.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.Option;

import java.rmi.ServerException;
import java.util.Optional;

import static top.banbianjia.cloud.member.response.ResponseCode.LOGIN_ERROR;
import static top.banbianjia.cloud.member.response.ResponseCode.LOGIN_SUCCESS;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("")
    public Object login(User user, HttpServletResponse response) {
        //无法查找到对象
        User loginUser = userService.selectByNameAndPassword(user);
        Optional.ofNullable(loginUser).orElseThrow(() -> new ServiceException("账号密码不正常"));
            //生成cookie -->放入redis中
            //response.addCookie();
        return new ResponseResult(LOGIN_SUCCESS);
    }

}
