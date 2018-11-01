package com.jishou.schoolfellow.model;

import lombok.Data;

@Data
public class Role {
    private Integer rno;
    private String rname;
    private String rid;
    private String rpw;

    public Integer getRno() {
        return rno;
    }

    public String getRname() {
        return rname;
    }

    public String getRid() {
        return rid;
    }

    public String getRpw() {
        return rpw;
    }

    public void setRno(Integer rno) {
        this.rno = rno;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public void setRpw(String rpw) {
        this.rpw = rpw;
    }
}
