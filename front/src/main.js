import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import Lightbox from 'vue-easy-lightbox'
import Vuelidate from 'vuelidate'
import eventBus from './event-bus'
import vuetify from './plugins/vuetify'

Vue.config.productionTip = false
Vue.use(Lightbox)
Vue.use(Vuelidate)

axios.defaults.baseURL = '/api'
axios.defaults.headers.common.Accept = 'application/json'
axios.interceptors.response.use(
  response => response,
  (error) => {
    return Promise.reject(error)
  }
)

Vue.prototype.$bus = eventBus

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
