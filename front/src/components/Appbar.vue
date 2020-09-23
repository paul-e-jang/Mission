<template>
<div class="flex">
      <div class="logo">
          <router-link to="/"><h2>SmartJack Mission</h2></router-link>
      </div>
      <nav>
          <button id="nav-toggle" class="hamburger-menu">
              <span class="strip"></span>
              <span class="strip"></span>
              <span class="strip"></span>
          </button>
          <ul id="nav-menu-container">
              <li><router-link to="/">Home</router-link></li>
              <li><router-link to="/gallary">갤러리</router-link></li>
              <li><router-link to="/admin">관리</router-link></li>
              <li><router-link to="/login"> 로그인 </router-link> </li>
              <li><router-link to="/register"> 회원가입 </router-link></li>
          </ul>
      </nav>

</div>
</template>

<script>
export default {
  name: 'Appbar',
  props: {
    msg: String
  }
}
</script>
