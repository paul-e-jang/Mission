<template>
<v-sheet color="white" id="wrapper">
  <div id="subject">
    <h2> 이미지 업로드 </h2>
  </div>
  <div v-for="(item, index) in files" :key="index">
    {{ item.name}} <br> {{item}} <br>
    </div>
      <input ref="imageInput" type="file" hidden @change="onChangeImages">
    <v-btn type="button" @click="onClickImageUpload">이미지 업로드</v-btn>
    <v-img v-if ="imageUrl" :src="imageUrl" />
  <div id="input">
<v-file-input
    v-model="files"
    color="orance accent-3"
    counter
    label="File input"
    multiple
    placeholder="클릭하여 업로드 하세요."
    prepend-icon="mdi-camera"
    outlined
    accept="image/png, image/jpeg, image/bmp, image/jpg, image/gif"
    :show-size="1000"
    :rules="valid.size"
    ref="imageInput"
  >
    <template v-slot:selection="{ index, text }">
      <v-chip
        v-if="index < 2"
        color="orange darken-2"
        dark
        label
        small
      >
        {{ text }}
      </v-chip>

      <span
        v-else-if="index === 2"
        class="overline grey--text text--darken-3 mx-2"
      >
        +{{ files.length - 2 }} File(s)
      </span>
    </template>
  </v-file-input>
</div>
</v-sheet>
</template>

<script>
export default {
  data () {
    return {
      files: [],
      valid: {
        size: [
        ]
      },
      imageUrl: null
    }
  },
  methods: {
    onClickImageUpload () {
      this.$refs.imageInput.click()
    },
    onChangeImages (e) {
      console.log(e.target.files)
      const file = e.target.files[0]
      this.imageUrl = URL.createObjectURL(file)
    }
  }
}
</script>

<style scoped>
* {
  text-align: center;
}
#wrapper {
  min-height: 75vh;
}

#subject {
  margin-bottom: 20px;
  padding: 30px;
}

#input {
  width: 65%;
  margin: auto;
}

</style>
