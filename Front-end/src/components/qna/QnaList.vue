<template>
  <div>
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
            <th style="min-width: 35rem; text-align: center">제목</th>
            <th>작성자</th>
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
              <router-link
                class="user-link"
                :to="`/qna/detail/${article.index}`"
                >{{ article.title }}</router-link
              >
            </td>
            <td>{{ article.writer }}</td>
            <td>{{ article.time }}</td>
          </tr>
        </tbody>
      </table>
      <router-link
        v-if="isLogin"
        :to="{ name: 'QnaRegist' }"
        class="btn btn-primary"
        style="margin-bottom: 10px"
        >Q&A 등록</router-link
      >
    </main>
  </div>
</template>

<script>
import { mapState } from "vuex";
import { listArticle } from "@/api/board";

export default {
  data() {
    return {
      articles: [],
    };
  },
  created() {
    // 서버를 통해 게시글 불러오기 및 articles 초기화
    listArticle(
      "qna",
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

<style scoped>
td {
  padding: 0.25rem;
}
th {
  padding: 0.25rem;
  text-align: center;
}
</style>
