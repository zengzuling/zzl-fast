package xin.cymall.controller;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xin.cymall.common.exception.MyException;
import xin.cymall.common.log.SysLog;
import xin.cymall.common.utils.PageUtils;
import xin.cymall.common.utils.Query;
import xin.cymall.common.utils.R;
import xin.cymall.entity.SysConfig;
import xin.cymall.service.SysConfigService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
 * 系统配置信息表
 *
 * @author zzl
 * @date 2017-08-02 17:19:29
 */
@Controller
@RequestMapping("sys/config")
public class SysConfigController extends AbstractController{
	@Autowired
	private SysConfigService sysConfigService;

	@RequestMapping("/list")
	public String list() {
		return "config/list";
	}
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/listData")
	@RequiresPermissions("sys:config:list")
	public R listData(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);

		List<SysConfig> sysConfigList = sysConfigService.queryList(query);
		int total = sysConfigService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(sysConfigList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 跳转到新增页面
	 **/
	@RequestMapping("/add")
	@RequiresPermissions("sys:config:list")
	public String add(){
		return "config/add";
	}

	/**
	 *   跳转到修改页面
	 **/
	@RequestMapping("/edit/{id}")
	@RequiresPermissions("sys:config:list")
	public String edit(HttpServletRequest request, Model model, @PathVariable("id") Long id){
		SysConfig sysConfig = sysConfigService.queryObject(id);
		model.addAttribute("model", sysConfig);
		return "config/edit";
	}

	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:config:info")
	public R info(@PathVariable("id") Long id){
		SysConfig sysConfig = sysConfigService.queryObject(id);

		return R.ok().put("sysConfig", sysConfig);
	}

	/**
	 * 获取规则管理信息
	 */
	@ResponseBody
	@RequestMapping("/rule")
	@RequiresPermissions("sys:config:info")
	public R rule(@RequestParam Map<String, Object> params){
		List<SysConfig> sysConfigList = sysConfigService.findRule(params);

		return R.ok().put("data", sysConfigList);
	}


	/**
	 * 保存
	 */
	@ResponseBody
	@SysLog("保存参数")
	@RequestMapping("/save")
	@RequiresPermissions("sys:config:save")
	public R save(@RequestBody SysConfig sysConfig){
		if(CollectionUtils.isNotEmpty(sysConfigService.findByCode(sysConfig.getCode()))){
			throw new MyException("参数名已存在");
		}
		sysConfigService.save(sysConfig);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@SysLog("修改参数管理")
	@RequestMapping("/update")
	@RequiresPermissions("sys:config:update")
	public R update(@RequestBody SysConfig sysConfig){
		SysConfig oldConfig=sysConfigService.queryObject(sysConfig.getId());
		if(!oldConfig.getCode().equals(sysConfig.getCode())){
			if(CollectionUtils.isNotEmpty(sysConfigService.findByCode(sysConfig.getCode()))){
				throw new MyException("参数名已存在");
			}
		}
		sysConfigService.update(sysConfig);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@ResponseBody
	@SysLog("删除参数管理")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:config:delete")
	public R delete(@RequestBody Long[] ids){
		sysConfigService.deleteBatch(ids);

		return R.ok();
	}

}
