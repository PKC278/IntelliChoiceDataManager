package com.ruoyi.major.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.major.mapper.MajorMapper;
import com.ruoyi.major.domain.Major;
import com.ruoyi.major.service.IMajorService;

/**
 * 专业列表Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-09-05
 */
@Service
public class MajorServiceImpl implements IMajorService 
{
    @Autowired
    private MajorMapper majorMapper;

    /**
     * 查询专业列表
     * 
     * @param CategoryID 专业列表主键
     * @return 专业列表
     */
    @Override
    public Major selectMajorByCategoryID(Long CategoryID)
    {
        return majorMapper.selectMajorByCategoryID(CategoryID);
    }

    /**
     * 查询专业列表列表
     * 
     * @param major 专业列表
     * @return 专业列表
     */
    @Override
    public List<Major> selectMajorList(Major major)
    {
        return majorMapper.selectMajorList(major);
    }

    /**
     * 新增专业列表
     * 
     * @param major 专业列表
     * @return 结果
     */
    @Override
    public int insertMajor(Major major)
    {
        return majorMapper.insertMajor(major);
    }

    /**
     * 修改专业列表
     * 
     * @param major 专业列表
     * @return 结果
     */
    @Override
    public int updateMajor(Major major)
    {
        return majorMapper.updateMajor(major);
    }

    /**
     * 批量删除专业列表
     * 
     * @param CategoryIDs 需要删除的专业列表主键
     * @return 结果
     */
    @Override
    public int deleteMajorByCategoryIDs(Long[] CategoryIDs)
    {
        return majorMapper.deleteMajorByCategoryIDs(CategoryIDs);
    }

    /**
     * 删除专业列表信息
     * 
     * @param CategoryID 专业列表主键
     * @return 结果
     */
    @Override
    public int deleteMajorByCategoryID(Long CategoryID)
    {
        return majorMapper.deleteMajorByCategoryID(CategoryID);
    }
}
