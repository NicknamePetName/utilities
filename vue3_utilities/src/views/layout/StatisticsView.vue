<template>
  <div id="statistics">
    <body>
      <div class="head clearfix">
        <h1 class="pulll_left">数据分析</h1>
        <div class="menu menu2 pulll_left">
          <ul>
            <li><a href="#">首页</a></li>
            <li><a href="#">数据统计</a></li>
            <li><a href="#">数据分析</a></li>
            <li><a href="#">实时信息</a></li>
            <li><a href="#">实时汇报</a></li>
            <li><a href="#">历史数据</a></li>
          </ul>
        </div>
        <div class="time" id="showTime" style="color: #67cfe3">
          {{ formattedTime }}
        </div>
      </div>

      <div class="mainbox">
        <ul class="clearfix nav1">
          <li style="width: 20%">
            <div class="box" style="height: 570px">
              <div class="tit">区域概览</div>
            </div>
          </li>
          <li style="width: 60%">
            <div class="box" style="height: 570px">
              <div class="tit">实时数据</div>
              <div id="container" style="height: 100%;margin-top: -20px;"></div>
            </div>
          </li>
          <li style="width: 20%">
            <div class="box" style="height: 570px">
              <div class="tit">数据分析</div>
            </div>
          </li>
        </ul>

        <div class="box" style="height: auto">
          <div class="tit">亦忻</div>
        </div>
      </div>
    </body>
  </div>
</template>

<!-- <script>
export default {
  name: 'statistics',
  methods: {
    
  }
}
</script> -->
<script>
import * as echarts from "echarts";
export default {
  data() {
    return {
      formattedTime: "", // 用于存储格式化后的时间字符串
      timer: null, // 定时器对象
      myChart: null,
      chartData: [
        [1, 2, 3, 4, 3, 5, 1],
        [2, 4, 6, 1, 3, 2, 1],
        [1, 2, 3, 4, 1, 2, 5],
      ],
    };
  },
  mounted() {
    // 在组件挂载后开始更新时间
    this.startTimer();
    this.initChart();
    window.addEventListener("resize", this.resizeChart);
  },
  beforeDestroy() {
    // 在组件销毁前清除定时器，防止内存泄漏
    this.stopTimer();
    window.removeEventListener("resize", this.resizeChart);
  },
  methods: {
    updateTime() {
      const dt = new Date();
      const y = dt.getFullYear();
      const mt = dt.getMonth() + 1;
      const day = dt.getDate();
      const h = dt.getHours();
      const m = dt.getMinutes();
      const s = dt.getSeconds();

      this.formattedTime = `${y}年${mt}月${day}日 ${h}:${m}:${s}`;
    },
    startTimer() {
      // 开始定时器
      this.updateTime();
      this.timer = setInterval(this.updateTime, 1000);
    },
    stopTimer() {
      // 停止定时器
      clearInterval(this.timer);
    },
    initChart() {
      this.myChart = echarts.init(document.getElementById("container"), null, {
        renderer: "canvas",
        useDirtyRect: false,
      });
      this.setChartOption();
    },
    setChartOption() {
      const option = {
        angleAxis: {
          type: "category",
          data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
        },
        radiusAxis: {},
        polar: {},
        series: [
          {
            type: "bar",
            data: this.chartData[0],
            coordinateSystem: "polar",
            // name: 'A',
            stack: "a",
            emphasis: {
              focus: "series",
            },
          },
          {
            type: "bar",
            data: this.chartData[1],
            coordinateSystem: "polar",
            // name: 'B',
            stack: "a",
            emphasis: {
              focus: "series",
            },
          },
          {
            type: "bar",
            data: this.chartData[2],
            coordinateSystem: "polar",
            // name: 'C',
            stack: "a",
            emphasis: {
              focus: "series",
            },
          },
        ],
        legend: {
          show: true,
          data: ["A", "B", "C"],
        },
      };
      if (option && typeof option === "object") {
        this.myChart.setOption(option);
      }
    },
    resizeChart() {
      if (this.myChart) {
        this.myChart.resize();
      }
    },
  },
};
</script>

