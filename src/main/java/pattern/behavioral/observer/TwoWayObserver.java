package pattern.behavioral.observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.Observer;

public class TwoWayObserver {
  
  public static class Player extends Observable implements Observer,Runnable{
    String name;
    
    public Player(String name) {
      this.name = name;
    }

    @Override
    public void run() {
      try {
        final InputStreamReader isr = new InputStreamReader(System.in);
        final BufferedReader br = new BufferedReader(isr);
        while (true) {
            String response = br.readLine();
            setChanged();
            notifyObservers("[" + name + "]" + response);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @Override
    public void update(Observable o, Object arg) {
      if (arg instanceof String) {
        String resp = (String) arg;
        System.out.println("\n<" + name + "> receive response from : " + resp);
    }
    }
  }
  
  public static void main(String[] args) {
    System.out.println("Enter Text >");

    // create an event source - reads from stdin
    final Player player1 = new Player("A");
    final Player player2 = new Player("B");
    
    player1.addObserver(player2);
    player2.addObserver(player1);


    // starts the event thread
    Thread thread1 = new Thread(player1);
    Thread thread2 = new Thread(player2);
    thread1.start();
    thread2.start();
}

}
