<template>
  <form class="row g-3" style="margin: 200px" method="post">
    <input type="hidden" name="action" value="findpassword" />
    <span>
      <div class="col-md-4">
        <label for="inputEmail4" class="form-label">ID</label>
        <input
          type="text"
          class="form-control"
          name="id"
          id="inputID"
          v-model="id"
        />
      </div>
    </span>
    <span>
      <div class="col-md-4">
        <label for="inputAddress" class="form-label">Name</label>
        <input
          type="text"
          class="form-control"
          name="name"
          id="inputName"
          placeholder="name"
          v-model="name"
        />
      </div>
    </span>
    <span>
      <div class="col-md-4">
        <label for="inputCity" class="form-label">Phone</label>
        <input
          type="text"
          class="form-control"
          name="telephone"
          id="inputPhone"
          placeholder="010-xxxx-xxxx"
          v-model="telephone"
        />
      </div>
    </span>

    <div class="col-12">
      <input
        type="button"
        class="btn btn-primary"
        ID="button_submit"
        value="Find password"
        @click="findPwd"
      />
    </div>
  </form>
</template>

<script>
export default {
  data() {
    return {
      id: "",
      name: "",
      telephone: "",
    };
  },
  methods: {
    findPwd: function () {
      let userlist = JSON.parse(localStorage.getItem("userlist"));

      for (let user of userlist) {
        if (
          user.id == this.id &&
          user.name == this.name &&
          user.telephone == this.telephone
        ) {
          alert(user.password);
          break;
        }
      }
    },
  },
};
</script>

<style></style>
