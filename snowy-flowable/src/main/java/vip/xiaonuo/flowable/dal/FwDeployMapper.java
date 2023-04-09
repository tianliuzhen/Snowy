package vip.xiaonuo.flowable.dal;


import vip.xiaonuo.flowable.domain.dto.FlowProcDefDto;

import java.util.List;

/**
 * 流程定义查询
 *
 * @author Tony
 * @email
 * @date 2022/1/29 5:44 下午
 **/
public interface FwDeployMapper {

    /**
     * 流程定义列表
     *
     * @param name
     * @return
     */
    List<FlowProcDefDto> selectDeployList(String name);
}
