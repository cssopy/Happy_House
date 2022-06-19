<template>
  <!-- <c:if test = "${!empty userDto}">  -->
  <section id="interest" class="d-flex align-items-center">
    <div class="container">
      <form style="margin: 200px" id="interest-form" method="post">
        <select
          id="sido"
          class="mb-3 form-control"
          form="interest-form"
          name="sido"
        >
          <option selected="selected">시/도를 선택하세요.</option>
          <option>서울특별시</option>
        </select>
        <select
          id="gugun"
          class="mb-3 form-control"
          form="interest-form"
          name="gugun"
        >
          <option selected="selected">시/도를 먼저 선택하세요.</option>
        </select>
        <select
          id="dong"
          class="mb-3 form-control"
          form="interest-form"
          name="dong"
        >
          <option selected="selected">구/군을 먼저 선택하세요.</option>
        </select>
        <input id="regionCode" type="hidden" name="regionCode" />
        <input type="hidden" name="action" value="register" />
        <button type="submit" class="btn btn-primary" Id="button_submit">
          등록
        </button>
      </form>
    </div>
  </section>
  <!-- </c:if> -->
</template>

<script>
export default {};
</script>

<style></style>
