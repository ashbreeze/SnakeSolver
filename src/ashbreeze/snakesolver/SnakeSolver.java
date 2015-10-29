package ashbreeze.snakesolver;

import java.util.ArrayList;
import java.util.Collections;

import ashbreeze.snakesolver.block.Block;
import ashbreeze.snakesolver.block.BlockDirection;
import ashbreeze.snakesolver.block.BlockLocation;
import ashbreeze.snakesolver.block.BlockTypeEnum;
import ashbreeze.snakesolver.constraint.Constraint;

public class SnakeSolver {
	
	private ArrayList<BlockTypeEnum> blockTypes = new ArrayList<BlockTypeEnum>();
	private Constraint constraint;
	
	private ArrayList<BlockLocation> solution = new ArrayList<BlockLocation>();
	private boolean solved;
	

	public SnakeSolver(ArrayList<BlockTypeEnum> blockTypes, Constraint constraint) {
		this.blockTypes = blockTypes;
		this.constraint = constraint;
	}
	
	public void solve() {
		for (Block block: nextBlocks(new Block(BlockTypeEnum.END, new BlockLocation(-1, 0, 0), new BlockDirection(1, 0, 0), null), blockTypes)) {
			this.solution.add(block.getLocation());
		}
		
		Collections.reverse(this.solution);
		
		this.solution.remove(0);
		
		if (!this.solution.isEmpty()) {
			this.solved = true;
		}
	}
	
	private ArrayList<Block> nextBlocks(Block startingBlock, ArrayList<BlockTypeEnum> blockTypes) {
		ArrayList<Block> blocks = new ArrayList<Block>();
		
		for (BlockLocation l: startingBlock.getNextLocations()) {
			if (!this.constraint.withinConstraint(l)) {
				continue;
			}
			
			boolean bad = false;
			
			for (BlockLocation l2: startingBlock.getPreviousBlockLocations()) {
				if (l.matches(l2)) {
					bad = true;
					break;
				}
			}
			
			if (bad) {
				continue;
			}
			
			Block block = new Block(blockTypes.get(0), l, startingBlock.getLocation().directionTo(l), startingBlock);
			
			ArrayList<BlockTypeEnum> cleanedBlockTypes = new ArrayList<BlockTypeEnum>();
			
			cleanedBlockTypes.addAll(blockTypes);
			
			cleanedBlockTypes.remove(0);
			
			if (cleanedBlockTypes.isEmpty()) {
				return startingBlock.getPreviousBlocks();
			}
			
			blocks.addAll(nextBlocks(block, cleanedBlockTypes));
		}
		
		return blocks;
	}

	public boolean isSolved() {
		return this.solved;
	}

	public ArrayList<BlockLocation> getSolution() {
		return this.solution;
	}
	
}