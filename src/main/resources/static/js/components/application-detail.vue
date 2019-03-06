<template>
  <div class="application-detail">
    <table>
      <tr>
        <td>Applicant</td>
        <td>{{application.user.firstName}} {{application.user.lastName}}</td>
      </tr>
      <tr>
        <td>Email</td>
        <td>{{application.user.email}}</td>
      </tr>
    </table>
    <h2>Competences</h2>
    <competence-profile-list :profiles="application.user.profiles"/>
    <h2>Availabile</h2>
    <availability-list :availabilities="application.user.availabilities"/>
    <application-status-form :onSet="setApplicationStatus"/>
  </div>
</template>
<script>
import ApplicationStatusForm from './application-status-form.vue'

export default {
  props: ['application', 'onUpdate'],
  data: function () {
    return {
      applicationModel: application
    }
  },
  methods: {
    setApplicationStatus: function (status) {
      applicationModel.status = status;
      onUpdate(applicationModel);
    }
  }
}
</script>
