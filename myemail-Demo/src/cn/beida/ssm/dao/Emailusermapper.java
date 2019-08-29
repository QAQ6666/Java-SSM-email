package cn.beida.ssm.dao;

import org.apache.ibatis.annotations.Param;

import cn.beida.ssm.pojo.Emailuser;

public interface Emailusermapper extends MapperDad {
    public Emailuser seleEid(@Param("name")String name);
    public String seleEmail(@Param("email")String email);
    public Integer addNew(Emailuser emailuser);
}
