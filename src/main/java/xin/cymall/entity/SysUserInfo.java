package xin.cymall.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户个人信息
 * 
 * @author zzl
 * @email 1144701440@qq.com
 * @date 2019-07-18 10:49:13
 */
@Data
public class SysUserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**用户id**/
	private String userInfoId;
	/**用户名**/
	private String username;
	/**密码**/
	private String password;
	/**邮箱**/
	private String email;
	/**手机号**/
	private String mobile;
	/**地址**/
	private String address;
	/**状态  0：禁用   1：正常**/
	private String status;
	/**创建者ID**/
	private String createUserId;
	/**创建时间**/
	private Date createTime;
	/**角色id**/
	private String roleId;
	/**部门id**/
	private String orgId;
}
