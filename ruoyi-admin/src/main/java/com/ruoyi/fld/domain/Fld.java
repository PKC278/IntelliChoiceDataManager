package com.ruoyi.fld.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 院校详情对象 fld
 * 
 * @author ruoyi
 * @date 2023-09-04
 */
public class Fld extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 院校代码 */
    private Long yxdm;

    /** 院校ID */
    private String schId;

    /** 专业名称缩写 */
    @Excel(name = "专业名称缩写")
    private String fldName;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String name;

    /** 专业ID */
    private String categoryId;

    /** 专业介绍 */
    private String infos;

    public void setYxdm(Long yxdm) 
    {
        this.yxdm = yxdm;
    }

    public Long getYxdm() 
    {
        return yxdm;
    }
    public void setSchId(String schId) 
    {
        this.schId = schId;
    }

    public String getSchId() 
    {
        return schId;
    }
    public void setFldName(String fldName) 
    {
        this.fldName = fldName;
    }

    public String getFldName() 
    {
        return fldName;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCategoryId(String categoryId) 
    {
        this.categoryId = categoryId;
    }

    public String getCategoryId() 
    {
        return categoryId;
    }
    public void setInfos(String infos) 
    {
        this.infos = infos;
    }

    public String getInfos() 
    {
        return infos;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("yxdm", getYxdm())
            .append("schId", getSchId())
            .append("fldName", getFldName())
            .append("name", getName())
            .append("categoryId", getCategoryId())
            .append("infos", getInfos())
            .toString();
    }
}
