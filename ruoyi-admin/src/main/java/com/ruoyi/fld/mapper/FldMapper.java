package com.ruoyi.fld.mapper;

import java.util.List;
import com.ruoyi.fld.domain.Fld;

/**
 * 院校详情Mapper接口
 * 
 * @author ruoyi
 * @date 2023-09-04
 */
public interface FldMapper 
{
    /**
     * 查询院校详情
     * 
     * @param yxdm 院校详情主键
     * @return 院校详情
     */
    public Fld selectFldByYxdm(Long yxdm);

    /**
     * 查询院校详情列表
     * 
     * @param fld 院校详情
     * @return 院校详情集合
     */
    public List<Fld> selectFldList(Fld fld);

    /**
     * 新增院校详情
     * 
     * @param fld 院校详情
     * @return 结果
     */
    public int insertFld(Fld fld);

    /**
     * 修改院校详情
     * 
     * @param fld 院校详情
     * @return 结果
     */
    public int updateFld(Fld fld);

    /**
     * 删除院校详情
     * 
     * @param yxdm 院校详情主键
     * @return 结果
     */
    public int deleteFldByYxdm(Long yxdm);

    /**
     * 批量删除院校详情
     * 
     * @param yxdms 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFldByYxdms(Long[] yxdms);
}
