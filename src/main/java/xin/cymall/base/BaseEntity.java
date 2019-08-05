package xin.cymall.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import xin.cymall.common.shiro.ShiroUtils;
import xin.cymall.common.utils.Constant;

import java.util.Date;

/**
 * @Author zzl
 * @date 2019/7/19  11:03
 * @Des: 基础实体类
 */
@Data
public abstract class BaseEntity {
    private static final long serialVersionUID = 1L;

    /**状态  0：禁用   1：正常**/
    private String status = "1";
    /**创建者ID**/
    private Long createUserId = ShiroUtils.getUserId();
    /**创建时间**/
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime = new Date();
    /**角色id**/
    private Long roleId = Constant.DEFAULT_ADMIN;
}
