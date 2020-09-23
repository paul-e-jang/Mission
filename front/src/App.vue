<template>
<div>
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
</div>
</template>

<script>
import AppBar from './components/Appbar'
import Footer from './components/Footer'
const DEFAULT_TRANSITION = 'fade'

export default {
  data () {
    return {
      transitionName: DEFAULT_TRANSITION,
      prevHeight: 0
    }
  },
  created () {
    this.$router.beforeEach((to, from, next) => {
      this.transitionName = DEFAULT_TRANSITION
      next()
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
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap');
* {
  font-family: 'Noto Sans KR', sans-serif;
}

</style>
