package com.ruoyi.colleges.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
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
import com.ruoyi.colleges.domain.Colleges;
import com.ruoyi.colleges.service.ICollegesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 院校列表Controller
 * 
 * @author ruoyi
 * @date 2023-08-30
 */
//@DataSource(value = DataSourceType.SLAVE)
@RestController
@RequestMapping("/colleges/colleges")
public class CollegesController extends BaseController
{
    @Autowired
    private ICollegesService collegesService;

    /**
     * 查询院校列表列表
     */
    @PreAuthorize("@ss.hasPermi('colleges:colleges:list')")
    @GetMapping("/list")
    public TableDataInfo list(Colleges colleges)
    {
        startPage();
        List<Colleges> list = collegesService.selectCollegesList(colleges);
        return getDataTable(list);
    }

    /**
     * 导出院校列表列表
     */
    @PreAuthorize("@ss.hasPermi('colleges:colleges:export')")
    @Log(title = "院校列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Colleges colleges)
    {
        List<Colleges> list = collegesService.selectCollegesList(colleges);
        ExcelUtil<Colleges> util = new ExcelUtil<Colleges>(Colleges.class);
        util.exportExcel(response, list, "院校列表数据");
    }

    /**
     * 获取院校列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('colleges:colleges:query')")
    @GetMapping(value = "/{yxdm}")
    public AjaxResult getInfo(@PathVariable("yxdm") Long yxdm)
    {
        return success(collegesService.selectCollegesByYxdm(yxdm));
    }

    /**
     * 新增院校列表
     */
    @PreAuthorize("@ss.hasPermi('colleges:colleges:add')")
    @Log(title = "院校列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Colleges colleges)
    {
        return toAjax(collegesService.insertColleges(colleges));
    }

    /**
     * 修改院校列表
     */
    @PreAuthorize("@ss.hasPermi('colleges:colleges:edit')")
    @Log(title = "院校列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Colleges colleges)
    {
        return toAjax(collegesService.updateColleges(colleges));
    }

    /**
     * 删除院校列表
     */
    @PreAuthorize("@ss.hasPermi('colleges:colleges:remove')")
    @Log(title = "院校列表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{yxdms}")
    public AjaxResult remove(@PathVariable Long[] yxdms)
    {
        return toAjax(collegesService.deleteCollegesByYxdms(yxdms));
    }
}
