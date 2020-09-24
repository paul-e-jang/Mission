<template>
  <div class="home">
    <section id="hero-image">
              <div class="hero-text">
                  <h1>SmartJack <span>Gallary</span> 과제</h1>
                  <h5>
                    프런트엔드로 Vue.js / Vue-router / Vuex를 사용하였고, 스프링 프레임워크를 RESTapi 서버로 사용하였습니다. <br />
                    서버로 Tomcat9를 사용하였고, 스프링 시큐리티와 연동하여 Single Page Application을 구성하였습니다.
                  </h5>
                  <v-btn dark color="warning"> Goto gallary </v-btn>
              </div>
          </section>

    <section id="pages-list">
        <div class="flex">
            <h5>구현 페이지</h5>
            <div id="pages-list-container">
                <div class="pages-list-item">
                    <span class="pages-list-text">이미지 갤러리(업로드, 뷰), 로그인, 회원가입, 로그인/로그아웃 이력 페이지</span>
                </div>
            </div>
        </div>
    </section>
  </div>
</template>

<script>

export default {
  name: 'Home'
}
</script>
