package CarExample;

import java.util.ArrayList;

public class TrafficOffice implements Observable<String>, Runnable
{
	private String maintenanceStatus;
	private String[] maintenanceStatuse = {"maintenance started", "maintenance finished"};
	private int count = 0;
	private ArrayList<Observer> observerArrayList;


	public TrafficOffice()
	{
		maintenanceStatus = maintenanceStatuse[1];
		observerArrayList = new ArrayList<>();
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			try
			{
				Thread.sleep(10000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}


			if (count > 1) count = 0;

			maintenanceStatus = maintenanceStatuse[count];
			System.out.println("\n !!! " + maintenanceStatus);

			if (maintenanceStatus == "maintenance started")
				notifyObservers(maintenanceStatus);

			try
			{
				Thread.sleep(10000);
				notifyAll();
				count++;
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
