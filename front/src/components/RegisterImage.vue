<template>
<v-sheet color="white" id="wrapper" class="pa-5">
  <div id="subject" class="cent">
    <h2> 이미지 업로드 </h2>
  </div>
    <input
    ref="imageInput"
    type="file"
    hidden
    multiple
    @change="onChangeImages"
    accept="image/png, image/jpeg, image/bmp, image/jpg, image/gif"
    >
    <div class="mb-5 cent">
    <v-btn rounded class="mr-3" :loading="loading" color="orange" outlined dark type="button" @click="onClickImageUpload" v-if="!imageUrl">이미지 선택
      <v-icon right dark>mdi-pencil</v-icon>
    </v-btn>
    <v-btn rounded color="indigo" class="mr-3" outlined dark type="button" @click="onClickImageUpload" v-if="imageUrl&&!loading">다시 선택
      <v-icon right dark>mdi-pencil</v-icon>
    </v-btn>
    <v-btn rounded color="green" :loading="loading" outlined dark @click="submitForm" v-if="imageUrl">이미지 업로드
      <v-icon right dark>mdi-cloud-upload</v-icon>
    </v-btn>
    </div>
   <v-card
    class="mx-auto mb-5"
    max-width="500"
    v-if="imageUrl"
    outlined
    tile
  >
      <v-img
      v-if="imageUrl"
      :src="imageUrl"
      aspect-ratio="1"
      class="grey lighten-2"
      />

    <v-card-title>
      이미지 이름: {{image.name}}
    </v-card-title>

    <v-card-subtitle>
      크기: {{ Math.round(image.size/1024) }}kb<br />
      작성자: {{ uploader }} <br />
      작성일: {{ new Date()}}
    </v-card-subtitle>
  </v-card>
</v-sheet>
</template>

<script>
import articleservice from '@/services/article'
export default {
  data () {
    return {
      imageUrl: null,
      loading: null,
      loader: null,
      image: null,
      uploader: this.$store.getters.user
    }
  },
  computed () {
    return {
      form: {
        imgName: this.image.name,
        imgSize: this.image.size,
        uploader: this.uploader,
        uploaded_time: new Date()
      }
    }
  },
  methods: {
    onClickImageUpload () {
      this.$refs.imageInput.click()
    },
    onChangeImages (e) {
      console.log(e.target.files)
      const file = e.target.files[0]
      this.image = file
      this.imageUrl = URL.createObjectURL(file)
    },
    submitForm () {
      const f = new FormData()
      const f2 = new FormData()
      f2.append('image', this.image)
      f.append('imgName', this.image.name)
      f.append('imgSize', this.image.size)
      f.append('uploader', this.uploader)
      f.append('uploaded_time', new Date())
      articleservice.fileUpload(f2)
      articleservice.writeArticle(f).then(() => {
        alert('성공적으로 등록되었습니다.')
        this.$router.push('/gallary')
      }).catch((error) => {
        this.errorMessage = '등록에 실패했습니다. 이유: \n' + error.message
      })
    }
  },
  watch: {
    loader () {
      const l = this.loader
      this[l] = !this[l]
      setTimeout(() => (this[l] = false), 3000)
      this.loader = null
    }
  }
}
</script>

<style scoped>
.cent {
  text-align: center;
}
#wrapper {
  min-height: 75vh;
}
#subject {
  margin-bottom: 20px;
  padding: 20px;
}
#input {
  width: 65%;
  margin: auto;
}
.custom-loader {
  animation: loader 1s infinite;
  display: flex;
}
</style>
