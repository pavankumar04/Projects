package com.hexaware.MLPXX.integration.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
public class CommonUtil {
    public static final String host;
    public static final String port;
    public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "8080");
        webapp = System.getProperty("service.webapp", "MLPXX");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}
class Room{

  int roomNo;
 
  public Room() {

  }

  public Room(final int argRoomNo) {
    this.roomNo = argRoomNo;
  }
    
  public final int getRoomNo() {
    return roomNo;
  }
   
  public final void setRoomNo(final int argRoomNo) {
    this.roomNo = argRoomNo;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }                                  
    Room room = (Room) obj;
    if (Objects.equals(roomNo, room.roomNo)) {
      return true;
    }           
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(roomNo);
  }
}
 