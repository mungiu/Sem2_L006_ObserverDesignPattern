package SoccerExample.Observers;

import SoccerExample.Observable;
import SoccerExample.Observer;
import SoccerExample.SoccerMatchInfo;

import javax.swing.*;
import java.awt.*;

public class MatchOverview extends JFrame implements Observer
{
	private int team1Score;
	private int team2Score;
	private int team1Tackles;
	private int team2Tackles;
	TextArea textArea;

	public MatchOverview()
	{
		team1Score = 0;
		team2Score = 0;
		team1Tackles = 0;
		team2Tackles = 0;

		createPanel();
	}

	private void createPanel()
	{
		textArea = new TextArea();
		setSize(550, 750); // set frame size
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel contentPane = new JPanel(new BorderLayout(0, 5));
		contentPane.add(textArea, BorderLayout.NORTH);
		setContentPane(contentPane);
		setVisible(true);
	}

	private void updateLabel(String info)
	{
		textArea.append(info);
	}

	/**
	 * All TUI text should go in here somehow
	 *
	 * @param obs
	 * @param arg
	 */
	@Override
	public void notify(Observable obs, Object arg)
	{
		SoccerMatchInfo info = (SoccerMatchInfo) arg;
		if (info.team1Score > team1Score)
		{
			updateLabel("Team 1 scores!\n");
			team1Score = info.team1Score;
		}
		if (info.team2Score > team2Score)
		{
			updateLabel("Team 2 scores!\n");
			team2Score = info.team2Score;
		}
		if (info.team1RoughTackle > team1Tackles)
		{
			updateLabel("Team 1 got tackled!\n");
			team1Tackles = info.team1RoughTackle;
		}
		if (info.team2RoughTackle > team2Tackles)
		{
			updateLabel("Team 2 got tackled!\n");
			team2Tackles = info.team2RoughTackle;
		}
	}
}
