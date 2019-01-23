<%-- 
<script type="text/javascript">

/* 	/* 컨트롤러로 부터 전송받은 파일이 이미지 파일인지 확인하는 함수
	function checkImageType(fileName){
		var pattern = /jpg$|gif$|png$|jpeg$/i;
		return fileName.match(pattern);
	}//checkImageType
	
	//이미지 원본 링크 제공
	function getImageLink(fileName){
		
		if(!checkImageType(fileName)){
			return;
		}//if
		
		var front = fileName.substr(0, 12);
		var end = fileName.substr(14);
		
		return front + end;
		
	}//getImageLink */
</script>
<style type="text/css">
.fileDrop {
	width: 100%;
	height: 200px;
	border: 1px dotted blue;
}

small {
	margin-left: 3px;
	font-weight: bold;
	color: gray;
}
</style>
</head>
<body>
	<h2>ajax 업로드</h2>
	<form id="fileForm" action="fileUpload.do" method="post"
		enctype="multipart/form-data">
		<div class="box-body">
				<input type="file" id="fileUp" name="fileUp"><br>
				<br> <input type="button" class="btn btn-info btn-sm"
					value="전송" onclick="fileSubmit();">
		</div>
	</form>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
    function fileSubmit() {
        var formData = new FormData($("#fileForm")[0]);
        $.ajax({
            type : 'post',
            url : 'profFileUpload.do',
            data : formData,
            processData : false,
            contentType : false,
            success : function(html) {
                alert("파일 업로드하였습니다.");
            },
            error : function(error) {
                alert("파일 업로드에 실패하였습니다.");
                console.log(error);
                console.log(error.status);
            }
        });
    }
</script>
</head>
     <form id="fileForm" action="profFileUpload" method="post"
        enctype="multipart/form-data">
        <input type="hidden" id="mem_id" name="mem_id" value=" ${mem_id }">
        <input type="file" id="fileUp" name="fileUp">         
        <input type="button" class="btn btn-info btn-sm" value="전송" onClick="fileSubmit();">
    </form>
 
