package edu.ynu.docmanagesystem.security;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import edu.ynu.docmanagesystem.po.User;
import edu.ynu.docmanagesystem.service.UserService;

public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		Integer userId = (Integer) arg0.getPrimaryPrincipal();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		//查询用户拥有的角色
		List<Integer> findRoleById = userService.findRoleById(userId);
		//使用java8的流将角色转为字符串
		List<String> roles = findRoleById.stream().map(String::valueOf).collect(Collectors.toList());
		//把角色信息加入授权
		simpleAuthorizationInfo.addRoles(roles);
		//加入用户拥有的权限
		simpleAuthorizationInfo.addStringPermissions(userService.findShiroPermissionById(userId));
		return simpleAuthorizationInfo;

	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) 
			throws AuthenticationException {
		// 取出用户唯一标识
		String userId = (String) arg0.getPrincipal();
		// 如果用户不存在返回空，认证失败
		User user = userService.findUserById(Integer.valueOf(userId));
		if (user == null) {
			return null;
		}
		// 存在此用户，对密码进行验证。
		SimpleAuthenticationInfo simpleAuthenticationInfo = 
				new SimpleAuthenticationInfo(user.getUserid(),
		        user.getPassword(), ByteSource.Util.bytes(user.getSalt()), this.getName());
		return simpleAuthenticationInfo;
	}

}
