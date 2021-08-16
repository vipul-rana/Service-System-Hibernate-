<%@page import="pp.Worker"%>
<%@page import="java.util.List"%>
<jsp:useBean id="wd" class="pp.Wdao"></jsp:useBean>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
<a href="index2.jsp"><button type="button" class="btn btn-default">Home</button></a>
  <table align="center" border="2px" class="table table-hover">
    

<center><h1>Worker Details</h1></center>

<%
	String ids=request.getParameter("wid");
	int wid=Integer.parseInt(ids);
	List<Worker> al=wd.search1(wid);
	int x=0;
	if(al.isEmpty())
		out.println("No data found");
	else
	{
		for(Worker w:al)
		{
			%>
			<tbody>	
			<tr><th>Worker Id:</th><td><%=w.getWid() %></td></tr>
			<tr><th>Name:</th><td><%=w.getWname() %></td></tr>
			<tr><th>Contact:</th><td><%=w.getContact() %></td></tr>
			<tr><th>Email:</th><td><%=w.getEmail() %></td></tr>
			<tr><th>Category:</th><td><%=w.getCategory() %></td></tr>
			<tr><th>Location:</th><td><%=w.getLocation() %></td></tr>
			<tr><th>Address:</th><td><%=w.getAddress() %></td></tr>
			<tr><th>Services:</th><td><%=w.getServices() %></td></tr>
			<tr><th>Charges:</th><td><%=w.getCharges() %></td></tr>
			</tbody>
			<%
			x=w.getWid();
		}
	}
%>
</table>
<%
	String id=(String)session.getAttribute("uemail"); 
	if(id==null)
	{
%>
		<center><a href="Ulogin.html"><button type="button" class="btn btn-primary btn-lg">Book Now</button></a></center>
<%
	}
	else
	{
%>
		<center><a href="Book.jsp?id=<%=x %>"><button type="button" class="btn btn-primary btn-lg">Book Now</button></a></center>
<%		
	}
%>