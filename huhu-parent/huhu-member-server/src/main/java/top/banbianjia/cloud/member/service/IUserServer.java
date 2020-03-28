package top.banbianjia.cloud.member.service;

import top.banbianjia.cloud.member.domain.User;

public interface IUserServer {
    /**
     * 查询用户
     *
     * @param user
     * @return
     */
    User selectByEntity(User user);

}
