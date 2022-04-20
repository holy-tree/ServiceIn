import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  
  {
    path: '/',
    component: () => import('../views/exhibit_ding.vue')
  },
  {
    path: '/exhibit/ding',
    component: () => import('../views/exhibit_ding.vue')
  },
  {
    path: '/exhibit/pi',
    component: () => import('../views/exhibit_pi.vue')
  },
  {
    path: '/exhibit/both',
    component: () => import('../views/exhibit_both.vue')
  },
  {
    path: '/predict/ding',
    component: () => import('../views/predict_ding.vue')
  },
  {
    path: '/predict/pi',
    component: () => import('../views/predict_pi.vue')
  },
  {
    path: '/predict/both',
    component: () => import('../views/predict_both.vue')
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {undefined
return originalPush.call(this, location).catch(err => err)
}
