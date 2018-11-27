package SoccerExample.Observables;

import SoccerExample.Observable;
import SoccerExample.Observers.*;
import SoccerExample.SoccerMatchInfo;
import SoccerExample.SoccerTeam;

public class SoccerMatch implements Observable
{
	private SoccerTeam team1, team2;
	private Fan[] fans;

	private int scoreTeam1, scoreTeam2;
	private int roughTackleTeam1, roughTackleTeam2;

	private Commentator comm;
	private SoccerWebPage webPage;
	private BetDotCom betPage;
	private AngryCoach[] angryCoaches;
	private ScoreBoard scoreBoard;
	private Referee refere;

	public SoccerMatch(SoccerTeam t1, SoccerTeam t2)
	{
		// array ready for taking in 2 coaches
		angryCoaches = new AngryCoach[2];
		scoreBoard = new ScoreBoard();

		team1 = t1;
		team2 = t2;
	}

	/**
	 * Notifies observers when a goal is scored
	 */
	public void teamScore(SoccerTeam team)
	{
		SoccerMatchInfo updatedSoccerMatchInfo = new SoccerMatchInfo(scoreTeam1, scoreTeam2, roughTackleTeam1, roughTackleTeam2, team1, team2);
		if (team.equals(team1))
			scoreTeam1++;
		else if (team.equals(team2))
			scoreTeam2++;

		// notifying observers about latest news
		notifyObservers(updatedSoccerMatchInfo);
	}

	/**
	 * Notifies observers when a tackle is made
	 *
	 * @param team
	 */
	public void roughTackle(SoccerTeam team)
	{
		SoccerMatchInfo updatedSoccerMatchInfo = new SoccerMatchInfo(scoreTeam1, scoreTeam2, roughTackleTeam1, roughTackleTeam2, team1, team2);

		if (team.equals(team1))
			roughTackleTeam1++;
		else if (team.equals(team2))
			roughTackleTeam2++;

		// notifying observers about latest news
		notifyObservers(updatedSoccerMatchInfo);
	}

	public int getTeam1Score()
	{
		return scoreTeam1;
	}

	public int getTeam2Score()
	{
		return scoreTeam2;
	}

	public SoccerTeam getSoccerTeam1()
	{
		return team1;
	}

	public SoccerTeam getSoccerTeam2()
	{
		return team2;
	}

//	public void addCommentator(Commentator comm)
//	{
//		this.comm = comm;
//	}
//
//	public void addWebPage(SoccerWebPage wp)
//	{
//		webPage = wp;
//	}
//
//	public void addBetPage(BetDotCom bp) { betPage = bp;}
//
//	public void addFans(Fan... fans) { this.fans = fans; }
//
//	public void addAngryCoaches(AngryCoach... angryCoaches) { this.angryCoaches = angryCoaches; }
}