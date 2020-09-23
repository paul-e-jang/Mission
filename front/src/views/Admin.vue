<template>
<div class="admin">
  <nav class="admin-nav">
    <ul class="menu">
      <li class="menu-item">
        <router-link class="menu-link" to="/record" id="menu1">로그인 기록</router-link>
      </li>
      <li class="menu-item">
        <router-link class="menu-link" to="/registerimage" id="menu2" >이미지 등록</router-link>
      </li>
    </ul>
  </nav>
  <main class="admin-main">
    <router-view></router-view>
  </main>
</div>
</template>

<script>

export default {
  mounted () {
    document.getElementById('menu1').focus()
  }
}
</script>

<style scoped lang="scss">
// Static Variables
$admin-nav-width: 250px;

// Global CSS

*,
*::before,
*::after {
  box-sizing: border-box;
}

body {
  height: 85vh;
  overflow-x: hidden;
}

// Main Layout Grid

.admin {
  --spacing: 1rem;

  // Flexbox Fallback
  display: flex;
  flex-wrap: wrap;

  // Grid
  display: grid;
  height: 85vh;

  grid-template-columns:  $admin-nav-width 1fr;
  grid-template-areas:    "nav    main";

  &-nav {
    flex: 0 0 $admin-nav-width;
    grid-area: nav;
    background: url('../assets/img/bg_pattern.png') 0 0 repeat;
  }

  &-main {
    flex: 1;
    grid-area: main;
    padding: var(--spacing);
    overflow-y: auto;
    overflow-x: hidden;
    -webkit-overflow-scrolling: touch;

    background-color: #f4f7fa;
  }

  @media screen and (min-width: 48rem) {
    --spacing: 2rem;
  }
}

// ===============================
// Demo stuff to make it look nice
// ===============================

img {
  max-width: 100%;
  height: auto;
}

.toolbar {
  display: flex;
  flex: 1;
  justify-content: space-between;
  align-items: center;
  padding: 0 var(--spacing);
}

.menu {
  list-style-type: none;
  padding: 0;

  &-item {
    border-bottom: 1px solid rgba(255, 255, 255, 0.07);
  }
  &-link {
    display: block;
    padding: 1rem 2rem;
    color: #fff;
    text-decoration: none;
    &:hover,
    &:focus{
      background-color: #1f222d;
    }
  }

}
</style>
