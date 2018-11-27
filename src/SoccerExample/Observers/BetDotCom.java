package SoccerExample.Observers;

import SoccerExample.Observable;
import SoccerExample.Observer;
import SoccerExample.SoccerMatchInfo;
import SoccerExample.SoccerTeam;

import javax.swing.*;
import java.awt.*;

import static SoccerExample.Observers.SoccerWebPage.round;

public class BetDotCom extends JFrame implements Observer
{
	private SoccerTeam team1, team2;
	private Label scoresLabel;

	public BetDotCom(SoccerTeam t1, SoccerTeam t2)
	{
		team1 = t1;
		team2 = t2;
		// instantiating the GUI which is within a method
		createPanel();
	}

	private void createPanel()
	{
		Label lbl = new Label("Match scores");
		lbl.setFont(new Font("Helvetica", Font.PLAIN, 20));
		scoresLabel = new Label();
		scoresLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
		setSize(550, 120); // set frame size
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel contentPane = new JPanel(new BorderLayout(0, 5));
		contentPane.add(lbl, BorderLayout.NORTH);
		contentPane.add(scoresLabel);
		setContentPane(contentPane);
		setVisible(true);
		updateLabel(0, 0);
	}

	private void updateLabel(int ts1, int ts2)
	{
		String s = team1.getName() + ": " + round(ts1, 3) +
				"; " + team2.getName() + ": " + round(ts2, 3);
		scoresLabel.setText(s);
	}

	private void updateLabel(double ts1, double ts2)
	{
		String s = "ODDS: " + team1.getName() + ": " + ts1 +
				"; " + team2.getName() + ": " + ts2;
		scoresLabel.setText(s);
	}

	@Override
	public void notify(Observable obs, Object arg)
	{
		SoccerMatchInfo info = (SoccerMatchInfo) arg;
		double t1 = info.team1Score;
		double t2 = info.team2Score;
		double t1odds = t1 / (t1 + t2);
		if (t1 > t2) t1odds = 1 - t1odds;
		else if (t1 < t2) t1odds = 1 + t1odds;
		else t1odds = 1;

		double t2odds = t2 / (t1 + t2);
		if (t1 > t2) t2odds = 1 + t2odds;
		else if (t1 < t2) t2odds = 1 - t2odds;
		else t2odds = 1;


		updateLabel(t1odds, t2odds);
	}
}
