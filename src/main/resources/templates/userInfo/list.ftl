<#--  zzl 2019-07-18 10:49:13-->
<!DOCTYPE html>
<html>
<head>
    <title>用户个人信息列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/sysuserinfo/js/list.js"></script>
</head>
<body>
<form class="layui-form " action="">
    <div class="layui-form-item">
        <label class="layui-form-label">名称:</label>
        <div class="layui-input-inline">
            <input type="text" name=""  placeholder="请输入名称" class="layui-input">
        </div>

        <div class="layui-input-normal">
            <button class="layui-btn layui-btn-green" lay-submit="" lay-filter="moreSearch">
                <i class="fa fa-chevron-down">&nbsp;</i>更多
            </button>
            <button class="layui-btn search-btn" table-id="sysUserInfoTable" lay-submit="" lay-filter="search">
                <i class="fa fa-search">&nbsp;</i>查询
            </button>
            <button type="reset" class="layui-btn layui-btn-primary"><i class="fa fa-refresh">&nbsp;</i>重置</button>
        </div>
    </div>
    <div class="layui-form-item more-search">
       <#-- 更多条件-->
    </div>
</form>
<div class="layui-btn-group">
        <@shiro.hasPermission name="sysuserinfo:save">
        <button class="layui-btn" onclick="addPage('/sysuserinfo/add')">
            <i class="fa fa-plus">&nbsp;</i>增加
        </button>
        </@shiro.hasPermission>
        <@shiro.hasPermission name="sysuserinfo:update">
        <button class="layui-btn" onclick="editPage('sysUserInfoTable','/sysuserinfo/edit')">
            <i class="fa fa-pencil-square-o">&nbsp;</i>修改
        </button>
         <button class="layui-btn layui-btn-green" onclick="updateState('批量启用','sysUserInfoTable','/sysuserinfo/enable')">
            <i class="fa fa-check-square-o">&nbsp;</i>启用
        </button>
        <button class="layui-btn  layui-btn-danger" onclick="updateState('批量禁用','sysUserInfoTable','/sysuserinfo/limit')">
            <i class="fa fa-expeditedssl">&nbsp;</i>禁用
        </button>
        </@shiro.hasPermission>
        <@shiro.hasPermission name="sysuserinfo:delete">
         <button class="layui-btn layui-btn-delete" onclick="deleteBatch('批量删除','sysUserInfoTable','/sysuserinfo/delete');">
            <i class="fa fa-trash-o">&nbsp;</i>删除
        </button>
        </@shiro.hasPermission>

</div>
<div class="layui-form ">
    <table class="layui-table" id="sysUserInfoTable" cyType="pageGrid"
           cyProps="url:'/sysuserinfo/listData',checkbox:'true',pageColor:'#2991d9'">
        <thead>
        <tr>
            <!--复选框-->
            <th width="1%" param="{type:'checkbox'}">
                <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
            </th>
            			            <!--isPrimary：是否是主键-->
            <th width="10%" param="{name:'userInfoId'}">用户id</th>
		          <th width="10%" param="{name:'username'}">用户名</th>
			            			
		          <th width="10%" param="{name:'email'}">邮箱</th>
			            			
		          <th width="10%" param="{name:'mobile'}">手机号</th>

		          <th width="10%" param="{name:'createTime'}">创建时间</th>

		          <th width="10%" param="{name:'orgId'}">隶属部门</th>
			                        <!--isPrimary：渲染列-->
                  <th width="10%" param="{name:'status'}">状态</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>