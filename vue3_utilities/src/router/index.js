import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import LayoutView from '../views/layout/LayoutView'
import StudentView from '../views/layout/StudentView.vue'
import TeacherView from '../views/layout/TeacherView.vue'
import NotFound from '../views/page404/NotFound.vue'
import StatisticsView from '../views/layout/StatisticsView.vue'

const routes = [
  {
    path: '/login',
    name: 'login',
    alias: '/',
    component: LoginView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/layout',
    name: 'layout',
    redirect: '/layout/home',
    component: LayoutView,
    children:[
      {
        path: 'student',
        component: StudentView,
      },
      {
        path: 'home',
        component: HomeView,
      },
      {
        path: 'teacher',
        component: TeacherView,
      },
      {
        path: 'statistics',
        component: StatisticsView
      },
    ]
  },
  {
    // 404 页面
    path: '/:pathMatch(.*)*', component: NotFound
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
