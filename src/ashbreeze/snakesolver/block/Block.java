package ashbreeze.snakesolver.block;

import java.util.ArrayList;

public class Block {
	
	private BlockTypeEnum type;
	private BlockLocation location;
	private BlockDirection direction;
	
	private Block previousBlock;
	
	public Block(BlockTypeEnum type, BlockLocation location, BlockDirection direction, Block previousBlock) {
		this.type = type;
		this.location = location;
		this.direction = direction;
		this.previousBlock = previousBlock;
	}
	
	public ArrayList<BlockLocation> getNextLocations() {
		ArrayList<BlockLocation> locations = new ArrayList<BlockLocation>();
		
		switch (this.type) {
			case END:
			case STRAIGHT:
				locations.add(this.location.copy().shiftInDirection(this.direction));
				
				break;
				
			case CORNER:
				locations.add(this.location.copy().shiftInDirection(this.direction.copy().rotate90(1, 0)));
				locations.add(this.location.copy().shiftInDirection(this.direction.copy().rotate90(-1, 0)));
				locations.add(this.location.copy().shiftInDirection(this.direction.copy().rotate90(0, 1)));
				locations.add(this.location.copy().shiftInDirection(this.direction.copy().rotate90(0, -1)));
				
				break;
		}
		
		return locations;
	}

	public BlockLocation getLocation() {
		return this.location;
	}

	public ArrayList<BlockLocation> getPreviousBlockLocations() {
		ArrayList<BlockLocation> locations = new ArrayList<BlockLocation>();
		
		for (Block b: this.getPreviousBlocks()) {
			locations.add(b.getLocation());
		}
		
		return locations;
	}

	public ArrayList<Block> getPreviousBlocks() {
		ArrayList<Block> blocks = new ArrayList<Block>();
		
		Block block = this;
		
		while (block != null) {
			blocks.add(block);
			
			block = block.getPreviousBlock();
		}
		
		return blocks;
	}
	
	private Block getPreviousBlock() {
		return this.previousBlock;
	}

}
