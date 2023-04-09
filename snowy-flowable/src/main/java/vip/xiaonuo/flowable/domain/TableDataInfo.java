package vip.xiaonuo.flowable.domain;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import vip.xiaonuo.flowable.common.HttpStatus;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuzhen.tian
 * @version 1.0 TableDataInfo.java  2023/4/8 23:08
 */

@Data
public class TableDataInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 列表数据
     */
    private List<?> rows;

    /**
     * 消息状态码
     */
    private int code;

    /**
     * 消息内容
     */
    private String msg;

    /**
     * 表格数据对象
     */
    public TableDataInfo() {
    }

    /**
     * 分页
     *
     * @param list  列表数据
     * @param total 总记录数
     */
    public TableDataInfo(List<?> list, int total) {
        this.rows = list;
        this.total = total;
    }

    public static TableDataInfo toDataTable(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        PageInfo PageInfo = new PageInfo<>(list);
        rspData.setTotal(PageInfo.getTotal());
        return rspData;
    }

}
