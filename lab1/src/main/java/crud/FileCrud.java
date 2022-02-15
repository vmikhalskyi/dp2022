package crud;

import fileIO.FileIO;
import fileIO.FileIOInterface;
import juice.Juice;

public class FileCrud implements Lab2CrudInterface {
	
	FileIOInterface fio;
	
	public FileCrud() {
		this.fio = new FileIO();
	}

	@Override
	public Juice readJuice() {
		return (Juice) fio.loadFromFile();
	}

	@Override
	public void updateJuice(Juice juice) {
		fio.saveToFile(juice);
	}

}
