package com.costaroot.users;

public class Executor {
    private UserFilterImpl filterImpl;

    public Executor() {
        filterImpl = new UserFilterImpl();
    }

    private void executeAllFilters() {
        filterImpl.printAllUsers();
        System.out.println("-------");
        filterImpl.printUserOlderThanAge(40);
        System.out.println("-------");
        filterImpl.printUserFromCityYoungerThanAge("Dnepr", 50);
        System.out.println("-------");
        filterImpl.printAverageAgeInCity("Lviv");
        System.out.println("-------");
        System.out.println("Amount Users not from Kyiv: " + filterImpl.amountUserSkipCity("Kyiv"));
        System.out.println("-------");
        filterImpl.printTopOldestUser(3);
    }

    public void run() {
        executeAllFilters();
    }

}
