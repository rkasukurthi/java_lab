package jax_ws.server;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService(endpointInterface="jax_ws.server.ImageServer")
public class ImageServerImpl implements ImageServer {

  @Override
  public Image downloadImage(String name) {
    try {
    File image = new File("C:/src/java_lab/src/main/resources/images/check_box.png");
      return ImageIO.read(image);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public String uploadImage(Image data) {
    if(data!=null){
      //store somewhere
      return "Upload Successful";
  }

  throw new WebServiceException("Upload Failed!");
  }

}
