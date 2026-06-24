package kr.playground.service;

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
}