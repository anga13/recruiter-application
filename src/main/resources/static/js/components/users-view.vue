<template>
  <div class="user-view">
    <user-list :users="this.users"></user-list>
    <user-form :onAdd="this.addUser"></user-form>
  </div>
</template>
<script>
import UserForm from './user-form.vue'
import UserList from './user-list.vue'
import {createUser, getAllUsers} from '../services'
export default {
  components: {
    UserList,
    UserForm
  },
  data: function () {
    return {
      users: []
    }
  },
  mounted() {
    getAllUsers().then(res => {
      this.users = res.data;
    });
  },
  methods: {
    addUser: function (user) {
      createUser(user).then(res => {
        console.console.log(`added user ${res.data.lastName}`);
      });
    }
  }
}
</script>
