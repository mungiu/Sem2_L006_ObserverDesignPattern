package SoccerExample.Observers;

import SoccerExample.Observable;
import SoccerExample.Observer;
import SoccerExample.SoccerMatchInfo;
import SoccerExample.SoccerTeam;

public class Fan implements Observer
{
	private SoccerTeam teamCheersFor;
	private int team1ScoreMemory;
	private int team2ScoreMemory;
	private int tackledT1CountMemory;
	private int tackledT2CountMemory;

	public Fan(SoccerTeam soccerTeam)
	{
		teamCheersFor = soccerTeam;
		team1ScoreMemory = 0;
		team2ScoreMemory = 0;

		tackledT1CountMemory = 0;
		tackledT2CountMemory = 0;
	}

	@Override
	public void notify(Observable obs, Object arg)
	{
		SoccerMatchInfo info = (SoccerMatchInfo) arg;
		boolean cheersForTeam1 = info.team1 == teamCheersFor;
		boolean cheersForTeam2 = info.team2 == teamCheersFor;

		if (cheersForTeam1)
		{
			boolean friendlyScores = info.team1Score > team1ScoreMemory;
			boolean enemyScores = info.team2Score > team2ScoreMemory;
			boolean friendlyGotTackled = info.team1RoughTackle > tackledT1CountMemory;

			// fan behaviour when teams score
			if (friendlyScores)
				System.out.println("Fan: GOOOOOOAAAALLL!!!! for " + teamCheersFor.getName());
			else if (enemyScores)
				System.out.println("Fan: BUUUUUH!");

			// fan behaviour when friendly is tackled
			if (friendlyGotTackled)
				System.out.println("Fan: Stop tackling the " + info.team1.getName());
		}
		else if (cheersForTeam2)
		{
			boolean friendlyScores = info.team2Score > team2ScoreMemory;
			boolean enemyScores = info.team1Score > team1ScoreMemory;
			boolean friendlyGotTackled = info.team2RoughTackle > tackledT2CountMemory;

			// fan behaviour when teams score
			if (friendlyScores)
				System.out.println("Fan: GOOOOOOAAAALLL!!!! for " + teamCheersFor.getName());
			else if (enemyScores)
				System.out.println("Fan: BUUUUUH!");

			// fan behaviour when friendly is tackled
			if (friendlyGotTackled)
				System.out.println("Fan: Stop tackling the " + info.team2.getName());
		}

		// fan updates memory with new info
		team1ScoreMemory = info.team1Score;
		team2ScoreMemory = info.team2Score;
		tackledT1CountMemory = info.team1RoughTackle;
		tackledT2CountMemory = info.team2RoughTackle;
	}
}
