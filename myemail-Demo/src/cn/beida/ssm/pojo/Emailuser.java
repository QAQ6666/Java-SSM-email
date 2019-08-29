package cn.beida.ssm.pojo;

public class Emailuser {
    private Integer eid;

    private String emailstr;

    private String euname;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEmailstr() {
        return emailstr;
    }

    public void setEmailstr(String emailstr) {
        this.emailstr = emailstr == null ? null : emailstr.trim();
    }

    public String getEuname() {
        return euname;
    }

    public void setEuname(String euname) {
        this.euname = euname == null ? null : euname.trim();
    }
}