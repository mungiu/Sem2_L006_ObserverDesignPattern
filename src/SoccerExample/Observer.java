package SoccerExample;

public interface Observer<T>
{
	void notify(Observable obs, T arg);
}


