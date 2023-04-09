package vip.xiaonuo.flowable.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 动态人员、组
 * @author Tony
 * @date 2021/4/17 22:59
 */
@Data
public class FlowNextDto implements Serializable {

    private String type;
    private String dataType;
    private String vars;

}
