package CarExample;

public interface Observer<T> {

    void notify(Observable obs, T arg);

}


