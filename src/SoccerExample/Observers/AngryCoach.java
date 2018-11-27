package SoccerExample.Observers;

import SoccerExample.Observable;
import SoccerExample.Observer;
import SoccerExample.SoccerMatchInfo;
import SoccerExample.SoccerTeam;

public class AngryCoach implements Observer
{
	private SoccerTeam coachedTeam;
	private int coachedTeamScore;
	private int tackleT1CountMemory;
	private int tackleT2CountMemory;

	public AngryCoach(SoccerTeam soccerTeam)
	{
		coachedTeamScore = 0;
		tackleT1CountMemory = 0;
		tackleT2CountMemory = 0;
		coachedTeam = soccerTeam;
	}


	@Override
	public void notify(Observable obs, Object arg)
	{
		SoccerMatchInfo info = (SoccerMatchInfo) arg;
		boolean coachesTeam1 = info.team1 == coachedTeam;
		boolean coachesTeam2 = info.team2 == coachedTeam;

		if (coachesTeam1)
		{
			// coach behaviour when his team does not score
			if (coachedTeamScore == info.team1Score)
				System.out.println("Coach: Come on " + info.team1.getName() + " we need to score!");
			// coach behaviour when his team gets tackled
			if (tackleT1CountMemory < info.team1RoughTackle)
				System.out.println("Coach: Hey judge, please report what happened to player from team: " + info.team1.getName());
		}
		else if (coachesTeam2)
		{
			// coach behaviour when his team does not score
			if (coachedTeamScore == info.team2Score)
				System.out.println("Coach: Come on " + info.team2.getName() + " we need to score!");
			// coach behaviour when his team gets tackled
			if (tackleT2CountMemory < info.team2RoughTackle)
				System.out.println("Coach: Hey judge, please report what happened to player from team: " + info.team2.getName());
		}

		// coach memorizes new info about tackles
		tackleT1CountMemory = info.team1RoughTackle;
		tackleT2CountMemory = info.team2RoughTackle;
	}
}
