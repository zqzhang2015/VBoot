<template>
  <div>
    <el-container class="home-container">
      <el-header class="home-header">
        <span class="home_title">VBoot平台</span>
        <div style="display: flex;align-items: center;margin-right: 15px">
          <!-- 跳转到聊天见面的 -->
          <!-- <el-badge style="margin-right: 30px" :is-dot="this.$store.state.nfDot">
                        <i class="fa fa-bell-o" @click="goChat" style="cursor: pointer"></i>
                    </el-badge> -->
          <el-dropdown @command="handleCommand">
            <span class="el-dropdown-link home_userinfo" style="display: flex;align-items: center">
              {{user.name}}
              <!-- 头像 -->
              <i><img src="http://p8c6dz1tq.bkt.clouddn.com/blogcomment128x128.png" style="width: 40px;height: 40px;margin-right: 5px;margin-left: 5px;border-radius: 40px" /></i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>个人中心</el-dropdown-item>
              <el-dropdown-item>设置</el-dropdown-item>
              <el-dropdown-item command="logout" divided>注销</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </el-header>
      <el-container>
        <el-aside width="180px" class="home-aside">
          <div style="display: flex;justify-content: flex-start;width: 180px;text-align: left;">
            <el-menu style="background: #ececec;width: 200px;" unique-opened router>
              <template v-for="(item,index) in menus" v-if="!item.hidden">
                <div v-if="item.children.length>1">
                  <el-submenu :key="index" :index="index+''">
                    <template slot="title">
                      <i :class="item.iconCls"></i>
                      <span slot="title">{{item.name}}</span>
                    </template>
                    <!-- 判断是否有三级菜单 -->
                    <template v-for="(child,index2) in item.children">
                      <!-- 有三级菜单 -->
                      <div v-if="child.children.length>1">
                        <el-submenu :key="index2+'2'" :index="index2+'2'">
                          <template slot="title">
                            <i :class="child.iconCls"></i>
                            <span slot="title">{{child.name}}</span>
                          </template>
                          <el-menu-item v-for="child2 in child.children" :index="child2.path" :key="child2.path">{{child2.name}}
                          </el-menu-item>
                        </el-submenu>
                      </div>
                      <div v-else>
                        <!-- 没有三级菜单时 -->
                        <el-menu-item v-if="index2" :index="child.path" router="child.path">{{child.name}}
                        </el-menu-item>
                      </div>
                    </template>
                  </el-submenu>
                </div>
                <div v-else>
                  <el-menu-item :index="item.path">
                    <template slot="title">
                      <i :class="item.iconCls"></i>
                      <span slot="title">{{item.name}}</span>
                    </template>
                  </el-menu-item>
                </div>
              </template>
            </el-menu>
          </div>
        </el-aside>
        <el-container>
          <el-main>
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
              <el-breadcrumb-item v-text="this.$router.currentRoute.name"></el-breadcrumb-item>
            </el-breadcrumb>
            <!-- <keep-alive>
                            <router-view v-if="this.$route.meta.keepAlive"></router-view>
                        </keep-alive> -->
            <router-view></router-view>
          </el-main>
        </el-container>
      </el-container>
    </el-container>

  </div>
</template>
<script>
export default {
  data() {
    return {
      isDot: false
    };
  },
  computed: {
    user() {
      return this.$store.state.user;
    },
    menus() {
      return this.$store.state.routes;
    }
  },
  mounted() {},
  methods: {
    //待修改
    handleCommand(cmd) {
      var _this = this;
      if (cmd == "logout") {
        this.$confirm("您确认注销登录, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        })
          .then(() => {
            _this
              .getRequest("/logout")
              .then(res => {
                _this.$store.commit("logout");
                _this.$router.replace({ path: "/" });
              })
              .catch(error => {
                this.$message.error(error);
              });
          })
          .catch(() => {
            _this.$message({
              type: "info",
              message: "取消"
            });
          });
      }
    }
  }

  //   computed: {
  //     user() {
  //       return this.$store.state.user;
  //     },
  //     routes() {
  //       return this.$store.state.routes;
  //     }
  //   }
};
</script>
<style>
.home-container {
  height: 100%;
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
}

.home-header {
  background-color: #20a0ff;
  color: #333;
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: space-between;
  box-sizing: content-box;
  padding: 0px;
}

.home-aside {
  background-color: #ececec;
}

.home-main {
  background-color: #fff;
  color: #000;
  text-align: center;
  margin: 0px;
  padding: 0px;
}

.home_title {
  color: #fff;
  font-size: 22px;
  display: inline;
  margin-left: 8px;
}

.home_userinfo {
  color: #fff;
  cursor: pointer;
}

.home_userinfoContainer {
  display: inline;
  margin-right: 20px;
}

.el-submenu .el-menu-item {
  width: 180px;
  min-width: 175px;
}
</style>