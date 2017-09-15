package org.itbank.app.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.itbank.app.model.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/my")
public class MemberController {
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	ServletContext application;

	@GetMapping("/profile")
	public ModelAndView profileHandle() {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("section", "my/profile");
		return mav;
	}

	@PostMapping("/profile")
	public ModelAndView profilePostHandle(@RequestParam Map param,
			@RequestParam(name="profile") MultipartFile f, HttpServletRequest request) throws InterruptedException {
		System.out.println(application.getRealPath("/temp"));
		Thread.sleep(10000);
		ModelAndView mav = new ModelAndView("t_expr");
		System.out.println("파일정보====================");
		System.out.println(f.toString());
		System.out.println(f.getContentType());
		System.out.println(f.getName());
		System.out.println(f.getOriginalFilename());
		System.out.println(f.getSize());
		System.out.println(f.isEmpty());
		//transferTo(File f)...실제 업로드.getInputStream()
		
		System.out.println("profilePostHandle.."+param);
		mav.addObject("section", "my/profile");
		return mav;
	}

	@GetMapping("/info")
	public String infoHandle(Model model, HttpSession session) {
		Map map = (Map) session.getAttribute("auth");
		model.addAttribute("section", "my/info");
		return "t_expr";
	}

	@PostMapping("/info")
	public String infoPostHandle() {
		return "t_expr";
	}

}
