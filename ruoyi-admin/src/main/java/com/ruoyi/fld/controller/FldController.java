package com.ruoyi.fld.controller;

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
import com.ruoyi.fld.domain.Fld;
import com.ruoyi.fld.service.IFldService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 院校详情Controller
 * 
 * @author ruoyi
 * @date 2023-09-04
 */
@RestController
@RequestMapping("/fld/fld")
public class FldController extends BaseController
{
    @Autowired
    private IFldService fldService;

    /**
     * 查询院校详情列表
     */
    @PreAuthorize("@ss.hasPermi('fld:fld:list')")
    @GetMapping("/list")
    public TableDataInfo list(Fld fld)
    {
        startPage();
        List<Fld> list = fldService.selectFldList(fld);
        return getDataTable(list);
    }

    /**
     * 导出院校详情列表
     */
    @PreAuthorize("@ss.hasPermi('fld:fld:export')")
    @Log(title = "院校详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Fld fld)
    {
        List<Fld> list = fldService.selectFldList(fld);
        ExcelUtil<Fld> util = new ExcelUtil<Fld>(Fld.class);
        util.exportExcel(response, list, "院校详情数据");
    }

    /**
     * 获取院校详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('fld:fld:query')")
    @GetMapping(value = "/{categoryId}")
    public AjaxResult getInfo(@PathVariable("categoryId") Long categoryId)
    {
        return success(fldService.selectFldByYxdm(categoryId));
    }

    /**
     * 新增院校详情
     */
    @PreAuthorize("@ss.hasPermi('fld:fld:add')")
    @Log(title = "院校详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Fld fld)
    {
        return toAjax(fldService.insertFld(fld));
    }

    /**
     * 修改院校详情
     */
    @PreAuthorize("@ss.hasPermi('fld:fld:edit')")
    @Log(title = "院校详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Fld fld)
    {
        return toAjax(fldService.updateFld(fld));
    }

    /**
     * 删除院校详情
     */
    @PreAuthorize("@ss.hasPermi('fld:fld:remove')")
    @Log(title = "院校详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{categoryId}")
    public AjaxResult remove(@PathVariable Long[] categoryId)
    {
        return toAjax(fldService.deleteFldByYxdms(categoryId));
    }
}
