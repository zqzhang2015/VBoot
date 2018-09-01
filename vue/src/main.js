// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

// element-ui
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);
// axios
import { getRequest } from './utils/axios'
import { postRequest } from './utils/axios'
import { deleteRequest } from './utils/axios'
import { putRequest } from './utils/axios'
Vue.prototype.getRequest = getRequest;
Vue.prototype.postRequest = postRequest;
Vue.prototype.deleteRequest = deleteRequest;
Vue.prototype.putRequest = putRequest;
//store
import store from './store'

//utils
import {initMenu} from './utils/menu'

Vue.config.productionTip = false

// 路由卫士
router.beforeEach((to, from, next) => {
  if (to.name == 'Login') {
    next();
    return;
  }
  let name = store.state.user.name;
  if (name == '未登录') {
    if (to.meta.requireAuth || to.name == null) {
      next({path: '/', query: {redirect: to.path}})
    } else {
      next();
    }
  } else {
    initMenu(router, store);
    next();
  }
  // if(to.meta.requireAuth){
  //   alert("请先登录！");
  //   // this.$message.error("请先登录！");
  // }
  // var name = store.state.user.name;
  // if (name == '未登录') {
  //   if (to.meta.requireAuth || to.name == null) {
  //     next({ path: '/', query: { redirect: to.path } })
  //   } else {
  //     next();
  //   }
  // } else {
  //   initMenu(router, store);
  //   if (to.path == '/chat')
  //     store.commit("updateMsgList", []);
  //   next();
  // }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
