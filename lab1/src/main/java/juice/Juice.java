package juice;

public class Juice {
	private String title;
	private String descr;
	private String img;

	public Juice(String title, String descr, String img) {
		super();
		this.title = title;
		this.descr = descr;
		this.img = img;
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
		return "{\"title\": \""+title+"\", \"descr\": \""+descr+"\", \"img\": \""+img+"\"}";
	}
}
