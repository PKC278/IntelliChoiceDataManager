package com.ruoyi.major.mapper;

import java.util.List;
import com.ruoyi.major.domain.Major;

/**
 * 专业列表Mapper接口
 * 
 * @author ruoyi
 * @date 2023-09-05
 */
public interface MajorMapper 
{
    /**
     * 查询专业列表
     * 
     * @param CategoryID 专业列表主键
     * @return 专业列表
     */
    public Major selectMajorByCategoryID(Long CategoryID);

    /**
     * 查询专业列表列表
     * 
     * @param major 专业列表
     * @return 专业列表集合
     */
    public List<Major> selectMajorList(Major major);

    /**
     * 新增专业列表
     * 
     * @param major 专业列表
     * @return 结果
     */
    public int insertMajor(Major major);

    /**
     * 修改专业列表
     * 
     * @param major 专业列表
     * @return 结果
     */
    public int updateMajor(Major major);

    /**
     * 删除专业列表
     * 
     * @param CategoryID 专业列表主键
     * @return 结果
     */
    public int deleteMajorByCategoryID(Long CategoryID);

    /**
     * 批量删除专业列表
     * 
     * @param CategoryIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMajorByCategoryIDs(Long[] CategoryIDs);
}
