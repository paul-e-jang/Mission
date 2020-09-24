import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '../store/index'

Vue.use(VueRouter)

const routes = [{
  path: '/',
  name: 'Home',
  component: () => import('../views/Home.vue'),
  meta: { transitionName: 'fade' }
},
{
  path: '/gallary',
  name: 'Gallary',
  component: () => import('../views/Gallary.vue'),
  meta: { transitionName: 'fade', authRequired: Boolean(!store.getters.logged) }
},
{
  path: '/admin',
  name: 'Admin',
  component: () => import('../views/Admin.vue'),
  meta: { transitionName: 'fade', authRequired: Boolean(store.getters.logged) },
  children: [
    {
      path: '/record',
      name: 'Record',
      component: () => import('../components/LoginRecord.vue')
    },
    {
      path: '/registerimage',
      name: 'RegisterImage',
      component: () => import('../components/RegisterImage.vue')
    }
  ]
},
{
  path: '/login',
  name: 'Login',
  component: () => import('../views/Login.vue'),
  meta: { transitionName: 'fade' }
},
{
  path: '/logout',
  redirect: '/'
},
{
  path: '/register',
  name: 'Register',
  component: () => import('../views/Register.vue')
},
{
  path: '*',
  redirect: '/404'
},
{
  path: '/404',
  component: () => import('../views/404.vue')
}
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach(function (to, from, next) {
  // to: 이동할 url에 해당하는 라우팅 객체
  if (to.matched.some(function (routeInfo) {
    return routeInfo.meta.authRequired
  })) {
    alert('로그인 하세요.')
    if (from.name !== 'Login') {
      router.push('/login')
    }
  } else {
    next()
  }
})

export default router
