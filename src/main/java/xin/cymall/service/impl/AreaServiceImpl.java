package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.cymall.common.utils.StringUtil;
import xin.cymall.dao.AreaDao;
import xin.cymall.entity.Area;
import xin.cymall.service.AreaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("areaService")
@Transactional
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaDao areaDao;
	
	@Override
	public Area queryObject(String areaId){
		return areaDao.queryObject(areaId);
	}
	
	@Override
	public List<Area> queryList(Map<String, Object> map){
		return areaDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return areaDao.queryTotal(map);
	}
	
	@Override
	public void save(Area area){
		areaDao.save(area);
	}
	
	@Override
	public void update(Area area){
		areaDao.update(area);
	}
	
	@Override
	public void delete(String areaId){
		areaDao.delete(areaId);
	}


	/**
	 * @author zzl
	 * @Description 根据分类ID中转成分类名称串
	 * @param
	 *
	 */
	@Override
	public  String getAreaNameStr(String areaIdStr){
		String areaNameStr="";
		if(StringUtil.isEmpty(areaIdStr)){
			return areaNameStr;
		}
		if(areaIdStr.indexOf(',')>-1){
			String[] menuId = areaIdStr.split(",");
			for(int i=0;i<menuId.length;i++){
				areaNameStr+=getAreaName(menuId[i]);
				if(i!=menuId.length-1){
					areaNameStr+=",";
				}
			}
		}else{
			areaNameStr+=getAreaName(areaIdStr);
		}
		return areaNameStr;
	}
	/**
	 * @author zzl
	 * @Description 根据菜单ID获取菜单名称
	 * @param
	 *
	 */
	public  String getAreaName(String areaId){
		Area area=queryObject(areaId);
		return area.getAreaName();
	}
	@Override
	public void deleteBatch(String[] areaIds){
		for(String id:areaIds){
			delete(id);
			//删除下级地区
			deleteSon(id);
		}
		areaDao.deleteBatch(areaIds);
	}

	//删除下级
	private void deleteSon(String pId) {
		List<Area> areaList = findByParentId(pId);
		if (areaList != null) {
			for (Area area:areaList) {
				delete(area.getAreaId());
				//删除下级地区
				deleteSon(area.getAreaId());
			}
		}
	}

	//禁用或启用
	public void updateState(String[] ids,String stateValue) {
		for (String id:ids){
			Area area =queryObject(id);
			area.setState(stateValue);
			update(area);
			//禁用或启用下级
			updateSon(id,stateValue);
		}
	}

	//禁用或启用下级
	private void updateSon(String pId,String stateValue) {
		List<Area> areaList = findByParentId(pId);
		if (areaList != null) {
			for (int i = 0; i < areaList.size(); i++) {
				Area area = areaList.get(i);
				area.setState(stateValue);
				update(area);
				//禁用下级地区
				updateSon(area.getAreaId(),stateValue);
			}
		}
	}

	private List<Area> findByParentId(String pId) {
		return areaDao.findByParentId(pId);
	}

	@Override
	public List<Area> getAreaListByIsShow(HashMap<String, Object> paraMap) {
		return areaDao.getAreaListByIsShow(paraMap);
	}

	@Override
	public int getCount(Map<String, Object> params) {
		return areaDao.getCount(params);
	}

}
