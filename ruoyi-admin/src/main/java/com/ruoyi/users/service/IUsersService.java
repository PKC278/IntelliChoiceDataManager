package com.ruoyi.users.service;

import java.util.List;
import com.ruoyi.users.domain.Users;

/**
 * 用户管理Service接口
 * 
 * @author ruoyi
 * @date 2023-09-05
 */
public interface IUsersService 
{
    /**
     * 查询用户管理
     * 
     * @param UserId 用户管理主键
     * @return 用户管理
     */
    public Users selectUsersByUserId(Long UserId);

    /**
     * 查询用户管理列表
     * 
     * @param users 用户管理
     * @return 用户管理集合
     */
    public List<Users> selectUsersList(Users users);

    /**
     * 新增用户管理
     * 
     * @param users 用户管理
     * @return 结果
     */
    public int insertUsers(Users users);

    /**
     * 修改用户管理
     * 
     * @param users 用户管理
     * @return 结果
     */
    public int updateUsers(Users users);

    /**
     * 批量删除用户管理
     * 
     * @param UserIds 需要删除的用户管理主键集合
     * @return 结果
     */
    public int deleteUsersByUserIds(Long[] UserIds);

    /**
     * 删除用户管理信息
     * 
     * @param UserId 用户管理主键
     * @return 结果
     */
    public int deleteUsersByUserId(Long UserId);
}
