package com.ruoyi.majorinfo.service;

import java.util.List;
import com.ruoyi.majorinfo.domain.Majorinfo;

/**
 * 专业详情Service接口
 * 
 * @author ruoyi
 * @date 2023-09-05
 */
public interface IMajorinfoService 
{
    /**
     * 查询专业详情
     * 
     * @param zydm 专业详情主键
     * @return 专业详情
     */
    public Majorinfo selectMajorinfoByZydm(Long zydm);

    /**
     * 查询专业详情列表
     * 
     * @param majorinfo 专业详情
     * @return 专业详情集合
     */
    public List<Majorinfo> selectMajorinfoList(Majorinfo majorinfo);

    /**
     * 新增专业详情
     * 
     * @param majorinfo 专业详情
     * @return 结果
     */
    public int insertMajorinfo(Majorinfo majorinfo);

    /**
     * 修改专业详情
     * 
     * @param majorinfo 专业详情
     * @return 结果
     */
    public int updateMajorinfo(Majorinfo majorinfo);

    /**
     * 批量删除专业详情
     * 
     * @param zydms 需要删除的专业详情主键集合
     * @return 结果
     */
    public int deleteMajorinfoByZydms(Long[] zydms);

    /**
     * 删除专业详情信息
     * 
     * @param zydm 专业详情主键
     * @return 结果
     */
    public int deleteMajorinfoByZydm(Long zydm);
}
