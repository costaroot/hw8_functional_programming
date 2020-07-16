package com.costaroot.users;

import java.util.ArrayList;
import java.util.List;

public class UserFilterImpl implements UserFilters {
    List<User> users;

    public UserFilterImpl() {
        users = new ArrayList<>();
        this.createUsers();
    }

    private void createUsers() {
        users.add(new User("Vasia", 16, "Dnepr"));
        users.add(new User("Petia", 23, "Dnepr"));
        users.add(new User("Elena", 42, "Lutsk"));
        users.add(new User("Elena", 92, "Chernigyv"));
        users.add(new User("Sergey", 5, "Kyiv"));
        users.add(new User("Maryna", 32, "Kyiv"));
        users.add(new User("Ivan Ivanovych", 69, "Lviv"));
        users.add(new User("Ivanovych", 2, "Lviv"));
    }

    public void printAllUsers() {
        users.forEach(System.out::println);
    }

    @Override
    public void printUserOlderThanAge(int age) {
        users.stream().
                filter(user -> user.getAge() > age).
                forEach(System.out::println);
    }

    @Override
    public void printUserFromCityYoungerThanAge(String city, int age) {
        users.stream().
                filter(user -> user.getAge() < age && user.getCity().equals(city)).
                forEach(System.out::println);
    }

    @Override
    public void printAverageAgeInCity(String city) {
        long count = users.stream().
                filter(user -> user.getCity().
                        equals(city)).
                count();
        long sum = users.stream().
                filter(user -> user.getCity().equals(city)).
                mapToInt(User::getAge).
                sum();
        System.out.println("In city " + city + " Average Age =" + (double) sum / count);
    }

    @Override
    public long amountUserSkipCity(String city) {
        return users.stream().
                filter(user -> !user.getCity().equals(city)).
                count();
    }

    @Override
    public void printTopOldestUser(int numberOfTop) {
        users.stream().
                sorted((user, t1) -> -Integer.compare(user.getAge(), t1.getAge())).
                limit(numberOfTop).
                forEach(e -> System.out.println(e));
    }
}
