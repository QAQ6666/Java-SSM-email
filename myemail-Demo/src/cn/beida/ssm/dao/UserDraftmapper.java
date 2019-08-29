package cn.beida.ssm.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.beida.ssm.pojo.UserDraft;

public interface UserDraftmapper extends MapperDad{
    public Integer savedraft(UserDraft Draft);
    public List<UserDraft> inquireDraft(@Param("deid")Integer deid);
}
