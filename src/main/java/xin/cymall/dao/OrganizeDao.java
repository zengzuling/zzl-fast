package xin.cymall.dao;

import xin.cymall.entity.Organize;

import java.util.List;

/**
 * 记录组织机构管理信息
 * 
 * @author zzl
 * @date 2017-11-06 17:39:31
 */
public interface OrganizeDao extends BaseDao<Organize> {

    List<Organize> getList();

    List<Organize> queryByParentId(String orgId);

    Organize queryByOrgCode(String orgCode);
}
