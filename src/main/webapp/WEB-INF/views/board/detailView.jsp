<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script src="https://code.jquery.com/jquery-3.5.1.js"  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>

	<script>
	
		var titleFlag = false;
		var contentsFlag = false;
	
		$(document).ready(function(){
			// 수정버튼 클릭
			$('#updateBtn').click(function(){
				
				var title = $.trim($('#txtBoardTitle').val());
				$('#txtBoardTitle').val(title);
				
				var contents = $.trim($('#txtBoardContents').val());
				$('#txtBoardContents').val(contents);
				
				if(title == null || title == ""){
					alert('제목을 입력하세요');
					$('#txtBoardTitle').focus();
					return;
				}else{
					titleFlag = true;
				}

				if(contents == null || contents == ""){
					alert('내용을 입력하세요');
					$('#txtBoardContents').focus();
					return;
				}else{
					contentsFlag = true;
				}
				
				if(title && contents){
					clickUpdateBtn();
				}				
			});
			
			// 삭제버튼 클릭
			$('#deleteBtn').click(function(){
				var delFlag = confirm("삭제하시겠습니까?");
				
				if(delFlag == true){
					clickDeleteBtn();
					$('#detailFrm').attr("action","/board/list");
					$('#detailFrm').attr("method","get");
					$('#detailFrm').submit();
				}else{
					return;
				}
			});
			
			$('#listBtn').click(function(){
				$('#detailFrm').attr("action","/board/list");
				$('#detailFrm').attr("method","get");
				$('#detailFrm').submit();
			});
			
		});// jquery 초기 셋팅
		
		function clickUpdateBtn(){
			$.ajax({
				type:'POST',
				url:'/board/updateProc',
				data:$('#detailFrm').serialize(),
				success: function(data){
			    	if(data == 0){
			    		alert('수정에 실패하였습니다.');
			    	}else if(data == -1){
			    		alert('수정 도중 장애가 발생하였습니다.');
			    	}else {
			    		alert('수정에 성공하였습니다');
			    		detailFrm.action = "/board/detail";
			    		detailFrm.method = "GET";
			    		detailFrm.submit();
			    	}
				},
				error: function(err){
					alert('통신 도중 장애가 발생하였습니다');
				}
			});
		}// clickUpdateBtn end
		
		function clickDeleteBtn(){
			$.ajax({
				type:'POST',
				url:'/board/deleteProc',
				data:$('#detailFrm').serialize(),
				success: function(data){
			    	if(data == 0){
			    		alert('삭제에 실패하였습니다.');
			    	}else if(data == -1){
			    		alert('삭제 도중 장애가 발생하였습니다.');
			    	}else {
			    		alert('삭제에 성공하였습니다');
			    		detailFrm.action = "/board/list";
			    		detailFrm.method = "GET";
			    		detailFrm.submit();
			    	}
				},
				error: function(err){
					alert('통신 도중 장애가 발생하였습니다');
				}
			});
		}// clickDeleteBtn end
	</script>
</head>
<body>
<h2>DETAIL VIEW11</h2>

	<div>
		<form id="detailFrm" method="post">
			<input type="hidden" name="boardSeq" value="${board.boardSeq}"> 
			<label>제목</label>
			<input type="text" name="boardTitle" id="txtBoardTitle" maxlength="50" value="${board.boardTitle}">
			<br>
			<label>작성자</label>
			<input type="text" name="boardWriter" id="txtBoardWriter" maxlength="25" value="${board.boardWriter}" readonly="readonly">
			<br>
			<label>작성일</label>
			<c:out value="${board.boardRegDate}"></c:out>
			<br>
			<textarea rows="20" cols="100" id="txtBoardContents" name="boardContents" maxlength="600">${board.boardContents}</textarea>
		</form>
		
		<button id="updateBtn">수정</button>
		<button id="deleteBtn">삭제</button>
		<button id="listBtn">목록</button>
	</div>

</body>
</html>