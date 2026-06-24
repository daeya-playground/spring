<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Memo 목록</title></head>
<body>
    <h1>Memo 목록 (MyBatis)</h1>

    <c:choose>
        <c:when test="${empty memoList}">
            <p>메모가 없습니다.</p>
        </c:when>
        <c:otherwise>
            <ul>
                <c:forEach items="${memoList}" var="memo">
				    <li>${memo.ID} : ${memo.CONTENT}</li>
				</c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>
</body>
</html>