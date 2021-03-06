package com.watermelon.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.watermelon.pojo.User;
import com.watermelon.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public ModelAndView registerPage(@ModelAttribute User user) {

		ModelAndView modelAndView = new ModelAndView("register");
		return modelAndView;
	}

	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public ModelAndView registerSubmit(@Valid User user, BindingResult bindingResult) {
		if (bindingResult.getFieldError("email") != null || bindingResult.getFieldError("password") != null) {
			return registerPage(user);
		}
		userService.insert(user);
		ModelAndView modelAndView = new ModelAndView("registerSuccess");
		return modelAndView;
	}

	@RequestMapping(value = "/register2.do", method = RequestMethod.GET)
	public ModelAndView registe2rPage(@ModelAttribute User user) {

		ModelAndView modelAndView = new ModelAndView("register");
		return modelAndView;
	}

	@RequestMapping(value = "/register2.do", method = RequestMethod.POST)
	public ModelAndView register2Submit(String email, String password, HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		if (email == null || !email.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")){
			request.setAttribute("message","注册成功");
			request.getRequestDispatcher("WEB-INF/jsp/register2.jsp").forward(request, response);
		    return null;
		}
		if(password.length()<=6||password==null)
		{
			request.setAttribute("message","�������");
			request.getRequestDispatcher("WEB-INF/jsp/register2.jsp").forward(request, response);
		    return null;
		}
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		userService.insert(user);
		ModelAndView modelAndView = new ModelAndView("registerSuccess");
		return modelAndView;
	}

}