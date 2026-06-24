package kr.playground.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.playground.service.MemoService;

@Controller
public class MemoController {

    @Resource(name = "memoService")
    private MemoService memoService;

    @RequestMapping(value = "/memo/list.do")
    public String memoList(Model model) {
        List<Map<String, Object>> list = memoService.selectMemoList();
        model.addAttribute("memoList", list);
        return "memo/list";
    }
}