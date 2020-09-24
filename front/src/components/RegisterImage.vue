<template>
<v-sheet color="white" id="wrapper">
  <div id="subject">
    <h2> 이미지 업로드 </h2>
  </div>
  <v-row class="ma-5" v-if="imageUrl" id="grid-image">
    <v-col>
        <v-container fluid>
          <v-row>
            <v-col
              v-for="n in 8"
              :key="n"
              class="d-flex child-flex"
              cols="3"
            >
              <v-card flat tile class="d-flex">
                <v-img
                v-if="imageUrl"
                :src="imageUrl"
                aspect-ratio="1"
                class="grey lighten-2"
                >
                  <template v-slot:placeholder>
                    <v-row
                      class="fill-height ma-0"
                      align="center"
                      justify="center"
                    >
                      <v-progress-circular indeterminate color="grey lighten-5"></v-progress-circular>
                    </v-row>
                  </template>
                </v-img>
              </v-card>
            </v-col>
          </v-row>
        </v-container>
    </v-col>
  </v-row>

    <input
    ref="imageInput"
    type="file"
    hidden
    multiple
    @change="onChangeImages"
    accept="image/png, image/jpeg, image/bmp, image/jpg, image/gif"
    >
    <v-btn rounded class="mr-3" :loading="loading" color="orange" outlined dark type="button" @click="onClickImageUpload" v-if="!imageUrl">이미지 선택
      <v-icon right dark>mdi-pencil</v-icon>
    </v-btn>
    <v-btn rounded color="indigo" class="mr-3" outlined dark type="button" @click="onClickImageUpload" v-if="imageUrl&&!loading">다시 선택
      <v-icon right dark>mdi-pencil</v-icon>
    </v-btn>
    <v-btn rounded color="green" :loading="loading" outlined dark type="button" @click="loader = 'loading'" v-if="imageUrl">이미지 업로드
      <v-icon right dark>mdi-cloud-upload</v-icon>
    </v-btn>
</v-sheet>
</template>

<script>
export default {
  data () {
    return {
      imageUrl: null,
      loading: null,
      loader: null
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
* {
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
