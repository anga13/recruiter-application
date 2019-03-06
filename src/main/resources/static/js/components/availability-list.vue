<template>
  <section class="added-availabilities-list">
  <h1>Added Availabilities</h1>
  <table>
          <tr>
              <th>From Date</th>
              <th>To Date</th>
          </tr>
          <tr v-for="availability in availabilities">
            <td>{{availability.fromDate | formatDate}}</td>
            <td>{{availability.toDate | formatDate}}</td>
          </tr>
  </table>
  </section>
</template>
<script>
export default {
  props: ['availabilities']
}
</script>
