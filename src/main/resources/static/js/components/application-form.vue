<template>
  <div class="application-form">
    <h1>Application Form</h1>
      <competence-profile-form :onAdd="addCompetenceProfile"></competence-profile-form>
      <availability-form :onAdd="addAvailability"></availability-form>
      <competence-profile-list :profiles="application.user.competenceProfiles"></competence-profile-list>
      <availability-list :availabilities="application.user.availabilities"></availability-list>
      <section>
        <form @submit.prevent="submitApplication">
          <h1>Will you send the application?</h1>
    			<span class="submit"><input type="submit" value="Send Application"/></span>
    			<span class="submit"><input type="button" @onPush="clearForm" value="Cancel"/></span>
        </form>
      </section>
  </div>
</template>
<script>
import CompetenceProfileList from './competence-profile-list.vue'
import CompetenceProfileForm from './competence-profile-form.vue'
import AvailabilityList from './availability-list.vue'
import AvailabilityForm from './availability-form.vue'
export default {
  components: {
    CompetenceProfileList,
    CompetenceProfileForm,
    AvailabilityList,
    AvailabilityForm
  },
  props: ['user', 'onApplictionSubmit'],
  data: function () {
    return {
      application: {
        user: {
          competenceProfiles: [],
          availabilities: [],
        }
      }
    };
  },
  methods: {
    submitApplication: function () {
      this.onApplictionSubmit(this.application);
      this.application = {};
    },
    addCompetenceProfile: function (competenceProfile) {
      this.application.user.competenceProfiles.push(competenceProfile);
    },
    addAvailability: function (availability) {
      this.application.user.availabilities.push(availability);
    },
    clearForm: function () {
      this.application = {};
    }
  }
}
</script>
