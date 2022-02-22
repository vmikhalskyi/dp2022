package crud;

import java.util.List;

import juice.Juice;

public interface Lab2CrudInterface {
	public List<Juice> readJuice();
	public void updateJuice(List<Juice> juice);

}
