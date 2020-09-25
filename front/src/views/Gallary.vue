<template>
  <section>
    <div class="container">
      <div>
        <h1> 이미지 갤러리 </h1>
        </div>
      <div class="grid-row">
        <img v-for="(img, idx) in imgs" :key=idx :src="require(`@/assets/img/${img.name}`)" :alt="img.alt" @click="() => show(idx)">
      </div>
    </div>
    <vue-easy-lightbox
      escDisabled
      moveDisabled
      :visible="visible"
      :imgs="imgs"
      :index="index"
      @hide="handleHide"
      @on-index-change="handleIndexChange"
    ></vue-easy-lightbox>
  </section>
</template>

<script>
import VueEasyLightbox from 'vue-easy-lightbox'
import articleservice from '@/services/article'

export default {
  data () {
    return {
      imgs: [{
        name: 'alps.jpg',
        alt: 'I will live here someday',
        src: ''
      },
      {
        name: 'bear.jpg',
        alt: 'Friendly bear',
        src: '../assets/img/bear.jpg'
      }],
      visible: false,
      index: 0
    }
  },
  mounted () {
    this.Fetch()
  },
  methods: {
    show (index) {
      this.index = index
      this.visible = true
    },
    handleHide () {
      this.visible = false
    },
    handleIndexChange (old, newIndex) {
      if (newIndex === 5) {
        setTimeout(() => {
          this.imgs.push('https://i.loli.net/2018/11/10/5be6852e33f19.jpeg')
        }, 1000)
      }
    },
    Fetch () {
      articleservice.fetchArticles()
      this.$bus.$on('articleLoad', (data) => {
        this.imgs = data
        console.log(this.imgs)
      })
    }
  },
  components: {
    VueEasyLightbox
  }

}
</script>

<style ccoped>
img {
  width: 270px;
  height: 180px;
  margin: 20px;
  border-radius: 3px;
  cursor: pointer;
  transition: all 0.3s ease;
}

img:hover {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0);
  transform: scale(1.05);
}

#mylightbox {
  background-color: blanchedalmond;
}

.container {
  width: 100%;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  min-height: 85vh;
  position: relative
}
h1 {
  color: black;
}
.gallery {
  width: 80%;
  max-width: 980px;
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
}
.pic {
  width: calc(50% - 30px);
  margin: 15px;
  cursor: pointer;
}

.grid-row {
  display: flex;
  flex-flow: row wrap;
  justify-content: flex-start;
}
.btn {
  cursor: pointer;
  outline: none;
  text-decoration: none;
  text-align: center;
  font-size: 20px;
  line-height: 50px;
  height: 50px;
  padding: 0 8px;
  margin-left: 20px;
  background-color: #50d1c1;
  border-color: #50d1c1;
  border-radius: 4px;
  color: #fff;
  transition: 0.3s;
}
.btn:active {
  color: #ccc;
  background-color: #6ab5ae;
  border-color: #6ab5ae;
  outline: none;
}

</style>
