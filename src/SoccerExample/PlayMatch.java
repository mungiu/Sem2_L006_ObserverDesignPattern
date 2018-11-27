package SoccerExample;

import SoccerExample.Observables.SoccerMatch;
import SoccerExample.Observers.*;

public class PlayMatch
{
	public static void main(String[] s)
	{
		SoccerTeam team1 = new SoccerTeam("Dream Team");
		SoccerTeam team2 = new SoccerTeam("Old Boys");

		Fan fan1 = new Fan(team1);
		Fan fan2 = new Fan(team1);
		Fan fan3 = new Fan(team1);
		Fan fan4 = new Fan(team2);

		AngryCoach coach1 = new AngryCoach(team1);
		AngryCoach coach2 = new AngryCoach(team2);

		SoccerMatch match = new SoccerMatch(team1, team2);
		MatchOverview matchOverview = new MatchOverview();

		Commentator comm = new Commentator(team1, team2);
		SoccerWebPage reportPage = new SoccerWebPage(team1, team2);
		BetDotCom bettingPage = new BetDotCom(team1, team2);


		match.addObserver(comm);
		match.addObserver(reportPage);
		match.addObserver(bettingPage);
		match.addObserver(fan1, fan2, fan3, fan4);
		match.addObserver(coach1, coach2);
		match.addObserver(matchOverview);

//		match.addCommentator(comm);
//		match.addWebPage(reportPage);
//		match.addBetPage(bettingPage);
//		match.addFans(fan1, fan2, fan3, fan4);
//		match.addAngryCoaches(coach1, coach2);

		System.out.println("Match starting \n\n");

		for (int i = 0; i < 90; i++)
		{

			int rand = (int) (Math.random() * 100);
			double nr = Math.random();
			// score goal
			if (rand < 8)
				match.teamScore(nr > 0.50 ? team1 : team2);
			else // penalty
				if (rand >= 8 && rand < 12)
					match.roughTackle(nr > 0.50 ? team1 : team2);

			try
			{
				Thread.sleep(100);
			}
			catch (InterruptedException e)
			{
				break;
			}
		}

		System.out.println("\n\nMatch ended, bets not accepted anymore");
	}

}
