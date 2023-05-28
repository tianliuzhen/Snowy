<template>
	<a-row>
		<a-col :span="5">
			<a-card :bordered="false">
				<s-table ref="table"
						 :columns="columns"
						 :data="loadData" bordered
						 :row-key="(record) => record.id"
						 :pagination="pagination">
				</s-table>
			</a-card>
		</a-col>
	</a-row>
</template>

<script setup name="flowable-definition">
import definitionApi from "@/api/flowable/definition";

const columns = [
	{
		title: '角色名称',
		dataIndex: 'name',
		resizable: true,
		width: 150
	},
	{
		title: '分类',
		dataIndex: 'category'
	}
]
let selectedRowKeys = ref([])


// 表格查询 返回 Promise 对象
const loadData = (param) => {
	param.pageNum = 1
	param.pageSize = 10
	console.log("param:", param)
	return definitionApi.listDefinition(param).then((res) => {
		return res
	})
}
const pagination = () => {
	pageSizeOptions: ['40', '50', '60', '70']
}


// 可伸缩列
const handleResizeColumn = (w, col) => {
	col.width = w
}
</script>

<style scoped>

</style>
