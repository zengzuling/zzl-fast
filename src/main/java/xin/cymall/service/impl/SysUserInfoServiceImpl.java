package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.cymall.dao.SysUserInfoDao;
import xin.cymall.entity.SysUserInfo;
import xin.cymall.service.SysUserInfoService;

import java.util.List;
import java.util.Map;




@Service("sysUserInfoService")
@Transactional
public class SysUserInfoServiceImpl implements SysUserInfoService {
	@Autowired
	private SysUserInfoDao sysUserInfoDao;
	
	@Override
	public SysUserInfo get(String userInfoId){
		return sysUserInfoDao.get(userInfoId);
	}

	@Override
	public List<SysUserInfo> getList(Map<String, Object> map){
		return sysUserInfoDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return sysUserInfoDao.getCount(map);
	}

	@Override
	public void save(SysUserInfo sysUserInfo){
		sysUserInfoDao.save(sysUserInfo);
	}

	@Override
	public void update(SysUserInfo sysUserInfo){
		sysUserInfoDao.update(sysUserInfo);
	}

	@Override
	public void delete(String userInfoId){
		sysUserInfoDao.delete(userInfoId);
	}

	@Override
	public void deleteBatch(String[] userInfoIds){
		sysUserInfoDao.deleteBatch(userInfoIds);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			SysUserInfo sysUserInfo=get(id);
			sysUserInfo.setStatus(stateValue);
            update(sysUserInfo);
        }
    }

}
