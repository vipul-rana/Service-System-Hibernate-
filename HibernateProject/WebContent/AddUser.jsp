<%@page import="pp.User"%>
<jsp:useBean id="ud" class="pp.UserDao"></jsp:useBean>
<jsp:useBean id="u" class="pp.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<%
	String uid=request.getParameter("uid");
	//User s=ud.search1(uid);
	//String xx=s.getUid();
	//out.println(xx);
	int x=0;
	/*
	if(x==1)
	{
		
	}*/
	try
	{
		String i=ud.addUser(u);
		out.println("<script>window.alert('Signed Up Succesfully!!!');</script>");
		out.println("<script>window.location.href='index.html';</script>");
	}
	catch(Exception e)
	{
		out.println("<script>window.alert('This email is already registered!!');</script>");
		out.println("<script>window.location.href='Ulogin.html';</script>");
	}
%>