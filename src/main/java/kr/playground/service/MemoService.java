package kr.playground.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.playground.mapper.MemoMapper;

@Service("memoService")
public class MemoService {

    @Resource(name = "memoMapper")
    private MemoMapper memoMapper;

    public List<Map<String, Object>> selectMemoList() {
        return memoMapper.selectMemoList();
    }
    
    public void insertMemo(String content) {
    	Map<String, Object> param = new HashMap<>();
    	param.put("content", content);
    	memoMapper.insertMemo(param);
    }
    
    public void updateMemo(int id, String content) {
    	Map<String, Object> param = new HashMap<>();
    	param.put("id", id);
    	param.put("content", content);
    	memoMapper.updateMemo(param);
    }
    
    public void deleteMemo(int id) {
    	memoMapper.deleteMemo(id);
    }
}