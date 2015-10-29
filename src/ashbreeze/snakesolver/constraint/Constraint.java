package ashbreeze.snakesolver.constraint;

import ashbreeze.snakesolver.block.BlockLocation;

public abstract class Constraint {

	public abstract boolean withinConstraint(BlockLocation location);
	
}
