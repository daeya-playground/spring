package kr.playground.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.playground.mapper.MemoMapper;
import kr.playground.vo.MemoVO;
import kr.playground.vo.MemoPageVO;

@Service("memoService")
public class MemoService {

    @Resource(name = "memoMapper")
    private MemoMapper memoMapper;

    public MemoPageVO selectMemoPage(String status, String keyword, int page, int size) {
    	MemoVO param = new MemoVO();
        param.setStatus(status);
        param.setKeyword(keyword);
        param.setSize(size);
        param.setOffset((page - 1) * size);
        
        int total = memoMapper.selectMemoCount(param);
        List<MemoVO> items = memoMapper.selectMemoList(param);
        
        MemoPageVO result = new MemoPageVO();
        result.setItems(items);
        result.setTotal(total);
        result.setPage(page);
        result.setSize(size);
        return result;        
    }
    
    public void insertMemo(String title, String content, String status) {
        MemoVO memo = new MemoVO();
    	memo.setTitle(title);
    	memo.setContent(content);
    	memo.setStatus(status);
    	memoMapper.insertMemo(memo);
    }
    
    public void updateMemo(int id, String title, String content, String status) {
    	MemoVO memo = new MemoVO();
    	memo.setId(id);
    	memo.setTitle(title);
    	memo.setContent(content);
    	memo.setStatus(status);
    	memoMapper.updateMemo(memo);
    }
    
    public void deleteMemo(int id) {
    	memoMapper.deleteMemo(id);
    }
}