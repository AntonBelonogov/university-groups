import { createRouter, createWebHistory } from 'vue-router'
import GroupList from '../components/GroupList.vue'
import GroupStudents from '../components/GroupStudents.vue'

const routes = [
  {
    path: '/',
    name: 'GroupList',
    component: GroupList
  },
  {
    path: '/groups/:groupId/students',
    name: 'GroupStudents',
    component: GroupStudents,
    props: true
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
