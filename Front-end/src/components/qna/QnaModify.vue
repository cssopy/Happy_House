<template>
  <form
    id="writeform"
    class="row g-3"
    style="margin: 100px"
    method="post"
    v-if="article"
  >
    <legend>Notice</legend>
    <div class="col-md-10">
      <label for="inputEmail4" class="form-label">Title</label>
      <input
        type="text"
        class="form-control"
        id="title"
        name="title"
        v-model="article.title"
      />
    </div>
    <div class="col-md-10">
      <label for="inputPassword4" class="form-label">Contents</label>
      <textarea
        type="text"
        class="form-control"
        rows="6"
        id="contents"
        name="contents"
        v-model="article.content"
      ></textarea>
    </div>

    <div class="col-12">
      <input type="hidden" name="act" value="modifyNotice" />
      <input
        type="button"
        id="modifyBtn"
        class="btn btn-primary"
        style="margin-top: 10px; margin-right: 10px"
        value="modify"
        @click="updateArticle"
      />
    </div>
  </form>
</template>

<script>
import { getArticle, modifyArticle } from "@/api/board";

export default {
  data() {
    return {
      article: null,
    };
  },
  created() {
    getArticle(
      {
        boardName: "qna",
        articleIndex: this.$route.params.qnaid,
      },
      (response) => {
        this.article = response.data;
      },
      (error) => {
        console.log("게시글 불러오기 에러발생!!", error);
      }
    );
  },
  methods: {
    updateArticle() {
      this.article.time = new Date(this.article.time);
      console.log(this.article);
      modifyArticle(
        {
          boardName: "qna",
          articleIndex: this.article.index,
          article: {
            index: this.article.index,
            title: this.article.title,
            content: this.article.content,
          },
        },
        ({ data }) => {
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data === "SUCCESS") {
            msg = "수정이 완료되었습니다.";
          }
          alert(msg);
          this.$router.push(`/qna/detail/${this.article.index}`);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};
</script>

<style></style>
