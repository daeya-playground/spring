<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Memo 목록</title></head>
<body>
	<form action="${pageContext.request.contextPath}/memo/insert.do" method="post">
	  <input type="text" name="content" placeholder="새 메모" required />
	  <button type="submit">등록</button>
	</form>

    <h1>Memo 목록 (MyBatis)</h1>

    <c:choose>
        <c:when test="${empty memoList}">
            <p>메모가 없습니다.</p>
        </c:when>
        <c:otherwise>
            <ul>
                <c:forEach items="${memoList}" var="memo">
				    <li>${memo.id} : ${memo.content}
				    	<form action="${pageContext.request.contextPath}/memo/update.do" method="post">
						  <input type="hidden" name="id" value="${memo.id}" />
						  <input type="text" name="content" value="${memo.content}" />
						  <button type="submit">수정</button>
						</form>
						
						<form action="${pageContext.request.contextPath}/memo/delete.do" method="post"
						      onsubmit="return confirm('삭제할까요?');">
						  <input type="hidden" name="id" value="${memo.id}" />
						  <button type="submit">삭제</button>
						</form>
				    </li>
				</c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>
</body>
</html>