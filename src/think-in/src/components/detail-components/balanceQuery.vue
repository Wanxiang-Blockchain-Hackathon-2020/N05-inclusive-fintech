<template>
  <el-container  class ='el-container' style="border: 1px solid #eee">
    <el-main>
      <el-form   ref="form" :model="form" label-width="80px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="sign">
              <el-input v-model="form.name">1111</el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item align="right">
          <el-button type="primary" @click="onSubmit">立即创建</el-button>
          <!--<el-button>取消</el-button>-->
        </el-form-item>
      </el-form>
      <p style="margin-top: 90px;"></p>
      <hr style="margin-top: 50px">
      <span>{{form.balance}}</span>
    </el-main>
  </el-container>
</template>

<script>
export default {/* eslint-disable */
  data() {
    return {
      form: {
        balance: 1000,
        timestamp: new Date().getTime(),
        toAddress: '123',
        sign: '123sign',
        balance: ''
      }
  }},
  methods: {
  onSubmit() {
    this.$message({
      message: '提交成功'+'http://localhost:8080',
      type: 'success'
    })
    console.log('submit!');
    this.$http.post(
      'http://localhost:8080/api/balanceQuery',
      this.form).then(function (res) {
      console.log(res)
      let data = res.data.data 
    })
  }
  }
}
</script>
