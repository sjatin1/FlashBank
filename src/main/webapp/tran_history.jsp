<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page import = "java.util.List" %>
<%@ page import="perfios.pojo.Transact" %>
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
<title>Transaction History</title>
</head>

<body>

<form>
<center>
	<h1 align="center">ALL Transactions</h1>
	<span class="btn"><button class="btn-primary" onclick="ExportToExcel('xlsx')">DOWNLOAD</button></span><br><br>
	
	<%
	   List<Transact> list=Services.getTran_History();  
    
    out.print("<table id = 'tran_table' width='100%'");  
    
    out.print("<tr><th>Accno</th><th>Transaction Type</th><th>Transaction ID</th><th>Transaction Time</th><th>Amt</th></tr>");  
   
    for(Transact e:list)
    {  
     out.print("<tr><td>"+e.getAccno()+"</td><td>"+e.getTran_type()+"</td><td>"+e.getTran_id()+"</td><td>"+e.getTran_time()+"</td><td>"+e.getAmt()+"</td></tr>");  
    }  
    out.print("</table>");  
	%>
	<br><a href = "admin.jsp"> Go back </a><br><br>
		
	</center>
	</form>
	
		<script type="text/javascript" src="https://unpkg.com/xlsx@0.15.1/dist/xlsx.full.min.js"></script>
<script type="text/javascript">
	function ExportToExcel(type, fn, dl) {
	    var elt = document.getElementById('tran_table');
	    var wb = XLSX.utils.table_to_book(elt, { sheet: "sheet1" });
	    return dl ?
	    	XLSX.write(wb, { bookType: type, bookSST: true, type: 'base64' }):
	      	XLSX.writeFile(wb, fn || ('AllTransactions.' + (type || 'xlsx')));
	}
</script>

</body>
</html>