package engine.damage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import engine.AABB;
import utility.Constants;
import utility.SpriteSheet;
import utility.Vector2D;

/**
 * An arrow, fired by hunter
 * @author Callum
 *
 */
public class Arrow extends Projectile
{

	public Arrow(Vector2D pos, Vector2D dir, boolean player, long id)
	{
		super(new AABB(pos, SpriteSheet.PROJECTILES[4].getWidth(null),
				SpriteSheet.PROJECTILES[4].getHeight(null)), 0, -1, pos, dir
				.getNormalized().multiply(Constants.ARROW_SPEED), true, player,
				Constants.ARROW_DAMAGE, Constants.ARROW_KNOCKBACK, id);
	}

	@Override
	public void draw(Graphics g, Vector2D offset)
	{
		Vector2D shifted = getPosition().add(offset).subtract(
				getSpeed().getNormalized().multiply(32));
		AffineTransform af = new AffineTransform();
		af.rotate(-Math.toRadians(getSpeed().getAngle()), shifted.getX(),
				shifted.getY());
		af.translate(shifted.getX(), shifted.getY());
		((Graphics2D) g).drawImage(SpriteSheet.PROJECTILES[4], af, null);
	}
}