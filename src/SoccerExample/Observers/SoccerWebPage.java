package SoccerExample.Observers;

import SoccerExample.Observable;
import SoccerExample.Observer;
import SoccerExample.SoccerMatchInfo;
import SoccerExample.SoccerTeam;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SoccerWebPage extends JFrame implements Observer
{

	private SoccerTeam team1, team2;
	private Label scoresLabel;

	public SoccerWebPage(SoccerTeam t1, SoccerTeam t2)
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
		setSize(350, 120); // set frame size
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

	public static double round(double value, int places)
	{
		if (places < 0) throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	@Override
	public void notify(Observable obs, Object arg)
	{
		SoccerMatchInfo info = (SoccerMatchInfo) arg;
		updateLabel(info.team1Score, info.team2Score);
	}
}
