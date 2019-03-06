<template>
  <div>
  <form id="competence-form-root" @submit.prevent="addCompetenceProfile">
    <label for="competence-id" text="Cscdscss">Competence</label>:
    <select name="competence" v-model="profile.competence" id="competence-id">
      <option v-for="competence in competences" :value="competence">
        {{competence.name}}
      </option>
    </select>
        <label for="yearsOfExperience">Years of experience</label>:
    <input type="number" min="0" max="99" v-model="profile.yearsOfExperience" id="yearsOfExperience"/>
<!--
            <span class="error" th:if="${#fields.hasErrors('yearsOfExperience')}"
                  th:errors="*{yearsOfExperience}">AmountOfYears Error</span>
                -->
        <p class="submit"><input type="submit" value="Submit this!"/></p>
  </form>
</div>
</template>
<script>
import {getAllCompetences} from '../services'

export default {
  props: ['onAdd'],
  data: function () {
    return {
      competences: [],
      profile: {}
    }
  },
  mounted() {
    getAllCompetences()
    .then(res => {
      this.competences = res.data;
    });
  },
  methods: {
    addCompetenceProfile: function () {
      console.log(this.onAdd);
      this.onAdd(this.profile);
      this.profile = {};
    }
  }
}
</script>
