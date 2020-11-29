<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Insert View11</title>

	<script src="https://code.jquery.com/jquery-3.5.1.js"  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>

	<script>
		var titleFlag = false;
		var contentsFlag = false;
	
		$(document).ready(function(){
			$('#submitBtn').click(function(){
				
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
					insertBoard();
				}
			});
			
			$('#listBtn').click(function(){
				location.href = '/board/list';
			});
		}); 
		
		function insertBoard(){
			$.ajax({
			    type: 'POST',
			    url:'/board/insertProc', 			//	request 보낼 서버의 경로
    			data: $('#submitFrm').serialize(),
			    success: function(data) {
			    	var msg = data;
			    	console.log(msg);
			    	
			    	if(msg == 0){
			    		alert('등록에 실패하였습니다.');
			    	}else if(msg == -1){
			    		alert('등록 도중 장애가 발생하였습니다.');
			    	}else {
			    		alert('등록에 성공하였습니다');
			    		location.href='/board/list';
			    	}
			    },
			    error: function(err) {
					alert('통신 도중 장애가 발생하였습니다');
			    }
			});

		}
		
	</script>
</head>
<body>
	<div>
		<h2>insert View</h2>
	</div>
	
	<div>
		<form id="submitFrm" action="/board/insertProc" method="post">
			<label>제목</label>
			<input type="text" name="boardTitle" id="txtBoardTitle" maxlength="50">
			<br>
			<label>작성자</label>
			<input type="text" name="boardWriter" id="txtBoardWriter" maxlength="25">
			<br>
			<textarea rows="20" cols="100" id="txtBoardContents" name="boardContents" maxlength="600"></textarea>
		</form>
		<button id="submitBtn">등록</button>
		<button id="listBtn">목록</button>
	</div>
</body>
</html>