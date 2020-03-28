package top.banbianjia.cloud.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.banbianjia.cloud.member.domain.User;
import top.banbianjia.cloud.member.mapper.UserMapper;
import top.banbianjia.cloud.member.service.IUserServer;

@Service
public class UserServiceImpl implements IUserServer {
    @Autowired
    private UserMapper userMapper;

    public User selectByEntity(User user) {
        return userMapper.selectByPrimaryKey(user.getId());
    }

}
