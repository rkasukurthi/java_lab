package pattern.behavioral.observer;

import java.util.Observable;
import java.util.Observer;  /* this is Event Handler */
 
public class ResponseHandler implements Observer {
    @Override
    public void update(Observable obj, Object arg) {
        if (arg instanceof String) {
            String resp = (String) arg;
            System.out.println("\nReceived response: " + resp);
        }
    }
}