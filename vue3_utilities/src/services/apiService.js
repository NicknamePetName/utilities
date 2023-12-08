// src/services/apiService.js

import axios from 'axios';

const apiClient = axios.create({
  baseURL: 'http://localhost:8080', // 后端 API 地址
  // 可以添加其他 Axios 配置项
});

export default apiClient;
