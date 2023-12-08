<script setup>
import { ref } from "vue";

import { reactive } from 'vue'

const formInline = reactive({
  user: '',
  region: '',
  date: '',
})

const onSubmit = () => {
  console.log('submit!')
}



const currentPage = ref(4)
const pageSize = ref(100)
const total=ref(20)

//当每页条数变化，调用此函数
const handleSizeChange = (size) => {
    pageSize.value = size
}

//当前页码变化，调用此函数
const handleCurrentChange = (num) => {
  currentPage.value = num
}

import{userListService} from '@/api/User.js'
const userList =async()=>{
  let params={
    page:'',
    pageSize:'',
    
  }
  let result =await userListService();

  
}



const value = ref("");
const handleClick = () => {
  console.log("click");
};

const tableData = ref(
[
  {
    
    studentID: "16151618956",
    name: "亦忻",
    gender: "男",
    age: 22,
    class: "No. 189, Grove St, Los Angeles",
    electricity: "110",
    water: "120",
    createTime: "2023-11-29",
    updateTime: "2023-11-29"
  }
]
  ) 
;
</script>
<template>
  <div id="student">

    <el-row class="mb-4">
      <el-form :inline="true" :model="formInline" class="demo-form-inline">
    <el-form-item label="姓名">
      <el-input v-model="formInline.user" placeholder="请输入姓名" clearable />
    </el-form-item>
    <el-form-item label="性别">
      <el-select
        v-model="formInline.region"
        placeholder="请输入性别"
        clearable
      >
        <el-option label="男" value="男" />
        <el-option label="女" value="女" />
      </el-select>
    </el-form-item>
    
  </el-form>


      <el-date-picker
        v-model="value2"
        type="daterange"
        unlink-panels
        range-separator="到"
        start-placeholder="开始日期"
        end-placeholder="截止日期"
        :shortcuts="shortcuts"
        :size="size"
      />
      <el-form-item>
      <el-button type="primary" @click="onSubmit">查询</el-button>
    </el-form-item>
    </el-row>
    <div class="content">
      <el-table :data="tableData" style="width: 100%">
        <el-table-column fixed="left" prop="name" label="姓名" width="100" />
        <el-table-column prop="studentID" label="学号" width="150" />
        <el-table-column prop="gender" label="性别" width="100" />
        <el-table-column prop="age" label="年龄" width="100" />
        <el-table-column prop="class" label="班级" width="200" />
        <el-table-column prop="electricity" label="用电量" width="100" />
        <el-table-column prop="water" label="用水量" width="100" />
        <el-table-column prop="createTime" label="创建日期" width="150" />
        <el-table-column prop="updateTime" label="更新日期" width="150" />
        <el-table-column fixed="right" label="操作" width="150">
          <template #default>
            <el-button link type="primary" size="small" @click="handleClick"
              >删除</el-button
            >
            <el-button link type="primary" size="small">修改</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-pagination
      class="paging"
      v-model:current-page="currentPage"
      v-model:page-size="pageSize"
      :page-sizes="[100, 200, 300, 400]"
      :small="small"
      :disabled="disabled"
      :background="background"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />
  </div>
</template>
    
    

  
  <style lang="scss" scoped>
#student {
  padding-top: 30px;
  position: fixed;
  left: 320px;
  .content {
    position: fixed;
    top: 100px;
  }
  .paging {
    position: fixed;
    left: 700px;
    bottom: 50px;
  }
  .selecttime {
    margin-left: 20px;
  }
}
</style>