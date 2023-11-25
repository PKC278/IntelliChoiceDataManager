package com.ruoyi.zyjsinfos.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 院校专业介绍对象 zyjsinfos
 * 
 * @author ruoyi
 * @date 2023-09-05
 */
public class Zyjsinfos extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 院校代码 */
    @Excel(name = "院校代码")
    private Long yxdm;

    /** dicCurId */
    private String dicCurId;

    /** 定位ID */
    private String specId;

    /** 院校ID */
    @Excel(name = "院校ID")
    private String schID;

    /** 专业ID */
    private String categoryId;

    /** 院校层次 */
    @Excel(name = "院校层次")
    private String yxcc;

    /** 专业类别 */
    @Excel(name = "专业类别")
    private String type;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String zy;

    /** 是否包含专业介绍 */
    @Excel(name = "是否包含专业介绍")
    private String hasInfo;

    /** 专业介绍 */
    private String zyjs;

    public void setYxdm(Long yxdm) 
    {
        this.yxdm = yxdm;
    }

    public Long getYxdm() 
    {
        return yxdm;
    }
    public void setDicCurId(String dicCurId) 
    {
        this.dicCurId = dicCurId;
    }

    public String getDicCurId() 
    {
        return dicCurId;
    }
    public void setSpecId(String specId) 
    {
        this.specId = specId;
    }

    public String getSpecId() 
    {
        return specId;
    }
    public void setSchID(String schID) 
    {
        this.schID = schID;
    }

    public String getSchID() 
    {
        return schID;
    }
    public void setCategoryId(String categoryId) 
    {
        this.categoryId = categoryId;
    }

    public String getCategoryId() 
    {
        return categoryId;
    }
    public void setYxcc(String yxcc) 
    {
        this.yxcc = yxcc;
    }

    public String getYxcc() 
    {
        return yxcc;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setZy(String zy) 
    {
        this.zy = zy;
    }

    public String getZy() 
    {
        return zy;
    }
    public void setHasInfo(String hasInfo) 
    {
        this.hasInfo = hasInfo;
    }

    public String getHasInfo() 
    {
        return hasInfo;
    }
    public void setZyjs(String zyjs) 
    {
        this.zyjs = zyjs;
    }

    public String getZyjs() 
    {
        return zyjs;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("yxdm", getYxdm())
            .append("dicCurId", getDicCurId())
            .append("specId", getSpecId())
            .append("schID", getSchID())
            .append("categoryId", getCategoryId())
            .append("yxcc", getYxcc())
            .append("type", getType())
            .append("zy", getZy())
            .append("hasInfo", getHasInfo())
            .append("zyjs", getZyjs())
            .toString();
    }
}
