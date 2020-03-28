package top.banbianjia.cloud.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.banbianjia.cloud.common.exception.Problems;
import top.banbianjia.cloud.common.exception.ServiceException;
import top.banbianjia.cloud.common.response.ResultResponse;
import top.banbianjia.cloud.member.domain.User;
import top.banbianjia.cloud.member.domain.interfaces.IUserService;
import top.banbianjia.cloud.member.repository.remote.IMemberCache;
import top.banbianjia.cloud.member.repository.remote.prekey.MemberKeyPrefix;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
//    @Autowired
//    private IMemberCache memberCache;

    @GetMapping("/")
    public ResultResponse login(User user, HttpServletResponse response) {
        Optional.ofNullable(user).orElseThrow(() -> new ServiceException(Problems.LOGIN_ERROR));
        if (StringUtils.isEmpty(user.getName()) && StringUtils.isEmpty(user.getTel())) {
            throw new ServiceException(Problems.LOGIN_ERROR);
        }
        User loginUser = userService.selectUserByNameOrTelAndPassword(user);
        //全局异常处理会返回ResultResponse
        Optional.ofNullable(user).orElseThrow(() -> new ServiceException(Problems.LOGIN_ERROR,"账号或密码错误"));
        //发送cookie 存入redis中
        String token = UUID.randomUUID().toString().replace("-", "");
//        memberCache.set(MemberKeyPrefix.MEMBER_LOGIN_PREFIX, token, loginUser);
        Cookie tokenCookie = new Cookie("token", token);
        response.addCookie(tokenCookie);
        return new ResultResponse(Problems.OK, null);
    }
}
