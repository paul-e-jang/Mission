<template>
  <div class="dashboard">
    <div class="dashboard-item--full">
      <div class="card">
        Something!
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'LoginRecord'
}
</script>

<style scoped lang="scss">
// Dashboard Overview Grid

.dashboard {
  --column-count: 2;

  // Flexbox Fallback
  display: flex;
  flex-wrap: wrap;
  margin: 0 calc(var(--spacing) * -0.5);

  // Grid
  display: grid;
  grid-template-columns: repeat(var(--column-count), 1fr);
  grid-gap: var(--spacing);

  &-item {
    // By default, items span 2 columns
    flex: 1 1 50%;
    grid-column-end: span 2;
    padding: calc(var(--spacing) / 2);

    // these span the full width
    &--full {
      flex-basis: 100%;
      grid-column: 1 / -1;
    }

    // these span only one column
    &--col {
      flex-basis: calc(100% / var(--column-count));
      grid-column-end: span 1;
    }
  }

  // Switch to 4-col grid on larger screens
  @media screen and (min-width: 48rem) {
    --column-count: 4;
  }

  // If we have grid support, reset the margins and paddings;
  // grid-gap handles the spacing for us.
  @supports (display: grid) {
    margin: 0;

    &-item {
      padding: 0;
    }
  }
  .card {
  height: 100%;
  width: 100%;
  padding: 1rem;
  font-size: 2rem;
  font-weight: 300;
  background-color: #fff;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
  transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
}
}
</style>
