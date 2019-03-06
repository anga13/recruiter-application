<template>
  <div class="user-list">
    <table>
      <tr>
        <th>Name</th>
        <th>Email</th>
        <th>SSN</th>
      </tr>
      <tr v-for="user in users">
        <td>{{user.firstName}} {{user.lastName}}</td>
        <td>{{user.email}}</td>
        <td>{{user.ssn}}</td>
      </tr>
    </table>
  </div>
</template>
<script>
export default {
  props: ['users']
}
</script>
