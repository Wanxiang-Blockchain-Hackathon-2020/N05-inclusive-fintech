/* eslint-disable */
<template>
  <el-container  class ='el-container' style="border: 1px solid #eee">
    <el-main>
        <el-form   ref="form" :model="form" label-width="80px">
          <el-row>
            <el-col :span="12">
              <el-form-item label="address">
                <el-input v-model="form.address">0004</el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="金额">
                <el-col></el-col>
                <el-input v-model="form.balance">1111</el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="慈善机构">
                <el-select v-model="form.region" placeholder="请选择目标慈善机构" :size="medium">
                  <el-option label="上海红十字会" value="shanghai"></el-option>
                  <el-option label="武汉红十字会" value="wuhan"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-form-item label="求助原因">
            <el-input type="textarea" v-model="form.context"></el-input>
          </el-form-item>
          <el-form-item align="right">
            <el-button type="primary" @click="onSubmit">立即创建</el-button>
            <!--<el-button>取消</el-button>-->
          </el-form-item>
        </el-form>
      <el-tag >历史援助记录：</el-tag>
      <el-table
        :data="tableData"
        tooltip-effect="dark"
        :datatype="selection"
        style="width: 100%">
        <el-table-column
          type="index"
          label="编号"
          :index="indexMethod">
        </el-table-column>
        <el-table-column
          prop="date"
          label="日期"
          width="180">
        </el-table-column>
        <el-table-column
          prop="amount"
          label="金额"
          width="180">
        </el-table-column>
        <el-table-column
          prop="address"
          label="备注">
        </el-table-column>
        <el-table-column label="状态">
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="showProcessing(scope.$index, scope.row)">审核中</el-button>
          </template>
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="showOk(scope.$index, scope.row)">申请成功</el-button>
          </template>
        </el-table-column>

      </el-table>
    </el-main>
  </el-container>
</template>

<script>/* eslint-disable */
export default {
  data() {
    return {
      form: {
        balance: 1000,
        timestamp: new Date().getTime(),
        context: '34567890',
        sign: '0004'
      },
      logImage:{
        fits: ['fill', 'contain', 'cover', 'none', 'scale-down'],
        image_url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
      }
    }
  },
  methods: {
    onSubmit() {
      this.$message({
        message: '提交成功'+this.form.sign,
        type: 'success'
      })
      console.log('submit!');
      this.$http.post("http://localhost:8080/api/aidApply",this.form).then(function (res) {
        console.log(res)
      })
    }
  }
}
</script>
