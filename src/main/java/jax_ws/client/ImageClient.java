package jax_ws.client;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import jax_ws.server.ImageServer;

public class ImageClient {
  
  public static void main(String[] args) throws Exception {
    URL url = new URL("http://localhost:9998/ws/image?wsdl");
    QName qname= new QName("http://server.jax_ws/", "ImageServerImplService");
    
    Service service =Service.create(url, qname);
    ImageServer imageServer =service.getPort(ImageServer.class);
    
    Image image = imageServer.downloadImage("rss.png");
    
    JFrame frame = new JFrame();
    frame.setSize(300,300);
    JLabel label = new JLabel(new ImageIcon(image));
    frame.add(label);
    frame.setVisible(true);
    
    System.out.println("imageServer.downloadImage() : Download Successful!");
    
  }

}
