<template>
  <div id="app">
    <main-header />
    <router-view />
    <main-footer />
  </div>
</template>

<script>
import MainHeader from "@/components/common/MainHeader.vue";
import MainFooter from "@/components/common/MainFooter.vue";

export default {
  components: {
    MainHeader,
    MainFooter,
  },
};
</script>

<style></style>
