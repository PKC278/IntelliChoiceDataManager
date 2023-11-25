package com.ruoyi.colleges.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 院校列表对象 colleges
 * 
 * @author ruoyi
 * @date 2023-08-30
 */
public class Colleges extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 院校代码 */
    @Excel(name = "院校代码")
    private Long yxdm;

    /** 院校ID */
    @Excel(name = "院校ID")
    private String schoolID;

    /** 院校详情代码 */
    @Excel(name = "院校详情代码")
    private String schInfoId;

    /** 院校名称 */
    @Excel(name = "院校名称")
    private String schoolName;

    /** 院校所属省份 */
    @Excel(name = "院校所属省份")
    private String location;

    /** 主管部门 */
    @Excel(name = "主管部门")
    private String governingDepartment;

    /** 院校类型 */
    @Excel(name = "院校类型")
    private String universityType;

    /** 办学层次 */
    @Excel(name = "办学层次")
    private String educationLevel;

    /** 一流大学 */
    @Excel(name = "一流大学")
    private String yldx;

    /** 一流学科 */
    @Excel(name = "一流学科")
    private String ylxk;

    /** 是否双一流 */
    @Excel(name = "是否双一流")
    private String syl;

    /** 是否有研究院 */
    @Excel(name = "是否有研究院")
    private String yjs;

    /** 满意度 */
    @Excel(name = "满意度")
    private String manyidu;

    /** 校徽 */
    private String schoolBadge;

    /** 关注数 */
    @Excel(name = "关注数")
    private String followCount;

    /** 官方电话 */
    @Excel(name = "官方电话")
    private String dh;

    /** hasZb */
    @Excel(name = "hasZb")
    private String hasZb;

    /** 招生网址 */
    @Excel(name = "招生网址")
    private String zswz;

    /** 通讯地址 */
    @Excel(name = "通讯地址")
    private String txdz;

    /** 学校网址 */
    @Excel(name = "学校网址")
    private String xxwz;

    /** 校内专业排名 */
    private String avgRank;

    /** 社交账号 */
    private String sjzh;

    /** 微信二维码 */
    private String wxQR;

    /** 微博二维码 */
    private String wbQR;

    public void setYxdm(Long yxdm) 
    {
        this.yxdm = yxdm;
    }

    public Long getYxdm() 
    {
        return yxdm;
    }
    public void setSchoolID(String schoolID) 
    {
        this.schoolID = schoolID;
    }

    public String getSchoolID() 
    {
        return schoolID;
    }
    public void setSchInfoId(String schInfoId) 
    {
        this.schInfoId = schInfoId;
    }

    public String getSchInfoId() 
    {
        return schInfoId;
    }
    public void setSchoolName(String schoolName) 
    {
        this.schoolName = schoolName;
    }

    public String getSchoolName() 
    {
        return schoolName;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setGoverningDepartment(String governingDepartment) 
    {
        this.governingDepartment = governingDepartment;
    }

    public String getGoverningDepartment() 
    {
        return governingDepartment;
    }
    public void setUniversityType(String universityType) 
    {
        this.universityType = universityType;
    }

    public String getUniversityType() 
    {
        return universityType;
    }
    public void setEducationLevel(String educationLevel) 
    {
        this.educationLevel = educationLevel;
    }

    public String getEducationLevel() 
    {
        return educationLevel;
    }
    public void setYldx(String yldx) 
    {
        this.yldx = yldx;
    }

    public String getYldx() 
    {
        return yldx;
    }
    public void setYlxk(String ylxk) 
    {
        this.ylxk = ylxk;
    }

    public String getYlxk() 
    {
        return ylxk;
    }
    public void setSyl(String syl) 
    {
        this.syl = syl;
    }

    public String getSyl() 
    {
        return syl;
    }
    public void setYjs(String yjs) 
    {
        this.yjs = yjs;
    }

    public String getYjs() 
    {
        return yjs;
    }
    public void setManyidu(String manyidu) 
    {
        this.manyidu = manyidu;
    }

    public String getManyidu() 
    {
        return manyidu;
    }
    public void setSchoolBadge(String schoolBadge) 
    {
        this.schoolBadge = schoolBadge;
    }

    public String getSchoolBadge() 
    {
        return schoolBadge;
    }
    public void setFollowCount(String followCount) 
    {
        this.followCount = followCount;
    }

    public String getFollowCount() 
    {
        return followCount;
    }
    public void setDh(String dh) 
    {
        this.dh = dh;
    }

    public String getDh() 
    {
        return dh;
    }
    public void setHasZb(String hasZb) 
    {
        this.hasZb = hasZb;
    }

    public String getHasZb() 
    {
        return hasZb;
    }
    public void setZswz(String zswz) 
    {
        this.zswz = zswz;
    }

    public String getZswz() 
    {
        return zswz;
    }
    public void setTxdz(String txdz) 
    {
        this.txdz = txdz;
    }

    public String getTxdz() 
    {
        return txdz;
    }
    public void setXxwz(String xxwz) 
    {
        this.xxwz = xxwz;
    }

    public String getXxwz() 
    {
        return xxwz;
    }
    public void setAvgRank(String avgRank) 
    {
        this.avgRank = avgRank;
    }

    public String getAvgRank() 
    {
        return avgRank;
    }
    public void setSjzh(String sjzh) 
    {
        this.sjzh = sjzh;
    }

    public String getSjzh() 
    {
        return sjzh;
    }
    public void setWxQR(String wxQR) 
    {
        this.wxQR = wxQR;
    }

    public String getWxQR() 
    {
        return wxQR;
    }
    public void setWbQR(String wbQR) 
    {
        this.wbQR = wbQR;
    }

    public String getWbQR() 
    {
        return wbQR;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("yxdm", getYxdm())
            .append("schoolID", getSchoolID())
            .append("schInfoId", getSchInfoId())
            .append("schoolName", getSchoolName())
            .append("location", getLocation())
            .append("governingDepartment", getGoverningDepartment())
            .append("universityType", getUniversityType())
            .append("educationLevel", getEducationLevel())
            .append("yldx", getYldx())
            .append("ylxk", getYlxk())
            .append("syl", getSyl())
            .append("yjs", getYjs())
            .append("manyidu", getManyidu())
            .append("schoolBadge", getSchoolBadge())
            .append("followCount", getFollowCount())
            .append("dh", getDh())
            .append("hasZb", getHasZb())
            .append("zswz", getZswz())
            .append("txdz", getTxdz())
            .append("xxwz", getXxwz())
            .append("avgRank", getAvgRank())
            .append("sjzh", getSjzh())
            .append("wxQR", getWxQR())
            .append("wbQR", getWbQR())
            .toString();
    }
}
