package com.ruoyi.major.controller;

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
import com.ruoyi.major.domain.Major;
import com.ruoyi.major.service.IMajorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 专业列表Controller
 * 
 * @author ruoyi
 * @date 2023-09-05
 */
@RestController
@RequestMapping("/major/major")
public class MajorController extends BaseController
{
    @Autowired
    private IMajorService majorService;

    /**
     * 查询专业列表列表
     */
    @PreAuthorize("@ss.hasPermi('major:major:list')")
    @GetMapping("/list")
    public TableDataInfo list(Major major)
    {
        startPage();
        List<Major> list = majorService.selectMajorList(major);
        return getDataTable(list);
    }

    /**
     * 导出专业列表列表
     */
    @PreAuthorize("@ss.hasPermi('major:major:export')")
    @Log(title = "专业列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Major major)
    {
        List<Major> list = majorService.selectMajorList(major);
        ExcelUtil<Major> util = new ExcelUtil<Major>(Major.class);
        util.exportExcel(response, list, "专业列表数据");
    }

    /**
     * 获取专业列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('major:major:query')")
    @GetMapping(value = "/{CategoryID}")
    public AjaxResult getInfo(@PathVariable("CategoryID") Long CategoryID)
    {
        return success(majorService.selectMajorByCategoryID(CategoryID));
    }

    /**
     * 新增专业列表
     */
    @PreAuthorize("@ss.hasPermi('major:major:add')")
    @Log(title = "专业列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Major major)
    {
        return toAjax(majorService.insertMajor(major));
    }

    /**
     * 修改专业列表
     */
    @PreAuthorize("@ss.hasPermi('major:major:edit')")
    @Log(title = "专业列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Major major)
    {
        return toAjax(majorService.updateMajor(major));
    }

    /**
     * 删除专业列表
     */
    @PreAuthorize("@ss.hasPermi('major:major:remove')")
    @Log(title = "专业列表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{CategoryIDs}")
    public AjaxResult remove(@PathVariable Long[] CategoryIDs)
    {
        return toAjax(majorService.deleteMajorByCategoryIDs(CategoryIDs));
    }
}
