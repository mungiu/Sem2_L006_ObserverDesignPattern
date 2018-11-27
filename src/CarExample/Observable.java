package CarExample;

import java.util.ArrayList;
import java.util.List;

/**
 * NOTE: Contains default predefined methods which to not necessarily need to be rewritten
 *
 * @param <T>
 */
public interface Observable<T>
{

	List<Observer> observers = new ArrayList<>();

	default void addObserver(Observer<T> obs)
	{
		if (obs == null) throw new NullPointerException();
		if (!observers.contains(obs))
			observers.add(obs);
	}

	default void deleteObserver(Observer<T> obs)
	{
		observers.remove(obs);
	}

	default void notifyObservers(T arg)
	{
		for (Observer observer : observers)
		{
			observer.notify(this, arg);
		}
	}
}


