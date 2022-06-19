<template>
  <header id="header" class="fixed-top d-flex align-items-center">
    <b-container>
      <b-row class="d-flex align-items-center justify-content-between">
        <b-col>
          <div class="logo">
            <h1>
              <router-link to="/">Happy House &#127968;</router-link>
            </h1>
          </div>
        </b-col>
        <b-col>
          <nav id="navbar" class="navbar">
            <div id="header_nav_confirm_off" v-if="!isLogin">
              <ul>
                <li>
                  <router-link to="/notice" class="nav-link scrollto"
                    >공지사항</router-link
                  >
                </li>
                <li>
                  <router-link to="/user/login" class="nav-link scrollto"
                    >로그인</router-link
                  >
                </li>
                <li>
                  <router-link to="/user/signup" class="getstarted scrollto"
                    >회원가입</router-link
                  >
                </li>
              </ul>
            </div>
            <div id="header_nav_confirm_on" v-else>
              <ul>
                <li>
                  <router-link to="/notice" class="nav-link scrollto"
                    >공지사항</router-link
                  >
                </li>
                <li>
                  <router-link to="/qna" class="nav-link scrollto"
                    >Q&A</router-link
                  >
                </li>
                <li>
                  <router-link to="/apt/interest" class="nav-link scrollto"
                    >관심 지역</router-link
                  >
                </li>
                <li>
                  <router-link to="/user/logout" class="nav-link scrollto"
                    >로그아웃</router-link
                  >
                </li>
                <li>
                  <router-link to="/user/info" class="getstarted scrollto"
                    >회원정보</router-link
                  >
                </li>
              </ul>
            </div>
            <i class="bi bi-list mobile-nav-toggle"></i>
          </nav>
        </b-col>
      </b-row>
    </b-container>
  </header>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "MainHeader",
  computed: {
    ...mapState(["isLogin", "loginInfo"]),
  },
};
</script>

<style></style>
