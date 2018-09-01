import Vue from 'vue'
import Router from 'vue-router'
// import Login from '@/components/HelloWorld'
import Login from '@/pages/Login'
import Home from '@/pages/Home'
import Info from '@/pages/system/Info'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      children: [
        {
          path: '/home/info',
          component: Info
        },
        {
          path: '',
          redirect: '/home/info'
        }
      ],
      meta: {
        requireAuth: true
      },
    }
  ]
})
