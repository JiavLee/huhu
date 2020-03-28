package top.banbianjia.cloud.member.domain.interfaces;

import top.banbianjia.cloud.member.domain.User;

public interface IUserService {
    /**
     * 通过名称或者电话和密码查询用户是否存在
     *
     * @param user
     * @return
     */
    User selectUserByNameOrTelAndPassword(User user);

}
