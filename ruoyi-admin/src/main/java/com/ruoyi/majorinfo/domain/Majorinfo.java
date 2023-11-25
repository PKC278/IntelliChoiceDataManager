package com.ruoyi.majorinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 专业详情对象 majorinfo
 * 
 * @author ruoyi
 * @date 2023-09-05
 */
public class Majorinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专业代码 */
    private Long zydm;

    /** 定位ID */
    @Excel(name = "定位ID")
    private String specId;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String zymc;

    /** 所属专业类 */
    @Excel(name = "所属专业类")
    private String xk;

    /** 所属层次 */
    @Excel(name = "所属层次")
    private String xlcc;

    /** 专业介绍 */
    private String zyjs;

    /** 毕业生规模 */
    private String xsgm;

    /** 男女比例 */
    private String boyGirlpercent;

    /** 专业满意度 */
    private String zymyd;

    /** 推荐高校 */
    private String zytjzsList;

    /** 相似专业 */
    private String simileZyList;

    /** 考研方向 */
    private String kyfx;

    /** 就业方向 */
    private String jyfx;

    /** 毕业生平均月薪 */
    private String xcspList;

    public void setZydm(Long zydm) 
    {
        this.zydm = zydm;
    }

    public Long getZydm() 
    {
        return zydm;
    }
    public void setSpecId(String specId) 
    {
        this.specId = specId;
    }

    public String getSpecId() 
    {
        return specId;
    }
    public void setZymc(String zymc) 
    {
        this.zymc = zymc;
    }

    public String getZymc() 
    {
        return zymc;
    }
    public void setXk(String xk) 
    {
        this.xk = xk;
    }

    public String getXk() 
    {
        return xk;
    }
    public void setXlcc(String xlcc) 
    {
        this.xlcc = xlcc;
    }

    public String getXlcc() 
    {
        return xlcc;
    }
    public void setZyjs(String zyjs) 
    {
        this.zyjs = zyjs;
    }

    public String getZyjs() 
    {
        return zyjs;
    }
    public void setXsgm(String xsgm) 
    {
        this.xsgm = xsgm;
    }

    public String getXsgm() 
    {
        return xsgm;
    }
    public void setBoyGirlpercent(String boyGirlpercent) 
    {
        this.boyGirlpercent = boyGirlpercent;
    }

    public String getBoyGirlpercent() 
    {
        return boyGirlpercent;
    }
    public void setZymyd(String zymyd) 
    {
        this.zymyd = zymyd;
    }

    public String getZymyd() 
    {
        return zymyd;
    }
    public void setZytjzsList(String zytjzsList) 
    {
        this.zytjzsList = zytjzsList;
    }

    public String getZytjzsList() 
    {
        return zytjzsList;
    }
    public void setSimileZyList(String simileZyList) 
    {
        this.simileZyList = simileZyList;
    }

    public String getSimileZyList() 
    {
        return simileZyList;
    }
    public void setKyfx(String kyfx) 
    {
        this.kyfx = kyfx;
    }

    public String getKyfx() 
    {
        return kyfx;
    }
    public void setJyfx(String jyfx) 
    {
        this.jyfx = jyfx;
    }

    public String getJyfx() 
    {
        return jyfx;
    }
    public void setXcspList(String xcspList) 
    {
        this.xcspList = xcspList;
    }

    public String getXcspList() 
    {
        return xcspList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("zydm", getZydm())
            .append("specId", getSpecId())
            .append("zymc", getZymc())
            .append("xk", getXk())
            .append("xlcc", getXlcc())
            .append("zyjs", getZyjs())
            .append("xsgm", getXsgm())
            .append("boyGirlpercent", getBoyGirlpercent())
            .append("zymyd", getZymyd())
            .append("zytjzsList", getZytjzsList())
            .append("simileZyList", getSimileZyList())
            .append("kyfx", getKyfx())
            .append("jyfx", getJyfx())
            .append("xcspList", getXcspList())
            .toString();
    }
}
