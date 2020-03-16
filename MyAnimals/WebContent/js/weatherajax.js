


$(function() {
	$("#weaview").click(function() {
		var url = "weather";//서블릿 이름
		var code = $("#address option :selected").val();
		
		$.ajax({
			type : "GET",
			url : url + "?code=" + code,//서블릿으로 간다.
			dataType : "text",
			success : function(msg) {
				var tmp = $.trim(msg);//trim(msg)문자열 좌우에서 공백 제거
				//JSON.parse():문자열을 자바 스크립트 객체로 변환하여 반환.
				//JSON.stringify():인수로 전달 받은 자바스크립트 객체를 문자열로 변환하여 반환.
				var obj = JSON.parse(tmp);
				
				

				$("#pubDate").val(obj.pubDate);
				$("#temp").val(obj.temp);
				$("#x").val(obj.x);
				$("#y").val(obj.y);
				$("#reh").val(obj.reh);
				$("#pop").val(obj.pop);
				$("#wfKor").val(obj.wfKor);

				var condition = obj.wfKor;
				
				

			},
			error : function() {
				alert("data load failed");
			}
		})
	})
})