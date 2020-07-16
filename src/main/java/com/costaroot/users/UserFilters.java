package com.costaroot.users;

public interface UserFilters {
    public void printUserOlderThanAge(int age);

    public void printUserFromCityYoungerThanAge(String city, int age);

    public void printAverageAgeInCity(String city);

    public long amountUserSkipCity(String city);

    public void printTopOldestUser(int numberOfTop);
}
