package xin.cymall.entity;

import lombok.Data;
import xin.cymall.base.BaseEntity;

import java.io.Serializable;



/**
 * 用户个人信息
 * 
 * @author zzl
 * @email 1144701440@qq.com
 * @date 2019-07-18 10:49:13
 */
@Data
public class SysUserInfo extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**用户id**/
	private String userInfoId;
	/**用户名**/
	private String username;
	/**性别**/
	private String sex;
	/**密码**/
	private String password;
	/**邮箱**/
	private String email;
	/**手机号**/
	private String mobile;
	/**地址**/
	private String address;
	/**部门id**/
	private String orgId;

	/**
	 * 冗余字段
	 */
	/**角色名**/
	private String roleName;
	/**部门名**/
	private String orgName;

}
