<%@page import="pp.User"%>
<jsp:useBean id="ud" class="pp.UserDao"></jsp:useBean>
<jsp:useBean id="u" class="pp.User"></jsp:useBean>
<%
	String uid=request.getParameter("uid");
	String oldpwd=request.getParameter("oldPassword");
	String newpwd=request.getParameter("newPassword");
	String confirm=request.getParameter("confirmPassword");
	
	boolean i=ud.search(uid, oldpwd);
	
	if(i)
	{
		if(oldpwd.equals(newpwd))
		{
			out.println("<script>window.alert('Your Old Password and New Password Cannot be same!!!');</script>");
			out.println("<script>window.location.href='UpdatePassword.jsp';</script>");
		}
		else if(!newpwd.equals(confirm))
		{
			out.println("<script>window.alert('Password Mismatch!!!');</script>");
			out.println("<script>window.location.href='UpdatePassword.jsp';</script>");
		}
		else
		{
			User s=new User();
			s.setUid(uid);
			s.setPassword(newpwd);
			int j=ud.updatePassword(s);
			if(j>0)
			{
				out.println("<script>window.alert('Password Changed');</script>");
				out.println("<script>window.location.href='index2.jsp';</script>");
			}
		}
	}
	else
	{
		out.println("<script>window.alert('Wrong Password!!!');</script>");
		out.println("<script>window.location.href='UpdatePassword.jsp';</script>");
	}
%>