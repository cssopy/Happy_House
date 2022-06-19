<template>
  <div>
    <div class="row g-3" style="margin: 100px" v-if="article">
      <fieldset disabled>
        <legend>Article</legend>
        <div class="col-md-10">
          <label for="inputEmail4" class="form-label">Title</label>
          <input
            type="text"
            class="form-control"
            id="read_notice_Title"
            v-model="article.title"
          />
        </div>
        <div class="col-md-10">
          <label for="inputEmail4" class="form-label">Writer</label>
          <input
            type="text"
            class="form-control"
            id="read_notice_Title"
            v-model="article.writer"
          />
        </div>
        <div class="col-md-10">
          <label for="inputPassword4" class="form-label">Contents</label>
          <textarea
            type="text"
            class="form-control"
            rows="6"
            id="read_notice_Contents"
            v-model="article.content"
          ></textarea>
        </div>
      </fieldset>
      <div class="col-12">
        <div v-if="isLogin">
          <router-link
            class="btn btn-primary"
            style="margin-top: 10px; margin-right: 10px"
            :to="`/qna/modify/${article.index}`"
          >
            modify
          </router-link>
          <button
            class="btn btn-primary"
            style="margin-top: 10px"
            @click="removeArticle"
          >
            delete
          </button>
        </div>
      </div>
      <div>
        <div class="p-3 bg-light col-md-10">
          <div class="mb-3 mt-3">
            <label for="comment">Comments:</label>
            <textarea
              class="form-control"
              rows="3"
              id="comment"
              name="text"
              v-model="content"
            ></textarea>
          </div>
          <button type="button" class="btn btn-primary" @click="registCmt">
            등록
          </button>
        </div>
        <div class="col-md-10" v-if="comments">
          <div
            class="p-2 border-bottom"
            v-for="(comment, index) in comments"
            :key="index"
          >
            <table>
              <colgroup>
                <col style="width: 92%" />
                <col style="width: 8%" />
              </colgroup>
              <tr>
                <td>
                  <strong>{{ comment.writer }} </strong>
                  <span class="text-black-50">({{ comment.time }})</span>
                </td>
                <td>
                  <button
                    class="btn btn-outline-danger"
                    @click="removeComment(comment.index)"
                  >
                    삭제
                  </button>
                </td>
              </tr>
              <tr>
                <td>{{ comment.content }}</td>
              </tr>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import {
  getArticle,
  getComment,
  writeComment,
  deleteComment,
  deleteArticle,
} from "@/api/board";

export default {
  data() {
    return {
      article: null,
      content: "",
      comments: [],
    };
  },
  created() {
    // 해당하는 번호의 게시글 불러오기
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

    // 해당 게시글의 댓글 불러오기
    getComment(
      {
        boardName: "qna",
        articleIndex: this.$route.params.qnaid,
      },
      (response) => {
        this.comments = response.data;
      },
      (error) => {
        console.log("댓글 불러오기 에러발생!!", error);
      }
    );
  },
  computed: {
    ...mapState(["isLogin", "loginInfo"]),
  },
  methods: {
    registCmt() {
      writeComment(
        {
          boardName: "qna",
          articleIndex: this.article.index,
          comment: {
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
          this.$router.go();
        },
        (error) => {
          console.log(error);
        }
      );
    },
    removeArticle() {
      deleteArticle(
        {
          boardName: "qna",
          articleIndex: this.article.index,
        },
        ({ data }) => {
          let msg = "삭제 처리시 문제가 발생했습니다.";
          if (data === "SUCCESS") {
            msg = "삭제가 완료되었습니다.";
          }
          alert(msg);
          this.$router.push({ name: "QnaList" });
        },
        (error) => {
          console.log(error);
        }
      );
    },
    removeComment(cmtId) {
      deleteComment(
        {
          boardName: "qna",
          articleIndex: this.article.index,
          commentIndex: cmtId,
        },
        ({ data }) => {
          let msg = "삭제 처리시 문제가 발생했습니다.";
          if (data === "SUCCESS") {
            msg = "삭제가 완료되었습니다.";
          }
          alert(msg);
          this.$router.go();
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
