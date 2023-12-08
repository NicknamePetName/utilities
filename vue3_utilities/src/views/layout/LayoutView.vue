<template>
  <div id="layout">
    <nav id="navbar">
      <div class="logo">
        <img src="https://github.com/NicknamePetName/Photo/blob/main/source/yixin.jpg?raw=true" alt="亦忻" />
      </div>
      <div class="nav">
        <div class="home" @click="tohome" :class="{ active: isActive1 }">主页</div>
        <div class="student" @click="tostudent" :class="{ active: isActive2 }">学生信息</div>
        <div class="teacher" @click="toteacher" :class="{ active: isActive3 }">教师信息</div>
        <div class="statistics" @click="tostatistics" :class="{ active: isActive4 }">数据统计</div>
        <div class="login" @click="tologin">返回登录页面</div>
      </div>
    </nav>
    <router-view></router-view>
  </div>
  
</template>

<script>
import router from '@/router'
export default {
  name: '#layout',
  data() {
    return {
      isActive1:true,
      isActive2:false,
      isActive3:false,
      isActive4:false,
    }
  },
  methods: {
    tohome: function () {
      this.isActive1 = true;
      this.isActive2 = false;
      this.isActive3 = false;
      this.isActive4 = false;
      router.push('/layout/home');
    },
    tostudent: function () {
      this.isActive2 = true;
      this.isActive1 = false;
      this.isActive3 = false;
      this.isActive4 = false;
      router.push('/layout/student');
    },
    toteacher: function () {
      this.isActive3 = true;
      this.isActive2 = false;
      this.isActive1 = false;
      this.isActive4 = false;
      router.push('/layout/teacher');
    },
    tologin: function () {
      router.push('/');
    },
    tostatistics: function() {
      this.isActive4 = true;
      this.isActive2 = false;
      this.isActive3 = false;
      this.isActive1 = false;
      router.push('/layout/statistics');
    }
  }
}
</script>


<style lang="scss" scoped>
nav {
  background-color: darkturquoise;
  border-right: 2px solid rgba(200, 200, 200, 0.1);
  color: #FFFFFF;
  position: fixed;
  top: 0;
  left: 0;
  width: 200px;
  height: 100%;
  z-index: 100;
  cursor: pointer;

  .logo {
    padding: 30px 0;
    text-align: center;

    img {
      height: 75px;
      width: 75px;
      border-radius: 50%;
    }
  }

  .nav {
    padding: 0;
    list-style-type: none;
    margin: 0;

    div {
      color: #FFFFFF;
      border-bottom: 2px solid rgba(200, 200, 200, 0.7);
      padding: 20px;

      &:first-of-type {
        border-top: 2px solid rgba(200, 200, 200, 1);
      }
    }

  }

}
</style>

<style>
.active {
  background-color:aquamarine;
  color: red !important;
}
</style>