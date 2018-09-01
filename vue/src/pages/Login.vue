<template>
  <div>
    <el-form :rules="rules" :model="loginForm" ref="loginForm" class="login-container" label-position="left" label-width="0px" v-loading="loading">
      <h3 class="login_title">Vboot系统登录</h3>
      <el-form-item prop="name">
        <el-input v-model="loginForm.name" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item prop="pass">
        <el-input type="password" v-model="loginForm.pass" placeholder="密码"></el-input>
      </el-form-item>
      <el-checkbox class="login_remember" v-model="checked" label-position="left">记住密码</el-checkbox>
      <el-form-item>
        <el-button type="primary" @click="submitClick('loginForm')">登录</el-button>
        <el-button @click="resetForm('loginForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      rules: {
        name: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 5, max: 8, message: "长度在 5 到 8 个字符", trigger: "blur" }
        ],
        pass: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 6, max: 16, message: "长度在 6 到 16 个字符", trigger: "blur" }
        ]
      },
      checked: true,
      loginForm: {
        name: "admin",
        pass: "123456"
      },
      loading: false
    };
  },
  methods: {
    submitClick: function(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          //验证通过
          var _this = this;
          this.loading = true;
          this.postRequest("/login", {
            username: this.loginForm.name,
            password: this.loginForm.pass
          })
            .then(resp => {
              let data = resp.data;
              if (data.status === 200) {
                this.loading = false;
                _this.$store.commit("login", data.data);
                const path = this.$route.query.redirect;
                this.$router.replace({
                  path: path == "/" || path == undefined ? "/home" : path
                });
              } else {
                this.$message.error("认证失败！");
                this.loading = false;
                return false;
              }

              // _this.loading = false;
              // if (resp && resp.status == 200) {
              //   var data = resp.data;
              //   _this.$store.commit('login', data.msg);
              //   var path = _this.$route.query.redirect;
              //   _this.$router.replace({path: path == '/' || path == undefined ? '/home' : path});
              // }
            })
            .catch(error => {
              this.$message.error(error);
            });
        } else {
          //验证失败
          this.$message.error("请填全登录信息！");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
};
</script>
<style>
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 180px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}

.login_remember {
  margin: 0px 0px 35px 0px;
  text-align: left;
}
</style>
