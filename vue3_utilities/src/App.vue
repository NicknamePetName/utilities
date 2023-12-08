<template>
  <div id="app">
    <router-view></router-view>
    <button @click="getData">Get Data</button>
  </div>
</template>
<!-- "type": "module", -->

<script>
import apiClient from '@/services/apiService';

export default {
  methods: {
    async getData() {
      try {
        const response = await apiClient.get('/api/data'); // 根据后端 API 的路径进行调整
        console.log('Data:', response.data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    },
  },
};
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
