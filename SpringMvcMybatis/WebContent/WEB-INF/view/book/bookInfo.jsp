<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<title>book 정보 출력</title>

<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
	function selectData(){
			var sel= $("#book").val(); 
			var search = $("#search").val();
			//alert("sel: "+sel+" search: "+search);
	
			if(sel == 1){ //책 검색 
				$.ajax({
					type:"post"
					,url:"bookSearch.do"
					,data:"bname="+search
					,dataType:"json"})
					.done(function(args){
						var msg = "책 정보<br>";
						msg += "<table border='1'>";
						msg += "<tr bgcolor='#D9E5FF'><td>주문번호</td><td>책 이름</td><td>출판사</td><td>할인가</td></tr>";
						for(var i=0; i<args.length; i++){
							msg +="<tr>";
							msg +="<td>"+args[i].orderid+"</td>";
							msg +="<td>"+args[i].bname+"</td>";
							msg +="<td>"+args[i].publisher+"</td>";
							msg +="<td>"+args[i].saleprice+"</td>";
							msg +="</tr>";
							}
						msg +="</table>";
						$("#bookD").text("");
						$("#bookD").html(msg);

						}).fail(function(e){
							alert(e.responseText);
							});

			}else{ //고객검색

				$.ajax({
					type:"post"
					,url:"custSearch.do"
					,data:"name="+search
					,dataType:"json"})
					.done(function(args){
						var num = 0;
						var price = 0;
						var msg = "고객이 사간 책 정보<br>";
						msg += "<table border='1'>";
						msg += "<tr bgcolor='#FFB2D9'><td>사간 날</td><td>책 이름</td><td>출판사</td><td>가격</td></tr>";
						for(var i=0; i<args.length; i++){
							msg +="<tr>";
							msg +="<td>"+args[i].orderdate+"</td>";
							msg +="<td>"+args[i].bname+"</td>";
							msg +="<td>"+args[i].publisher+"</td>";
							msg +="<td>"+args[i].saleprice+"</td>";
							msg +="</tr>";
							num += 1;
							price += args[i].saleprice;
							}
						msg +="</table>";
						msg +="<br>고객님의 총 구매가격은 "+price+"원이고 구매건수는 "+num+"회 입니다.";
						$("#bookD").text("");
						$("#bookD").html(msg);

						}).fail(function(e){
							alert(e.responseText);
							});
			}
		}
</script>

</head>
<body>

<select id="book" name="book">
	<option vlaue="">검색어</option>
	<option value="1">책이름</option>
	<option value="2">고객이름</option>
</select>
<input type="text" id="search" name="search"/>
<input type="button" value="검색" onclick="selectData()">
<hr>
<div id="bookD">
</div>
<%


%>
</body>
</html>