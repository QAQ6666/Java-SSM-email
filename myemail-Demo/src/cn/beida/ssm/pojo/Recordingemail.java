package cn.beida.ssm.pojo;

public class Recordingemail {
    private Integer rid;

    private String rdate;

    private String rtext;
    
    private Object rminfile;
    
    private String rbigfile;
    private Integer eid;
    
    private String rtheme;
    
    private String rminfilename;

    
    public String getRminfilename() {
        return rminfilename;
    }

    public void setRminfilename(String rminfilename) {
        this.rminfilename = rminfilename;
    }

    public String getRtheme() {
        return rtheme;
    }

    public void setRtheme(String rtheme) {
        this.rtheme = rtheme;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Object getRminfile() {
        return rminfile;
    }

    public void setRminfile(Object rminfile) {
        this.rminfile = rminfile;
    }

    public String getRbigfile() {
        return rbigfile;
    }

    public void setRbigfile(String rbigfile) {
        this.rbigfile = rbigfile;
    }

    public String getRtext() {
        return rtext;
    }

    public void setRtext(String rtext) {
        this.rtext = rtext;
    }

    
    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

}