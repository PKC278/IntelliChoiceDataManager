package com.ruoyi.majorinfo.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.majorinfo.domain.Majorinfo;
import com.ruoyi.majorinfo.service.IMajorinfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 专业详情Controller
 * 
 * @author ruoyi
 * @date 2023-09-05
 */
@RestController
@RequestMapping("/majorinfo/majorinfo")
public class MajorinfoController extends BaseController
{
    @Autowired
    private IMajorinfoService majorinfoService;

    /**
     * 查询专业详情列表
     */
    @PreAuthorize("@ss.hasPermi('majorinfo:majorinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(Majorinfo majorinfo)
    {
        startPage();
        List<Majorinfo> list = majorinfoService.selectMajorinfoList(majorinfo);
        return getDataTable(list);
    }

    /**
     * 导出专业详情列表
     */
    @PreAuthorize("@ss.hasPermi('majorinfo:majorinfo:export')")
    @Log(title = "专业详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Majorinfo majorinfo)
    {
        List<Majorinfo> list = majorinfoService.selectMajorinfoList(majorinfo);
        ExcelUtil<Majorinfo> util = new ExcelUtil<Majorinfo>(Majorinfo.class);
        util.exportExcel(response, list, "专业详情数据");
    }

    /**
     * 获取专业详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('majorinfo:majorinfo:query')")
    @GetMapping(value = "/{zydm}")
    public AjaxResult getInfo(@PathVariable("zydm") Long zydm)
    {
        return success(majorinfoService.selectMajorinfoByZydm(zydm));
    }

    /**
     * 新增专业详情
     */
    @PreAuthorize("@ss.hasPermi('majorinfo:majorinfo:add')")
    @Log(title = "专业详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Majorinfo majorinfo)
    {
        return toAjax(majorinfoService.insertMajorinfo(majorinfo));
    }

    /**
     * 修改专业详情
     */
    @PreAuthorize("@ss.hasPermi('majorinfo:majorinfo:edit')")
    @Log(title = "专业详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Majorinfo majorinfo)
    {
        return toAjax(majorinfoService.updateMajorinfo(majorinfo));
    }

    /**
     * 删除专业详情
     */
    @PreAuthorize("@ss.hasPermi('majorinfo:majorinfo:remove')")
    @Log(title = "专业详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{zydms}")
    public AjaxResult remove(@PathVariable Long[] zydms)
    {
        return toAjax(majorinfoService.deleteMajorinfoByZydms(zydms));
    }
}
