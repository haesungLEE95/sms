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
<style type="text/css">
.filebox label {
	display: inline-block;
	padding: .5em .75em;
	color: #fff;
	font-size: inherit;
	line-height: normal;
	vertical-align: middle;
	background-color: #5cb85c;
	cursor: pointer;
	border: 1px solid #4cae4c;
	border-radius: .25em;
	-webkit-transition: background-color 0.2s;
	transition: background-color 0.2s;
}

.filebox label:hover {
	background-color: #6ed36e;
}

.filebox label:active {
	background-color: #367c36;
}

.filebox input[type="file"] {
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0;
}
</style>
</head>
<form id="fileForm" action="profFileUpload" method="post"
	enctype="multipart/form-data">
	<input type="hidden" id="mem_id" name="mem_id" value="${mem_id}">
	<div class="filebox">
		<label for="fileUp">프로필 업로드</label> <input type="file" id="fileUp"
			name="fileUp">
	</div>
	<input type="button" class="btn btn-info btn-sm" value="전송"
		onClick="fileSubmit();"> 파일 선택 후 전송을 눌러주세요
</form>

