package engine;

import java.io.Serializable;

public class StatusEffect implements Serializable
{
	public static final int HEALTH = 0;
	public static final int SPEED = 1;
	public static final int DEF = 2;
	public static final int STUN = 3;
	public static final int RAGE = 4;

	private int timeLeft;
	private int frequency;
	private int frequencyCounter;
	private double strength;
	private int type;
	private boolean multiplicative;

	public StatusEffect(int time, int freq, double strength, int type,
			boolean mult)
	{
		timeLeft = time;
		frequency = freq;
		frequencyCounter = (frequency == 0 ? 0 : 1);
		this.strength = strength;
		this.type = type;
		multiplicative = mult;
	}

	public int getTime()
	{
		return timeLeft;
	}

	public int getType()
	{
		return type;
	}

	public double getAbsStrength()
	{
		return strength;
	}

	public double getStrength()
	{
		return (frequencyCounter == 0 ? strength : (multiplicative ? 1 : 0));
	}

	public void elapseTime()
	{
		if (timeLeft > 0)
		{
			timeLeft--;
		}
		if (frequencyCounter == 0)
			frequencyCounter = frequency;
		if (frequency != 0)
			frequencyCounter--;
	}
}