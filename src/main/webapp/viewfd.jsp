<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page import = "java.util.List" %>
<%@ page import="perfios.pojo.FD_pojo" %>
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
<title>FD details</title>
</head>
<body>
<form>
<center>
	<h1 align="center">Fixed Deposit Details</h1>
	<span class="btn"><button class="btn-primary" onclick="ExportToExcel('xlsx')">DOWNLOAD</button></span><br><br>
	
	<%
	   String accno = (String) session.getAttribute("acc");
	   List<FD_pojo> list=Services.displayAll(accno);  
    
    out.print("<table id='viewfd' width='100%'");  
    
    out.print("<tr><th>Accno</th><th>FD Name</th><th>FD Amount</th><th>FD Time</th></tr>");  
   
    for(FD_pojo e:list)
    {  
     out.print("<tr><td>"+e.getAccno()+"</td><td>"+e.getFd_name()+"</td><td>"+e.getFd_amt()+"</td><td>"+e.getDt()+"</td></tr>");  
    }  
    out.print("</table>");  
      
	%>
	<br><br><span><a href = "Fixeddep.jsp"> Go back </a></span>
		
	</center>
	</form>
		
	<script type="text/javascript" src="https://unpkg.com/xlsx@0.15.1/dist/xlsx.full.min.js"></script>
<script type="text/javascript">
	function ExportToExcel(type, fn, dl) {
	    var elt = document.getElementById('viewfd');
	    var wb = XLSX.utils.table_to_book(elt, { sheet: "sheet1" });
	    return dl ?
	    	XLSX.write(wb, { bookType: type, bookSST: true, type: 'base64' }):
	      	XLSX.writeFile(wb, fn || ('Myfds.' + (type || 'xlsx')));
	}
</script>

</body>
</html>