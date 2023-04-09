package vip.xiaonuo.flowable.domain.DO;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import vip.xiaonuo.flowable.domain.BaseEntity;

/**
 * 流程监听对象 sys_listener
 *
 * @author Tony
 * @date 2022-12-25
 */

@Data
public class SysListener extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 表单主键
     */
    private Long id;

    /**
     * 名称
     */
    @Excel(name = "名称")
    private String name;

    /**
     * 监听类型
     */
    @Excel(name = "监听类型")
    private String type;

    /**
     * 事件类型
     */
    @Excel(name = "事件类型")
    private String eventType;

    /**
     * 值类型
     */
    @Excel(name = "值类型")
    private String valueType;

    /**
     * 执行内容
     */
    @Excel(name = "执行内容")
    private String value;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Integer status;


}
