package com.sample.JDBCProject2.factory;

import java.sql.Date;
import java.util.List;

import com.sample.JDBCProject2.model.Actor;
import com.sample.JDBCProject2.persistance.ActorDb;

public class ActorFactory {
	public static Actor[] retrieveAll() {
		List<Actor> list = ActorDb.retrieveAll();
		Actor[] actors = list.toArray(new Actor[list.size()]);
		return actors;
	}
	public static Actor findById(int id) {
		Actor actor = ActorDb.findById(id);
		return actor;
	}
	
	public static int addNewActor(String fName, String lName, String ph, double fees, Date dob, String gender) {
		int res = ActorDb.insertIntoDb(fName, lName,  ph,  fees, dob, gender);
		return res;
	}
}
