package misc;

public class TowerOfHanoi {

	public void createTower(char fromTower, char auxilaryTower, char toTower, int k) {
		if (k == 1) {
			System.out.println("moving plate 1 " + fromTower + " to " + toTower);
			return;
		}
		createTower(fromTower, toTower, auxilaryTower, k - 1);
		System.out.println("moving " + k + " plate from " + fromTower + " to " + toTower);
		createTower(auxilaryTower, fromTower, toTower, k - 1);
	}

	public static void main(String[] arg) {

		TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
		towerOfHanoi.createTower('A', 'B', 'C', 3);
	}
}