<style lang="scss" scoped>
#statistics {
  width: 1200px;
  position: fixed;
  left: 360px;
  top: 40px;
  color: #fff;
  font-size: 16px;
  background: #033c76 url(../images/beijing.png) no-repeat center;
  background-size: 100% 100%;
  /* CSS Document */
  * {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
  }

  *,
  body {
    padding: 0px;
    margin: 0px;
    font-family: "微软雅黑";
  }

  html,
  body {
    min-height: 100%;
  }

  li {
    list-style-type: none;
  }

  i {
    margin: 0px;
    padding: 0px;
    text-indent: 0px;
  }

  img {
    border: none;
    max-width: 100%;
  }

  a {
    text-decoration: none;
    color: #fff;
  }

  a.active,
  a:focus {
    outline: none !important;
    text-decoration: none;
  }

  ol,
  ul,
  p,
  h1,
  h2,
  h3,
  h4,
  h5,
  h6 {
    padding: 0;
    margin: 0;
  }

  a:hover {
    color: #06c;
    text-decoration: none !important;
  }

  .clearfix:after,
  .clearfix:before {
    display: table;
    content: " ";
  }

  .clearfix:after {
    clear: both;
  }

  .pulll_left {
    float: left;
  }

  .pulll_right {
    float: right;
  }

  i {
    font-style: normal;
  }

  .text-w {
    color: #ffe400;
  }

  .text-d {
    color: #ff6316;
  }

  .text-s {
    color: #14e144;
  }

  .text-b {
    color: #07e5ff;
  }

  .head {
    position: relative;
    height: 90px;
    margin: 0 15px;
    padding-right: 60px;
  }

  .head h1 {
    font-size: 30px;
    letter-spacing: -2px;
    text-align: center;
    line-height: 90px;
    padding-right: 55px;
    color: #daf9ff;
  }

  .head .menu ul {
    font-size: 0;
  }

  .head .menu li {
    display: inline-block;
    position: relative;
    margin: 30px 15px;
  }

  .head .menu li a {
    display: block;
    font-size: 18px;
    color: #fff;
    line-height: 30px;
    padding: 0 10px;
  }

  .head .time {
    position: absolute;
    right: 40px;
    line-height: 90px;
    top: -20px;
  }

  .menu li:before,
  .menu li:after {
    position: absolute;
    width: 10px;
    height: 5px;
    opacity: 0.4;
    content: "";
    border-top: 2px solid #02a6b5;
    top: -1px;
    border-radius: 2px;
  }

  .menu li:before,
  .menu li a:before {
    border-left: 2px solid #02a6b5;
    left: -1px;
  }

  .menu li:after,
  .menu li a:after {
    border-right: 2px solid #02a6b5;
    right: -1px;
  }

  .menu li a {
    position: relative;
  }

  .menu li a:before,
  .menu li a:after {
    position: absolute;
    width: 10px;
    height: 5px;
    opacity: 0.4;
    content: "";
    border-bottom: 2px solid #02a6b5;
    bottom: -1px;
    border-radius: 2px;
  }

  .head .menu li a:hover {
    color: #f4e925;
  }

  .menu li a:hover:before,
  .menu li a:hover:after,
  .menu li:hover:before,
  .menu li:hover:after {
    border-color: #f4e925;
    opacity: 1;
  }

  .mainbox {
    padding: 0px 10px;
  }

  .nav1 {
    margin-left: -6px;
    margin-right: -6px;
  }

  .nav1 > li {
    padding: 0 6px;
    float: left;
  }

  .box {
    border: 1px solid rgba(7, 118, 181, 0.5);
    box-shadow: inset 0 0 10px rgba(7, 118, 181, 0.4);
    margin-bottom: 12px;
    position: relative;
  }

  .tit {
    padding: 10px 10px 10px 25px;
    border-bottom: 1px solid rgba(7, 118, 181, 0.7);
    font-size: 16px;
    font-weight: 500;
    position: relative;
  }

  .tit:before,
  .tit01:before {
    position: absolute;
    content: "";
    width: 6px;
    height: 6px;
    background: rgba(22, 214, 255, 0.9);
    box-shadow: 0 0 5px rgba(22, 214, 255, 0.9);
    border-radius: 10px;
    left: 10px;
    top: 18px;
  }

  .tit:after,
  .box:before {
    width: 100%;
    height: 1px;
    content: "";
    position: absolute;
    left: 0;
    bottom: -1px;
    background: linear-gradient(to right, #076ead, #4ba6e0, #076ead);
    box-shadow: 0 0 5px rgba(131, 189, 227, 1);
    opacity: 0.6;
  }

  .box:before {
    top: -1px;
  }

  .boxnav {
    padding: 10px;
  }

  .tit01 {
    font-size: 16px;
    font-weight: 500;
    position: relative;
    padding-left: 15px;
  }

  .tit01:before {
    left: 3px;
    top: 8px;
  }

  .mapc {
    background: url(../images/bg3.png) no-repeat center center;
    background-size: 100% 100%;
  }

  .map {
    position: relative;
    height: 100%;
  }
  .mapnav {
    position: absolute;
    z-index: 10;
  }

  .yqlist li {
    float: left;
    width: 50%;
    padding: 10px 0;
    text-align: center;
  }

  .yq {
    width: 100px;
    height: 100px;
    margin: 0 auto 5px auto;
    position: relative;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 30px;
    font-family: electronicFont;
    color: #fff32b;
  }

  .yqlist li span {
    opacity: 0.6;
    font-size: 14px;
  }

  .yq:before {
    position: absolute;
    width: 100%;
    height: 100%;
    content: "";
    background: url(../images/img1.png) center center;
    border-radius: 100px;
    background-size: 100% 100%;
    opacity: 0.3;
    left: 0;
    top: 0;
    animation: myfirst2 15s infinite linear;
  }

  .yq:after {
    position: absolute;
    width: 86%;
    background: url(../images/img2.png) center center;
    border-radius: 100px;
    background-size: 100% 100%;
    opacity: 0.3;
    height: 86%;
    content: "";
    left: 7%;
    top: 7%;
    animation: myfirst 15s infinite linear;
  }

  @keyframes myfirst {
    to {
      transform: rotate(-360deg);
    }
  }

  @keyframes myfirst2 {
    to {
      transform: rotate(360deg);
    }
  }

  /* 外部容器样式 */
  .overflow-container {
    width: 300px; /* 定义容器宽度 */
    height: 200px; /* 定义容器高度 */
    overflow: auto; /* 启用滚动条 */
    border: 1px solid #ccc; /* 边框 */
    border-radius: 10px; /* 圆角边框 */
    background: linear-gradient(to bottom, #f0f0f0, #e0e0e0); /* 渐变背景 */
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* 阴影效果 */
    padding: 20px; /* 内边距 */
  }

  /* 内部内容样式 */
  .content {
    border-radius: 10px; /* 圆角边框 */
    padding: 10px; /* 内边距 */
  }

  /* 模拟内容 */
  .content p {
    margin: 0 0 10px 0; /* 段落间距 */
  }

  /* 自定义滚动条轨道 */
  .content::-webkit-scrollbar {
    width: 8px; /* 设置滚动条宽度 */
    height: 11px;
  }

  /* 自定义滚动条滑块 */
  .content::-webkit-scrollbar-thumb {
    background-color: #007fde; /* 滑块背景颜色 */
    border-radius: 4px; /* 滑块圆角 */
  }

  .titspan {
    color: #02a6b5;
    font-size: 20px;
    white-space: nowrap;
    padding-right: 35px;
  }

  .contentSpan {
    padding-top: 5px;
    max-width: 200px;
    font-size: 15px;
    word-wrap: break-word;
    padding-right: 35px;
    font-family: 宋体;
  }

  /* 表格数据样式 */
  .gongdan-item-active {
    border-radius: 1px;
    background-color: #01b7ff;
    font-size: 15px;
    white-space: nowrap;
    color: #dbdbdb;
    padding-left: 10px;
    padding-right: 35px;
  }
  .gongdan-item {
    border-radius: 1px;
    padding-top: 5px;
    max-width: 200px;
    /* width: .30303rem; */
    word-wrap: break-word;
    height: 0.151515rem;
    padding-right: 35px;
    font-family: 微软雅黑;
    background-color: rgba(255, 255, 255, 0.2);
    font-size: 0.090909rem;
    color: white;
    margin-right: 0.010101rem;
    padding-left: 10px;
  }
}
</style>