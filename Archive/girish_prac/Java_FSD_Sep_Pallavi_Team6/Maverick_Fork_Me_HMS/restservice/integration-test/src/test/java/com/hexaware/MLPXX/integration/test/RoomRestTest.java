package com.hexaware.MLPXX.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class RoomRestTest {

	@Test
	public void testRoomList() throws AssertionError, URISyntaxException {
		Room[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/room")).getBody().as(Room[].class);
		for (Room r: res) {
			switch (r.roomNo) {
				case 101:
					assertEquals(new Room(101), r);
					break;
				case 102:
					assertEquals(new Room(102), r);
					break;				
				case 103:
					assertEquals(new Room(103), r);
					break;				
				case 104:
					assertEquals(new Room(104), r);
					break;				
				case 105:
					assertEquals(new Room(105), r);
					break;			
				default:
					fail("Unknown Room with id:" + r);	
			}
		}
	}

  
  @Test
	public void testRoomById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/room/1000")).then().assertThat().statusCode(404);
	}
}
