<template>
  <form class="row g-3" style="margin: 200px" method="post">
    <div class="col-md-6">
      <label for="inputEmail4" class="form-label">ID</label>
      <input
        type="text"
        class="form-control"
        id="signUp_ID"
        name="id"
        v-model="id"
      />
    </div>
    <div class="col-md-6">
      <label for="inputPassword4" class="form-label">Password</label>
      <input
        type="password"
        class="form-control"
        id="signUp_PWD"
        name="password"
        v-model="password"
      />
    </div>
    <div class="col-md-6">
      <label for="inputAddress" class="form-label">Name</label>
      <input
        type="text"
        class="form-control"
        id="signUp_Name"
        placeholder="name"
        name="name"
        v-model="name"
      />
    </div>
    <div class="col-md-6">
      <label for="inputCity" class="form-label">Phone</label>
      <input
        type="text"
        class="form-control"
        id="signUp_Phone"
        placeholder="010-xxxx-xxxx"
        name="telephone"
        v-model="telephone"
      />
    </div>
    <div class="col-12">
      <label for="inputAddress2" class="form-label">Address</label>
      <input
        type="text"
        class="form-control"
        id="signUp_Address"
        name="address"
        placeholder="1234 Main St, Apartment, studio, or floor"
        v-model="address"
      />
    </div>
    <div class="col-12">
      <input
        type="button"
        class="btn btn-primary"
        ID="button_submit"
        value="Sign in"
        @click="signup"
      />
    </div>
  </form>
</template>

<script>
export default {
  data() {
    return {
      id: "",
      password: "",
      name: "",
      telephone: "",
      address: "",
    };
  },
  methods: {
    signup: function () {
      let user = {
        id: this.id,
        password: this.password,
        name: this.name,
        telephone: this.telephone,
        address: this.address,
      };

      let userlist = JSON.parse(localStorage.getItem("userlist"));

      if (userlist) {
        userlist.push(user);
      } else {
        userlist = [];
        userlist.push(user);
      }

      localStorage.setItem("userlist", JSON.stringify(userlist));

      this.$router.push("/user/login");
    },
  },
};
</script>

<style></style>
