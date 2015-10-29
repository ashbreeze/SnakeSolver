package ashbreeze.snakesolver.block;

public class BlockDirection {
	
	private int x;
	private int y;
	private int z;
	
	public BlockDirection(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
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

	public BlockDirection copy() {
		return new BlockDirection(this.x, this.y, this.z);
	}

	public BlockDirection rotate90(int x, int y) {
		if (this.x != 0) {
			this.x = 0;
			this.y = x;
			this.z = y;
		} else if (this.y != 0) {
			this.y = 0;
			this.x = x;
			this.z = y;
		} else if (this.z != 0) {
			this.z = 0;
			this.x = x;
			this.y = y;
		}
		
		return this;
	}
	
}
