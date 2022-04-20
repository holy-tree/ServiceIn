<template>
  <div>
    <el-steps :active="active" finish-status="success">
      <el-step title="上传xlsx文件" icon="el-icon-edit"></el-step>
      <el-step title="将文件上传至服务器" icon="el-icon-upload"></el-step>
      <el-step title="导出结果" icon="el-icon-success"></el-step>
    </el-steps>
    <el-row>
      <el-col :span="10" align="middle">
        <br /><br />
        <el-button type="text" @click="open">README</el-button>
        <el-upload
          class="upload-demo"
          drag
          :auto-upload="false"
          action=""
          :limit="1"
          accept=".xls, .xlsx"
          :on-change="onChange"
        >
          <i class="el-icon-upload"></i>
          <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
          <div class="el-upload__tip" slot="tip">只能上传xlsx文件</div>
        </el-upload>
        <br />
        <el-button @click="toBackend"> 上传至服务器 </el-button>
      </el-col>
      <el-col :span="2" align="middle">
        <br /><br /><br /><br /><br /><br /><br /><br />
        <i class="el-icon-arrow-right"></i>
        <i class="el-icon-arrow-right"></i>
        <i class="el-icon-arrow-right"></i>
        <i class="el-icon-arrow-right"></i>
        <i class="el-icon-arrow-right"></i>
      </el-col>
      <el-col :span="6" :offset="2" align="middle">
        <br /><br /><br /><br />
        <el-card>
          <el-input
            type="textarea"
            v-loading="loading"
            :autosize="{ minRows: 6, maxRows: 18 }"
            v-model="Answer"
          >
          </el-input>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import xlsx from "xlsx";
import { readFile } from "../util/xlsx";

export default {
  data() {
    return {
      loading: false,
      Answer: "",
      preAnswer: [],
      active: 0,
    };
  },

  methods: {
    open() {
      this.$alert(
        "导入的xlsx文件第一行需为WS_MM~SI_QM等14个属性名，之后每一行均为需要预测的14个因子数据。",
        "导入说明",
        {
          confirmButtonText: "确定",
          callback: (action) => {
            this.$message({
              type: "success",
              message: `消息已读`,
            });
          },
        }
      );
    },
    next() {
      this.active++;
    },
    async onChange(file) {
      let dataBinary = await readFile(file.raw);
      let workBook = xlsx.read(dataBinary, { type: "binary", cellDates: true });
      let workSheet = workBook.Sheets[workBook.SheetNames[0]];
      const data = xlsx.utils.sheet_to_json(workSheet);
      console.log(data);
      this.next();

      this.$axios({
        method: "POST",
        url: "http://localhost:8083/dian",
        data: data,
      })
        .then((result) => {
          console.log(result);
          this.$message.success("成功上传xlsx文件");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    toBackend() {
      this.loading = true;
      this.$axios({
        method: "POST",
        url: "http://localhost:8083/dian/upload",
      })
        .then((result) => {
          this.Answer = "";
          for (let i = 0; i < result.data.length; i++) {
            this.Answer = this.Answer + "\n" + result.data[i].toString();
          }

          console.log(result);

          this.next();
          this.loading = false;
          this.$message.success("预测成功！");
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style>
</style>