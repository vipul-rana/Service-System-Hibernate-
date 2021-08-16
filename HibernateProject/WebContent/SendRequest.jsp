<%@page import="org.hibernate.cfg.AnnotationConfiguration"%>
<%@page import="org.hibernate.Session"%>
<%@page import="pp.Worker"%>
<%@page import="pp.User"%>
<jsp:useBean id="ad" class="pp.AppDao"></jsp:useBean>
<jsp:useBean id="a" class="pp.Appointment"></jsp:useBean>
<%
	String uid=request.getParameter("uid");
	String wi=request.getParameter("wid");
	int wid=Integer.parseInt(wi);
	String date=request.getParameter("date");
	String time=request.getParameter("time");
	String address=request.getParameter("address");
	String work=request.getParameter("work");
	String status=request.getParameter("status");
	String workstatus=request.getParameter("workstatus");
	
	Session session1=new AnnotationConfiguration().configure().buildSessionFactory().openSession();
	User u=(User)session1.get(User.class, new String(uid));
	Worker w=(Worker)session1.get(Worker.class, new Integer(wid));
	a.setUid(u);
	a.setWid(w);
	a.setDate(date);
	a.setTime(time);
	a.setAddress(address);
	a.setWork(work);
	a.setStatus(status);
	a.setWorkstatus(workstatus);
	
	int x=ad.addUser(a);
	if(x>0)
	{
		out.println("<script>window.alert('Request Sent!!!');</script>");
		out.println("<script>window.location.href='index2.jsp';</script>");
	}
	else
	{
		out.println("<script>window.alert('Something Went Wrong!!!!');</script>");
		out.println("<script>window.location.href='index2.jsp';</script>");
	}
%>