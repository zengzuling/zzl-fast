package xin.cymall.dao;

import xin.cymall.entity.Area;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zzl
 * @date 2017-08-11 10:52:35
 */
public interface AreaDao extends BaseDao<Area> {

    List<Area> getAreaListByIsShow(Map<String, Object> paraMap);

    int getCount(Map<String, Object> params);

    List<Area> findByParentId(String pId);
}
