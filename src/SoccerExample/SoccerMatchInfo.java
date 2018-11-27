package SoccerExample;

public class SoccerMatchInfo
{

	public int team1RoughTackle, team2RoughTackle, team1Score, team2Score;
	public SoccerTeam team1, team2;

	public SoccerMatchInfo() {}

	public SoccerMatchInfo(int _scoreTeam1,
						   int _scoreTeam2,
						   int _penaltyTeam1,
						   int _penaltyTeam2,
						   SoccerTeam _team1,
						   SoccerTeam _team2)
	{
		team1RoughTackle = _penaltyTeam1;
		team2RoughTackle = _penaltyTeam2;
		team1Score = _scoreTeam1;
		team2Score = _scoreTeam2;
		team1 = _team1;
		team2 = _team2;
	}
}
