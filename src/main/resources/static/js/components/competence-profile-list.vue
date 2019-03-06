<template>
  <div class="competence-profile-list">
    <table>
            <tr>
                <th>Competence</th>
                <th>Years of experience</th>
            </tr>
            <tr v-for="profile in profiles">
              <td>{{profile.competence.name}}</td>
              <td>{{profile.yearsOfExperience}}</td>
            </tr>
    </table>
  </div>
</template>
<script>
export default {
  props: ['profiles']
}
</script>
