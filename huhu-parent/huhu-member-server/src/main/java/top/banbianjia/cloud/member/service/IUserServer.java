package top.banbianjia.cloud.member.service;

import top.banbianjia.cloud.member.domain.User;

public interface IUserServer {
    /**
     * 查询用户
     * @param user
     * @return
     */
    public User selectByEntity(User user);

    public User selectByNameAndPassword(User user);
}
