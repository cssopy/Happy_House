<template>
  <div class="home">
    <section id="hero" class="d-flex align-items-center">
      <div class="container">
        <div class="row">
          <div
            class="col-lg-6 pt-5 pt-lg-0 order-2 order-lg-1 d-flex flex-column justify-content-center"
          >
            <h1 data-aos="fade-up">Welcome to Happy House!</h1>
            <h2 data-aos="fade-up" data-aos-delay="400">
              Happy House에서 동별, 아파트별 실거래가를 확인하세요.
            </h2>
            <div data-aos="fade-up" data-aos-delay="800">
              <a href="#search" class="btn-get-started scrollto">시작하기</a>
            </div>
          </div>
          <div
            class="col-lg-6 order-1 order-lg-2 hero-img"
            data-aos="fade-left"
            data-aos-delay="200"
          >
            <img src="" class="img-fluid animated" alt="" />
          </div>
        </div>
      </div>
    </section>
    <!-- End Hero -->

    <main id="main">
      <!-- ======= Clients Section ======= -->
      <section id="clients" class="clients clients">
        <div class="container">
          <div class="row"></div>
        </div>
      </section>
      <!-- End Clients Section -->

      <!-- ======= Search Section ======= -->
      <section id="search" class="search">
        <div class="container">
          <div class="section-title" data-aos="fade-up">
            <h2>간편 조회하기</h2>
            <p>조회하고자 하는 지역을 선택해주세요.</p>
          </div>

          <div class="row" data-aos="fade-up">
            <div class="dropdown">
              <select id="sido" class="form-control">
                <option selected="selected">시/도를 선택하세요.</option>
                <option>서울특별시</option>
              </select>
              <select id="gugun" class="form-control">
                <option selected="selected">시/도를 먼저 선택하세요.</option>
              </select>
              <select id="dong" class="form-control">
                <option selected="selected">구/군을 먼저 선택하세요.</option>
              </select>
            </div>
          </div>
        </div>
      </section>
      <!-- End Services Section -->

      <!-- ======= Map Section ======= -->
      <section id="map" class="map" data-aos="fade-up">
        <!-- 지도를 표시할 div 입니다 -->
        <div id="map" style="width: 100%; height: 350px"></div>
      </section>
    </main>
    <!-- End #main -->
  </div>
</template>

<script></script>
