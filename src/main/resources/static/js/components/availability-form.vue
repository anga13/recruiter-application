<template>
  <section>
    <h1>Add Availability</h1>
    <form @submit.prevent="addAvailability">
      <label for="availability-from">From Date</label>
      <datepicker v-model="availability.fromDate" name="availability-from"/>
      <label for="availability-to">To Date</label>
      <datepicker v-model="availability.toDate" name="availability-to"/>
      <p class="submit"><input type="submit" th:value="Add Availability"/></p>
    </form>
  </section>
</template>
<script>
import Datepicker from 'vuejs-datepicker';

export default {
  components: {
    Datepicker
  },
  props: ['onAdd'],
  data: function () {
    return {
      availability: {}
    };
  },
  methods: {
    addAvailability: function () {
      this.onAdd(this.availability);
      this.availability = {};
    }
  }
}
</script>
