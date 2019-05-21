package com.nuriilengir.GreedyApproach;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.nuriilengir.Model.Entity;

public class GreedyApproach {
	private Entity[] entities;
	private Entity[] players;
	private int maxCost;

	public GreedyApproach(Entity[] entities, Entity[] players, int maxCost) {
		this.entities = entities;
		this.players = players;
		this.maxCost = maxCost;
	}

	public void ssolveByGreedyApproach(int PLAYER_COUNT, int PLAYER_POSITION) {
		Arrays.sort(players);
		int totalRate = 0;
		boolean[] position = new boolean[11];
		for (int i = 0; i < 11; i++) {
			if (i != 0 && i < PLAYER_POSITION) {
				position[i] = false;
			} else {
				position[i] = true;
			}
		}
		ArrayList<Entity> takenItems = new ArrayList<Entity>();
		for (int i = 0; i < players.length; i++) {
			if (maxCost - players[i].getPrice() >= 0) {
				if (players[i].getPosition() <= PLAYER_POSITION && position[players[i].getPosition()] == false
						&& takenItems.size() <= PLAYER_COUNT) {
					takenItems.add(players[i]);
					position[players[i].getPosition()] = true;
					maxCost -= players[i].getPrice();
					totalRate += players[i].getPrice();
				}
			} else {
				break;
			}
		}
		System.out.println(totalRate);
		System.out.println(takenItems.toString());
	}

	
	public void getEntities(Entity players[], int positionRange, int playerCount) {
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
