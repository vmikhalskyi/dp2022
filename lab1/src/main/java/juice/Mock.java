package juice;

import java.util.ArrayList;
import java.util.List;

public class Mock {

	private List<Juice> juiceList = new ArrayList<>();
	
	public Mock() {
		this.juiceList.add(new Juice(0, "Apple juice", "Super duper juice", "http://surl.li/blayq"));
		this.juiceList.add(new Juice(1, "Orange juice", "Very delicious juice", "http://surl.li/blayc"));
		this.juiceList.add(new Juice(2, "Watermelon juice", "Made from watermelons", "http://surl.li/blayr"));
	}

	public List<Juice> getJuiceList() {
		return juiceList;
	}

	public void setJuiceList(List<Juice> juiceList) {
		this.juiceList = juiceList;
	}
	
	
}
