package org.itbank.controler;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.itbank.controler.MemberDaoMyBastis;

@Controller
public class joincontroller {
	@Autowired
	MemberDaoMyBastis memberDao;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinGetHandle() {
		return "join";
	}

	@PostMapping("/join")
	public String joinPostHandle(@RequestParam Map map, HttpSession session, Model model) {
		try {
			boolean b = memberDao.addOne(map);
			session.setAttribute("auth", "on");
			return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("temp", map);
			return "join";
		}
	}

	@PostMapping("/signup_check/{mode}")
	public String signupHandle() {
		return "";
	}
}
