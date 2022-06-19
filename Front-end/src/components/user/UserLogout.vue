<template>
  <div></div>
</template>

<script>
import { mapActions } from "vuex";
export default {
  methods: {
    ...mapActions(["setlogout"]),
  },
  created() {
    this.setlogout();

    this.$router.push("/");
  },
};
</script>

<style></style>
