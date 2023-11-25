package com.ruoyi.majorinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.majorinfo.mapper.MajorinfoMapper;
import com.ruoyi.majorinfo.domain.Majorinfo;
import com.ruoyi.majorinfo.service.IMajorinfoService;

/**
 * 专业详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-09-05
 */
@Service
public class MajorinfoServiceImpl implements IMajorinfoService 
{
    @Autowired
    private MajorinfoMapper majorinfoMapper;

    /**
     * 查询专业详情
     * 
     * @param zydm 专业详情主键
     * @return 专业详情
     */
    @Override
    public Majorinfo selectMajorinfoByZydm(Long zydm)
    {
        return majorinfoMapper.selectMajorinfoByZydm(zydm);
    }

    /**
     * 查询专业详情列表
     * 
     * @param majorinfo 专业详情
     * @return 专业详情
     */
    @Override
    public List<Majorinfo> selectMajorinfoList(Majorinfo majorinfo)
    {
        return majorinfoMapper.selectMajorinfoList(majorinfo);
    }

    /**
     * 新增专业详情
     * 
     * @param majorinfo 专业详情
     * @return 结果
     */
    @Override
    public int insertMajorinfo(Majorinfo majorinfo)
    {
        return majorinfoMapper.insertMajorinfo(majorinfo);
    }

    /**
     * 修改专业详情
     * 
     * @param majorinfo 专业详情
     * @return 结果
     */
    @Override
    public int updateMajorinfo(Majorinfo majorinfo)
    {
        return majorinfoMapper.updateMajorinfo(majorinfo);
    }

    /**
     * 批量删除专业详情
     * 
     * @param zydms 需要删除的专业详情主键
     * @return 结果
     */
    @Override
    public int deleteMajorinfoByZydms(Long[] zydms)
    {
        return majorinfoMapper.deleteMajorinfoByZydms(zydms);
    }

    /**
     * 删除专业详情信息
     * 
     * @param zydm 专业详情主键
     * @return 结果
     */
    @Override
    public int deleteMajorinfoByZydm(Long zydm)
    {
        return majorinfoMapper.deleteMajorinfoByZydm(zydm);
    }
}
