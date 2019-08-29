package cn.beida.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.beida.ssm.pojo.Recordingemail;

public interface Recordingemailmapper extends MapperDad {
    //使用注解的方法调用sql
    @Select("Select * from recordingemail")
    public List<Recordingemail> seleall();
    
    public Integer saveEmail(Recordingemail recordingemail);
    //查询用户发送记录
    public List<Recordingemail> seleRecording(@Param("id")Integer id);
}
