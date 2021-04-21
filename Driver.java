package cs146project1;

import java.util.*;

import static cs146project1.VisitingPurpose.*;

public class Driver {
    private static final int max = 999;

    public static void main(String[] args) throws Exception {
        Vector<Customer> customers = new Vector<>();

		customers.add(new Customer(getRandomTime(), "Joe", 21, PB));
		customers.add(new Customer(getRandomTime(), "Bob", 22, DL));
		customers.add(new Customer(getRandomTime(), "John", 23,VR));
		customers.add(new Customer(getRandomTime(), "Mark", 24, MA));
		customers.add(new Customer(getRandomTime(), "Richard", 25, PB));
		customers.add(new Customer(getRandomTime(), "Sarah", 26, DL));
		customers.add(new Customer(getRandomTime(), "Martha", 27, VR));
		customers.add(new Customer(getRandomTime(), "Joy", 28, MA));
		customers.add(new Customer(getRandomTime(), "Ruth", 29, PB));
		customers.add(new Customer(getRandomTime(), "George", 30, DL));
		customers.add(new Customer(getRandomTime(), "Sally", 21, PB));
		customers.add(new Customer(getRandomTime(), "Mathew", 22, DL));
		customers.add(new Customer(getRandomTime(), "Aden", 23,VR));
		customers.add(new Customer(getRandomTime(), "Josh", 24, MA));
		customers.add(new Customer(getRandomTime(), "Henry", 25, PB));
		customers.add(new Customer(getRandomTime(), "David", 26, DL));
		customers.add(new Customer(getRandomTime(), "Ash", 27, VR));
		customers.add(new Customer(getRandomTime(), "Mars", 28, MA));
		customers.add(new Customer(getRandomTime(), "Pluto", 29, PB));
		customers.add(new Customer(getRandomTime(), "Rachel", 30, DL));


		HeapSort heapSort = new HeapSort();
		heapSort.heapSort(customers);

		print(customers);

		Scanner keyboard = new Scanner(System.in);



		String repeat = "y";

		while (repeat.equalsIgnoreCase("y"))
		{
			System.out.println("Enter Customer details to update: ");
			Customer inputCustomer = menuProcessing();
			int indexToInsert = findIndexToInsert(customers, inputCustomer);

			if(indexToInsert >= 0 ) {
				customers.set(indexToInsert, inputCustomer);
			} else {
				customers.add(inputCustomer);
			}

			heapSort.heapSort(customers);
			print(customers);

			System.out.println("Would you like update another customers details? Enter y/n ");
			repeat = keyboard.nextLine();
		}




        PriorityQueue priorityQueue = new PriorityQueue();
        customers.add(new Customer(getRandomTime(), "Joe", 21, PB));
		customers.add(new Customer(getRandomTime(), "Bob", 22, DL));
		customers.add(new Customer(getRandomTime(), "John", 23,VR));
		customers.add(new Customer(getRandomTime(), "Mark", 24, MA));
		customers.add(new Customer(getRandomTime(), "Richard", 25, PB));
		customers.add(new Customer(getRandomTime(), "Sarah", 26, DL));
		customers.add(new Customer(getRandomTime(), "Martha", 27, VR));
		customers.add(new Customer(getRandomTime(), "Joy", 28, MA));
		customers.add(new Customer(getRandomTime(), "Ruth", 29, PB));
		customers.add(new Customer(getRandomTime(), "George", 30, DL));
		customers.add(new Customer(getRandomTime(), "Sally", 21, PB));
		customers.add(new Customer(getRandomTime(), "Mathew", 22, DL));
		customers.add(new Customer(getRandomTime(), "Aden", 23,VR));
		customers.add(new Customer(getRandomTime(), "Josh", 24, MA));
		customers.add(new Customer(getRandomTime(), "Henry", 25, PB));
		customers.add(new Customer(getRandomTime(), "David", 26, DL));
		customers.add(new Customer(getRandomTime(), "Ash", 27, VR));
		customers.add(new Customer(getRandomTime(), "Mars", 28, MA));
		customers.add(new Customer(getRandomTime(), "Pluto", 29, PB));
		customers.add(new Customer(getRandomTime(), "Rachel", 30, DL));
		priorityQueue
				.maxHeapInsert(new Customer(getRandomTime(), "Mark", 24,
						PB, DL, VR, MA));
		priorityQueue
				.maxHeapInsert(new Customer(getRandomTime(), "John",
						23, PB, DL, VR));
		priorityQueue
				.maxHeapInsert(new Customer(getRandomTime(), "Bob", 22,
						PB,DL));
        priorityQueue.maxHeapInsert(new Customer(getRandomTime(), "Joe", 21, PB));
		priorityQueue.print();

		keyboard = new Scanner(System.in);




		repeat = "y";

		while (repeat.equalsIgnoreCase("y"))
		{
			System.out.println("Enter Customer details to be added to the Queue: ");
			Customer customer = menuProcessing();

			priorityQueue.maxHeapInsert(customer);
			priorityQueue.print();

			System.out.println("Would you like add another customer to queue? Enter y/n ");
			repeat = keyboard.nextLine();
		}


        System.out.println("First Customer in  the Queue is: "+ priorityQueue.heapExtractMax());


		repeat = "y";

		Scanner in = new Scanner(System.in);
		while (repeat.equalsIgnoreCase("y"))
		{
			System.out.println("Enter Customer Name to update priority: ");
			String name = in.next();
            int  indexOfCustomer = priorityQueue.findIndexOfCustomer(name);
            if(indexOfCustomer >= 0) {
				System.out.println("Enter waiting score: ");
				int waitingScore = in.nextInt();
				Customer customer = priorityQueue.findCustomer(name);
				customer.setOverridenWaitingScore(waitingScore);
				priorityQueue.heapIncreaseKey(indexOfCustomer, customer);
				priorityQueue.print();
			} else {
            	System.out.println("Customer not found");
			}


			System.out.println("Would you like to update priority of another customer? Enter y/n ");
			repeat = keyboard.nextLine();
		}





	}

