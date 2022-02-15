package fileIO;

import juice.Juice;

public class Main {

	public static void main(String[] args) {
		
		Juice juice = new Juice("Apple juice", "A type of fruit juice that is made from the pulp of apples processed for their juice. It is a very clear liquid from which the pulp has been removed. This juice is often used to flavor meats, or as an ingredient in dressings and sauces, adding a sweet apple flavor.", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Apple_juice_with_3apples.jpg/220px-Apple_juice_with_3apples.jpg");

		FileIOInterface fio = new FileIO();
		
		fio.saveToFile(juice);
		
		System.out.println((Juice) fio.loadFromFile());
	}

}
