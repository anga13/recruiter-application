import Vue from 'vue'
import VueRouter from 'vue-router'
import moment from 'moment'
import App from './app.vue'
import router from './router'


// This installs <router-view> and <router-link>,
// and injects $router and $route to all router-enabled child components
Vue.use(VueRouter)
Vue.filter('formatDate', function(value) {
  if (value) {
    return moment(String(value)).format(moment.HTML5_FMT.DATE);
  }
})

new Vue({
  router,
  components: { App },
  template: `<App/>`
}).$mount('#app');
