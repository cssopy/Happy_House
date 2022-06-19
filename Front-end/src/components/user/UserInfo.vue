<template>
  <form class="row g-3" style="margin: 100px">
    <fieldset disabled>
      <legend>Profile Info</legend>
      <div class="col-md-7">
        <label for="inputEmail4" class="form-label">ID</label>
        <input
          type="text"
          class="form-control"
          id="profile_ID"
          name="id"
          v-model="id"
        />
      </div>
      <div class="col-md-7">
        <label for="inputPassword4" class="form-label">Password</label>
        <input
          type="text"
          class="form-control"
          id="profile_PWD"
          name="password"
          v-model="password"
        />
      </div>
      <div class="col-md-7">
        <label for="inputAddress" class="form-label">Name</label>
        <input
          type="text"
          class="form-control"
          id="profile_Name"
          placeholder="name"
          name="name"
          v-model="name"
        />
      </div>
      <div class="col-md-7">
        <label for="inputCity" class="form-label">Phone</label>
        <input
          type="text"
          class="form-control"
          id="profile_Phone"
          placeholder="010-xxxx-xxxx"
          name="telephone"
          v-model="telephone"
        />
      </div>
      <div class="col-7">
        <label for="inputAddress2" class="form-label">Address</label>
        <input
          type="text"
          class="form-control"
          id="profile_Address"
          placeholder="1234 Main St, Apartment, studio, or floor"
          name="address"
          v-model="address"
        />
      </div>
    </fieldset>
    <div class="col-12">
      <router-link
        :to="{ name: 'UserModify', params: { user: this.id } }"
        class="btn btn-primary"
        style="margin-top: 10px"
        >Change Info</router-link
      >
      <b-button
        class="btn btn-primary"
        style="margin-top: 10px; margin-left: 10px"
        @click="deleteUser"
      >
        Delete account
      </b-button>
    </div>
  </form>
</template>

<script>
import { mapState } from "vuex";
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
  created() {
    this.id = this.loginInfo.id;
    this.password = this.loginInfo.password;
    this.name = this.loginInfo.name;
    this.telephone = this.loginInfo.telephone;
    this.address = this.loginInfo.address;
  },
  computed: {
    ...mapState(["loginInfo"]),
  },
  methods: {
    deleteUser() {
      // 삭제 처리
      alert("삭제");
    },
  },
};
</script>

<style></style>
