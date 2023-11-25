package com.ruoyi.users.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户管理对象 Users
 * 
 * @author ruoyi
 * @date 2023-09-06
 */
public class Users extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long UserId;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String UserName;

    /** 用户邮箱 */
    @Excel(name = "用户邮箱")
    private String UserEmail;

    /** 用户密码 */
    @Excel(name = "用户密码")
    private String UserPwd;

    /** 注册时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "注册时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date RegTime;

    /** 登陆Token */
    private String Token;

    /** 最后登陆时间 */
    private Date LastLogin;

    public void setUserId(Long UserId) 
    {
        this.UserId = UserId;
    }

    public Long getUserId() 
    {
        return UserId;
    }
    public void setUserName(String UserName) 
    {
        this.UserName = UserName;
    }

    public String getUserName() 
    {
        return UserName;
    }
    public void setUserEmail(String UserEmail) 
    {
        this.UserEmail = UserEmail;
    }

    public String getUserEmail() 
    {
        return UserEmail;
    }
    public void setUserPwd(String UserPwd) 
    {
        this.UserPwd = UserPwd;
    }

    public String getUserPwd() 
    {
        return UserPwd;
    }
    public void setRegTime(Date RegTime) 
    {
        this.RegTime = RegTime;
    }

    public Date getRegTime() 
    {
        return RegTime;
    }
    public void setToken(String Token) 
    {
        this.Token = Token;
    }

    public String getToken() 
    {
        return Token;
    }
    public void setLastLogin(Date LastLogin) 
    {
        this.LastLogin = LastLogin;
    }

    public Date getLastLogin() 
    {
        return LastLogin;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("UserId", getUserId())
            .append("UserName", getUserName())
            .append("UserEmail", getUserEmail())
            .append("UserPwd", getUserPwd())
            .append("RegTime", getRegTime())
            .append("Token", getToken())
            .append("LastLogin", getLastLogin())
            .toString();
    }
}
