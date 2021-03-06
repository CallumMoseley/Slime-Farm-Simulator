package enemy;

import java.awt.Graphics;

import engine.AABB;
import engine.Stats;
import engine.damage.MeleeEnemyDamageSource;
import utility.SpriteSheet;
import utility.Vector2D;
import world.Room;

/**
 * Fast but weak melee slime
 *
 * @author Alexander Shah
 * @version Jun 15, 2016
 */
public class GreenSlime extends Slime
{
	private int movementCounter;
	private Vector2D slideDir;

	public GreenSlime(int x, int y)
	{
		super(x, y);

		setStats(new Stats(25, 100, 100, 100, 10.0));
		movementCounter = (int) (Math.random() * 150);
		slideDir = new Vector2D();
	}

	/**
	 * Adds the slime's hitbox to its room
	 * @param r the room where the slime is
	 */
	public void addDamage(Room r)
	{
		setDamageSource(new MeleeEnemyDamageSource(getHitbox(), 5, 10, getID()));
		super.addDamage(r);
	}

	@Override
	/**
	 * Updates the slime's state
	 * @param l the room where the slime is
	 */
	public void update(Room l)
	{
		if (movementCounter == 0)
		{
			movementCounter = (int) (Math.random() * 60 + 30);
			setSpeed(new Vector2D());
		}
		else
		{
			movementCounter--;
			if (movementCounter == 30)
			{
				slideDir = EnemyAttackPatterns.runTowardsPlayer(l, getPos());
				slideDir.multiplyBy(3.5);
			}
			if (movementCounter < 30)
			{
				setSpeed(slideDir);
			}
		}

		super.update(l);
	}

	@Override
	public int getWidth()
	{
		return SpriteSheet.ENEMIES[1].getWidth(null);
	}

	@Override
	public int getHeight()
	{
		return SpriteSheet.ENEMIES[1].getHeight(null);
	}

	@Override
	public void draw(Graphics g, Vector2D offset)
	{
		Vector2D shifted = getPos().add(offset);
		g.drawImage(SpriteSheet.ENEMIES[1], (int) shifted.getX()
				- getWidth() / 2, (int) shifted.getY() - getHeight() / 2, null);

		drawEntityDetails(g, offset);
	}

}
