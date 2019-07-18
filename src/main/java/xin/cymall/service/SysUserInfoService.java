package xin.cymall.service;

import xin.cymall.entity.SysUserInfo;

import java.util.List;
import java.util.Map;

/**
 * 用户个人信息
 * 
 * @author zzl
 * @email 1144701440@qq.com
 * @date 2019-07-18 10:49:13
 */
public interface SysUserInfoService {
	
	SysUserInfo get(String userInfoId);
	
	List<SysUserInfo> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(SysUserInfo sysUserInfo);
	
	void update(SysUserInfo sysUserInfo);
	
	void delete(String userInfoId);
	
	void deleteBatch(String[] userInfoIds);

    void updateState(String[] ids, String stateValue);
}
