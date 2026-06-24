package kr.playground.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.playground.service.PlaygroundService;

@Controller
public class PlaygroundController {
	
	@Resource(name = "playgroundService")
	private PlaygroundService playgroundService;
	
	@RequestMapping(value = "/playground.do")
	public String hello(Model model) {
		model.addAttribute("message", playgroundService.getMessage());
		model.addAttribute("count", playgroundService.getCount());
		return "playground/playground";
	}
}
