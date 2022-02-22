package juice;

import java.io.Serializable;

public class Juice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int id;
	String title;
	String descr;
	String img;
	
	public Juice() {
		
	}

	public Juice(int id, String title, String descr, String img) {
		super();
		this.id = id;
		this.title = title;
		this.descr = descr;
		this.img = img;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
