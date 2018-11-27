package CarExample;

import java.util.ArrayList;

public class TrafficLight implements Observable<String>, Observer<String>, Runnable
{

	private String currentLight;
	private String[] lights = {"GREEN", "YELLOW", "RED"};
	private int count = 2;
	private ArrayList<Observer> observerArrayList;

	public TrafficLight()
	{
		currentLight = lights[2];
		observerArrayList = new ArrayList<>();
	}

	@Override
	public synchronized void notify(Observable obs, String arg)
	{
		// if maintenance starts traffic light stops at current light for 1 min
		if (arg == "maintenance started")
			try
			{
				System.out.println("!!!! TRAFFIC LIGHT BLOCKED !!!!");
				wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		// NOTE: another thread will notify this thread if maintenance is finished
	}


	@Override
	public void deleteObserver(Observer<String> obs)
	{
		observerArrayList.remove(obs);
	}


	@Override
	public void run()
	{
		while (true)
			for (int i = 0; i < 10; i++)
			{
				try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}

				count = (++count) % 3;
				currentLight = lights[count];
				System.out.println("\nLight is " + currentLight);

				notifyObservers(currentLight);
			}
	}
}

