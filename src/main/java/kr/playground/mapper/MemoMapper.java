package kr.playground.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.playground.vo.MemoVO;

@Mapper("memoMapper")
public interface MemoMapper {

//    List<Map<String, Object>> selectMemoList();
//    void insertMemo(Map<String, Object> param);
//    void updateMemo(Map<String, Object> param);
//    void deleteMemo(int id);
	
	List<MemoVO> selectMemoList();
    void insertMemo(MemoVO param);
    void updateMemo(MemoVO param);
    void deleteMemo(int id);
}