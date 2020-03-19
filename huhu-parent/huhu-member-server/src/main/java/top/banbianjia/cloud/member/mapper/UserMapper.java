package top.banbianjia.cloud.member.mapper;

import java.util.List;
import top.banbianjia.cloud.member.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}