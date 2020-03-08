<template>
  <el-container  class ='el-container' style="border: 0px solid #eee">
    <el-header class="el-header" style="border-bottom: 1px solid #dcdfe6;padding: 0px;height: 100px;">
      <div>
        <el-image :src="logoImage.image_url" :fit="fits[0]" style="width: 60px; height: 54px;margin-top: 20px;float: right;"></el-image>
        <el-image :src="logoImage.image_url1" :fit="fits[0]" style="width: 60px; height: 54px;margin-top: 20px;float: left;"></el-image>
        <div style="font: 40px arial;text-align: center;float: left;margin-top: 26px;margin-left: 20px">INCLUSIVE CHARITY PLATFORM</div>
      </div>

      <el-dropdown style="float: right;margin-top: 28px">
  <span class="" >
     <i class="el-icon-user-solid"></i>
    欢迎你！<i class="el-icon-arrow-down el-icon--right"></i>
  </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>密码修改</el-dropdown-item>
          <el-dropdown-item>登出</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </el-header>
    <el-main style="padding:0px;border: 0px;">
      <el-tabs tab-position="top"  style="height: 500px;border: 0px">
        <el-tab-pane label="捐赠申请" name="first">
          <span slot="label">
            <el-image :src="roleIcon.jzr" :fit="fits[0]" style="width: 18px; height: 18px;margin-top: 3px;">
            </el-image>
            捐赠申请
          </span>
          <v-donator></v-donator>
        </el-tab-pane>
        <el-tab-pane label="求援申请" name="second">
          <span slot="label">
            <el-image :src="roleIcon.syr" :fit="fits[0]" style="width: 18px; height: 18px;margin-top: 3px;">
            </el-image>
            援助申请
          </span>
          <v-benefit></v-benefit>
        </el-tab-pane>
        <el-tab-pane label="援助审核" name="third">
         <span slot="label">
            <el-image :src="roleIcon.cszz" :fit="fits[0]" style="width: 18px; height: 18px;margin-top: 3px;">
            </el-image>
            援助审核
          </span>
          <v-allocat-audit></v-allocat-audit>
        </el-tab-pane>
        <el-tab-pane label="援助进度查询" name="fourth">
          <span slot="label">
            <el-image :src="roleIcon.cszz" :fit="fits[0]" style="width: 18px; height: 18px;margin-top: 3px;">
            </el-image>
            援助进度查询
          </span>
        </el-tab-pane>
        <el-tab-pane label="捐赠-援助关系查询" name="five">
          <span slot="label">
            <el-image :src="roleIcon.cszz" :fit="fits[0]" style="width: 18px; height: 18px;margin-top: 3px;">
            </el-image>
             捐赠-援助关系查询
          </span>
        </el-tab-pane>
      </el-tabs>
    </el-main>
    <el-footer style="text-align: center;background-color: #eaffe2;height: 20px;color: #eaffe2;background-color: gray">
      <span style="font-size: smaller">版权所有© 2006-2020 黑客松比赛作品 沪ICP备10205985</span>
    </el-footer>
  </el-container>
</template>
<script>
import vdonator from '@/components/detail-components/donator'
import beneficiaries from './detail-components/beneficiaries'
import allocatAudit from './detail-components/allocat-audit'

export default {
  components: {
    'v-donator': vdonator,
    'v-benefit': beneficiaries,
    'v-allocat-audit': allocatAudit
  },
  data () {
    return {
      fits: ['fill', 'contain', 'cover', 'none', 'scale-down'],
      logoImage: {
        image_url: 'static/logo.png',
        image_url1: 'static/INCLUSIVE CHARITY.png'
      },
      roleIcon: {
        syr: 'static/受益人.jpg',
        cszz: 'static/慈善组织.png',
        jzr: 'static/捐赠人.png',
        jg: 'static/监管.png',
        jrjg: 'static/金融机构.png'
      }
    }
  }
}

</script>
