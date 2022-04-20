<template>
  <div id="app">
    <el-container>
      <el-header>
        <el-col :offset="10" :span="12">
          <el-tabs v-model="activeName" @tab-click="changeRouter1()">
            <el-tab-pane label="拟合数据" name="exhibit"></el-tab-pane>
            <el-tab-pane label="预测数据" name="predict"></el-tab-pane>
          </el-tabs>
        </el-col>
      </el-header>
      <el-container>
        <el-aside width="200px"
          ><el-menu
            :default-active="activeName2"
            class="el-menu-vertical-demo"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
          >
            <el-menu-item index="1" @click="changeRouter1()">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>成锭率</span>
              </template>
            </el-menu-item>
            <el-menu-item index="2" @click="changeRouter2()">
              <i class="el-icon-menu"></i>
              <span slot="title">成材率</span>
            </el-menu-item>
            <el-menu-item index="3" @click="changeRouter3()">
              <i class="el-icon-d-caret"></i>
              <span slot="title">综合成材率</span>
            </el-menu-item>
          </el-menu></el-aside
        >
        <el-main>
          <div
            :style="{
              background: '#fff',
              padding: '20px',
              minHeight: '80vh',
              marginTop: '0px',
            }"
          >
            <router-view />
          </div>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "app",
  data() {
    return {
      activeName: "exhibit",
      activeName2: "1",
    };
  },

  methods: {
    changeRouter1() {
      this.$router.push("/" + this.activeName + "/ding");
      this.activeName2 = "1";
    },
    changeRouter2() {
      this.$router.push("/" + this.activeName + "/pi");
      this.activeName2 = "2";
    },
    changeRouter3() {
      this.$router.push("/" + this.activeName + "/both");
      this.activeName2 = "3";
    },
  },
};
</script>

<style scoped>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  position: absolute;
  height: 100%;
  width: 100%;
  top: 0px;
  left: 0px;
}
.el-container {
  height: 100%;
  padding: 0px;
  margin: 0px;
}
.el-header {
  background-color: #f2f6fc;
  color: #333;
  text-align: center;
  line-height: 60px;
}
.el-aside {
  background-color: #545c64;
  color: #333;
  text-align: center;
  line-height: 200px;
}
.el-main {
  background-color: #e9eef3;
  color: #333;
}
</style>
