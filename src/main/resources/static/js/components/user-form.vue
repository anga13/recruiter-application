<template>
  <div class="user-form">
    <form @submit.prevent="submitUser">
      <label for="first-name-field">First Name</label>
      <input type="text" v-model="user.firstName" id="first-name-field"/>
      <label for="last-name-field">Last Name</label>
      <input type="text" v-model="user.lastName" id="last-name-field"/>
      <label for="ssn-field">SSN</label>
      <input type="text" v-model="user.ssn" id="ssn-field"/>
      <label for="email-field">Email</label>
      <input type="email" v-model="user.email" id="email-field"/>
      <label for="username-field">Username</label>
      <input type="text" v-model="user.username" id="username-field"/>
      <label for="password-field">Password</label>
      <input type="password" v-model="user.password" id="password-field"/>
      <input type="submit">Save</input>
    </form>
  </div>
</template>
<script>
export default {
  props: ['onAdd'],
  data: function () {
    return {
      user: {}
    }
  },
  methods: {
    submitUser: function () {
      this.onAdd(this.user);
      this.user = {};
    }
  }
}
</script>
