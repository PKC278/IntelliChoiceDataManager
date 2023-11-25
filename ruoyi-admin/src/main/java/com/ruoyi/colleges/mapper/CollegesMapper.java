package com.ruoyi.colleges.mapper;

import java.util.List;
import com.ruoyi.colleges.domain.Colleges;

/**
 * 院校列表Mapper接口
 * 
 * @author ruoyi
 * @date 2023-08-30
 */
public interface CollegesMapper 
{
    /**
     * 查询院校列表
     * 
     * @param yxdm 院校列表主键
     * @return 院校列表
     */
    public Colleges selectCollegesByYxdm(Long yxdm);

    /**
     * 查询院校列表列表
     * 
     * @param colleges 院校列表
     * @return 院校列表集合
     */
    public List<Colleges> selectCollegesList(Colleges colleges);

    /**
     * 新增院校列表
     * 
     * @param colleges 院校列表
     * @return 结果
     */
    public int insertColleges(Colleges colleges);

    /**
     * 修改院校列表
     * 
     * @param colleges 院校列表
     * @return 结果
     */
    public int updateColleges(Colleges colleges);

    /**
     * 删除院校列表
     * 
     * @param yxdm 院校列表主键
     * @return 结果
     */
    public int deleteCollegesByYxdm(Long yxdm);

    /**
     * 批量删除院校列表
     * 
     * @param yxdms 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCollegesByYxdms(Long[] yxdms);
}
