package CarExample;

public class Car implements Observer<String>
{

	private String name;

	public Car(String name) {this.name = name;}

	@Override
	public void notify(Observable o, String arg)
	{
		String lightState = arg;

		if ("RED".equals(lightState))
		{
			System.out.println("CarExample.Car " + name + " is stopped");
		}
		else if ("YELLOW".equals(lightState))
		{
			System.out.println("CarExample.Car " + name + " is stopping");
		}
		else if ("GREEN".equals(lightState))
		{
			System.out.println("CarExample.Car " + name + " is moving");
		}
	}
}
