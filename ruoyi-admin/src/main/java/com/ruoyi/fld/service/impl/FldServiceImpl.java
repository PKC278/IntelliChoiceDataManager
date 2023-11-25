package com.ruoyi.fld.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fld.mapper.FldMapper;
import com.ruoyi.fld.domain.Fld;
import com.ruoyi.fld.service.IFldService;

/**
 * 院校详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-09-04
 */
@Service
public class FldServiceImpl implements IFldService 
{
    @Autowired
    private FldMapper fldMapper;

    /**
     * 查询院校详情
     * 
     * @param yxdm 院校详情主键
     * @return 院校详情
     */
    @Override
    public Fld selectFldByYxdm(Long yxdm)
    {
        return fldMapper.selectFldByYxdm(yxdm);
    }

    /**
     * 查询院校详情列表
     * 
     * @param fld 院校详情
     * @return 院校详情
     */
    @Override
    public List<Fld> selectFldList(Fld fld)
    {
        return fldMapper.selectFldList(fld);
    }

    /**
     * 新增院校详情
     * 
     * @param fld 院校详情
     * @return 结果
     */
    @Override
    public int insertFld(Fld fld)
    {
        return fldMapper.insertFld(fld);
    }

    /**
     * 修改院校详情
     * 
     * @param fld 院校详情
     * @return 结果
     */
    @Override
    public int updateFld(Fld fld)
    {
        return fldMapper.updateFld(fld);
    }

    /**
     * 批量删除院校详情
     * 
     * @param yxdms 需要删除的院校详情主键
     * @return 结果
     */
    @Override
    public int deleteFldByYxdms(Long[] yxdms)
    {
        return fldMapper.deleteFldByYxdms(yxdms);
    }

    /**
     * 删除院校详情信息
     * 
     * @param yxdm 院校详情主键
     * @return 结果
     */
    @Override
    public int deleteFldByYxdm(Long yxdm)
    {
        return fldMapper.deleteFldByYxdm(yxdm);
    }
}
