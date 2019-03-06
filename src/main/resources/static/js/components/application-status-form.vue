<template>
  <div class="application-status-form">
    <form @submit.prevent="submitApplicationStatus">
      <input type="radio" v-for="status in statusOptions" :id="status.name" :value="status.id" v-model="applicationStatus">
        <label :for="status.name">{{status.name}}</label>
        <br>
        <span>Picked: {{ applicationStatus }}</span>
      </form>
  </div>
</template>
<script>
import {getAllStatuses} from '../services'

export default {
  props: ['status', 'onSet'],
  data: function () {
    return {
      newStatus: status
    }
  },
  mounted() {
    getAllStatuses().then(res => {
      this.statusOptions = res.data;
    });
  },
  methods: {
    submitApplicationStatus: function () {
      onSet(newStatus);
    }
  }
};
</script>
