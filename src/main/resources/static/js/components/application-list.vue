<template>
  <div class="application-list">
    <ul>
      <li v-for="application in applications">
        <router-link :to="{name: 'applicationDetail', params: {id: application.id}}">
          {{application.user.firstName}} {{application.user.firstName}}
        </router-link>
      </li>
    </ul>
  </div>
</template>
<script>
import { getAllApplications } from '../services'

export default {
  data: function () {
    return {
      applications: []
    };
  },
  mounted() {
    getAllApplications()
    .then(res => {
      this.applications = res.data;
    });
  }
}
</script>
