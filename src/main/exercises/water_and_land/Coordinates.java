package exercises.water_and_land;

public class Coordinates {
		private int x;
		private int y;
		private boolean island;
		
		public Coordinates() {
		}
		
		public Coordinates(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Coordinates(int x, int y, boolean island) {
			this(x, y);
			
			this.island = island;
		}
		
		public void setX(int arg) {
			x = arg;
		}
		
		public int getX() {
			return x;
		}
		
		public void setY(int arg) {
			y = arg;
		}
		
		public int getY() {
			return y;
		}
		
		public boolean island() {
			return island;
		}
		
		public boolean isNeighbor(Coordinates coordinates) {
			if (isNeighborX(coordinates) && isNeighborY(coordinates)) {
				return true;
			}
			
			return false;
		}
		
		public boolean isNeighborX(Coordinates coordinates) {
			if (this.x == coordinates.x) {
				return true;
			}
			
			if (this.x == (coordinates.x - 1)) {
				return true;
			}
			
			if (this.x == (coordinates.x + 1)) {
				return true;
			}
			
			return false;
		}
		
		public boolean isNeighborY(Coordinates coordinates) {
			if (this.y == coordinates.y) {
				return true;
			}
			
			if (this.y == (coordinates.y - 1)) {
				return true;
			}
			
			if (this.y == (coordinates.y + 1)) {
				return true;
			}
			
			return false;
		}
		
		public boolean equals(Coordinates coordinates) {
			if (this.x == coordinates.x && this.y == coordinates.y) {
				return true;
			}
			
			return false;
		}
	}