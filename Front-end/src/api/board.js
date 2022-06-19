import { apiInstance } from "./index.js";

const api = apiInstance();

function listArticle(boardName, success, fail) {
  api.get(`/board/${boardName}`).then(success).catch(fail);
}

function writeArticle(data, success, fail) {
  api
    .post(`/board/${data.boardName}`, JSON.stringify(data.article))
    .then(success)
    .catch(fail);
}

function getArticle(data, success, fail) {
  api
    .get(`/board/${data.boardName}/${data.articleIndex}`)
    .then(success)
    .catch(fail);
}

function modifyArticle(data, success, fail) {
  api
    .put(
      `/board/${data.boardName}/${data.articleIndex}`,
      JSON.stringify(data.article)
    )
    .then(success)
    .catch(fail);
}

function deleteArticle(data, success, fail) {
  api
    .delete(`/board/${data.boardName}/${data.articleIndex}`)
    .then(success)
    .catch(fail);
}

function getComment(data, success, fail) {
  api
    .get(`/board/${data.boardName}/${data.articleIndex}/comments`)
    .then(success)
    .catch(fail);
}

function writeComment(data, success, fail) {
  api
    .post(`/board/${data.boardName}/${data.articleIndex}`, data.comment)
    .then(success)
    .catch(fail);
}

function deleteComment(data, success, fail) {
  api
    .delete(
      `/board/${data.boardName}/${data.articleIndex}/${data.commentIndex}`
    )
    .then(success)
    .catch(fail);
}

export {
  listArticle,
  writeArticle,
  getArticle,
  modifyArticle,
  deleteArticle,
  getComment,
  writeComment,
  deleteComment,
};
