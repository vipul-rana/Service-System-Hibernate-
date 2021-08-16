package pp;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

public class AppDao 
{
	public Session session;
	public Session getSession()
	{
		return new AnnotationConfiguration().configure().buildSessionFactory().openSession();
	}
	
	public int addUser(Appointment a)
	{
		session =getSession();
		int i= (int) session.save(a);
		session.beginTransaction().commit();
		session.close();
		return i;
	}
	
	public List<Appointment> showRequests(int wid)
	{
		session =getSession();
		Appointment a=new Appointment();
		Worker w=(Worker) session.get(Worker.class, new Integer(wid));
		Criteria cr =session.createCriteria(Appointment.class);
		cr.add(Restrictions.eq("wid", w));
		List<Appointment> al= cr.list();		
		return al;		
		
		/*
		con=getCon();
		String qr="select * from appointment where workerid="+wid;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(qr);
		ArrayList<Appointment> al=new ArrayList<Appointment>(); 
		while(rs.next())
		{
			Appointment a=new Appointment();
			a.setAppno(rs.getInt("appno"));
			a.setUid(rs.getString("userid"));
			a.setWid(rs.getInt("workerid"));
			a.setDate(rs.getString("bookingdate"));
			a.setTime(rs.getString("timeslot"));
			a.setAddress(rs.getString("address"));
			a.setWork(rs.getString("workdesc"));
			a.setStatus(rs.getString("status"));
			a.setWorkstatus(rs.getString("workstatus"));
			al.add(a);
		}
		return al;
		*/
	}
	
	public int update(Appointment ab)
	{
		session=getSession();
		Query qr=session.createQuery("update Appointment set status=? where appno=?");
		qr.setParameter(0, ab.getStatus());
		qr.setParameter(1, ab.getAppno());
		int i=qr.executeUpdate();
		session.beginTransaction().commit();
		session.close();
		return i;
	}
	
	public int updateWork(Appointment ab)
	{
		session=getSession();
		Query qr=session.createQuery("update Appointment set workstatus=? where appno=?");
		qr.setParameter(0, ab.getWorkstatus());
		qr.setParameter(1, ab.getAppno());
		int i=qr.executeUpdate();
		session.beginTransaction().commit();
		session.close();
		return i;
	}
}