<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="专业门类" prop="Category">
        <el-input
          v-model="queryParams.Category"
          placeholder="请输入专业门类"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="专业类" prop="Professional">
        <el-input
          v-model="queryParams.Professional"
          placeholder="请输入专业类"
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
      <el-form-item label="满意度" prop="zymyd">
        <el-input
          v-model="queryParams.zymyd"
          placeholder="请输入满意度"
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
          v-hasPermi="['major:major:add']"
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
          v-hasPermi="['major:major:edit']"
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
          v-hasPermi="['major:major:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['major:major:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="majorList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="专业层次" align="center" prop="type" />
      <el-table-column label="专业门类ID" align="center" prop="categoryID" />
      <el-table-column label="专业门类" align="center" prop="category" />
      <el-table-column label="专业类ID" align="center" prop="professionalID" />
      <el-table-column label="专业类" align="center" prop="professional" />
      <el-table-column label="专业代码" align="center" prop="zydm" />
      <el-table-column label="专业名称" align="center" prop="zymc" />
      <el-table-column label="定位ID" align="center" prop="specId" />
      <el-table-column label="满意度" align="center" prop="zymyd" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['major:major:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['major:major:remove']"
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

    <!-- 添加或修改专业列表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="专业门类" prop="Category">
          <el-input v-model="form.Category" placeholder="请输入专业门类" />
        </el-form-item>
        <el-form-item label="专业类" prop="Professional">
          <el-input v-model="form.Professional" placeholder="请输入专业类" />
        </el-form-item>
        <el-form-item label="专业名称" prop="zymc">
          <el-input v-model="form.zymc" placeholder="请输入专业名称" />
        </el-form-item>
        <el-form-item label="满意度" prop="zymyd">
          <el-input v-model="form.zymyd" placeholder="请输入满意度" />
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
import { listMajor, getMajor, delMajor, addMajor, updateMajor } from "@/api/major/major";

export default {
  name: "Major",
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
      // 专业列表表格数据
      majorList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        Type: null,
        Category: null,
        Professional: null,
        zymc: null,
        zymyd: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {

      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询专业列表列表 */
    getList() {
      this.loading = true;
      listMajor(this.queryParams).then(response => {
        this.majorList = response.rows;
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
        Type: null,
        CategoryID: null,
        Category: null,
        ProfessionalID: null,
        Professional: null,
        zydm: null,
        zymc: null,
        specId: null,
        zymyd: null
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
      this.ids = selection.map(item => item.CategoryID)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加专业列表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const CategoryID = row.CategoryID || this.ids
      getMajor(CategoryID).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改专业列表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.CategoryID != null) {
            updateMajor(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMajor(this.form).then(response => {
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
      const CategoryIDs = row.CategoryID || this.ids;
      this.$modal.confirm('是否确认删除专业列表编号为"' + CategoryIDs + '"的数据项？').then(function() {
        return delMajor(CategoryIDs);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('major/major/export', {
        ...this.queryParams
      }, `major_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
