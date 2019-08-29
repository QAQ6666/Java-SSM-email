package cn.beida.ssm.dao.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.beida.ssm.dao.Emailusermapper;
import cn.beida.ssm.pojo.Emailuser;

public class EmailuserService extends Service<Emailusermapper>{
    
    private static Logger logger = LoggerFactory.getLogger(EmailuserService.class);
    
    public EmailuserService() {
        super(Emailusermapper.class);
    }
    /**
     * 通过查询返回一个实体类
     * @param name
     * @return
     */
    public  Emailuser seleEid(String name) {
        Emailuser  emailuser = this.MapperDad.seleEid(name);
        closesSession(this.session);
        return emailuser;
    }
    /**
     * 查询是否有重复的用户名，无则插入数据
     */
    public String seleEmail(String ema) {
        String r = this.MapperDad.seleEmail(ema);
        closesSession(this.session);
        return r;
    }
    /**
     * 
     */
    public Integer addNew(String email, String name) {
        Emailuser emailuser =  new Emailuser();
        emailuser.setEmailstr(email);
        emailuser.setEuname(name);
        try {
            this.MapperDad.addNew(emailuser);
            this.session.commit();
        } catch (Exception e) {
            this.session.rollback();
            return -1;
        }finally {
            closesSession(this.session);
        }
        
        return (emailuser.getEid());
    }
}
