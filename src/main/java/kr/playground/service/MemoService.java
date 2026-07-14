package kr.playground.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.playground.exception.MemoNotFoundException;
import kr.playground.exception.MemoValidationException;
import kr.playground.mapper.MemoMapper;
import kr.playground.vo.MemoVO;
import kr.playground.vo.MemoPageVO;

@Service("memoService")
public class MemoService {

    @Resource(name = "memoMapper")
    private MemoMapper memoMapper;

    public MemoPageVO selectMemoPage(String status, String keyword, String sort, String order, int page, int size) {
    	MemoVO param = new MemoVO();
        param.setStatus(status);
        param.setKeyword(keyword);
        param.setSort(resolveSort(sort));
        param.setOrder(resolveOrder(order));
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

    public MemoVO selectMemo(int id) {
        MemoVO memo = memoMapper.selectMemoById(id);
        if (memo == null) {
            throw new MemoNotFoundException("메모를 찾을 수 없습니다");
        }
        return memo;
    }

    public void insertMemo(String title, String content, String status) {
        validateTitle(title);
        MemoVO memo = new MemoVO();
    	memo.setTitle(title);
    	memo.setContent(content);
    	memo.setStatus(status);
    	memoMapper.insertMemo(memo);
    }
    
    public void updateMemo(int id, String title, String content, String status) {
        validateTitle(title);
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
    

    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new MemoValidationException("title은 필수입니다");
        }
    }

    private String resolveSort(String sort) {
        return "createdAt".equals(sort) ? "createdAt" : "id";
    }

    private String resolveOrder(String order) {
        return "desc".equalsIgnoreCase(order) ? "desc" : "asc";
    }
}