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
		        event.preventDefault();
		        
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
			
	        var formData = new FormData(); 
	        formData.append("BoardTitle", $('#txtBoardTitle').val()); 
	        formData.append("boardWriter", $('#boardWriter').val()); 
	        formData.append("BoardContents", $('#txtBoardContents').val()); 
	        formData.append("uploadFile", $("input[name=uploadFile]")[0].files[0]);

			$.ajax({
			    type: 'POST',
			    url:'/board/insertProc', 			//	request 보낼 서버의 경로
	            processData: false,
	            contentType: false,

    			data: formData,
    				//$('#submitFrm').serialize(),
			
			    success: function(data) {
			    	var msg = data;
			    	console.log("data : "+ msg);
			    	
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
		<form id="submitFrm" action="/board/insertProc" method="post" enctype="multipart/form-data">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="orange" witdh="70">제목</td>
				<td align="left"><input type="text" name="boardTitle" id="txtBoardTitle"></td>
			</tr>
			<tr>
				<td bgcolor="orange">작성자</td>
				<td align="left"><input type="text" name="boardWriter" id="boardWriter" size="10"></td>
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td align="left">
				<textarea rows="10" cols="40" id="txtBoardContents" name="boardContents" maxlength="600"></textarea>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">업로드</td>
				<td align="left"><input type="file" name="uploadFile" id="uploadFile"></td>
			</tr>
		</table>
			<input type="submit" id="submitBtn" value="새글 등록">
			<button id="listBtn">목록</button>
		</form>
	</div>
</body>
</html>