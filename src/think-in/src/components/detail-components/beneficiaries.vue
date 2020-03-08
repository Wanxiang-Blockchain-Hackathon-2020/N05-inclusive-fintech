/* eslint-disable */
<template>
  <el-container  class ='el-container' style="border: 1px solid #eee">
    <el-main>
        <el-form   ref="form" :model="form" label-width="80px">
          <el-row>
            <el-col :span="12">
              <el-form-item label="姓名">
                <el-input v-model="form.name">1111</el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="金额">
                <el-col></el-col>
                <el-input v-model="form.amount">1111</el-input>
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
            <el-input type="textarea" v-model="form.desc"></el-input>
          </el-form-item>
          <el-form-item align="right">
            <el-button type="primary" @click="onSubmit">立即创建</el-button>
            <!--<el-button>取消</el-button>-->
          </el-form-item>
        </el-form>
    </el-main>
  </el-container>
</template>

<script>/* eslint-disable */
export default {
  data() {
    return {
      form: {
        name: '',
        region: '',
        desc: '',
        amount: 1000
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
        message: '提交成功'+this.form.name,
        type: 'success'
      })
      console.log('submit!');
      this.$http.get("https://www.baidu.com").then(function (res) {
        console.log(res)
      })
    }
  }
}
</script>
