<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List View</title>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>


	<script>
		$(document).ready(function(){
			$('#insertBtn').click(function(){
				location.href = '/board/insertView';
			});//insertBtn event
			
			$('#searchBtn').click(function(){
	    		searchFrm.action = '/board/list';
	    		searchFrm.submit();
			});//searchBtn event
		});
	</script>
</head>
<body>

	<h2>Board List View</h2>
	
	<form name="searchFrm" id="searchFrm">
		<select name="searchOption" id="searchOption">
			<option value="all" <c:if test="${search.searchOption=='all'}">selected</c:if>>전체</option>
			<option value="boardTitle" <c:if test="${search.searchOption=='boardTitle'}">selected</c:if>>제목</option>
			<option value="boardContents" <c:if test="${search.searchOption=='boardContents'}">selected</c:if>>내용</option>
			<option value="boardWriter" <c:if test="${search.searchOption=='boardWriter'}">selected</c:if>>작성자</option>
		</select>
		<input type="text" name="keyword" id="keyword" value="${search.keyword}"> 
	</form>
	<button id="searchBtn">검색</button>
	
	<table>
		<thead>
			<tr>
				<th>bno</th>
				<th>title</th>
				<th>writer</th>
				<th>count</th>
				<th>regdate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="list">
				<tr>
					<td><c:out value="${list.boardSeq}"></c:out> </td>
					<td><a href='/board/detail?boardSeq=${list.boardSeq}'>${list.boardTitle}</a></td>
					<td><c:out value="${list.boardWriter}"></c:out> </td>
					<td><c:out value="${list.boardCnt}"></c:out> </td>
					<td><c:out value="${list.boardRegDate}"></c:out> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br>
	<c:if test="${pageMaker.prev}">
		<a href="/board/list?page=${pageMaker.startPage -1}&searchOption=${search.searchOption}&keyword=${search.keyword}">이전</a>
	</c:if>
	
	<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="page">
		<a href="/board/list?page=${page}&searchOption=${search.searchOption}&keyword=${search.keyword}">${page}</a>
	</c:forEach>
	
	<c:if test="${pageMaker.next}">
		<a href="/board/list?page=${pageMaker.endPage +1}&searchOption=${search.searchOption}&keyword=${search.keyword}">다음</a>
	</c:if>
	<br>
	<button id="insertBtn">글쓰기</button>	
</body>
</html>