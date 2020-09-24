<template>
<section>
  <form id="upload">
    <fieldset>
      <legend>이미지 업로드</legend>
      <input multiple="multiple" name="files[]" id="files" type="file"/> <br>
      <input type="submit" value="업로드">
      <div class="file-list"></div>
    </fieldset>
  </form>
</section>
</template>

<script>
export default {
  data () {
    return {
      files: [],
      previewIndex: 0
    }
  }
}
</script>
