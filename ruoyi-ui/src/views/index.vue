<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="24">
        <hr />
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h2>志愿智能后台管理框架</h2>
        <p>
          高考志愿，关键一招，选择我们，成功从此起！
          志愿填报，不是随意，是精心策划的开始！
          高考志愿填报，成就梦想，选择最佳
          选择明智，走向成功！志愿填报，选择我们！
          高考志愿，量身定制，打造个性化人生地图！
          百万职业选择，一站解决，志愿填报专家！
          高考志愿，精准匹配，梦想成真！
          志愿填报，决定人生，智选第一站！
          开启未来之旅，选对志愿关键一步        </p>
        <p>
<!--          <b>当前版本:</b> <span>v{{ version }}</span>-->
        </p>
<!--        <p>-->
<!--          <el-tag type="danger">&yen;免费开源</el-tag>-->
<!--        </p>-->
        <p>
<!--          <el-button-->
<!--            type="primary"-->
<!--            size="mini"-->
<!--            icon="el-icon-cloudy"-->
<!--            plain-->
<!--            @click="goTarget('https://gitee.com/y_project/RuoYi-Vue')"-->
<!--            >访问码云</el-button-->
<!--          >-->
<!--          <el-button-->
<!--            size="mini"-->
<!--            icon="el-icon-s-home"-->
<!--            plain-->
<!--            @click="goTarget('http://ruoyi.vip')"-->
<!--            >访问主页</el-button-->
<!--          >-->
        </p>
      </el-col>

<!--      <el-col :sm="24" :lg="12" style="padding-left: 50px">-->
<!--        <el-row>-->
<!--          <el-col :span="12">-->
<!--            <h2>技术选型</h2>-->
<!--          </el-col>-->
<!--        </el-row>-->
<!--        <el-row>-->
<!--          <el-col :span="6">-->
<!--            <h4>后端技术</h4>-->
<!--            <ul>-->
<!--              <li>SpringBoot</li>-->
<!--              <li>Spring Security</li>-->
<!--              <li>JWT</li>-->
<!--              <li>MyBatis</li>-->
<!--              <li>Druid</li>-->
<!--              <li>Fastjson</li>-->
<!--              <li>...</li>-->
<!--            </ul>-->
<!--          </el-col>-->
<!--          <el-col :span="6">-->
<!--            <h4>前端技术</h4>-->
<!--            <ul>-->
<!--              <li>Vue</li>-->
<!--              <li>Vuex</li>-->
<!--              <li>Element-ui</li>-->
<!--              <li>Axios</li>-->
<!--              <li>Sass</li>-->
<!--              <li>Quill</li>-->
<!--              <li>...</li>-->
<!--            </ul>-->
<!--          </el-col>-->
<!--        </el-row>-->
<!--      </el-col>-->
    </el-row>
    <el-divider />
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>联系信息</span>
          </div>
          <div class="body">
            <p>
              <i class="el-icon-s-promotion"></i> 官网：<el-link
                href="https://intellichoice.pkcsublog.top"
                target="_blank"
                >https://intellichoice.pkcsublog.top/</el-link
              >
            </p>
            <p>
              <i class="el-icon-chat-dot-round"></i> 作者：志愿智能

            </p>
          </div>
        </el-card>
      </el-col>

    </el-row>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.6"
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    }
  }
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

