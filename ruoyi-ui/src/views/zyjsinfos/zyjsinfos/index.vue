<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="院校代码" prop="yxdm">
        <el-input
          v-model="queryParams.yxdm"
          placeholder="请输入院校代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="院校ID" prop="schID">
        <el-input
          v-model="queryParams.schID"
          placeholder="请输入院校ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="院校层次" prop="yxcc">
        <el-input
          v-model="queryParams.yxcc"
          placeholder="请输入院校层次"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="专业名称" prop="zy">
        <el-input
          v-model="queryParams.zy"
          placeholder="请输入专业名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否包含专业介绍" prop="hasInfo">
        <el-input
          v-model="queryParams.hasInfo"
          placeholder="请输入是否包含专业介绍"
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
          v-hasPermi="['zyjsinfos:zyjsinfos:add']"
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
          v-hasPermi="['zyjsinfos:zyjsinfos:edit']"
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
          v-hasPermi="['zyjsinfos:zyjsinfos:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['zyjsinfos:zyjsinfos:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="zyjsinfosList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="院校代码" align="center" prop="yxdm" />
      <el-table-column label="dicCurId" align="center" prop="dicCurId" />
      <el-table-column label="定位ID" align="center" prop="specId" />
      <el-table-column label="院校ID" align="center" prop="schID" />
      <el-table-column label="专业ID" align="center" prop="categoryId" />
      <el-table-column label="院校层次" align="center" prop="yxcc" />
      <el-table-column label="专业类别" align="center" prop="type" />
      <el-table-column label="专业名称" align="center" prop="zy" />
      <el-table-column label="是否包含专业介绍" align="center" prop="hasInfo" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['zyjsinfos:zyjsinfos:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['zyjsinfos:zyjsinfos:remove']"
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

    <!-- 添加或修改院校专业介绍对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="院校代码" prop="yxdm">
          <el-input v-model="form.yxdm" placeholder="请输入院校代码" />
        </el-form-item>
        <el-form-item label="院校ID" prop="schID">
          <el-input v-model="form.schID" placeholder="请输入院校ID" />
        </el-form-item>
        <el-form-item label="院校层次" prop="yxcc">
          <el-input v-model="form.yxcc" placeholder="请输入院校层次" />
        </el-form-item>
        <el-form-item label="专业名称" prop="zy">
          <el-input v-model="form.zy" placeholder="请输入专业名称" />
        </el-form-item>
        <el-form-item label="是否包含专业介绍" prop="hasInfo">
          <el-input v-model="form.hasInfo" placeholder="请输入是否包含专业介绍" />
        </el-form-item>
        <el-form-item label="专业介绍" prop="zyjs">
          <el-input v-model="form.zyjs" type="textarea" placeholder="请输入内容" />
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
import { listZyjsinfos, getZyjsinfos, delZyjsinfos, addZyjsinfos, updateZyjsinfos } from "@/api/zyjsinfos/zyjsinfos";

export default {
  name: "Zyjsinfos",
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
      // 院校专业介绍表格数据
      zyjsinfosList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        yxdm: null,
        schID: null,
        yxcc: null,
        type: null,
        zy: null,
        hasInfo: null,
        zyjs: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        yxdm: [
          { required: true, message: "院校代码不能为空", trigger: "blur" }
        ],
        schID: [
          { required: true, message: "院校ID不能为空", trigger: "blur" }
        ],
        hasInfo: [
          { required: true, message: "是否包含专业介绍不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询院校专业介绍列表 */
    getList() {
      this.loading = true;
      listZyjsinfos(this.queryParams).then(response => {
        this.zyjsinfosList = response.rows;
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
        yxdm: null,
        dicCurId: null,
        specId: null,
        schID: null,
        categoryId: null,
        yxcc: null,
        type: null,
        zy: null,
        hasInfo: null,
        zyjs: null
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
      this.ids = selection.map(item => item.dicCurId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加院校专业介绍";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const dicCurId = row.dicCurId || this.ids
      getZyjsinfos(dicCurId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改院校专业介绍";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.dicCurId != null) {
            updateZyjsinfos(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addZyjsinfos(this.form).then(response => {
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
      const dicCurIds = row.dicCurId || this.ids;
      this.$modal.confirm('是否确认删除院校专业介绍编号为"' + dicCurIds + '"的数据项？').then(function() {
        return delZyjsinfos(dicCurIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('zyjsinfos/zyjsinfos/export', {
        ...this.queryParams
      }, `zyjsinfos_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
