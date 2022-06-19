import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: () => import("@/views/HomeView.vue"),
  },
  {
    path: "/user",
    name: "User",
    component: () => import("@/views/UserView.vue"),
    children: [
      {
        path: "signup",
        name: "UserSignUp",
        component: () => import("@/components/user/UserSignUp.vue"),
      },
      {
        path: "login",
        name: "UserLogin",
        component: () => import("@/components/user/UserLogin.vue"),
      },
      {
        path: "find",
        name: "UserFind",
        component: () => import("@/components/user/UserFindPwd.vue"),
      },
      {
        path: "logout",
        name: "UserLogout",
        component: () => import("@/components/user/UserLogout.vue"),
      },
      {
        path: "info",
        name: "UserInfo",
        component: () => import("@/components/user/UserInfo.vue"),
      },
      {
        path: "modify",
        name: "UserModify",
        component: () => import("@/components/user/UserModify.vue"),
      },
    ],
  },
  {
    path: "/notice",
    name: "notice",
    component: () => import("@/views/NoticeView.vue"),
    children: [
      {
        path: "",
        name: "NoticeList",
        component: () => import("@/components/notice/NoticeList.vue"),
      },
      {
        path: "regist",
        name: "Regist",
        component: () => import("@/components/notice/NoticeRegist.vue"),
      },
    ],
  },
  {
    path: "/qna",
    name: "Qna",
    component: () => import("@/views/QnaView.vue"),
    children: [
      {
        path: "",
        name: "QnaList",
        component: () => import("@/components/qna/QnaList.vue"),
      },
      {
        path: "regist",
        name: "QnaRegist",
        component: () => import("@/components/qna/QnaRegist.vue"),
      },
      {
        path: "detail/:qnaid",
        name: "QnaDetail",
        component: () => import("@/components/qna/QnaDetail.vue"),
      },
      {
        path: "modify/:qnaid",
        name: "QnaModify",
        component: () => import("@/components/qna/QnaModify.vue"),
      },
    ],
  },
  {
    path: "/apt",
    name: "Apt",
    component: () => import("@/views/AptView.vue"),
    children: [
      {
        path: "interest",
        name: "Interest",
        component: () => import("@/components/apt/AptInterest.vue"),
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
