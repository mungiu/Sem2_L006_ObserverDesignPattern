package SoccerExample.Observers;

import SoccerExample.Observable;
import SoccerExample.Observer;
import SoccerExample.SoccerMatchInfo;
import SoccerExample.SoccerTeam;

public class Commentator implements Observer
{

	private SoccerMatchInfo lastInfo;

	public Commentator(SoccerTeam team1, SoccerTeam team2)
	{
		lastInfo = new SoccerMatchInfo();
		lastInfo.team1 = team1;
		lastInfo.team2 = team2;
	}

	@Override
	public void notify(Observable obs, Object arg)
	{
		SoccerMatchInfo info = (SoccerMatchInfo) arg;

		if (info.team1RoughTackle > lastInfo.team1RoughTackle)
			System.out.println(info.team1.getName() + " gets a penalty!");
		else if (info.team2RoughTackle > lastInfo.team2RoughTackle)
			System.out.println(info.team2.getName() + " gets a penalty!");
		else if (info.team1Score > lastInfo.team1Score)
			System.out.println(info.team1.getName() + " scooooores!");
		else if (info.team2Score > lastInfo.team2Score)
			System.out.println(info.team2.getName() + " scooooores!");

		lastInfo = info;
	}
}
