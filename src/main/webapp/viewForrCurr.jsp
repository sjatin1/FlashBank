<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page import = "java.util.List" %>
<%@ page import="perfios.pojo.Foreign_Exchange_pojo" %>
<%@ page import="perfios.pojo.Services" %>
<meta charset="UTF-8">
<style>
th, td {
 padding: 10px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}
.btn{
padding-left:1500px;
}
h1{
padding-top : 30px;
}
th {background-color: DarkTurquoise;}
td:hover {background-color: aqua;}
</style>
<link rel="stylesheet" href="style1.css">
<title>Foreign Currency</title>
</head>
<body>
<form>
<center>
	<h1 align="center">Foreign Currency Details</h1>
	<span class="btn"><button class="btn-primary" onclick="ExportToExcel('xlsx')">DOWNLOAD</button></span><br><br>
	
	<%
	   String accno = (String) session.getAttribute("acc");
	   List<Foreign_Exchange_pojo> list=Services.displayAllCurrencies(accno);  
    
    out.print("<table id='viewcurr' width='100%'");  
    
    out.print("<tr><th>Accno</th><th>Currency Type</th><th>Amount</th></tr>");  
   
    for(Foreign_Exchange_pojo e:list)
    {  
     out.print("<tr><td>"+e.getAccno()+"</td><td>"+e.getCurr_type()+"</td><td>"+e.getFor_curr()+"</td></tr>");  
    }  
    out.print("</table>");  
	%>
	<br><br><span><a href = "exchange.jsp"> Go back </a></span>
		
	</center>
	</form>
	
	<script type="text/javascript" src="https://unpkg.com/xlsx@0.15.1/dist/xlsx.full.min.js"></script>
<script type="text/javascript">
	function ExportToExcel(type, fn, dl) {
	    var elt = document.getElementById('viewcurr');
	    var wb = XLSX.utils.table_to_book(elt, { sheet: "sheet1" });
	    return dl ?
	    	XLSX.write(wb, { bookType: type, bookSST: true, type: 'base64' }):
	      	XLSX.writeFile(wb, fn || ('MyForeignCurrencies.' + (type || 'xlsx')));
	}
</script>

</body>
</html>