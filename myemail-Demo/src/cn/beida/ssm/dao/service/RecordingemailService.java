package cn.beida.ssm.dao.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.ResolverUtil.IsA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.beida.ssm.dao.Recordingemailmapper;
import cn.beida.ssm.pojo.Emailuser;
import cn.beida.ssm.pojo.Recordingemail;

public class RecordingemailService extends Service<Recordingemailmapper> {
    
    private  Logger logger = LoggerFactory.getLogger(UserService.class);
    
    public RecordingemailService() {
        super(Recordingemailmapper.class);
    }
    /**
     * 作为一条记录插入到sql
     * @param username
     * @param rbigfile
     * @param rminfile
     * @param rtext
     * @param rdate
     * @return
     */
    public Integer saveEmail(String username,String rbigfile,String rminfile,String rtext,String rdate,String rtheme,String rminfilename) throws SQLException {
        Emailuser email =  new EmailuserService().seleEid(username);
        Recordingemail recording = new Recordingemail();
        recording.setRdate(rdate);
        recording.setRminfilename(rminfilename);
        recording.setRtext(rtext);
        recording.setRtheme(rtheme);
        recording.setRbigfile(rbigfile);
        recording.setRminfile(rminfile);
        recording.setEid(email.getEid()); 
        Integer num =-1;
        try {
             num = this.MapperDad.saveEmail(recording);
            this.session.commit();
        } catch (Exception e) {
            this.session.rollback();
            return num;
        }finally {
            closesSession(this.session);
        }
        return num;
    }
    /**
     * 查询用户的发送记录
     */
    public List<Recordingemail> seleRecording(String username){
        Emailuser email =  new EmailuserService().seleEid(username);
        List<Recordingemail> list = this.MapperDad.seleRecording(email.getEid());
        closesSession(this.session);
        return list;
    }
    public void test() {
        List<Recordingemail> list = this.MapperDad.seleall();
        for (Recordingemail recordingemail : list) {
            System.out.println(recordingemail.getRid());
        }
    }
//    public static void main(String[] args) {
//        new RecordingemailService().test();
//    }
    
}
