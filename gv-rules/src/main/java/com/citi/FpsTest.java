package com.citi;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a test class to fire the rules.
 */
public class FpsTest {

	static final int JUNE = 6;

	public static final void main(String[] args) {

		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("fps-sf-session");

			// create an out of bounds fact
			com.citi.ParticipantEvent p = new com.citi.ParticipantEvent();
			p.setId("1");
			p.setLocation("RETAIL_STORE");
			p.setRegisteredTime(ZonedDateTime.of(2021, JUNE, 4, 0, 15, 0, 0, ZoneId.of("Asia/Singapore")).toInstant()
					.toEpochMilli());
			kSession.insert(p);

			// create a stage 1 txn
			p = new com.citi.ParticipantEvent();
			p.setLocation("FUEL_STATION");
			p.setId("4");
			p.setRegisteredTime(ZonedDateTime.of(2021, JUNE, 4, 4, 15, 0, 0, ZoneId.of("Asia/Singapore")).toInstant()
					.toEpochMilli());
			kSession.insert(p);

			/**
			 * STAGE 2 - create stage 2 txns
			 */
			p = new com.citi.ParticipantEvent();
			p.setLocation("JEWELLERY_STORE");
			p.setId("3");
			p.setRegisteredTime(ZonedDateTime.of(2021, JUNE, 4, 2, 15, 0, 0, ZoneId.of("Asia/Singapore")).toInstant()
					.toEpochMilli());
			kSession.insert(p);

			p = new com.citi.ParticipantEvent();
			p.setLocation("SUPERMARKET");
			p.setId("3a");
			p.setRegisteredTime(ZonedDateTime.of(2021, JUNE, 4, 3, 20, 0, 0, ZoneId.of("Asia/Singapore")).toInstant()
					.toEpochMilli());
			kSession.insert(p);

			p = new com.citi.ParticipantEvent();
			p.setLocation("JEWELLERY_STORE");
			p.setId("3b");
			p.setRegisteredTime(ZonedDateTime.of(2021, JUNE, 4, 3, 47, 0, 0, ZoneId.of("Asia/Singapore")).toInstant()
					.toEpochMilli());
			kSession.insert(p);

			/* ***************************************** */

			// create a stage 3 txn
			p = new com.citi.ParticipantEvent();
			p.setLocation("ONLINE");
			p.setId("2");
			p.setRegisteredTime(ZonedDateTime.of(2021, JUNE, 3, 23, 48, 0, 0, ZoneId.of("Asia/Singapore")).toInstant()
					.toEpochMilli());
			kSession.insert(p);

			// insert the fact and fire all rules
			kSession.fireAllRules();
			kSession.dispose();

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}