package ashbreeze.snakesolver.constraint;

import ashbreeze.snakesolver.block.BlockLocation;

public class CubeConstraint extends Constraint {

	private int size;
	
	public CubeConstraint(int size) {
		this.size = size;
	}
	
	@Override
	public boolean withinConstraint(BlockLocation location) {
		if (location.x() < 0 || location.x() > (this.size - 1)) {
			return false;
		}
		
		if (location.y() < 0 || location.y() > (this.size - 1)) {
			return false;
		}
		
		if (location.z() < 0 || location.z() > (this.size - 1)) {
			return false;
		}
		
		return true;
	}

}
