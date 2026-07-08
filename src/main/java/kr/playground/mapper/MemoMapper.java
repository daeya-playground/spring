package kr.playground.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.playground.vo.MemoVO;

@Mapper("memoMapper")
public interface MemoMapper {
	
	List<MemoVO> selectMemoList(MemoVO param);
	int selectMemoCount(MemoVO Param);
    void insertMemo(MemoVO param);
    void updateMemo(MemoVO param);
    void deleteMemo(int id);
    
}