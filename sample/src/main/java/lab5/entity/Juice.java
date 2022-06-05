package lab5.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="juice")
public class Juice { 
	@Id
	@GeneratedValue
	Long id;
	String title;
    String descr;
	String img;
	
	public Juice() {
		
	}

	public Juice(Long id, String title, String descr, String img) {
		this.id = id;
		this.title = title;
		this.descr = descr;
		this.img = img;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	@Override
	public String toString() {
		return "{\"id\": "+id+", \"title\": \""+title+"\", \"descr\": \""+descr+"\", \"img\": \""+img+"\"}";
	}
}
