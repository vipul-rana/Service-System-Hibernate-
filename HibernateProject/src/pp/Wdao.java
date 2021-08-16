package pp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

public class Wdao 
{
	Session session;
	public Session getSession()
	{
		return new AnnotationConfiguration().configure().buildSessionFactory().openSession();
	}
	public int addWorker(Worker w)
	{
		session=getSession();
		int i= (int) session.save(w);
		session.beginTransaction().commit();
		session.close();
		return i;
	}
	
	public List<Worker> search(String category, String location)
	{
		session=getSession();
		Criteria cr=session.createCriteria(Worker.class);
		cr.add(Restrictions.like("category", category+"%"));
		cr.add(Restrictions.like("location", location+"%"));
		List<Worker> al=cr.list();
		return al;
	}
	
	public List<Worker> search1(int wid)
	{
		session=getSession();
		Criteria cr=session.createCriteria(Worker.class);
		cr.add(Restrictions.eq("wid", wid));
		List<Worker> al= cr.list();
		return al;
	}
	
	public List<Worker> profile(String email)
	{
		session=getSession();
		Criteria cr=session.createCriteria(Worker.class);
		cr.add(Restrictions.eq("email", email));
		List<Worker> al= cr.list();
		return al;
	}
	
	public List<User> uprofile(String uid)
	{
		session=getSession();
		Criteria cr=session.createCriteria(User.class);
		cr.add(Restrictions.eq("uid", uid));
		List<User> al= cr.list();
		return al;
	}
	
	public int updateWorker(Worker w)
	{
		session=getSession();
		Query qr=session.createQuery("update Worker set wname=?, contact=?, category=?, location=?, address=?, services=?, charges=? where wid=?");
		qr.setParameter(0, w.getWname());
		qr.setParameter(1, w.getContact());
		qr.setParameter(2, w.getCategory());
		qr.setParameter(3, w.getLocation());
		qr.setParameter(4, w.getAddress());
		qr.setParameter(5, w.getServices());
		qr.setParameter(6, w.getCharges());
		qr.setParameter(7, w.getWid());
		int i=qr.executeUpdate();
		session.beginTransaction().commit();
		session.close();
		return i;
		
		/*
		con=getCon();
		String qr="update workers set name=?, contact=?, category=?, location=?, address=?, services=?, charges=? where id=?";
		ps=con.prepareStatement(qr);
		ps.setString(1, w.getName());
		ps.setInt(2, w.getContact());
		ps.setString(3, w.getCategory());
		ps.setString(4, w.getLocation());
		ps.setString(5, w.getAddress());
		ps.setString(6, w.getServices());
		ps.setInt(7, w.getCharges());
		ps.setInt(8, w.getId());
		return ps.executeUpdate();
		*/
	}
	
}