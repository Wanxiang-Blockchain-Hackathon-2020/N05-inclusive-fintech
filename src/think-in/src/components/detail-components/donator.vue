<!--
捐赠人页面：
包含功能
- 发起捐赠
- 查看捐赠
- 生成捐赠证书
-->

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
            <el-col :span="12">
              <el-form-item label="捐赠项目">
                <el-select v-model="form.project" placeholder="请选择捐赠项目" :size="medium">
                  <el-option label="孤寡老人" value="shanghai"></el-option>
                  <el-option label="留守儿童" value="wuhan"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
       <!--   <el-form-item label="活动时间">
            <el-col :span="11">
              <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
            </el-col>
            <el-col class="line" :span="2">-</el-col>
            <el-col :span="11">
              <el-time-picker placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
            </el-col>
          </el-form-item>-->
         <!-- <el-form-item label="即时配送">
            <el-switch v-model="form.delivery"></el-switch>
          </el-form-item>
          <el-form-item label="活动性质">
            <el-checkbox-group v-model="form.type">
              <el-checkbox label="美食/餐厅线上活动" name="type"></el-checkbox>
              <el-checkbox label="地推活动" name="type"></el-checkbox>
              <el-checkbox label="线下主题活动" name="type"></el-checkbox>
              <el-checkbox label="单纯品牌曝光" name="type"></el-checkbox>
            </el-checkbox-group>
          </el-form-item>-->
          <!--<el-form-item label="特殊资源">
            <el-radio-group v-model="form.resource">
              <el-radio label="线上品牌商赞助"></el-radio>
              <el-radio label="线下场地免费"></el-radio>
            </el-radio-group>
          </el-form-item>-->
          <el-form-item label="捐赠备注">
            <el-input type="textarea" v-model="form.desc"></el-input>
          </el-form-item>
          <el-form-item align="right">
            <el-button type="primary" @click="onSubmit">立即创建</el-button>
            <!--<el-button>取消</el-button>-->
          </el-form-item>
        </el-form>
        <p style="margin-top: 90px;"></p>
        <hr style="margin-top: 50px">
        <el-tag >历史捐赠记录：</el-tag>
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
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button
                size="mini"
                @click="showCertificate(scope.$index, scope.row)">查看证书</el-button>
            </template>
          </el-table-column>

        </el-table>
      <el-dialog title="慈善证书" :visible.sync="dialogTableVisible">
        <el-tag  :type='success'>{{certification.name}}</el-tag>
        <el-tag  :type="warning">{{certification.date}}</el-tag>
        <el-tag  :type="warning">{{certification.amount}}</el-tag>
        <div style="position: relative; width: 100%; height: 100%;">
          <el-image :src="certification.imageUrl"></el-image>
          <span style="position: absolute; bottom: 25%; left: 20%;right:15%;font-size: 20px;line-height: 60px;">
            <span>{{certification.name}} &nbsp;&nbsp; 先生/女士：</span>
          <br>

            <span> &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;您已为[xxx项目]于{{certification.date}}慷慨捐赠[{{certification.amount}}]元。</span>
          <br> <br>
            <span>感谢您，让世界更温暖！</span>
          <br>
            <span style="right: 0px;float: right;">黑客松慈善机构</span>
            <br>
            <span style="right: 0px;float: right;">{{certification.date}}</span>
          </span>
        </div>
      </el-dialog>
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
        amount: 1000,
        project: ''
      },
      logImage:{
        fits: ['fill', 'contain', 'cover', 'none', 'scale-down'],
        image_url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'
      },
      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1518 弄',
        amount: 200333,
        tag: '家'
      }, {
        date: '2016-05-04',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1517 弄',
        amount: 200333,
        tag: '公司'
      }, {
        date: '2016-05-01',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1519 弄',
        amount: 200333,
        tag: '家'
      }, {
        date: '2016-05-03',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1516 弄',
        amount: 200333,
        tag: '公司'
      }],
      dialogTableVisible: false,
      certification: {
        name: '',
        date: '',
        amount: '',
        imageUrl: ''
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
    },
    showCertificate(index,row) {
      this.dialogTableVisible = true
      this.certification.amount = row.amount
      this.certification.date = row.date
      this.certification.name = row.name
      this.certification.imageUrl = 'static/捐赠证书-空白.png'
      this.$message({
        message: '显示证书'+row.amount,
        type: 'success'
      })
    }
  }
  }
</script>
