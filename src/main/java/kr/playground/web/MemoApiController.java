package kr.playground.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.playground.service.MemoService;
import kr.playground.vo.MemoVO;

@RestController
@RequestMapping("/api/memos")
public class MemoApiController {

    @Resource(name = "memoService")
    private MemoService memoService;

    @GetMapping
    public List<MemoVO> list() {
        return memoService.selectMemoList();
    }
    
    @PostMapping
    public void insert (@RequestBody MemoVO memo){
    	memoService.insertMemo(memo.getTitle(), memo.getContent(), memo.getStatus());
    }
    
    @PutMapping("/{id}")
    public void update (@PathVariable int id, @RequestBody MemoVO memo) {
    	memoService.updateMemo(id, memo.getTitle(), memo.getContent(), memo.getStatus());
    }
    
    @DeleteMapping("/{id}")
    public void delete (@PathVariable int id) {
    	memoService.deleteMemo(id);
    }
}