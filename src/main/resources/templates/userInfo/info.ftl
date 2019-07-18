<#--  zzl 2019-07-18 10:49:13-->

<html>
<head>
    <title>用户个人信息详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left">用户id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.userInfoId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">用户名<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.username)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">密码<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.password)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">邮箱<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.email)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">手机号<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.mobile)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">地址<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.address)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">状态<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.status)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">创建者ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createUserId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">创建时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">角色id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.roleId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">部门id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.orgId)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
