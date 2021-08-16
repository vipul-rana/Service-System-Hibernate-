package pp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

public class UserDao 
{
	Session session;
	public Session getSession()
	{
		return new AnnotationConfiguration().configure().buildSessionFactory().openSession();
	}
	public String addUser(User u)
	{
		session=getSession();
		String i=(String) session.save(u);
		session.beginTransaction().commit();
		session.close();
		return i;
	}
	
	public boolean search(String uid, String password)
	{
		session=getSession();
		boolean flag=false;
		User x=(User) session.get(User.class, new String(uid));
		if(x!=null)
		{
			String a=x.getUid();
			String b=x.getPassword();
			if(a.equals(uid) && b.equals(password))
				flag=true;
		}
		session.close();
		return flag;
	}
	
	
	public User search1(String uid)
	{
		session=getSession();
		User x=(User) session.get(User.class, new String(uid));
		session.close();
		return x;
	}
	
	public int updateName(User u)
	{
		session=getSession();
		Query qr=session.createQuery("update User set name=? where uid=?");
		qr.setParameter(0, u.getName());
		qr.setParameter(1, u.getUid());
		int i=qr.executeUpdate();
		session.beginTransaction().commit();
		session.close();
		return i;
	}
	
	public int updatePassword(User u)
	{
		session=getSession();
		Query qr=session.createQuery("update User set password=? where uid=?");
		qr.setParameter(0, u.getPassword());
		qr.setParameter(1, u.getUid());
		int i=qr.executeUpdate();
		session.beginTransaction().commit();
		session.close();
		return i;
	}
	
	public List<Appointment> showBookings(String uid)
	{
		session=getSession();
		Appointment a=new Appointment();
		User u=(User) session.get(User.class, new String(uid));
		Criteria cr=session.createCriteria(Appointment.class); 
		cr.add(Restrictions.eq("uid" , u));
		List<Appointment> al= cr.list();		
		return al;		
	}
}
