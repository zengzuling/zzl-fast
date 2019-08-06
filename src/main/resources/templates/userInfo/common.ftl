<#--  用户个人信息公用页面-->
<#--  zzl 2019-07-18 10:49:13-->
              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">用户名<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="username" maxlength="50" lay-verify="required"
                 value="${(model.username)!""}"  placeholder="请输入用户名"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">密码<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="password"  name="password" maxlength="100" lay-verify="required"
                 value="${(model.password)!""}"  placeholder="请输入密码"  class="layui-input">
            </div>
        </div>
    <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">邮箱<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="email" maxlength="100" lay-verify="email"
                 value="${(model.email)!""}"  placeholder="请输入邮箱"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">手机号<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="tel"  name="mobile" maxlength="11" lay-verify="required|phone"
                 value="${(model.mobile)!""}"  placeholder="请输入手机号"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">地址<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="address" maxlength="100" lay-verify="required"
                 value="${(model.address)!""}"  placeholder="请输入地址"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">角色<span class="span_must">*</span></label>
            <div class="layui-input-normal">
<#--                <input type="text"  name="roleId" maxlength="20" lay-verify="required"-->
<#--                 value="${(model.roleId)!""}"  placeholder="请选择所属角色"  class="layui-input">-->
                <input value="${(model.roleId)!""}" id="demoRole" lay-verify="required"
                       cyType="treeTool" cyProps="url:'/sys/role/sysSelect',name:'roleId'"
                       placeholder="请选择所属角色" class="layui-input"/>
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">部门<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input value="${(model.orgId)!""}" id="demo" lay-verify="required"
                       cyType="treeTool" cyProps="url:'/organize/select',name:'orgId'"
                       placeholder="请选择所属部门" class="layui-input"/>
<#--                <input type="text"  name="orgId" maxlength="10" lay-verify="required"-->
<#--                 value="${(model.orgId)!""}"  placeholder="请选择所属部门"  class="layui-input">-->
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"
                 value="${(model.state)!"1"}" class="layui-input-inline"></div>
        </div>