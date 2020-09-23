<template>
  <section id="notfound">
      <div class="flex">
          <div class="notfound-content">
              잘못된 요청입니다!
          </div>
      </div>
  </section>
</template>

<script>

export default {
  name: '404',
  mounted () {
    setTimeout(() => {
      this.$router.push('/')
    }, 2000)
  }
}
</script>
