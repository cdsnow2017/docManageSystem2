package edu.ynu.docmanagesystem.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ynu.docmanagesystem.mapper.RoleMenuMapper;
import edu.ynu.docmanagesystem.mapper.UserResourceLogMapper;
import edu.ynu.docmanagesystem.mapper.UserRoleMapper;
import edu.ynu.docmanagesystem.mapper.UserMapper;
import edu.ynu.docmanagesystem.mapperExtend.UserExtendMapper;
import edu.ynu.docmanagesystem.po.RoleMenu;
import edu.ynu.docmanagesystem.po.RoleMenuExample;
import edu.ynu.docmanagesystem.po.Section;
import edu.ynu.docmanagesystem.po.UserResourceLog;
import edu.ynu.docmanagesystem.po.UserRole;
import edu.ynu.docmanagesystem.po.UserRoleExample;
import edu.ynu.docmanagesystem.po.User;
import edu.ynu.docmanagesystem.poExtend.PermissionShiroString;
import edu.ynu.docmanagesystem.poExtend.SectionReourceTypeAuthorizationList;
import edu.ynu.docmanagesystem.service.UserService;
import edu.ynu.docmanagesystem.util.LogType;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserExtendMapper userExtendMapper;

	@Autowired
	private UserMapper UserMapper;

	@Autowired
	private UserRoleMapper userRoleMapper;

	@Autowired
	private RoleMenuMapper roleMenuMapper;

	@Autowired
	private UserResourceLogMapper userResourceLogMapper;

	@Override
	public User findUserById(Integer userId) {
		return UserMapper.selectByPrimaryKey(userId);
	}

	@Override
	public String findMenuById(Integer userId) {
		List<Integer> findRoleById = findRoleById(userId);
		RoleMenuExample roleMenuExample = new RoleMenuExample();
		roleMenuExample.or().andRoleidIn(findRoleById);
		List<RoleMenu> selectByExample = roleMenuMapper.selectByExample(roleMenuExample);
		StringBuilder stringBuilder = new StringBuilder();
		for (RoleMenu roleMenu : selectByExample) {
			stringBuilder.append(roleMenu.getMenu());
		}
		return stringBuilder.toString();
	}

	@Override
	public List<Integer> findRoleById(Integer userId) {
		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.or().andUseridEqualTo(userId);
		List<UserRole> selectByExample = userRoleMapper.selectByExample(userRoleExample);
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (UserRole userRole : selectByExample) {
			arrayList.add(userRole.getRoleid());

		}
		return arrayList;
	}

	@Override
	public List<String> findShiroPermissionById(Integer userId) {
		Section section = userExtendMapper.findSectionByUserId(userId);
		List<PermissionShiroString> shiroPermissionById = userExtendMapper
		        .findShiroPermissionById(section.getSectionid());
		return shiroPermissionById.stream().map(PermissionShiroString::toString).collect(Collectors.toList());

	}

	@Override
	public void insertLog(Integer userId, Integer resourceId, String operation) {
		UserResourceLog userResourceLog = new UserResourceLog();
		userResourceLog.setOperation(operation);
		userResourceLog.setResourceid(resourceId);
		userResourceLog.setUserid(userId);
		userResourceLog.setTime(new Date());
		userResourceLogMapper.insertSelective(userResourceLog);

	}

	@Override
	public Map<Object, Object> userOperationCountStatistics() {
		List<Integer> allUserId = userExtendMapper.selectAllUserId();
		List<Integer> readCount = new ArrayList<>();
		List<Integer> downloadCount = new ArrayList<>();
		List<Integer> uploadCount = new ArrayList<>();
		for (Integer userId : allUserId) {
			readCount.add(userExtendMapper.selectOperationCountOneUser(userId, LogType.read));
			downloadCount.add(userExtendMapper.selectOperationCountOneUser(userId, LogType.download));
			uploadCount.add(userExtendMapper.selectOperationCountOneUser(userId, LogType.upload));
		}
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("allUserId", allUserId);
		hashMap.put("readCount", readCount);
		hashMap.put("downloadCount", downloadCount);
		hashMap.put("uploadCount", uploadCount);
		return hashMap;
	}

	@Override
	public List<SectionReourceTypeAuthorizationList> findSectionReourceTypeAuthorizationList() {
		return userExtendMapper.findSectionReourceTypeAuthorizationList();
	}

	@Override
	public Section findSectionByUserId(Integer userId) {
		return userExtendMapper.findSectionByUserId(userId);
	}

}