	private static int findIndexToInsert(Vector<Customer> customers, Customer inputCustomer) {
    	int indexToInsert = -1;
		for(int i = 0; i< customers.size(); i++) {
			if(customers.get(i).getName().equals(inputCustomer.getName())); {
				indexToInsert = i;
			}
		}
		return indexToInsert;
	}

	private static Customer menuProcessing() {
		Scanner in = new Scanner(System.in);
		Customer customer = new Customer();
		System.out.print("Enter Name: ");
		customer.setNameOfPerson(in.next());
		System.out.print("Enter Arriving Time: ");
		customer.setTimeOfVisit(in.nextInt());
		System.out.print("Enter Age: ");
		customer.setAgeOfPerson(in.nextInt());
		System.out.print("Enter , separated Visiting Purpose example 1,3,4 \n" +
				"1. Pay Bill \n" +
				"2. Drivers License \n" +
				"3. Vehicle Registration \n"+
				"4. Make Appointment for Driving Test \n"
		);
		String visitingOptions = in.next();
		List<VisitingPurpose> visitingPurposeList = new ArrayList<>();
		for(String visitingOption: visitingOptions.split(",")) {
			visitingPurposeList.add(VisitingPurpose.valueOf(Integer.parseInt(visitingOption)));
		}
		customer.setReasonForVisits(visitingPurposeList);
		return customer;
	}

	public static void print(Vector<Customer> customers) {
        System.out.println("Sorted List of customers");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i));
        }
    }

    private static int getRandomTime() {
        Random random = new Random();
        int randomNumber = random.nextInt(max);
        if (randomNumber == 0) {
            randomNumber = 1;
        }

        return randomNumber;
    }

}
