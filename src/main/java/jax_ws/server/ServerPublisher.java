package jax_ws.server;

import javax.xml.ws.Endpoint;

public class ServerPublisher {
  
  public static void main(String[] args) {
    Endpoint.publish("http://localhost:9999/ws/image", new ImageServerImpl());
    System.out.println("Server is published");
  }
}
