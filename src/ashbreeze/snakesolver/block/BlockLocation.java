package ashbreeze.snakesolver.block;

public class BlockLocation {
	
	private int x;
	private int y;
	private int z;
	
	public BlockLocation(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public BlockLocation copy() {
		return new BlockLocation(this.x, this.y, this.z);
	}

	public BlockLocation shiftInDirection(BlockDirection direction) {
		this.x += direction.x();
		this.y += direction.y();
		this.z += direction.z();
		
		return this;
	}
	
	public int x() {
		return this.x;
	}
	
	public int y() {
		return this.y;
	}
	
	public int z() {
		return this.z;
	}
	
	public BlockDirection directionTo(BlockLocation l) {
		return new BlockDirection(l.x() - this.x, l.y() - this.y, l.z() - this.z);
	}
	
	public boolean matches(BlockLocation location) {
		return location.x() == this.x && location.y() == this.y && location.z() == this.z;
	}
	
	@Override
	public String toString() {
		return this.x + " " + this.y + " " + this.z;
	}
	
}
