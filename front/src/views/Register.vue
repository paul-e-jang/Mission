<template>
  <section class="login">
  <form class="form-signin" @submit.prevent="submitForm">
    <div class="text-center mb-4">
      <span class="h3 mb-3 text-white">SmartJack 계정 등록</span>
      <!--
      <p>Build form controls with floating labels via the <code>:placeholder-shown</code> pseudo-element. <a
          href="https://caniuse.com/#feat=css-placeholder-shown">Works in latest Chrome, Safari, and Firefox.</a></p>-->
    </div>

    <div v-show="errorMessage" class="alert alert-danger failed">{{ errorMessage }}</div>

    <div class="form-label-group">
      <input type="text" v-model="form.memberCode" id="user-code" class="form-control" placeholder="아이디" autofocus>
      <label for="Id">아이디(최소 2글자, 최대 20글자)</label>
         <div class="field-error" v-if="$v.form.memberCode.$dirty">
          <div class="denied" v-if="!$v.form.memberCode.required">아이디를 입력하세요</div>
          </div>
    </div>
    <div class="form-label-group">
      <input type="text" v-model="form.emailAddress" id="email-address" class="form-control" placeholder="이메일" >
      <label for="Id">이메일</label>
         <div class="field-error" v-if="$v.form.emailAddress.$dirty">
          <div class="denied" v-if="!$v.form.emailAddress.required">이메일을 입력하세요.</div>
          </div>
    </div>
    <div class="form-label-group">
      <input type="text" v-model="form.name" class="form-control" placeholder="이름" >
      <label for="Id">이름</label>
         <div class="field-error" v-if="$v.form.name.$dirty">
          <div class="denied" v-if="!$v.form.name.required">이름을 입력하세요.</div>
          </div>
    </div>
    <div class="form-label-group">
      <input type="password" v-model="form.password" id="password" class="form-control" placeholder="비밀번호" >
      <label for="Pass">비밀번호 입력(최소 10글자, 최대 20글자 )</label>
          <div class="field-error" v-if="$v.form.password.$dirty">
          <div class="denied" v-if="!$v.form.password.required">비밀번호를 입력하세요.</div>
          </div>
    </div>
    <div class="form-label-group">
      <input type="password" v-model="form.password2" id="password2" class="form-control" placeholder="비밀번호2" >
      <label for="Pass">비밀번호 확인</label>
          <div class="field-error" v-if="$v.form.password2.$dirty">
          <div class="denied" v-if="!$v.form.password2.required">비밀번호를 한번 더 입력하세요.</div>
          </div>
    </div>
    <button class="btn-lg btn-warning btn-block mb-3 mt-3 login_btn" type="submit">계정 등록</button>
    <ul class="nav justify-content-center">
    </ul>
    <p class="mt-5 mb-3 text-muted text-center">&copy; 2020 <a href="http://github.com/bashpound">Github.com/bashpound/mission</a>
    </p>
  </form>
  </section>
</template>

<script>
import { required } from 'vuelidate/lib/validators'
import registrationService from '@/services/registration'

export default {
  name: 'LoginPage',
  data: function () {
    return {
      form: {
        memberCode: '',
        emailAddress: '',
        name: '',
        password: '',
        password2: ''
      },
      errorMessage: ''
    }
  },
  validations: {
    form: {
      memberCode: {
        required
      },
      password: {
        required
      },
      name: {
        required
      },
      emailAddress: {
        required
      },
      password2: {
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

      registrationService.register(this.form).then(() => {
        alert('성공적으로 등록되었습니다.')
        this.$router.push('/login')
      }).catch((error) => {
        this.errorMessage = '유저 등록에 실패했습니다. 이유: ' + error.message
      })
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
