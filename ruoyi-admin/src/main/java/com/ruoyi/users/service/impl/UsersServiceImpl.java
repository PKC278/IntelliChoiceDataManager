package com.ruoyi.users.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.UsersMapper;
import com.ruoyi.users.domain.Users;
import com.ruoyi.users.service.IUsersService;

/**
 * 用户管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-09-06
 */
@Service
public class UsersServiceImpl implements IUsersService 
{
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 查询用户管理
     * 
     * @param UserId 用户管理主键
     * @return 用户管理
     */
    @Override
    public Users selectUsersByUserId(Long UserId)
    {
        return usersMapper.selectUsersByUserId(UserId);
    }

    /**
     * 查询用户管理列表
     * 
     * @param users 用户管理
     * @return 用户管理
     */
    @Override
    public List<Users> selectUsersList(Users users)
    {
        return usersMapper.selectUsersList(users);
    }

    /**
     * 新增用户管理
     * 
     * @param users 用户管理
     * @return 结果
     */
    @Override
    public int insertUsers(Users users)
    {
        return usersMapper.insertUsers(users);
    }

    /**
     * 修改用户管理
     * 
     * @param users 用户管理
     * @return 结果
     */
    @Override
    public int updateUsers(Users users)
    {
        return usersMapper.updateUsers(users);
    }

    /**
     * 批量删除用户管理
     * 
     * @param UserIds 需要删除的用户管理主键
     * @return 结果
     */
    @Override
    public int deleteUsersByUserIds(Long[] UserIds)
    {
        return usersMapper.deleteUsersByUserIds(UserIds);
    }

    /**
     * 删除用户管理信息
     * 
     * @param UserId 用户管理主键
     * @return 结果
     */
    @Override
    public int deleteUsersByUserId(Long UserId)
    {
        return usersMapper.deleteUsersByUserId(UserId);
    }
}
