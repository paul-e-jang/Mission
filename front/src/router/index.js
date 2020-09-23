import Vue from 'vue'
import VueRouter from 'vue-router'

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
  meta: { transitionName: 'fade' }
},
{
  path: '/admin',
  name: 'Admin',
  component: () => import('../views/Admin.vue'),
  meta: { transitionName: 'fade' }
},
{
  path: '/login',
  name: 'Login',
  component: () => import('../views/Login.vue')
},
{
  path: '/logout',
  redirect: '/'
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

export default router
