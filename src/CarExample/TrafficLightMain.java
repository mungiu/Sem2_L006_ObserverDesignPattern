package CarExample;

public class TrafficLightMain
{

	public static void main(String[] args)
			throws InterruptedException
	{
		TrafficOffice to = new TrafficOffice();
		TrafficLight tf = new TrafficLight();

		Car c1 = new Car("c1");
		Car c3 = new Car("c3");
		Car c2 = new Car("c2");
		Taxi t1 = new Taxi("t1");
		SleepyDriver s1 = new SleepyDriver("s1");
		EscapeDriver e1 = new EscapeDriver("e1");

		to.addObserver(tf);
		tf.addObserver(c1);
		tf.addObserver(c2);
		tf.addObserver(c3);
		tf.addObserver(t1);
		tf.addObserver(s1);
		tf.addObserver(e1);

		new Thread(to).start();
		new Thread(tf).start();
	}

}
