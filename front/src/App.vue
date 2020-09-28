<template>
<v-app>
  <header>
  <AppBar />
  </header>
  <main>
    <transition
      :name="transitionName"
      mode="out-in"
      @beforeLeave="beforeLeave"
      @enter="enter"
      >
    <router-view/>
    </transition>
  </main>
    <footer>
  <Footer />
    </footer>
</v-app>
</template>

<script>
import AppBar from './components/Appbar'
import Footer from './components/Footer'
import auth from './services/authentication'

const DEFAULT_TRANSITION = 'fade'

export default {
  data () {
    return {
      transitionName: DEFAULT_TRANSITION,
      prevHeight: 0
    }
  },
  created () {
    document.title = 'SmartJack coding test'
    this.$router.beforeEach((to, from, next) => {
      this.transitionName = DEFAULT_TRANSITION
      if (to.name === 'Admin' || to.name === 'Gallary') {
        if (!this.$store.getters.logged) {
          alert('로그인 하세요.')
          this.$router.push('login')
        } else {
          next()
        }
      } else if (to.name === 'LogOut') {
        auth.beforeLogOut().then(() => {
          this.$store.commit('logout')
          alert('로그아웃 성공')
        }).catch(() => {
          alert('로그아웃 성공')
          this.$store.commit('logout')
          window.location.href = 'http://localhost:8090/'
        })
      } else { next() }
    })
  },
  methods: {
    beforeLeave (element) {
      this.prevHeight = getComputedStyle(element).height
    },
    enter (element) {
      const { height } = getComputedStyle(element)

      element.style.height = this.prevHeight

      setTimeout(() => {
        element.style.height = height
      })
    },
    afterEnter (element) {
      element.style.height = 'auto'
    }
  },
  components: {
    AppBar,
    Footer
  }
}
</script>

<style>
@import './css/master.css';
@import './css/bootstrap.css';
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap');
* {
  font-family: 'Noto Sans KR', sans-serif;
}

</style>
