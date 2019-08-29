package cn.beida.ssm.dao.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.beida.ssm.dao.Usermapper;
import cn.beida.ssm.pojo.User;

public class UserService extends Service<Usermapper>{
    
    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    
    public UserService() {
        super(Usermapper.class);
    }

    public void alluser() {
        List<User> list = this.MapperDad.alluser();
        for (User user : list) {
            System.out.println(user.getUname());
        }
        closesSession(this.session);
    }
    public Integer saveuser(Integer id,String name, String pwd) {
        User user = new User();
        user.setEid(id);
        user.setUname(name);
        user.setUpwd(pwd);
        Integer integer=-1;
        try {
             integer = this.MapperDad.saveUser(user);
            this.session.commit();
        } catch (Exception e) {
            this.session.rollback();
            return integer;
        }finally {
            closesSession(this.session);
        }
       
        return integer;
    }
    public boolean loginto(String name,String pwd) {
       Map<String,String> map = new HashMap<String, String>();
       map.put("name", name);
       map.put("pwd", pwd);
       User user =  this.MapperDad.loginto(map);
       if(user.getUid() != null || user.getUid() != 0) {
           closesSession(this.session);
           return true;
       }
       closesSession(this.session);
       return false;
    }
    
    public String seleuname(String name) {
        String t  = this.MapperDad.seleuname(name);
        closesSession(this.session);
        return t;
    }
}
