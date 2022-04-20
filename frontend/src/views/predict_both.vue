<template>
  <div>
    <el-row>
      <el-col :span="6" :offset="2" align="middle">
        <br /><br /><br /><br />
        <el-card>
          <el-button type="goon" @click="changeRouter1"> 预测成锭率 </el-button>
        </el-card>
      </el-col>

      <el-col :span="6" :offset="4" align="middle">
        <br /><br /><br /><br />
        <el-card>
          <el-button type="goon" @click="changeRouter2"> 预测成材率 </el-button>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },

  methods: {
    changeRouter1() {
        this.$router.push("/predict/ding");
    },
    changeRouter2() {
        this.$router.push("/predict/pi");
    },
  },
};
</script>
    
<style scoped>
.el-button--goon {
  color: rgb(0, 0, 0);
  background-color: #ffffff;
  border-color: #ffffff;
  height: 200px;
  width: 250px;
  padding: 20px;
}
</style>