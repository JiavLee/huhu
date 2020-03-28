package top.banbianjia.cloud.member.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.banbianjia.cloud.member.domain.User;
import top.banbianjia.cloud.member.domain.interfaces.IUserService;
import top.banbianjia.cloud.member.mapper.UserMapper;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectUserByNameOrTelAndPassword(User user) {
        return userMapper.selectUserByNameOrTelAndPassword(user);
    }
}
