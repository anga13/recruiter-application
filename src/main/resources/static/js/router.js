import VueRouter from 'vue-router'
import ApplicationForm from './components/application-form.vue'
import UsersView from './components/users-view.vue'
import ApplicationList from './components/application-list.vue'
import ApplicationDetail from './components/application-detail.vue'

const Home = { template: '<div>home</div>' }

// Create the router
const router = new VueRouter({
  //mode: 'history',
  base: __dirname,
  routes: [
    { path: '/', name: 'home', component: Home },
    { path: '/new-application', name: 'newApplication', component: ApplicationForm },
    { path: '/applications', name: 'applications', component: ApplicationList },
    { path: '/applications/:id', name: 'applicationDetail', component: ApplicationDetail, props: true },
    { path: '/register-user', name: 'registerUser', component: UsersView }
  ]
});
export default router;
