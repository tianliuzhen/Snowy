package vip.xiaonuo.flowable.domain.DO;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import vip.xiaonuo.flowable.domain.BaseEntity;

/**
 * 流程实例关联表单对象 sys_instance_form
 *
 * @author Tony
 * @date 2021-03-30
 */
@Data
public class SysDeployForm extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 表单主键
     */
    @Excel(name = "表单主键")
    private Long formId;

    /**
     * 流程定义主键
     */
    @Excel(name = "流程定义主键")
    private String deployId;


}
