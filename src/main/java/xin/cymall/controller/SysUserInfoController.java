package xin.cymall.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xin.cymall.common.enumresource.StateEnum;
import xin.cymall.common.log.SysLog;
import xin.cymall.common.utils.*;
import xin.cymall.entity.SysUserInfo;
import xin.cymall.service.OrganizeService;
import xin.cymall.service.SysRoleService;
import xin.cymall.service.SysUserInfoService;

import java.util.List;
import java.util.Map;


/**
 * 用户个人信息
 * 
 * @author zzl
 * @email 1144701440@qq.com
 * @date 2019-07-18 10:49:13
 */
@Controller
@RequestMapping("sysuserinfo")
public class SysUserInfoController extends AbstractController {
	@Autowired
	private SysUserInfoService sysUserInfoService;
	@Autowired
    private SysRoleService sysRoleService;
	@Autowired
    private OrganizeService organizeService;
	@Autowired
    private RedisUtil redisUtil;

    /**
     * 跳转到列表页
     */
    @RequestMapping("/list")
    @RequiresPermissions("sysuserinfo:list")
    public String list() {
        return "userInfo/list";
    }
    
	/**
	 * 列表数据
	 */
    @ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("sysuserinfo:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysUserInfo> sysUserInfoList = sysUserInfoService.getList(query);
        for (SysUserInfo sysUserInfo : sysUserInfoList) {
              sysUserInfo.setRoleName(sysRoleService.queryObject(sysUserInfo.getRoleId()).getRoleName());
              sysUserInfo.setOrgName(organizeService.queryObject(sysUserInfo.getOrgId()).getOrgName());
              sysUserInfo.setStatus(sysUserInfo.getStatus().equals("1") ? "可用" : "禁用");
        }
		int total = sysUserInfoService.getCount(query);
		
		PageUtils pageUtil = new PageUtils(sysUserInfoList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    /**
     * 跳转到新增页面
     **/
    @RequestMapping("/add")
    @RequiresPermissions("sysuserinfo:save")
    public String add(){
        return "userInfo/add";
    }

    /**
     *   跳转到修改页面
     **/
    @RequestMapping("/edit/{id}")
    @RequiresPermissions("sysuserinfo:update")
    public String edit(Model model, @PathVariable("id") String id){
		SysUserInfo sysUserInfo = sysUserInfoService.get(id);
        model.addAttribute("model",sysUserInfo);
        return "userInfo/edit";
    }

	/**
	 * 信息
	 */
    @ResponseBody
    @RequestMapping("/info/{userInfoId}")
    @RequiresPermissions("sysuserinfo:info")
    public R info(@PathVariable("userInfoId") String userInfoId){
        SysUserInfo sysUserInfo = sysUserInfoService.get(userInfoId);
        return R.ok().put("sysUserInfo", sysUserInfo);
    }

    /**
	 * 保存
	 */
    @ResponseBody
    @SysLog("保存用户个人信息")
	@RequestMapping("/save")
	@RequiresPermissions("sysuserinfo:save")
	public R save(@RequestBody SysUserInfo sysUserInfo){
		sysUserInfoService.save(sysUserInfo);
		redisUtil.set(Constant.RedisEnum.USERINFO.getValue()+sysUserInfo.getUserInfoId(),sysUserInfo);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
    @ResponseBody
    @SysLog("修改用户个人信息")
	@RequestMapping("/update")
	@RequiresPermissions("sysuserinfo:update")
	public R update(@RequestBody SysUserInfo sysUserInfo){
        sysUserInfo.setCreateTime(null);

		sysUserInfoService.update(sysUserInfo);
        redisUtil.set(Constant.RedisEnum.USERINFO.getValue()+sysUserInfo.getUserInfoId(),sysUserInfo);
		return R.ok();
	}

    /**
     * 启用
     */
    @ResponseBody
    @SysLog("启用用户个人信息")
    @RequestMapping("/enable")
    @RequiresPermissions("sysuserinfo:update")
    public R enable(@RequestBody String[] ids){
        String stateValue=StateEnum.ENABLE.getCode();
		sysUserInfoService.updateState(ids,stateValue);
        return R.ok();
    }
    /**
     * 禁用
     */
    @ResponseBody
    @SysLog("禁用用户个人信息")
    @RequestMapping("/limit")
    @RequiresPermissions("sysuserinfo:update")
    public R limit(@RequestBody String[] ids){
        String stateValue=StateEnum.LIMIT.getCode();
		sysUserInfoService.updateState(ids,stateValue);
        return R.ok();
    }
	
	/**
	 * 删除
	 */
    @ResponseBody
    @SysLog("删除用户个人信息")
	@RequestMapping("/delete")
	@RequiresPermissions("sysuserinfo:delete")
	public R delete(@RequestBody String[] userInfoIds){
		sysUserInfoService.deleteBatch(userInfoIds);
		//拼接数据删除redis
        for (int i = 0; i < userInfoIds.length; i++) {
            userInfoIds[i] = Constant.RedisEnum.USERINFO.getValue() + userInfoIds[i];
        }
        redisUtil.del(userInfoIds);
		return R.ok();
	}
	
}
