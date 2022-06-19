<template>
  <form class="row g-3" style="margin: 100px" method="">
    <legend>Add Q&A</legend>
    <div class="col-md-10">
      <label for="inputEmail4" class="form-label">Title</label>
      <input
        type="text"
        class="form-control"
        id="notice_Title"
        name="title"
        v-model="title"
      />
    </div>
    <div class="col-md-10">
      <label for="inputPassword4" class="form-label">Contents</label>
      <textarea
        type="text"
        class="form-control"
        id="notice_Contents"
        name="contents"
        v-model="content"
      ></textarea>
    </div>
    <div class="col-12">
      <input type="hidden" name="act" value="insertNotice" />
      <input
        type="button"
        class="btn btn-primary"
        style="margin-top: 10px"
        value="register"
        @click="regist"
      />
    </div>
  </form>
</template>

<script>
import { mapState } from "vuex";
import { writeArticle } from "@/api/board";

export default {
  data() {
    return {
      title: null,
      content: null,
    };
  },
  methods: {
    regist() {
      writeArticle(
        {
          boardName: "qna",
          article: {
            board: "qna",
            title: this.title,
            content: this.content,
            writer: this.loginInfo.id,
          },
        },
        ({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "SUCCESS") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
          this.moveList();
        },
        (error) => {
          console.log(error);
        }
      );
    },
    moveList() {
      this.$router.push({ name: "QnaList" });
    },
  },
  computed: {
    ...mapState(["loginInfo"]),
  },
};
</script>

<style></style>
