package com.ruoyi.zyjsinfos.controller;

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
import com.ruoyi.zyjsinfos.domain.Zyjsinfos;
import com.ruoyi.zyjsinfos.service.IZyjsinfosService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 院校专业介绍Controller
 * 
 * @author ruoyi
 * @date 2023-09-05
 */
@RestController
@RequestMapping("/zyjsinfos/zyjsinfos")
public class ZyjsinfosController extends BaseController
{
    @Autowired
    private IZyjsinfosService zyjsinfosService;

    /**
     * 查询院校专业介绍列表
     */
    @PreAuthorize("@ss.hasPermi('zyjsinfos:zyjsinfos:list')")
    @GetMapping("/list")
    public TableDataInfo list(Zyjsinfos zyjsinfos)
    {
        startPage();
        List<Zyjsinfos> list = zyjsinfosService.selectZyjsinfosList(zyjsinfos);
        return getDataTable(list);
    }

    /**
     * 导出院校专业介绍列表
     */
    @PreAuthorize("@ss.hasPermi('zyjsinfos:zyjsinfos:export')")
    @Log(title = "院校专业介绍", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Zyjsinfos zyjsinfos)
    {
        List<Zyjsinfos> list = zyjsinfosService.selectZyjsinfosList(zyjsinfos);
        ExcelUtil<Zyjsinfos> util = new ExcelUtil<Zyjsinfos>(Zyjsinfos.class);
        util.exportExcel(response, list, "院校专业介绍数据");
    }

    /**
     * 获取院校专业介绍详细信息
     */
    @PreAuthorize("@ss.hasPermi('zyjsinfos:zyjsinfos:query')")
    @GetMapping(value = "/{dicCurId}")
    public AjaxResult getInfo(@PathVariable("dicCurId") String dicCurId)
    {
        return success(zyjsinfosService.selectZyjsinfosByDicCurId(dicCurId));
    }

    /**
     * 新增院校专业介绍
     */
    @PreAuthorize("@ss.hasPermi('zyjsinfos:zyjsinfos:add')")
    @Log(title = "院校专业介绍", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Zyjsinfos zyjsinfos)
    {
        return toAjax(zyjsinfosService.insertZyjsinfos(zyjsinfos));
    }

    /**
     * 修改院校专业介绍
     */
    @PreAuthorize("@ss.hasPermi('zyjsinfos:zyjsinfos:edit')")
    @Log(title = "院校专业介绍", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Zyjsinfos zyjsinfos)
    {
        return toAjax(zyjsinfosService.updateZyjsinfos(zyjsinfos));
    }

    /**
     * 删除院校专业介绍
     */
    @PreAuthorize("@ss.hasPermi('zyjsinfos:zyjsinfos:remove')")
    @Log(title = "院校专业介绍", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dicCurIds}")
    public AjaxResult remove(@PathVariable String[] dicCurIds)
    {
        return toAjax(zyjsinfosService.deleteZyjsinfosByDicCurIds(dicCurIds));
    }
}
