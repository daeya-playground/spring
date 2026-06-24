package kr.playground.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("memoMapper")
public interface MemoMapper {

    List<Map<String, Object>> selectMemoList();
}