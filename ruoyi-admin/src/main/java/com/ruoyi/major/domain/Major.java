package com.ruoyi.major.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 专业列表对象 major
 * 
 * @author ruoyi
 * @date 2023-09-05
 */
public class Major extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专业层次 */
    @Excel(name = "专业层次")
    private String Type;

    /** 专业门类ID */
    private Long CategoryID;

    /** 专业门类 */
    @Excel(name = "专业门类")
    private String Category;

    /** 专业类ID */
    private Long ProfessionalID;

    /** 专业类 */
    @Excel(name = "专业类")
    private String Professional;

    /** 专业代码 */
    private String zydm;

    /** 专业名称 */
    @Excel(name = "专业名称")
    private String zymc;

    /** 定位ID */
    private String specId;

    /** 满意度 */
    @Excel(name = "满意度")
    private String zymyd;

    public void setType(String Type) 
    {
        this.Type = Type;
    }

    public String getType() 
    {
        return Type;
    }
    public void setCategoryID(Long CategoryID) 
    {
        this.CategoryID = CategoryID;
    }

    public Long getCategoryID() 
    {
        return CategoryID;
    }
    public void setCategory(String Category) 
    {
        this.Category = Category;
    }

    public String getCategory() 
    {
        return Category;
    }
    public void setProfessionalID(Long ProfessionalID) 
    {
        this.ProfessionalID = ProfessionalID;
    }

    public Long getProfessionalID() 
    {
        return ProfessionalID;
    }
    public void setProfessional(String Professional) 
    {
        this.Professional = Professional;
    }

    public String getProfessional() 
    {
        return Professional;
    }
    public void setZydm(String zydm) 
    {
        this.zydm = zydm;
    }

    public String getZydm() 
    {
        return zydm;
    }
    public void setZymc(String zymc) 
    {
        this.zymc = zymc;
    }

    public String getZymc() 
    {
        return zymc;
    }
    public void setSpecId(String specId) 
    {
        this.specId = specId;
    }

    public String getSpecId() 
    {
        return specId;
    }
    public void setZymyd(String zymyd) 
    {
        this.zymyd = zymyd;
    }

    public String getZymyd() 
    {
        return zymyd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("Type", getType())
            .append("CategoryID", getCategoryID())
            .append("Category", getCategory())
            .append("ProfessionalID", getProfessionalID())
            .append("Professional", getProfessional())
            .append("zydm", getZydm())
            .append("zymc", getZymc())
            .append("specId", getSpecId())
            .append("zymyd", getZymyd())
            .toString();
    }
}
