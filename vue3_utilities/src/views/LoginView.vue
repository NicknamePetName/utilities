<template>
  <div id="login">
    <div class="background">
      <form action="/login" method="post" class="loginFrom">
        <div class="logindouban">欢迎登录高校水电费管理系统</div>
        <p>请输入登录账户和密码</p>
        <div class="userName">
          <input type="text" placeholder="用户名" name="userName" />
        </div>
        <div class="password">
          <input type="password" placeholder="登录密码" name="password" />
        </div>
        <button type="submit" class="submit-login" @click="isLogin">
          登录
        </button>
        <div class="loginFoot">
          <a href="#" class="a-left" @click="forgetPasswd">忘记密码</a>
          <a href="#" class="a-right" @click="regist">注册账户</a>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import router from "@/router";
export default {
  name: "#login",
  data() {
    return {};
  },
  methods: {
    isLogin: function () {
      router.push("/layout");
    },
    forgetPasswd: function () {
      router.push();
    },
    regist: function () {
      router.push();
    },
  },
  computed: {},
};
</script>

<style lang="scss" scoped>
#login {
  margin-top: -8px;
  margin-left: -8px;

  .background {
    width: 100%;
    height: 100%;
    position: fixed;
    background: url(https://ts1.cn.mm.bing.net/th/id/R-C.d55bf96e27e1de920569cbd716fd8da7?rik=Zo0jp%2fAVuWGqWQ&riu=http%3a%2f%2fi.52desktop.cn%3a81%2fupimg%2fallimg%2f20130312%2f2013312191725765778026.jpg&ehk=Hc%2b3UlVxkd07dUJz5xDAa%2br6WY9WawJbEsMCjUMsllk%3d&risl=&pid=ImgRaw&r=0)
      no-repeat center;
    // background: url(http://10.1.99.100:801/eportal/extern/ZqtpVJ1634618461/Z6eodz1634618493/3195317a808ec8fd8acfe26d39cdb4e9.png) no-repeat center;
    background-size: 100% 100%;
  }

  .loginFrom {
    margin: 150px auto;
    padding: 30px 35px;
    width: 500px;
    border: 2px solid #aaaaaa;

    .logindouban {
      width: 400px;
      height: 62px;
      margin-left: 10px;
      margin-bottom: 23px;
      font-family: "PingFang SC";
      font-size: 30px;
      font-weight: 400;
      color: #000000;
      text-align: left;
    }

    p {
      width: 252px;
      height: 20px;
      margin-left: 10px;
      margin-bottom: 67px;
      font-family: "PingFang SC";
      font-size: 19px;
      font-weight: 400;
      line-height: 20px;
      color: #aaaaaa;
      text-align: left;
    }

    .userName input,
    .password input {
      width: 480px;
      height: 52px;
      margin-left: 10px;
      margin-bottom: 32px;
      padding: 15px 20px;
      border-radius: 4px;
      border: 1.5px solid #aaaaaa;
      box-sizing: border-box;
      font-family: "PingFang SC";
      font-size: 13px;
      font-weight: 400;
      color: #aaaaaa;
      text-align: left;
    }

    .submit-login {
      width: 478px;
      height: 60px;
      margin: 0 1px 32px 10px;
      padding: 9px 191px;
      border-radius: 4px;
      border: solid 1px #3083ff;
      background-color: #3083ff;
      box-shadow: 0 5px 8px 0 #185fff;
      font-family: "PingFang SC";
      font-size: 24px;
      font-weight: 100;
      line-height: 43px;
      color: #ffffff;
      text-align: left;
    }

    .loginFoot {
      .a-left,
      .a-right {
        float: left;
        display: block;
        width: 80px;
        height: 20px;
        font-family: "PingFang SC";
        font-size: 19px;
        font-weight: 400;
        line-height: 20px;
        color: #aaaaaa;
        text-align: left;
        text-decoration: none;
      }

      .a-right {
        float: right;
      }
    }
  }
}
</style>
