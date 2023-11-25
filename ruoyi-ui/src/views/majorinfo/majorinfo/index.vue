<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="定位ID" prop="specId">
        <el-input
          v-model="queryParams.specId"
          placeholder="请输入定位ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="专业名称" prop="zymc">
        <el-input
          v-model="queryParams.zymc"
          placeholder="请输入专业名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属专业类" prop="xk">
        <el-input
          v-model="queryParams.xk"
          placeholder="请输入所属专业类"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属层次" prop="xlcc">
        <el-input
          v-model="queryParams.xlcc"
          placeholder="请输入所属层次"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="毕业生规模" prop="xsgm">
        <el-input
          v-model="queryParams.xsgm"
          placeholder="请输入毕业生规模"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="男女比例" prop="boyGirlpercent">
        <el-input
          v-model="queryParams.boyGirlpercent"
          placeholder="请输入男女比例"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['majorinfo:majorinfo:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['majorinfo:majorinfo:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['majorinfo:majorinfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['majorinfo:majorinfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="majorinfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="专业代码" align="center" prop="zydm" />
      <el-table-column label="定位ID" align="center" prop="specId" />
      <el-table-column label="专业名称" align="center" prop="zymc" />
      <el-table-column label="所属专业类" align="center" prop="xk" />
      <el-table-column label="所属层次" align="center" prop="xlcc" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['majorinfo:majorinfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['majorinfo:majorinfo:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改专业详情对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="定位ID" prop="specId">
          <el-input v-model="form.specId" placeholder="请输入定位ID" />
        </el-form-item>
        <el-form-item label="专业名称" prop="zymc">
          <el-input v-model="form.zymc" placeholder="请输入专业名称" />
        </el-form-item>
        <el-form-item label="所属专业类" prop="xk">
          <el-input v-model="form.xk" placeholder="请输入所属专业类" />
        </el-form-item>
        <el-form-item label="所属层次" prop="xlcc">
          <el-input v-model="form.xlcc" placeholder="请输入所属层次" />
        </el-form-item>
        <el-form-item label="专业介绍" prop="zyjs">
          <el-input v-model="form.zyjs" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="毕业生规模" prop="xsgm">
          <el-input v-model="form.xsgm" placeholder="请输入毕业生规模" />
        </el-form-item>
        <el-form-item label="男女比例" prop="boyGirlpercent">
          <el-input v-model="form.boyGirlpercent" placeholder="请输入男女比例" />
        </el-form-item>
        <el-form-item label="专业满意度" prop="zymyd">
          <el-input v-model="form.zymyd" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="推荐高校" prop="zytjzsList">
          <el-input v-model="form.zytjzsList" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="相似专业" prop="simileZyList">
          <el-input v-model="form.simileZyList" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="考研方向" prop="kyfx">
          <el-input v-model="form.kyfx" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="就业方向" prop="jyfx">
          <el-input v-model="form.jyfx" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="毕业生平均月薪" prop="xcspList">
          <el-input v-model="form.xcspList" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listMajorinfo, getMajorinfo, delMajorinfo, addMajorinfo, updateMajorinfo } from "@/api/majorinfo/majorinfo";

export default {
  name: "Majorinfo",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 专业详情表格数据
      majorinfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        specId: null,
        zymc: null,
        xk: null,
        xlcc: null,
        zyjs: null,
        xsgm: null,
        boyGirlpercent: null,
        zymyd: null,
        zytjzsList: null,
        simileZyList: null,
        kyfx: null,
        jyfx: null,
        xcspList: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        specId: [
          { required: true, message: "定位ID不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询专业详情列表 */
    getList() {
      this.loading = true;
      listMajorinfo(this.queryParams).then(response => {
        this.majorinfoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        zydm: null,
        specId: null,
        zymc: null,
        xk: null,
        xlcc: null,
        zyjs: null,
        xsgm: null,
        boyGirlpercent: null,
        zymyd: null,
        zytjzsList: null,
        simileZyList: null,
        kyfx: null,
        jyfx: null,
        xcspList: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.zydm)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加专业详情";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const zydm = row.zydm || this.ids
      getMajorinfo(zydm).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改专业详情";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.zydm != null) {
            updateMajorinfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMajorinfo(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const zydms = row.zydm || this.ids;
      this.$modal.confirm('是否确认删除专业详情编号为"' + zydms + '"的数据项？').then(function() {
        return delMajorinfo(zydms);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('majorinfo/majorinfo/export', {
        ...this.queryParams
      }, `majorinfo_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
