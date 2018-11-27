package CarExample;

public class SleepyDriver implements Observer<String>
{
	private String name;

	public SleepyDriver(String name)
	{
		this.name = name;
	}

	@Override
	public void notify(Observable obs, String arg)
	{
		String l = arg;

		if ("RED".equals(l))
		{
			System.out.println("CarExample.Taxi " + name + " is stopped");
		}
		else if ("YELLOW".equals(l))
		{
			System.out.println("CarExample.Taxi " + name + " is waking up");
		}
		else if ("GREEN".equals(l))
		{
			System.out.println("CarExample.Taxi " + name + " is starting up and moving slowly");
		}
	}
}
