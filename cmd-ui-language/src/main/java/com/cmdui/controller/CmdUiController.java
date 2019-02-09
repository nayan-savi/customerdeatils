package com.cmdui.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmdui.logics.CmdUiUtil;

@Controller
public class CmdUiController {
	
	@Autowired	
	private CmdUiUtil cmdUiUtil;
	
	@RequestMapping("/console")
	public ModelAndView getHomePage(){
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/generateCode", method=RequestMethod.POST)
	public ModelAndView generateCode(HttpServletRequest request){
		String inputcode = request.getParameter("code");
		System.out.println(inputcode);
		String output = cmdUiUtil.getCode(inputcode);
		ModelAndView modelAndView = new ModelAndView("result");
		modelAndView.addObject("code", output);
		System.out.println(output);
		return modelAndView;
	}
}
