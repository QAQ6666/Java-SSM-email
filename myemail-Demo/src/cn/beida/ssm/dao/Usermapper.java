package cn.beida.ssm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.beida.ssm.pojo.User;

public interface Usermapper extends MapperDad {
    public List<User> alluser();

    public Integer saveUser(User user);

    public User loginto(Map<String, String> map);
    
    public String seleuname(@Param("name")String name);
}
