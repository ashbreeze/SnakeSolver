package ashbreeze.snakesolver.example;

import java.util.ArrayList;

import ashbreeze.snakesolver.SnakeSolver;
import ashbreeze.snakesolver.block.BlockLocation;
import ashbreeze.snakesolver.block.BlockTypeEnum;
import ashbreeze.snakesolver.constraint.CubeConstraint;

public class Example1 {

	public static void main(String[] args) {
		
		ArrayList<BlockTypeEnum> blockTypes = new ArrayList<BlockTypeEnum>();
		
		blockTypes.add(BlockTypeEnum.END);
		blockTypes.add(BlockTypeEnum.STRAIGHT);
		blockTypes.add(BlockTypeEnum.CORNER);
		blockTypes.add(BlockTypeEnum.CORNER);
		blockTypes.add(BlockTypeEnum.CORNER);
		blockTypes.add(BlockTypeEnum.STRAIGHT);
		blockTypes.add(BlockTypeEnum.CORNER);
		blockTypes.add(BlockTypeEnum.CORNER);
		blockTypes.add(BlockTypeEnum.STRAIGHT);
		blockTypes.add(BlockTypeEnum.CORNER);
		blockTypes.add(BlockTypeEnum.CORNER);
		blockTypes.add(BlockTypeEnum.CORNER);
		blockTypes.add(BlockTypeEnum.STRAIGHT);
		blockTypes.add(BlockTypeEnum.CORNER);
		blockTypes.add(BlockTypeEnum.STRAIGHT);
		blockTypes.add(BlockTypeEnum.CORNER);
		blockTypes.add(BlockTypeEnum.CORNER);
		blockTypes.add(BlockTypeEnum.CORNER);
		blockTypes.add(BlockTypeEnum.CORNER);
		blockTypes.add(BlockTypeEnum.STRAIGHT);
		blockTypes.add(BlockTypeEnum.CORNER);
		blockTypes.add(BlockTypeEnum.STRAIGHT);
		blockTypes.add(BlockTypeEnum.CORNER);
		blockTypes.add(BlockTypeEnum.STRAIGHT);
		blockTypes.add(BlockTypeEnum.CORNER);
		blockTypes.add(BlockTypeEnum.STRAIGHT);
		blockTypes.add(BlockTypeEnum.END);
		
		SnakeSolver snakeSolver = new SnakeSolver(blockTypes, new CubeConstraint(3));
		
		snakeSolver.solve();
		
		if (snakeSolver.isSolved()) {
			System.out.println("Solution found:");
			
			for (BlockLocation location: snakeSolver.getSolution()) {
				System.out.println(location.toString());
			}
		} else {
			System.out.println("No solution found :(");
		}
	}
	
}
