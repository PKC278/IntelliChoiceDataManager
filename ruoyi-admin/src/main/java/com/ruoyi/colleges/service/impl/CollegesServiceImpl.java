package com.ruoyi.colleges.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.colleges.mapper.CollegesMapper;
import com.ruoyi.colleges.domain.Colleges;
import com.ruoyi.colleges.service.ICollegesService;

/**
 * 院校列表Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-08-30
 */
@Service
public class CollegesServiceImpl implements ICollegesService 
{
    @Autowired
    private CollegesMapper collegesMapper;

    /**
     * 查询院校列表
     * 
     * @param yxdm 院校列表主键
     * @return 院校列表
     */
    @Override
    public Colleges selectCollegesByYxdm(Long yxdm)
    {
        return collegesMapper.selectCollegesByYxdm(yxdm);
    }

    /**
     * 查询院校列表列表
     * 
     * @param colleges 院校列表
     * @return 院校列表
     */
    @Override
    public List<Colleges> selectCollegesList(Colleges colleges)
    {
        return collegesMapper.selectCollegesList(colleges);
    }

    /**
     * 新增院校列表
     * 
     * @param colleges 院校列表
     * @return 结果
     */
    @Override
    public int insertColleges(Colleges colleges)
    {
        return collegesMapper.insertColleges(colleges);
    }

    /**
     * 修改院校列表
     * 
     * @param colleges 院校列表
     * @return 结果
     */
    @Override
    public int updateColleges(Colleges colleges)
    {
        return collegesMapper.updateColleges(colleges);
    }

    /**
     * 批量删除院校列表
     * 
     * @param yxdms 需要删除的院校列表主键
     * @return 结果
     */
    @Override
    public int deleteCollegesByYxdms(Long[] yxdms)
    {
        return collegesMapper.deleteCollegesByYxdms(yxdms);
    }

    /**
     * 删除院校列表信息
     * 
     * @param yxdm 院校列表主键
     * @return 结果
     */
    @Override
    public int deleteCollegesByYxdm(Long yxdm)
    {
        return collegesMapper.deleteCollegesByYxdm(yxdm);
    }
}
