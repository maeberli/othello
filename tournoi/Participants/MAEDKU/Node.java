package Participants.MAEDKU;

import Othello.Move;
import java.util.List;

public class Node
{
	private Grid grid;
	private Cell.Owner owner;
	
	public Node(Grid grid, Cell.Owner owner)
	{
		this.grid = grid;
		this.owner = owner;
	}
	
	public int eval()
	{
		return 0;
	}
	
	public boolean isGameOver()
	{
		return ops().size() == 0;
	}
	
	public List<Move> ops()
	{
		return grid.getPossibleTurns(owner);
	}
	
	public Node apply(Move move)
	{
		Grid newGrid = this.grid.copyOf();
		newGrid.addTurn(move, owner);
		return new Node(newGrid, owner == Cell.Owner.RED ? Cell.Owner.BLUE : Cell.Owner.RED );
	}
}