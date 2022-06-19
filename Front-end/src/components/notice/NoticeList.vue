<template>
  <main
    style="
      margin: 100px;
      display: flex;
      flex-direction: column;
      align-items: center;
    "
  >
    <table style="margin: 2rem">
      <thead style="border-bottom: solid #174c6d 0.125rem">
        <tr>
          <th style="min-width: 45rem; text-align: center">제목</th>
          <th>작성시간</th>
        </tr>
      </thead>
      <tbody v-if="articles">
        <tr
          class="border-bottom"
          v-for="(article, index) in articles"
          :key="index"
        >
          <td>
            <a
              href="${pageContext.request.contextPath}/Notice/readNotice?idx=${article.idx}"
              >{{ article.title }}</a
            >
          </td>
          <td>{{ article.time }}</td>
        </tr>
      </tbody>
    </table>
    <router-link
      to="/notice/regist"
      class="btn btn-primary"
      style="margin-bottom: 10px"
      v-if="isLogin"
      >공지사항 등록</router-link
    >
  </main>
</template>

<script>
import { mapState } from "vuex";
import { listArticle } from "@/api/board";

export default {
  data() {
    return {
      articles: null,
    };
  },
  created() {
    listArticle(
      "notice",
      (response) => {
        this.articles = response.data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  computed: {
    ...mapState(["isLogin"]),
  },
};
</script>

<style></style>
