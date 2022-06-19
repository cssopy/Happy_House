import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    isLogin: false,
    loginInfo: null,
  },
  getters: {},
  mutations: {
    SET_IS_LOGIN: (state, isLogin) => {
      state.isLogin = isLogin;
    },
    SET_LOGIN_INFO: (state, loginInfo) => {
      state.loginInfo = loginInfo;
    },
  },
  actions: {
    setlogin({ commit }, user) {
      commit("SET_IS_LOGIN", true);
      commit("SET_LOGIN_INFO", user);
    },
    setlogout({ commit }) {
      commit("SET_IS_LOGIN", false);
      commit("SET_LOGIN_INFO", null);
    },
  },
  modules: {},
  plugins: [
    createPersistedState({
      // 브라우저 종료시 제거하기 위해 localStorage가 아닌 sessionStorage로 변경. (default: localStorage)
      storage: sessionStorage,
    }),
  ],
});
