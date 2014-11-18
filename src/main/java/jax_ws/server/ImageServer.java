package jax_ws.server;

import java.awt.Image;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.DOCUMENT)
public interface ImageServer {

  @WebMethod
  Image downloadImage(String name);
  
  @WebMethod
  String uploadImage(Image data);
}
