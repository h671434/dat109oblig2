import no.hvl.dat109.oblig2.Address;
import no.hvl.dat109.oblig2.Car;
import no.hvl.dat109.oblig2.Costumer;
import no.hvl.dat109.oblig2.RentalGroup;

import java.util.Arrays;
import java.util.List;

/**
 * nothing special just a bunch of static objects to make the tests easier
 */
public class StaticTestObjs {

    public static final List<Car> cars = Arrays.asList(
            new Car("BS49404", "VW", "Golf", "blue", RentalGroup.A, true),
            new Car("EV123123", "toyota", "Camri", "green", RentalGroup.B, true),
            new Car("EQ555555", "saab", "idk", "orange", RentalGroup.C, true),
            new Car("ABC123", "Ford", "Mustang", "red", RentalGroup.A, true),
            new Car("XYZ456", "Chevrolet", "Camaro", "yellow", RentalGroup.B, true),
            new Car("DEF789", "Honda", "Accord", "silver", RentalGroup.C, true),
            new Car("GHI987", "Tesla", "Model 3", "white", RentalGroup.A, true),
            new Car("JKL654", "BMW", "X5", "black", RentalGroup.B, true),
            new Car("MNO321", "Toyota", "Corolla", "green", RentalGroup.C, true),
            new Car("PQR876", "Mercedes-Benz", "E-Class", "blue", RentalGroup.A, true),
            new Car("STU234", "Audi", "A4", "gray", RentalGroup.B, true),
            new Car("VWX567", "Nissan", "Altima", "purple", RentalGroup.C, true),
            new Car("YZA890", "Kia", "Sorento", "orange", RentalGroup.A, true)
    );

    public static final List<Address> adresses = Arrays.asList(
            new Address("StreetName A", "0000", "Oslo"),
            new Address("StreetName A", "0001", "Oslo"),
            new Address("StreetName B", "0002", "Oslo"),
            new Address("StreetName C", "0003", "Oslo"),
            new Address("StreetName D", "0004", "Oslo"),
            new Address("StreetName E", "0005", "Oslo"),
            new Address("StreetName F", "0006", "Oslo"),
            new Address("StreetName G", "0007", "Oslo"),
            new Address("StreetName H", "0008", "Oslo"),
            new Address("StreetName I", "0009", "Oslo"),
            new Address("StreetName J", "0010", "Oslo")

    );

    public static final List<Costumer> costumers = Arrays.asList(
            new Costumer("Boiman", "Boisonn", new Address("StreetName 12", "5055", "Bergen"), "98798987"),
            new Costumer("Alice", "Anderson", new Address("StreetName 13", "5056", "Bergen"), "98798988"),
            new Costumer("Bob", "Benson", new Address("StreetName 14", "5057", "Bergen"), "98798989"),
            new Costumer("Catherine", "Carter", new Address("StreetName 15", "5058", "Bergen"), "98798990"),
            new Costumer("David", "Dawson", new Address("StreetName 16", "5059", "Bergen"), "98798991"),
            new Costumer("Eva", "Evans", new Address("StreetName 17", "5060", "Bergen"), "98798992"),
            new Costumer("Frank", "Franklin", new Address("StreetName 18", "5061", "Bergen"), "98798993"),
            new Costumer("Grace", "Griffin", new Address("StreetName 19", "5062", "Bergen"), "98798994"),
            new Costumer("Harry", "Harrison", new Address("StreetName 20", "5063", "Bergen"), "98798995"),
            new Costumer("Ivy", "Iverson", new Address("StreetName 21", "5064", "Bergen"), "98798996")
    );

}
