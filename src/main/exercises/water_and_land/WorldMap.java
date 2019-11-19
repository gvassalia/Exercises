package exercises.water_and_land;

import java.util.ArrayList;
import java.util.List;

public class WorldMap {
		private boolean[][] map;
		
		List<Continent> continentSet;
		List<Coordinates> islandSet;
		
		public WorldMap() {
			continentSet = new ArrayList<Continent>();
			islandSet = new ArrayList<Coordinates>();
		}
		
		public WorldMap(boolean[][] map) {
			this();
			
			if (map == null) {
				throw new IllegalArgumentException("WorldMap cannot be null");
			}
			
			this.map = map;
			
			build();
		}
		
		public WorldMap(int[][] map) {
			this();
			
			if (map == null) {
				throw new IllegalArgumentException("WorldMap cannot be null");
			}
			
			this.map = new boolean [map.length][map[0].length];
			
			for (int i = 0; i < map.length; i++) {
				for (int ii = 0; ii < map[i].length; ii++) {
					if (map[i][ii] == 1) {
						this.map[i][ii] = true;
					}
				}	
			}
			
			build();
		}
		
		public int getArea() {
			return  map.length * map[0].length;
		}
		
		public int getWaterArea() {
			return getArea() - getContinentArea() - getIslandArea();
		}
		
		public int getContinentArea() {
			int area = 0;
			
			for (Continent continent : continentSet) {
				area += continent.size();
			}
			
			return area;
		}
		
		public int getIslandArea() {
			return islandSet.size();
		}
		
		public List<Continent> getContinents() {
			return continentSet;
		}
		
		public List<Coordinates> getIslands() {
			return islandSet;
		}
		
		private void build() {
			List<Continent> islandSet = new ArrayList<Continent>();
			List<Continent> continentSetToMerge = new ArrayList<Continent>();
			
			for (int i = 0; i < map.length; i++) {
				for (int ii = 0; ii < map[i].length; ii++) {
					if (map[i][ii]) {
						islandSet.add(new Continent(new Coordinates(ii, i, true)));
						continentSetToMerge.add(new Continent(new Coordinates(ii, i, true)));
					}
				}	
			}
			
			if (continentSetToMerge.size() <= 1) {
				return;
			}
			
			List<Continent> mergedContinentSet = continentSetToMerge;
			
			int mergeIdx = 0;
			
			while (mergedContinentSet.size() > 1) {
				Continent first = mergedContinentSet.remove(mergeIdx);
				continentSetToMerge = mergedContinentSet;
				
				mergedContinentSet = new ArrayList<Continent>();
				
				mergedContinentSet.add(first);
				
				if (!merge(mergedContinentSet, continentSetToMerge)) {
					mergeIdx++;
					
					break;
				}
				
				mergeIdx = 0;
			}
			
			for (Continent continentOrIsland : mergedContinentSet) {
				if (continentOrIsland.size() > 1) {
					this.continentSet.add(continentOrIsland);
					
					continue;
				}
			}
			
			MAIN_LOOP: for (Continent continentOrIsland : mergedContinentSet) {
				if (continentOrIsland.size() > 1) {
					continue;
				}
				
				for (Continent continent : continentSet) {
					if (continent.contains(continentOrIsland.get().get(0))) {
						continue MAIN_LOOP;
					}
				}
				
				this.islandSet.add(continentOrIsland.get().get(0));
			}
		}
		
		private boolean merge(List<Continent> mergedContinentSet, List<Continent> continentSetToMerge) {
			boolean modified = false;
			
			for (Continent continentToMerge : continentSetToMerge) {
				boolean merged = false;
				
				for (Continent continent : mergedContinentSet) {
					merged = continent.merge(continentToMerge);

					if (merged) {
						modified = true;
						break;
					}
				}
				
				if (!merged) {
					mergedContinentSet.add(continentToMerge);
				}
			}
			
			return modified;
		}
	}