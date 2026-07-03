package kr.playground.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.playground.mapper.MemoMapper;
import kr.playground.vo.MemoVO;

@Service("memoService")
public class MemoService {

    @Resource(name = "memoMapper")
    private MemoMapper memoMapper;

    public List<MemoVO> selectMemoList() {
        return memoMapper.selectMemoList();
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