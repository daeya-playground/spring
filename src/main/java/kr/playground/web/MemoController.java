package kr.playground.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.playground.service.MemoService;
import kr.playground.vo.MemoVO;

@Controller
public class MemoController {

    @Resource(name = "memoService")
    private MemoService memoService;

    @RequestMapping(value = "/memo/list.do")
    public String memoList(Model model) {
        List<MemoVO> list = memoService.selectMemoList();
        model.addAttribute("memoList", list);
        return "memo/list";
    }
    
    @RequestMapping("/memo/insert.do")
    public String insert(@RequestBody MemoVO memo) {
    	memoService.insertMemo(memo.getTitle(), memo.getContent(), memo.getStatus());
        return "redirect:/memo/list.do";
    }
    @RequestMapping("/memo/update.do")
    public String update(@RequestParam int id, @RequestBody MemoVO memo) {
    	memoService.updateMemo(id, memo.getTitle(), memo.getContent(), memo.getStatus());
        return "redirect:/memo/list.do";
    }
    @RequestMapping("/memo/delete.do")
    public String delete(@RequestParam int id) {
        memoService.deleteMemo(id);
        return "redirect:/memo/list.do";
    }
}