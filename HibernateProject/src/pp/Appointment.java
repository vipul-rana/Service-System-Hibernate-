package pp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="appointment")
public class Appointment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer appno;
	
	@ManyToOne(targetEntity=User.class, cascade=CascadeType.ALL)
	@JoinColumn(name="uid", referencedColumnName="uid")
	private User uid;
	
	@ManyToOne(targetEntity=Worker.class, cascade=CascadeType.ALL)
	@JoinColumn(name="wid", referencedColumnName="wid")
	private Worker wid;
	
	private String date;
	private String time;
	private String address;
	private String work;
	private String status;
	private String workstatus;
	public Integer getAppno() {
		return appno;
	}
	public void setAppno(Integer appno) {
		this.appno = appno;
	}
	public User getUid() {
		return uid;
	}
	public void setUid(User uid) {
		this.uid = uid;
	}
	public Worker getWid() {
		return wid;
	}
	public void setWid(Worker wid) {
		this.wid = wid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getWorkstatus() {
		return workstatus;
	}
	public void setWorkstatus(String workstatus) {
		this.workstatus = workstatus;
	}
}