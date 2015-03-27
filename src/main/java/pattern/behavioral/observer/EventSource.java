package pattern.behavioral.observer;

/* Filename: EventSource.java */
import java.util.Observable; // Observable is here
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Observable| Subject| EventSource means the object can be observed or can be listened by others, Inside observable, there is a
 * vector which will keep all the observers. Observable provide 3 three method, attach|dettach(Observer),
 * notify(). notify() method will call all update() of Observer.
 * 
 * Observer interface, Observer interface have one method update().
 * 
 * +-----------------------+              +---------------+
 * + Subject               +------------->+ Observer      +
 * +-----------------------+              +---------------+
 * + attach(Observer)      +              + update()      +
 * + dettach(Observer)     +              +               +
 * + notify()              +              +---------------+
 * +-----------------------+
 * 
 * @author zluo
 *
 */
public class EventSource extends Observable implements Runnable {
	@Override
	public void run() {
		try {
			final InputStreamReader isr = new InputStreamReader(System.in);
			final BufferedReader br = new BufferedReader(isr);
			while (true) {
				String response = br.readLine();
				setChanged();
				notifyObservers(response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}