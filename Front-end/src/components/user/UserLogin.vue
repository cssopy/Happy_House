<template>
  <form style="margin: 200px" method="post">
    <div class="mb-3">
      <label for="exampleInputEmail1" class="form-label">ID</label>
      <input
        type="text"
        class="form-control"
        id="inputId"
        name="id"
        v-model="id"
      />
    </div>
    <div class="mb-3">
      <label for="exampleInputPassword1" class="form-label">Password</label>
      <input
        type="password"
        class="form-control"
        id="inputPWD"
        name="password"
        v-model="password"
      />
    </div>
    <input
      type="button"
      class="btn btn-primary"
      @click="login"
      value="Submit"
    />
    <router-link
      class="btn btn-outline-primary"
      style="margin-left: 10px"
      to="/user/find"
    >
      Find password
    </router-link>
  </form>
</template>

<script>
import { mapActions } from "vuex";

export default {
  data() {
    return {
      id: "",
      password: "",
    };
  },
  methods: {
    ...mapActions(["setlogin"]),

    login: function () {
      let userlist = JSON.parse(localStorage.getItem("userlist"));

      for (let user of userlist) {
        if (user.id == this.id && user.password == this.password) {
          this.setlogin(user);
          break;
        }
      }

      this.$router.push("/");
    },
  },
};
</script>

<style></style>
