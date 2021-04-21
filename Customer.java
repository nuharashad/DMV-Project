package cs146project1;

import java.util.*;

/**
 * 
 * @author nuhar
 * 
 * Class: Customer
 * 
 * Purpose of Class: To get the input of the user. This includes the name of the person, their age,
 * their time, as well as the reason for their visit. It also generates a waiting score for the
 * user and returns the customer. 
 *
 */

public class Customer {
	private int timeOfVisit;
	private String nameOfPerson;
	private int ageOfPerson;
	private List<VisitingPurpose> reasonForVisits = new ArrayList<>();
	private int overridenWaitingScore = -1;

/**
 * Method: Constructor
 * 
 * @param time
 * @param name
 * @param age
 * @param reasonForVisit
 */
	public Customer(int time, String name, int age, VisitingPurpose... reasonForVisit) {
		timeOfVisit = time;
		nameOfPerson = name;
		ageOfPerson = age;
		reasonForVisits = Arrays.asList(reasonForVisit);
	}

	public Customer() {

	}

/**
 * Getters: Returning the time of visit, the name, the age, as well as the list containing the reason for visit.
 * 
 * @return
 */
	public int getTime() {
		return timeOfVisit;
	}
	public String getName() {
		return nameOfPerson;
	}
	public int getAge() {
		return ageOfPerson;
	}


	public int getTimeOfVisit() {
		return timeOfVisit;
	}

	public void setTimeOfVisit(int timeOfVisit) {
		this.timeOfVisit = timeOfVisit;
	}

	public String getNameOfPerson() {
		return nameOfPerson;
	}

	public void setNameOfPerson(String nameOfPerson) {
		this.nameOfPerson = nameOfPerson;
	}

	public int getAgeOfPerson() {
		return ageOfPerson;
	}

	public void setAgeOfPerson(int ageOfPerson) {
		this.ageOfPerson = ageOfPerson;
	}

	public List<VisitingPurpose> getReasonForVisits() {
		return reasonForVisits;
	}

	public void setReasonForVisits(List<VisitingPurpose> reasonForVisits) {
		this.reasonForVisits = reasonForVisits;
	}


	public void setOverridenWaitingScore(int overridenWaitingScore) {
		this.overridenWaitingScore = overridenWaitingScore;
	}

	/**
	 * Method: getTotalWaitingScore
	 * 
	 * Returns 
	 * 
	 * @return
	 */
	public int getTotalWaitingScore() {

		if(overridenWaitingScore > 0) {
			return overridenWaitingScore;
		}

		int waitingScore = 0;

		for(int i =0 ; i < reasonForVisits.size() ; i++) {
			waitingScore += reasonForVisits.get(i).getWaitingScore();
		}
		return 100 - waitingScore;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"timeOfVisit=" + timeOfVisit +
				", nameOfPerson='" + nameOfPerson + '\'' +
				", ageOfPerson=" + ageOfPerson +
				", reasonForVisits='" + reasonForVisits + '\'' +
				'}';
	}
}