<template>
	<div>
		<a-table
			ref="table"
			size="middle"
			:columns="columns"
			:dataSource="dataSource"
			:pagination="pagination"
			:loading="loading"
			@change="handleTableChange"
		>
            <span slot="num" slot-scope="text, record, index">
                {{ (pagination.current - 1) * pagination.pageSize + parseInt(index) + 1 }}
            </span>
			//此处是给表格最前列添加序号
		</a-table>
	</div>
</template>

<script>
export default {
	data() {
		return {
			//数据源
			dataSource: [],
			//表头
			columns: [
				{
					title: '编号',
					align: 'center',
					scopedSlots: {customRender: 'num'},
					dataIndex: 'id',
				},
				{
					title: '姓名',//表头名
					align: 'center',
					dataIndex: 'name',//数据源里的参数名
				},
				{
					title: '',
					align: 'center',
					dataIndex: ''
				}
			],
			//分页参数
			pagination: {
				size: 'large',
				current: 1,
				pageSize: 10,
				total: 0,
				pageSizeOptions: ['10', '20', '30'],//可选的页面显示条数
				showTotal: (total, range) => {
					return range[0] + "-" + range[1] + " 共" + total + "条"
				}, //展示每页第几条至第几条和总数
				hideOnSinglePage: false, // 只有一页时是否隐藏分页器
				showQuickJumper: true, //是否可以快速跳转至某页
				showSizeChanger: true, //是否可以改变pageSize
			},
		}
	},
	created() {
		this.getList()
	},
	methods: {
		//获取列表
		getList() {
			//调用接口获取列表 给你的数据源赋值
			this.dataSource = [{
				name: "tom",
				id: "1"
			}]
		},
		//表格改变时触发
		handleTableChange(pagination, filters, sorter) {
			this.ipagination = pagination;
			this.getList();
		},
	}
}
</script>
