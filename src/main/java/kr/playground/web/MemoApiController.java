package kr.playground.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.playground.service.MemoService;
import kr.playground.vo.MemoPageVO;
import kr.playground.vo.MemoVO;

@RestController
@RequestMapping("/api/memos")
public class MemoApiController {

    @Resource(name = "memoService")
    private MemoService memoService;

    @GetMapping
    public MemoPageVO list(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String order,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {
        return memoService.selectMemoPage(status, keyword, sort, order, page, size);
    }

    @GetMapping("/{id}")
    public MemoVO get(@PathVariable int id) {
        return memoService.selectMemo(id);
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