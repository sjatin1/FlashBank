<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<!DOCTYPE html>
<html>
<head>
<%@ page import = "java.util.List" %>
<%@ page import="perfios.pojo.Transact" %>
<%@ page import="perfios.pojo.Services" %>
<meta charset="UTF-8">
<title>Transaction details</title>
</head>
<body>
<form>
<center>
	<h1 align="center">Transaction History</h1>
	<span class="btn"><button class="btn-primary" onclick="ExportToExcel('xlsx')">DOWNLOAD</button></span><br><br>
	<%      
			String accno = (String) session.getAttribute("acc");
			List<Transact> list= Services.tran_hist(accno); 
			 out.print("<table id='tran_table' width='100%'");  
		        
		        out.print("<tr><th>Amount</th><th>Transaction Type</th><th>Transaction Id</th><th>Transaction Time</th><th></tr>");  
		       for (Transact c : list){
		         out.print("<tr><td>"+c.getAmt()+"</td><td>"+c.getTran_type()+"</td><td>"+c.getTran_id()+"</td><td>"+c.getTran_time()+"</td><td></tr>");    
		       }
		         out.print("</table>");  
		          

		out.println("<br><br><p align='center'> <a href = 'dashboard.jsp'> Go back </a></p><br><br>");

	%>
	
	
		
	</center>
	</form>
			<script type="text/javascript" src="https://unpkg.com/xlsx@0.15.1/dist/xlsx.full.min.js"></script>
<script type="text/javascript">
	function ExportToExcel(type, fn, dl) {
	    var elt = document.getElementById('tran_table');
	    var wb = XLSX.utils.table_to_book(elt, { sheet: "sheet1" });
	    return dl ?
	    	XLSX.write(wb, { bookType: type, bookSST: true, type: 'base64' }):
	      	XLSX.writeFile(wb, fn || ('Transactions.' + (type || 'xlsx')));
	}
</script>
	
	
	

</body>
</html>