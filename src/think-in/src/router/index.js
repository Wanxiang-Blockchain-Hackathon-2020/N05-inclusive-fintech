import Vue from 'vue'
import Router from 'vue-router'
import Nav from '@/components/Nav'
import CiShan from '../components/CiShan'
import donator from '../components/detail-components/donator'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Nav',
      component: Nav
    },
    {
      path: '/CiShan',
      name: 'CiShan',
      component: CiShan
    },
    {
      path: '/donator',
      name: '捐赠人',
      component: donator
    }
  ]
})
