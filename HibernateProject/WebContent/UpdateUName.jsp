<%@page import="pp.User"%>
<jsp:useBean id="ud" class="pp.UserDao"></jsp:useBean>
<%
	String uid=request.getParameter("uid");
	String name=request.getParameter("name");
	User u=new User();
	u.setUid(uid);
	u.setName(name);
	int i=ud.updateName(u);
	if(i>0)
	{
		out.println("<script>window.alert('Updated!!!');</script>");
		out.println("<script>window.location.href='index2.jsp';</script>");
	}
	else
	{
		out.println("<script>window.alert('Something Went Wrong!!!!');</script>");
		out.println("<script>window.location.href='index2.jsp';</script>");
	}
%>
