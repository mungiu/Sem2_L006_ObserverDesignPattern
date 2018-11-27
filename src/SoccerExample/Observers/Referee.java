package SoccerExample.Observers;

import SoccerExample.Observable;
import SoccerExample.Observer;
import SoccerExample.SoccerMatchInfo;

public class Referee implements Observer
{
	private int tackledT1CountMemory;
	private int tackledT2CountMemory;

	public Referee()
	{
		tackledT1CountMemory = 0;
		tackledT2CountMemory = 0;
	}

	@Override
	public void notify(Observable obs, Object arg)
	{
		SoccerMatchInfo info = (SoccerMatchInfo) arg;

		// NOTE: Using modulo to make a condition take place every second time
		if (info.team1RoughTackle > tackledT1CountMemory)
		{
			if (tackledT1CountMemory % 2 == 1)
				System.out.println("Referee: Yellow card for " + info.team2.getName());
			if (tackledT1CountMemory % 2 == 0)
				System.out.println("Referee: Red card for the ... team2" + info.team2.getName());
		}

		// NOTE: Using modulo to make a condition take place every second time
		if (info.team2RoughTackle > tackledT2CountMemory)
		{
			if (tackledT1CountMemory % 2 == 1)
				System.out.println("Referee: Yellow card for the ... team2" + info.team1.getName());
			if (tackledT1CountMemory % 2 == 0)
				System.out.println("Referee: Red card for the ... team2" + info.team1.getName());
		}
	}
}
