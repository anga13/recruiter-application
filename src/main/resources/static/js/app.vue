<template>
  <div id="app-root">
    <router-view class="view"><h1>Welcome</h1></router-view>
    <li><router-link :to="{name: 'home'}">Home</router-link></li>
    <li><router-link :to="{name: 'registerUser'}">Register User</router-link></li>
    <li><router-link :to="{name: 'newApplication'}">Write Application</router-link></li>
    <li><router-link :to="{name: 'applications'}">Read Applications</router-link></li>
  </div>
</template>
<script>
export default {
  data: function () {
    return {
      user: {}
    };
  }
}
</script>
