package top.banbianjia.cloud.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import top.banbianjia.cloud.member.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectByNameAndPassword(User user);

    User selectTest(@Param("name")String name,@Param("password")String password);
}