<template>
  <form class="row g-3" style="margin: 100px">
    <legend>Profile Info</legend>
    <div class="col-md-7">
      <label for="inputEmail4" class="form-label">ID</label>
      <input
        type="text"
        class="form-control"
        id="profile_ID"
        name="id"
        value="${userDto.id}"
        disabled
      />
    </div>
    <div class="col-md-7">
      <label for="inputPassword4" class="form-label">Password</label>
      <input
        type="text"
        class="form-control"
        id="profile_PWD"
        name="password"
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
        value="${userDto.name}"
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
        value="${userDto.telephone}"
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
        value="${userDto.address}"
      />
    </div>
    <div class="col-12">
      <button
        class="btn btn-primary"
        style="margin-top: 10px"
        @click="modifyUser"
      >
        Confirm Change
      </button>
    </div>
  </form>
</template>

<script>
export default {
  methods: {
    modifyUser() {
      // 사용자 정보 수정
      alert("수정");
    },
  },
};
</script>

<style></style>
