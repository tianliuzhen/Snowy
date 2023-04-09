package vip.xiaonuo.flowable.domain.DO;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import vip.xiaonuo.flowable.domain.BaseEntity;

/**
 * 流程表单对象 sys_task_form
 *
 * @author Tony
 * @date 2021-03-30
 */

@Data
public class SysForm extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 表单主键
     */
    private Long formId;

    /**
     * 表单名称
     */
    @Excel(name = "表单名称")
    private String formName;

    /**
     * 表单内容
     */
    @Excel(name = "表单内容")
    private String formContent;


}
