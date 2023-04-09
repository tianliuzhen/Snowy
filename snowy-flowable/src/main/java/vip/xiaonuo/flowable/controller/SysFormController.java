package vip.xiaonuo.flowable.controller;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.xiaonuo.flowable.common.AjaxResult;
import vip.xiaonuo.flowable.domain.DO.SysDeployForm;
import vip.xiaonuo.flowable.domain.DO.SysForm;
import vip.xiaonuo.flowable.domain.TableDataInfo;
import vip.xiaonuo.flowable.service.ISysDeployFormService;
import vip.xiaonuo.flowable.service.ISysFormService;

import java.util.List;


/**
 * 流程表单Controller
 *
 * @author Tony
 * @date 2021-04-03
 */
@RestController
@RequestMapping("/flowable/form")
public class SysFormController {
    @Autowired
    private ISysFormService sysFormService;

    @Autowired
    private ISysDeployFormService sysDeployFormService;

    /**
     * 查询流程表单列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysForm sysForm) {
        // todo 分页问题
        PageHelper.startPage(1, 2);
        List<SysForm> list = sysFormService.selectSysFormList(sysForm);
        return TableDataInfo.toDataTable(list);
    }

    @GetMapping("/formList")
    public AjaxResult formList(SysForm sysForm) {
        List<SysForm> list = sysFormService.selectSysFormList(sysForm);
        return AjaxResult.success(list);
    }
    /**
     * 导出流程表单列表
     */
    // @GetMapping("/export")
    // public AjaxResult export(SysForm sysForm) {
    //     List<SysForm> list = SysFormService.selectSysFormList(sysForm);
    //     ExcelUtil<SysForm> util = new ExcelUtil<SysForm>(SysForm.class);
    //     return util.exportExcel(list, "form");
    // }

    /**
     * 获取流程表单详细信息
     */
    @GetMapping(value = "/{formId}")
    public AjaxResult getInfo(@PathVariable("formId") Long formId) {
        return AjaxResult.success(sysFormService.selectSysFormById(formId));
    }

    /**
     * 新增流程表单
     */
    @PostMapping
    public AjaxResult add(@RequestBody SysForm sysForm) {
        return AjaxResult.toAjax(sysFormService.insertSysForm(sysForm));
    }

    /**
     * 修改流程表单
     */
    @PutMapping
    public AjaxResult edit(@RequestBody SysForm sysForm) {
        return AjaxResult.toAjax(sysFormService.updateSysForm(sysForm));
    }

    /**
     * 删除流程表单
     */
    @DeleteMapping("/{formIds}")
    public AjaxResult remove(@PathVariable Long[] formIds) {
        return AjaxResult.toAjax(sysFormService.deleteSysFormByIds(formIds));
    }


    /**
     * 挂载流程表单
     */
    @PostMapping("/addDeployForm")
    public AjaxResult addDeployForm(@RequestBody SysDeployForm sysDeployForm) {
        return AjaxResult.toAjax(sysDeployFormService.insertSysDeployForm(sysDeployForm));
    }
}
