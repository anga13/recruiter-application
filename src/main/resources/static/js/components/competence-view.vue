<template>
  <div class="competence-view">{{comp.name}}
    <button @click="deleteCompetence">Delete</button>
  </div>
</template>
<script>
export default {
  props: ['comp','onDelete'],
  methods: {
    deleteCompetence: function () {
      this.onDelete(this.comp);
    }
  },
}
</script>
