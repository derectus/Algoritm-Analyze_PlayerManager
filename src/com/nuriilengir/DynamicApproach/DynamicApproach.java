package com.nuriilengir.DynamicApproach;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nuriilengir.Model.Entity;

public class DynamicApproach {
	private Entity[] entities;
	private Entity[] players;
	private int maxCost;

	public DynamicApproach(Entity[] entities, Entity[] players, int totalCost)
			throws NumberFormatException, IOException {
		this.entities = entities;
		this.players = players;
		this.maxCost = totalCost;
	}

	public int solveByDynamicProgramming(int PLAYER_COUNT, int PLAYER_POSITION)
			throws ArithmeticException, ArrayIndexOutOfBoundsException {
		int PLAYER_LENGHT = players.length;
		int[][] matrix = new int[PLAYER_LENGHT + 1][maxCost + 1];
		int m = 0;
		for (int i = 1; i <= PLAYER_LENGHT; i++) {
			for (int j = 1; j <= maxCost; j++) {
				if (players[i - 1].getPrice() <= j) {
					matrix[i][j] = Math.max(matrix[i - 1][j],
							matrix[m][j - players[i - 1].getPrice()] + players[i - 1].getRating());
				} else {
					matrix[i][j] = matrix[i - 1][j];
				}
			}
			if (i % PLAYER_POSITION == 0 & i < PLAYER_LENGHT) {
				m += PLAYER_POSITION;

			}
		}
		int result = matrix[PLAYER_LENGHT][maxCost];
		int price = maxCost;
		List<Entity> takenPayers = new ArrayList<Entity>();
		System.out.println(result);
		int y = 0, cont = 0;
		for (int x = PLAYER_LENGHT; x > 0; x--) {
			if (result != matrix[x - 1][price] && cont == 0) {
				takenPayers.add(y++, players[x - 1]);
				result -= players[x - 1].getRating();
				price -= players[x - 1].getPrice();
				cont++;
			} else if (result != matrix[x - 1][price]
					&& takenPayers.get(y - 1).getPosition() != players[x - 1].getPosition() && cont != 0) {
				takenPayers.add(y++, players[x - 1]);
				result -= players[x - 1].getRating();
				price -= players[x - 1].getPrice();
			}
		}

		for (int i = 0; i < takenPayers.size(); i++) {
			System.out.println(takenPayers.get(i));
		}
		System.out.println("Cost : "+ (maxCost - price ));
		return matrix[PLAYER_LENGHT][maxCost];
	}

	public void getEntities(Entity players[], int positionRange, int playerCount) throws ArrayIndexOutOfBoundsException {
		int controlCount = 0, lastPlayerPosition = 0, controlPlayerCount = 0;
		for (int i = 0; i < entities.length; i++) {
			if (positionRange != 1 && lastPlayerPosition != positionRange + 1) {
				if (controlCount != playerCount) {
					players[controlPlayerCount++] = entities[i];
					lastPlayerPosition = entities[i].getPosition();
					controlCount++;
					if (playerCount == 10 && controlCount == 10) {
						controlCount = 0;
						lastPlayerPosition++;
					}
				} else if (lastPlayerPosition == entities[i].getPosition()) {
					if (lastPlayerPosition != entities[i + 1].getPosition()) {
						controlCount = 0;
						lastPlayerPosition++;
					}
					continue;
				}
			}
		}
	}

	public void printArray(Entity[] players) {
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null) {
				System.out.println(players[i].toString());
			}
		}
	}

}
