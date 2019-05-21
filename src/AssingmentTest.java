import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import com.nuriilengir.DynamicApproach.DynamicApproach;
import com.nuriilengir.GreedyApproach.GreedyApproach;
import com.nuriilengir.Model.Entity;

/**
 * @author Nuri Çilengir, Dokuz Eylül University, Dept. of Computer Engineering
 */
public class AssingmentTest {

	private static Scanner scanner;
	public static Scanner io;

	public static void main(String[] args) throws NumberFormatException, IOException {

		while (true) {
			io = new Scanner(System.in);
			Entity[] entities = new Entity[100];

			readFile(entities, "input.csv");
			System.out.println("\n----------------------------");
			System.out.println("(1) Dynamic Approach Solution");
			System.out.println("(2) Greedy Approach Solution");
			System.out.println("----------------------------");
			System.out.println("Please Enter Your Operation : ");
			int chooice = io.nextInt();
			if (chooice == 1 || chooice == 2) {
				System.out.println("Enter the amount to spend (X):");
				int totalCost = io.nextInt();
				System.out.println("Enter the number of the positions (N):");
				int numberOfPositions = io.nextInt();
				System.out.println("Enter the number of the available players for each position (K):");
				int playerCount = io.nextInt();
				Entity[] players = new Entity[numberOfPositions * playerCount];
				if (chooice == 1) {
					DynamicApproach dp = new DynamicApproach(entities, players, totalCost);
					dp.getEntities(players, numberOfPositions, playerCount);
					int dynamicSolver = dp.solveByDynamicProgramming(playerCount, numberOfPositions);
					System.out.println(dynamicSolver);
				} else if (chooice == 2) {
					GreedyApproach gp = new GreedyApproach(entities, players, totalCost);
					gp.getEntities(players, numberOfPositions, playerCount);
					gp.ssolveByGreedyApproach(playerCount, numberOfPositions);
				}
			} else {
				System.err.println("Please enter a valid value : ");
			}
		}
	}

	public static void readFile(Entity entities[], String fileName) {
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader("resources/" + fileName));
			scanner = new Scanner(input);
			int i = 0;
			while (scanner.hasNext()) {
				String[] entity = (String[]) scanner.nextLine().split(",");
				entities[i] = new Entity((String) entity[0], Integer.valueOf((String) entity[1]),
						Integer.valueOf((String) entity[2]), Integer.valueOf((String) entity[3]));
				i++;
			}
			Arrays.sort(entities, new Comparator<Entity>() {
				@Override
				public int compare(Entity arg0, Entity arg1) {
					return (int) (arg0.getPosition() - arg1.getPosition());
				}
			});
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
