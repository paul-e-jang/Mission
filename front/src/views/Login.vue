<template>
  <section class="login">
  <form class="form-signin" @submit.prevent="submitForm">
    <div class="text-center mb-4">
      <span class="h3 mb-3 text-white">SmartJack 로그인</span>
    </div>

    <div v-show="errorMessage" class="alert alert-danger failed">{{ errorMessage }}</div>

    <div class="form-label-group">
      <input type="text" v-model="form.username" id="Id" class="form-control" placeholder="아이디" autofocus>
      <label for="Id">이메일 or 아이디</label>
         <div class="field-error" v-if="$v.form.username.$dirty">
          <div class="denied" v-if="!$v.form.username.required">이메일 혹은 아이디를 입력하세요.</div>
          </div>
    </div>

    <div class="form-label-group">
      <input type="password" v-model="form.password" id="Pass" class="form-control" placeholder="비밀번호" >
      <label for="Pass">비밀번호</label>
          <div class="field-error" v-if="$v.form.password.$dirty">
          <div class="denied" v-if="!$v.form.password.required">비밀번호를 입력하세요.</div>
          </div>
    </div>
    <button class="btn-lg btn-warning btn-block mb-3 mt-3 login_btn" type="submit" >로그인</button>
    <ul class="nav justify-content-center">
    </ul>
    <p class="mt-5 mb-3 text-muted text-center">&copy; 2020 <a href="http://github.com/bashpound">Github.com/bashpound/mission</a>
    </p>
  </form>
  </section>
</template>

<script>
import { required } from 'vuelidate/lib/validators'
import authenticationService from '@/services/authentication'

export default {
  name: 'LoginPage',
  data: function () {
    return {
      form: {
        username: '',
        password: ''
      },
      errorMessage: ''
    }
  },
  validations: {
    form: {
      username: {
        required
      },
      password: {
        required
      }
    }
  },
  methods: {
    submitForm () {
      this.$v.$touch()
      if (this.$v.$invalid) {
        return
      }

      authenticationService.authenticate(this.form).then(() => {
        authenticationService.fetchuser()
        this.$bus.$on('myDataFetched', data => {
          this.$store.commit('updateMyData', data)
        })
        alert('로그인 성공')
        this.$router.push('/')
      }).catch((error) => {
        this.errorMessage = error.message
      })
    },
    isEmail (s) {
      const regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i
      return Boolean(regExp.test(s))
    }
  }
}
</script>

<style scoped>
.denied {
  color: #FFB320;
}
.login {
  min-height: 85vh;
  padding-top: 10%;
  padding-bottom: 50px;
  background: #3d3d3d;
}
.bd-placeholder-img {
  font-size: 1.125rem;
  text-anchor: middle;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

@media (min-width: 768px) {
  .bd-placeholder-img-lg {
    font-size: 3.5rem;
  }
}

.form-signin {
  width: 100%;
  max-width: 420px;
  padding: 0px;
  margin: auto;
}

.form-label-group {
  position: relative;
  margin-bottom: 1rem;
  text-align:left;
}

.form-label-group>input,
.form-label-group>label {
  height: 3.125rem;
  padding: .75rem;
}

.form-label-group>label {
  position: absolute;
  top: 0;
  left: 0;
  display: block;
  width: 100%;
  margin-bottom: 0;
  /* Override default `<label>` margin */
  line-height: 1.5;
  color: #495057;
  pointer-events: none;
  cursor: text;
  /* Match the input under the label */
  border: 1px solid transparent;
  border-radius: .25rem;
  transition: all .1s ease-in-out;
}

.form-label-group input::-webkit-input-placeholder {
  color: transparent;
}

.form-label-group input:-ms-input-placeholder {
  color: transparent;
}

.form-label-group input::-ms-input-placeholder {
  color: transparent;
}

.form-label-group input::-moz-placeholder {
  color: transparent;
}

.form-label-group input::placeholder {
  color: transparent;
}

.form-label-group input:not(:placeholder-shown) {
  padding-top: 1.25rem;
  padding-bottom: .25rem;
}

.form-label-group input:not(:placeholder-shown)~label {
  padding-top: .25rem;
  padding-bottom: .25rem;
  font-size: 12px;
  color: #777;
}
.nav-link{
  color:black;
}

/* Fallback for Edge
-------------------------------------------------- */
@supports (-ms-ime-align: auto) {
  .form-label-group>label {
    display: none;
  }

  .form-label-group input::-ms-input-placeholder {
    color: #777;
  }
}

/* Fallback for IE
-------------------------------------------------- */
@media all and (-ms-high-contrast: none),
(-ms-high-contrast: active) {
  .form-label-group>label {
    display: none;
  }

  .form-label-group input:-ms-input-placeholder {
    color: #777;
  }
}

  </style>
