package SoccerExample.Observers;

import SoccerExample.Observable;
import SoccerExample.Observer;
import SoccerExample.SoccerMatchInfo;

public class ScoreBoard implements Observer
{
	private int currentScoreT1;
	private int currentScoreT2;

	public ScoreBoard()
	{
		currentScoreT1 = 0;
		currentScoreT2 = 0;
	}

	@Override
	public void notify(Observable obs, Object arg)
	{
		SoccerMatchInfo info = (SoccerMatchInfo) arg;
		currentScoreT1 = info.team1Score;
		currentScoreT2 = info.team2Score;
		System.out.println("\nThe score is: " +
				"\nFor " + info.team1.getName() + " : " + currentScoreT1 +
				"\nFor " + info.team2.getName() + " : " + currentScoreT2 + "\n");
	}
}
