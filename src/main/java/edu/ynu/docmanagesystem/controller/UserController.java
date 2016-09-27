package edu.ynu.docmanagesystem.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.ynu.docmanagesystem.poExtend.State;
import edu.ynu.docmanagesystem.poExtend.UserExtend;
import edu.ynu.docmanagesystem.service.SectionService;
import edu.ynu.docmanagesystem.service.UserService;
import edu.ynu.docmanagesystem.util.BeanFactory;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SectionService sectionService;

	@RequestMapping("/login")
	public @ResponseBody State login(@RequestBody UserExtend user) throws Exception {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserid() + "", user.getPassword());
		// 登录成功返回1
		State state = BeanFactory.getState("1");
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			// 用户名不存在
			state.setState("-1");

		} catch (IncorrectCredentialsException e) {
			// 密码错误
			state.setState("0");
		} catch (Exception e) {
			// 其他错误
			e.printStackTrace();
			state.setState("-2");
		}
		Session session = subject.getSession();
		session.setAttribute("username", userService.findUserById(user.getUserid()).getUname());
		session.setAttribute("sectionname", userService.findSectionByUserId((user.getUserid())).getSectiondescribe());
		return state;
	}

	@RequestMapping("/menu")
	public @ResponseBody Map<Object, Object> selectMenu() {
		Subject subject = SecurityUtils.getSubject();
		Integer userId = (Integer) subject.getPrincipal();
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("data", userService.findMenuById(userId));
		return hashMap;

	}

	@RequestMapping("/userOperationCountStatistics")
	public @ResponseBody Map<Object, Object> userOperationCountStatistics() {
		return userService.userOperationCountStatistics();
	}

	@RequestMapping("/sectionCountStatistics")
	public @ResponseBody Map<Object, Object> sectionCountStatistics() {
		return sectionService.sectionCountStatistics();
	}

	@RequestMapping("/findSectionReourceTypeAuthorizationList")
	public @ResponseBody Map<Object, Object> findSectionReourceTypeAuthorizationList() {
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("data", userService.findSectionReourceTypeAuthorizationList());
		return hashMap;
	}

	@RequestMapping("/deleteSectionReourceTypeAuthorization")
	public String deleteSectionReourceTypeAuthorization(Integer sectionId, Integer resourceTypeId,
			Integer userAuthorityId, Boolean isCascade) {
		try {
			sectionService.deleteSectionResourceTypeAuthorization(sectionId, resourceTypeId, userAuthorityId,
					isCascade);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/index.html#/autManage";
	}

	@RequestMapping("/addSectionReourceTypeAuthorization")
	public String addSectionReourceTypeAuthorization(Integer sectionId, Integer resourceTypeId, Integer userAuthorityId,
			Boolean isCascade) {
		try {
			sectionService.addSectionResourceTypeAuthorization(sectionId, resourceTypeId, userAuthorityId, isCascade);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/index.html#/autManage";
	}

	@RequestMapping("/getUserInformation")
	public @ResponseBody Map<Object, Object> getUserInformation() {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("userName", session.getAttribute("username"));
		hashMap.put("sectionName", session.getAttribute("sectionname"));
		return hashMap;
	}

}
