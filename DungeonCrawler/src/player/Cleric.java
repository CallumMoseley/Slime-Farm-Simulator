package player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import world.Room;

public class Cleric extends Player {
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect((int) getPos().getX(), (int) getPos().getY(), 32, 32);
	}

	@Override
	public boolean attack(Point p, Room r)
	{
		return super.attack(p, r);
	}

	@Override
	public void ability1(Point p, Room r)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ability2(Point p, Room r)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ability3(Point p, Room r) {
		// TODO Auto-generated method stub
		
	}
}