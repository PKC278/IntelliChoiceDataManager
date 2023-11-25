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
      <el-form-item label="院校ID" prop="schoolID">
        <el-input
          v-model="queryParams.schoolID"
          placeholder="请输入院校ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="院校详情代码" prop="schInfoId">
        <el-input
          v-model="queryParams.schInfoId"
          placeholder="请输入院校详情代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="院校名称" prop="schoolName">
        <el-input
          v-model="queryParams.schoolName"
          placeholder="请输入院校名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="院校所属省份" prop="location">
        <el-input
          v-model="queryParams.location"
          placeholder="请输入院校所属省份"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="主管部门" prop="governingDepartment">
        <el-input
          v-model="queryParams.governingDepartment"
          placeholder="请输入主管部门"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="院校类型" prop="universityType">
        <el-input
          v-model="queryParams.universityType"
          placeholder="请输入院校类型"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="办学层次" prop="educationLevel">
        <el-input
          v-model="queryParams.educationLevel"
          placeholder="请输入办学层次"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="一流大学" prop="yldx">
        <el-select v-model="queryParams.yldx" placeholder="请选择一流大学" clearable>
          <el-option
            v-for="dict in dict.type.sys_boolean"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="一流学科" prop="ylxk">
        <el-select v-model="queryParams.ylxk" placeholder="请选择一流学科" clearable>
          <el-option
            v-for="dict in dict.type.sys_boolean"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否双一流" prop="syl">
        <el-select v-model="queryParams.syl" placeholder="请选择是否双一流" clearable>
          <el-option
            v-for="dict in dict.type.sys_boolean"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="是否有研究院" prop="yjs">
        <el-select v-model="queryParams.yjs" placeholder="请选择是否有研究院" clearable>
          <el-option
            v-for="dict in dict.type.sys_boolean"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="满意度" prop="manyidu">
        <el-input
          v-model="queryParams.manyidu"
          placeholder="请输入满意度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="关注数" prop="followCount">
        <el-input
          v-model="queryParams.followCount"
          placeholder="请输入关注数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="官方电话" prop="dh">
        <el-input
          v-model="queryParams.dh"
          placeholder="请输入官方电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="hasZb" prop="hasZb">
        <el-select v-model="queryParams.hasZb" placeholder="请选择hasZb" clearable>
          <el-option
            v-for="dict in dict.type.sys_boolean"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="招生网址" prop="zswz">
        <el-input
          v-model="queryParams.zswz"
          placeholder="请输入招生网址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学校网址" prop="xxwz">
        <el-input
          v-model="queryParams.xxwz"
          placeholder="请输入学校网址"
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
          v-hasPermi="['colleges:colleges:add']"
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
          v-hasPermi="['colleges:colleges:edit']"
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
          v-hasPermi="['colleges:colleges:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['colleges:colleges:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="collegesList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="院校代码" align="center" prop="yxdm" />
      <el-table-column label="院校ID" align="center" prop="schoolID" />
      <el-table-column label="院校详情代码" align="center" prop="schInfoId" />
      <el-table-column label="院校名称" align="center" prop="schoolName" />
      <el-table-column label="院校所属省份" align="center" prop="location" />
      <el-table-column label="主管部门" align="center" prop="governingDepartment" />
      <el-table-column label="院校类型" align="center" prop="universityType" />
      <el-table-column label="办学层次" align="center" prop="educationLevel" />
      <el-table-column label="一流大学" align="center" prop="yldx">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_boolean" :value="scope.row.yldx"/>
        </template>
      </el-table-column>
      <el-table-column label="一流学科" align="center" prop="ylxk">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_boolean" :value="scope.row.ylxk"/>
        </template>
      </el-table-column>
      <el-table-column label="是否双一流" align="center" prop="syl">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_boolean" :value="scope.row.syl"/>
        </template>
      </el-table-column>
      <el-table-column label="是否有研究院" align="center" prop="yjs">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_boolean" :value="scope.row.yjs"/>
        </template>
      </el-table-column>
      <el-table-column label="满意度" align="center" prop="manyidu" />
      <el-table-column label="关注数" align="center" prop="followCount" />
      <el-table-column label="官方电话" align="center" prop="dh" />
      <el-table-column label="hasZb" align="center" prop="hasZb">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_boolean" :value="scope.row.hasZb"/>
        </template>
      </el-table-column>
      <el-table-column label="招生网址" align="center" prop="zswz" />
      <el-table-column label="通讯地址" align="center" prop="txdz" />
      <el-table-column label="学校网址" align="center" prop="xxwz" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['colleges:colleges:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['colleges:colleges:remove']"
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

    <!-- 添加或修改院校列表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="院校名称" prop="schoolName">
          <el-input v-model="form.schoolName" placeholder="请输入院校名称" />
        </el-form-item>
        <el-form-item label="院校所属省份" prop="location">
          <el-input v-model="form.location" placeholder="请输入院校所属省份" />
        </el-form-item>
        <el-form-item label="主管部门" prop="governingDepartment">
          <el-input v-model="form.governingDepartment" placeholder="请输入主管部门" />
        </el-form-item>

        <el-form-item label="院校类型" prop="universityType">
          <el-input v-model="form.universityType" placeholder="请输入院校类型" />
        </el-form-item>
        <el-form-item label="办学层次" prop="educationLevel">
          <el-input v-model="form.educationLevel" placeholder="请输入办学层次" />
        </el-form-item>
        <el-form-item label="一流大学" prop="yldx">
          <el-select v-model="form.yldx" placeholder="请选择一流大学">
            <el-option
              v-for="dict in dict.type.sys_boolean"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="一流学科" prop="ylxk">
          <el-select v-model="form.ylxk" placeholder="请选择一流学科">
            <el-option
              v-for="dict in dict.type.sys_boolean"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否双一流" prop="syl">
          <el-select v-model="form.syl" placeholder="请选择是否双一流">
            <el-option
              v-for="dict in dict.type.sys_boolean"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否有研究院" prop="yjs">
          <el-select v-model="form.yjs" placeholder="请选择是否有研究院">
            <el-option
              v-for="dict in dict.type.sys_boolean"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="满意度" prop="manyidu">
          <el-input v-model="form.manyidu" placeholder="请输入满意度" />
        </el-form-item>
        <el-form-item label="校徽" prop="schoolBadge">
          <el-input v-model="form.schoolBadge" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="关注数" prop="followCount">
          <el-input v-model="form.followCount" placeholder="请输入关注数" />
        </el-form-item>
        <el-form-item label="官方电话" prop="dh">
          <el-input v-model="form.dh" placeholder="请输入官方电话" />
        </el-form-item>
        <el-form-item label="hasZb" prop="hasZb">
          <el-select v-model="form.hasZb" placeholder="请选择hasZb">
            <el-option
              v-for="dict in dict.type.sys_boolean"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="招生网址" prop="zswz">
          <el-input v-model="form.zswz" placeholder="请输入招生网址" />
        </el-form-item>
        <el-form-item label="通讯地址" prop="txdz">
          <el-input v-model="form.txdz" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="学校网址" prop="xxwz">
          <el-input v-model="form.xxwz" placeholder="请输入学校网址" />
        </el-form-item>
        <el-form-item label="校内专业排名" prop="avgRank">
          <el-input v-model="form.avgRank" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="社交账号" prop="sjzh">
          <el-input v-model="form.sjzh" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="微信二维码" prop="wxQR">
          <el-input v-model="form.wxQR" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="微博二维码" prop="wbQR">
          <el-input v-model="form.wbQR" type="textarea" placeholder="请输入内容" />
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
import { listColleges, getColleges, delColleges, addColleges, updateColleges } from "@/api/colleges/colleges";

export default {
  name: "Colleges",
  dicts: ['sys_boolean'],
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
      // 院校列表表格数据
      collegesList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        yxdm: null,
        schoolID: null,
        schInfoId: null,
        schoolName: null,
        location: null,
        governingDepartment: null,
        universityType: null,
        educationLevel: null,
        yldx: null,
        ylxk: null,
        syl: null,
        yjs: null,
        manyidu: null,
        schoolBadge: null,
        followCount: null,
        dh: null,
        hasZb: null,
        zswz: null,
        txdz: null,
        xxwz: null,
        avgRank: null,
        sjzh: null,
        wxQR: null,
        wbQR: null
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
    /** 查询院校列表列表 */
    getList() {
      this.loading = true;
      listColleges(this.queryParams).then(response => {
        this.collegesList = response.rows;
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
        schoolID: null,
        schInfoId: null,
        schoolName: null,
        location: null,
        governingDepartment: null,
        universityType: null,
        educationLevel: null,
        yldx: null,
        ylxk: null,
        syl: null,
        yjs: null,
        manyidu: null,
        schoolBadge: null,
        followCount: null,
        dh: null,
        hasZb: null,
        zswz: null,
        txdz: null,
        xxwz: null,
        avgRank: null,
        sjzh: null,
        wxQR: null,
        wbQR: null
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
      this.ids = selection.map(item => item.yxdm)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加院校列表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const yxdm = row.yxdm || this.ids
      getColleges(yxdm).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改院校列表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.yxdm != null) {
            updateColleges(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addColleges(this.form).then(response => {
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
      const yxdms = row.yxdm || this.ids;
      this.$modal.confirm('是否确认删除院校列表编号为"' + yxdms + '"的数据项？').then(function() {
        return delColleges(yxdms);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('colleges/colleges/export', {
        ...this.queryParams
      }, `colleges_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
