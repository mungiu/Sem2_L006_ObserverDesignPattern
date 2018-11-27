package CarExample;

public class EscapeDriver implements Observer<String>
{
	private String name;

	public EscapeDriver(String name)
	{
		this.name = name;
	}

	@Override
	public void notify(Observable obs, String arg)
	{
		System.out.println("Escape driver" + name + "is moving");
	}
}
