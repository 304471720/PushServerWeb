package com.jia.push.newpush.bean;


/**
 * Created by user on 2017/3/21.
 */
public class SendHuoDongEntity {
    private String id;
    private String company;
    private String type;
    private String title;
    private String cont;
    private String url;
    private String complan;
    private String starttime;
    private String endtime;
    private String inserttime;
    private Integer flag;
    private String dest;
    private String huoDonguser;
    private String city;
    private String role;
    private String effectiveTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComplan() {
        return complan;
    }

    public void setComplan(String complan) {
        this.complan = complan;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getInserttime() {
        return inserttime;
    }

    public void setInserttime(String inserttime) {
        this.inserttime = inserttime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getHuoDonguser() {
        return huoDonguser;
    }

    public void setHuoDonguser(String huoDonguser) {
        this.huoDonguser = huoDonguser;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SendHuoDongEntity that = (SendHuoDongEntity) o;

        if (id != that.id) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (cont != null ? !cont.equals(that.cont) : that.cont != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (complan != null ? !complan.equals(that.complan) : that.complan != null) return false;
        if (starttime != null ? !starttime.equals(that.starttime) : that.starttime != null) return false;
        if (endtime != null ? !endtime.equals(that.endtime) : that.endtime != null) return false;
        if (inserttime != null ? !inserttime.equals(that.inserttime) : that.inserttime != null) return false;
        if (flag != null ? !flag.equals(that.flag) : that.flag != null) return false;
        if (dest != null ? !dest.equals(that.dest) : that.dest != null) return false;
        if (huoDonguser != null ? !huoDonguser.equals(that.huoDonguser) : that.huoDonguser != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (effectiveTime != null ? !effectiveTime.equals(that.effectiveTime) : that.effectiveTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? Integer.valueOf(id) : 0 ;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (cont != null ? cont.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (complan != null ? complan.hashCode() : 0);
        result = 31 * result + (starttime != null ? starttime.hashCode() : 0);
        result = 31 * result + (endtime != null ? endtime.hashCode() : 0);
        result = 31 * result + (inserttime != null ? inserttime.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (dest != null ? dest.hashCode() : 0);
        result = 31 * result + (huoDonguser != null ? huoDonguser.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (effectiveTime != null ? effectiveTime.hashCode() : 0);
        return result;
    }
}
