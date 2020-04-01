<template>
  <div class="hold-transition login-page">
    <div class="login-box">
      <div class="login-logo">
        <h3><b>游戏管理后台</b></h3>
      </div>
      <!-- /.login-logo -->
      <div class="card">
        <div class="card-body login-card-body">
          <p class="login-box-msg">{{loginBoxMsg}}</p>

          <form @submit.prevent="submit($event)">
            <table style="width: 100%;border-collapse: separate;border-spacing: 0 16px">
              <tr>
                <td colspan="6">
                  <div class="input-group">
                    <!--suppress HtmlFormInputWithoutLabel -->
                    <input type="text" class="form-control" placeholder="用户名">
                    <div class="input-group-append">
                      <div class="input-group-text">
                        <span class="fas fa-user"></span>
                      </div>
                    </div>
                  </div>
                </td>
              </tr>
              <tr>
                <td colspan="6">
                  <div class="input-group">
                    <!--suppress HtmlFormInputWithoutLabel -->
                    <input type="password" class="form-control" placeholder="密码">
                    <div class="input-group-append">
                      <div class="input-group-text">
                        <span class="fas fa-lock"></span>
                      </div>
                    </div>
                  </div>
                </td>
              </tr>
              <tr>
                <td colspan="2" style="width: 40%">
                  <!--suppress HtmlFormInputWithoutLabel -->
                  <input type="text" class="form-control" placeholder="验证码" style="box-shadow: none">
                </td>
                <td colspan="2" style="width: 20%">
                  <!--suppress HtmlUnknownTarget -->
                  <img v-bind:src="captchaUrl" alt="">
                </td>
                <td colspan="2" style="width: 20%;text-align: center;vertical-align: bottom;font-size: smaller">
                  <a href="" style="text-decoration: underline" @click="codeUpdate">刷新</a>
                </td>
              </tr>
              <tr>
                <td colspan="3">
                  <div class="icheck-primary">
                    <input type="checkbox" id="remember">
                    <label for="remember">
                      自动登录
                    </label>
                  </div>
                </td>
                <td colspan="3">
                  <button type="submit" class="btn btn-primary btn-block">登录</button>
                </td>
              </tr>
            </table>
          </form>
        </div>
        <!-- /.login-card-body -->
      </div>
    </div>
  </div>
</template>

<script>
  import '../assets/icheck-bootstrap/icheck-bootstrap.css'
  import captcha from '../assets/img/code.jpg'
  export default {
    name: 'Login',
    data() {
      return {
        loginBoxMsg: "请登录",
        captchaUrl: captcha
        // errTip: '',
        // captchaUrl: captcha
      }
    },
    mounted() {
      // this.$data.captchaUrl = '/captcha';
    },
    methods: {
      codeUpdate: function () {
        this.$data.captchaUrl = '/captcha?' + new Date().getTime();
      },
      submit: function (event) {
        let formData = new FormData(event.target);
        formData.append("Content-Type", "application/x-www-form-urlencoded");
        this.axios.post('/session', formData).then(rsp => {
          console.log(rsp);
          let data = rsp.data;
          if (data.code === 0) {
            this.$router.replace('/index');
          } else if (data.code === 5001) {
            this.$data.errTip = '用户名或密码错误';
          } else if (data.code === 5002) {
            this.$data.errTip = '验证码错误';
          }
        });
      }
    }
  }
</script>
<style scoped>
</style>
