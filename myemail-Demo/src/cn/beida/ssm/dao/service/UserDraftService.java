package cn.beida.ssm.dao.service;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.beida.ssm.dao.UserDraftmapper;
import cn.beida.ssm.pojo.Emailuser;
import cn.beida.ssm.pojo.UserDraft;

public class UserDraftService extends Service<UserDraftmapper>{
    
    private  Logger logger = LoggerFactory.getLogger(UserDraftService.class);
    
    public UserDraftService() {
        super(UserDraftmapper.class);
    }
    
    public Integer savedraft(String uname,String endName,String theme, String con) {
        Emailuser em = new EmailuserService().seleEid(uname);
        Integer deid = em.getEid();
        logger.debug(deid+"");
        UserDraft ud = new UserDraft();
        ud.setDeid(deid);
        ud.setDrecipient(endName);
        ud.setDcon(con);
        ud.setDtheme(theme);
        String ddata = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ud.setDdata(ddata);
        Integer newDid = this.MapperDad.savedraft(ud);
        logger.debug(newDid+"");
        return newDid;
    }
    public List<UserDraft> inquireDraft(int deid){
        List<UserDraft> list = this.MapperDad.inquireDraft(deid);
        return list;
    }
}
