package crud;

import java.util.List;

import fileIO.FileIO;
import fileIO.FileIOInterface;
import juice.Juice;

public class FileCrud implements Lab2CrudInterface {
	
	FileIOInterface fio;
	
	public FileCrud() {
		this.fio = new FileIO();
	}

	@Override
	public List<Juice> readJuice() {
		return (List<Juice>) fio.loadFromFile();
	}

	@Override
	public void updateJuice(List<Juice> juice) {
		fio.saveToFile(juice);
	}

}
