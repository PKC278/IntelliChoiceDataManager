package com.ruoyi.zyjsinfos.service;

import java.util.List;
import com.ruoyi.zyjsinfos.domain.Zyjsinfos;

/**
 * 院校专业介绍Service接口
 * 
 * @author ruoyi
 * @date 2023-09-05
 */
public interface IZyjsinfosService 
{
    /**
     * 查询院校专业介绍
     * 
     * @param dicCurId 院校专业介绍主键
     * @return 院校专业介绍
     */
    public Zyjsinfos selectZyjsinfosByDicCurId(String dicCurId);

    /**
     * 查询院校专业介绍列表
     * 
     * @param zyjsinfos 院校专业介绍
     * @return 院校专业介绍集合
     */
    public List<Zyjsinfos> selectZyjsinfosList(Zyjsinfos zyjsinfos);

    /**
     * 新增院校专业介绍
     * 
     * @param zyjsinfos 院校专业介绍
     * @return 结果
     */
    public int insertZyjsinfos(Zyjsinfos zyjsinfos);

    /**
     * 修改院校专业介绍
     * 
     * @param zyjsinfos 院校专业介绍
     * @return 结果
     */
    public int updateZyjsinfos(Zyjsinfos zyjsinfos);

    /**
     * 批量删除院校专业介绍
     * 
     * @param dicCurIds 需要删除的院校专业介绍主键集合
     * @return 结果
     */
    public int deleteZyjsinfosByDicCurIds(String[] dicCurIds);

    /**
     * 删除院校专业介绍信息
     * 
     * @param dicCurId 院校专业介绍主键
     * @return 结果
     */
    public int deleteZyjsinfosByDicCurId(String dicCurId);
}
