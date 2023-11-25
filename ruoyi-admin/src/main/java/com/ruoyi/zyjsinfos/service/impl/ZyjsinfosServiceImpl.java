package com.ruoyi.zyjsinfos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zyjsinfos.mapper.ZyjsinfosMapper;
import com.ruoyi.zyjsinfos.domain.Zyjsinfos;
import com.ruoyi.zyjsinfos.service.IZyjsinfosService;

/**
 * 院校专业介绍Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-09-05
 */
@Service
public class ZyjsinfosServiceImpl implements IZyjsinfosService 
{
    @Autowired
    private ZyjsinfosMapper zyjsinfosMapper;

    /**
     * 查询院校专业介绍
     * 
     * @param dicCurId 院校专业介绍主键
     * @return 院校专业介绍
     */
    @Override
    public Zyjsinfos selectZyjsinfosByDicCurId(String dicCurId)
    {
        return zyjsinfosMapper.selectZyjsinfosByDicCurId(dicCurId);
    }

    /**
     * 查询院校专业介绍列表
     * 
     * @param zyjsinfos 院校专业介绍
     * @return 院校专业介绍
     */
    @Override
    public List<Zyjsinfos> selectZyjsinfosList(Zyjsinfos zyjsinfos)
    {
        return zyjsinfosMapper.selectZyjsinfosList(zyjsinfos);
    }

    /**
     * 新增院校专业介绍
     * 
     * @param zyjsinfos 院校专业介绍
     * @return 结果
     */
    @Override
    public int insertZyjsinfos(Zyjsinfos zyjsinfos)
    {
        return zyjsinfosMapper.insertZyjsinfos(zyjsinfos);
    }

    /**
     * 修改院校专业介绍
     * 
     * @param zyjsinfos 院校专业介绍
     * @return 结果
     */
    @Override
    public int updateZyjsinfos(Zyjsinfos zyjsinfos)
    {
        return zyjsinfosMapper.updateZyjsinfos(zyjsinfos);
    }

    /**
     * 批量删除院校专业介绍
     * 
     * @param dicCurIds 需要删除的院校专业介绍主键
     * @return 结果
     */
    @Override
    public int deleteZyjsinfosByDicCurIds(String[] dicCurIds)
    {
        return zyjsinfosMapper.deleteZyjsinfosByDicCurIds(dicCurIds);
    }

    /**
     * 删除院校专业介绍信息
     * 
     * @param dicCurId 院校专业介绍主键
     * @return 结果
     */
    @Override
    public int deleteZyjsinfosByDicCurId(String dicCurId)
    {
        return zyjsinfosMapper.deleteZyjsinfosByDicCurId(dicCurId);
    }
}
