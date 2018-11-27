package CarExample;

public class Taxi implements Observer<String>
{

	private String name;

	public Taxi(String name) {this.name = name;}

	@Override
	public void notify(Observable o, String arg)
	{
		String l = arg;

		if ("RED".equals(l))
		{
			System.out.println("CarExample.Taxi " + name + " is stopped");
		}
		else if ("YELLOW".equals(l))
		{
			System.out.println("CarExample.Taxi " + name + " is speeding up");
		}
		else if ("GREEN".equals(l))
		{
			System.out.println("CarExample.Taxi " + name + " is moving");
		}
	}

}
