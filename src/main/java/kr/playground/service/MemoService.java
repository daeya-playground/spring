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
    
    public void insertMemo(String content) {
        MemoVO memo = new MemoVO();
    	memo.setContent(content);
    	memoMapper.insertMemo(memo);
    }
    
    public void updateMemo(int id, String content) {
    	MemoVO memo = new MemoVO();
    	memo.setId(id);
    	memo.setContent(content);
    	memoMapper.updateMemo(memo);
    }
    
    public void deleteMemo(int id) {
    	memoMapper.deleteMemo(id);
    }
}