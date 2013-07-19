package com.ncos.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ncos.user.entity.User;
import com.ncos.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mv){
		mv.addObject("userList",userService.getList());
		mv.setViewName("user/list.tiles");
		return mv;
	}
	
	@RequestMapping("/save")
	public ModelAndView save(ModelAndView mv){
		User user = new User();
		user.setId("taeng2");
//		user.setName("taeyeon");
		userService.saveUser(user);
		return mv;
	}
}
