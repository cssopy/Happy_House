<template>
  <form class="row g-3" style="margin: 100px" method="post">
    <legend>Add notice</legend>
    <div class="col-md-10">
      <label for="inputEmail4" class="form-label">Title</label>
      <input
        type="text"
        class="form-control"
        id="notice_Title"
        name="title"
        v-model="notice.title"
      />
    </div>
    <div class="col-md-10">
      <label for="inputPassword4" class="form-label">Contents</label>
      <textarea
        type="text"
        class="form-control"
        id="notice_Contents"
        name="contents"
        v-model="notice.contents"
      ></textarea>
    </div>
    <div class="col-12">
      <button
        class="btn btn-primary"
        style="margin-top: 10px"
        @click="noticeRegist"
      >
        register
      </button>
    </div>
  </form>
</template>

<script>
export default {
  data() {
    return {
      notice: {
        title: "",
        contents: "",
        date: new Date(),
      },
    };
  },
  methods: {
    noticeRegist() {
      // 공지사항 등록 처리
      alert("등록");
      alert(this.notice);
    },
  },
};
</script>

<style></style>
