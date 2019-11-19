package exercises.water_and_land;

import java.util.ArrayList;
import java.util.List;

public class Continent {
		private List<Coordinates> coordinates;
		
		public Continent() {
			coordinates = new ArrayList<Coordinates>();
		}
		
		public Continent(Coordinates arg) {
			this();
			
			this.coordinates.add(arg);
		}
		
		public List<Coordinates> get() {
			return coordinates;
		}
		
		public boolean merge(Continent other) {
			if (!isNeighbor(other)) {
				return false;
			}
			
			for (Coordinates otherCoordinates : other.get()) {
				this.coordinates.add(new Coordinates(otherCoordinates.getX(), otherCoordinates.getY()));
			}
			
			return true;
		}
		
		public boolean contains(Coordinates newCoordinates) {
			for (Coordinates coordinates : coordinates) {
				if (coordinates.equals(newCoordinates)) {
					return true;
				}				
			}
			
			return false;
		}
		
		public boolean isNeighbor(Continent newContinent) {
			for (Coordinates newCoordinates : newContinent.get()) {
				if (isNeighbor(newCoordinates)) {
					return true;
				}
			}
			
			return false;
		}
		
		public boolean isNeighbor(Coordinates newCoordinates) {
			for (Coordinates coordinates : coordinates) {
				if (coordinates.isNeighbor(newCoordinates)) {
					return true;
				}				
			}
			
			return false;
		}
		
		public boolean add(Coordinates newCoordinates) {
			if (contains(newCoordinates)) {
				return false;
			}
			
			if (isNeighbor(newCoordinates)) {
				coordinates.add(new Coordinates(newCoordinates.getX(), newCoordinates.getY()));
				
				return true;
			}
			
			return false;
		}
		
		public int size() {
			return coordinates.size();
		}
	}