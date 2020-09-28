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
              <li v-if=logged><router-link to="/logout"> 로그아웃 </router-link></li>
              <li v-if=!logged><router-link to="/login"> 로그인 </router-link> </li>
              <li v-if=!logged><router-link to="/register"> 회원가입 </router-link></li>
          </ul>
      </nav>

</div>
</template>

<script>
import auth from '@/services/authentication'

export default {
  name: 'Appbar',
  props: {
    msg: String
  },
  computed: {
    logged () {
      return Boolean(this.$store.getters.logged)
    }
  },
  methods: {
    beforeLogout () {
      auth.beforeLogOut().then(() => {
        alert('로그아웃 완료')
      }).catch((error) => {
        alert(error.message)
      })
    }
  }
}
</script>

<style scoped>
nav ul {
    list-style-type: none;
    padding: 0;
    margin: 5px 0 0;
}

nav ul li {
    display: inline-block;
    font-size: 1em;
    margin-right: 30px;
    vertical-align: middle;
}

nav ul li a {
    color: #eee;
    font-weight: 500;
}

nav ul li a:hover {
    color: #FFB320;
}
</style>
