package org.example;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        //Задача 3
        Animal [] animals = {new Dog(), new Cat(), new Dog(), new Cow()};
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
        }

        //Задача 7
        Counter counter = new Counter();
        System.out.println(Counter.getCount());
        Counter counter2 = new Counter();
        System.out.println(Counter.getCount());

        //Задача 10
        ArrayList<Student> students2 = new ArrayList<>();
        students2.add(new Student("Ivan", "20", 4.9));
        students2.add(new Student("Alex", "20", 4.1));
        students2.add(new Student("Boris", "21", 4.23));
        University universe = new University(students2);
        universe.printStudents();
        universe.sortStudents();
        System.out.println();
        universe.printStudents();
        System.out.println();
        universe.sortStudentsGrade();
        System.out.println();
        universe.printStudents();

        //Задача 13
        UniqueID id = new UniqueID();
        UniqueID id2 = new UniqueID();
        UniqueID id3 = new UniqueID();
        UniqueID id4 = new UniqueID();
        System.out.println(id.getID());
        System.out.println(id4.getID());

        //Задача 18
        Customer customer = new Customer("123", "20",22);
        Product2 product2 = new Product2("tomato", 500);
        Product2 product3 = new Product2("potato", 500);
        Order order = new Order(customer, product2,5,2500);
        Order order2 = new Order(customer, product3,2,1000);
        Order.printOrderHistory();

        //Задача 17
        Weapon weapon1 = new Weapon("дубинка",20);
        Weapon weapon2 = new Weapon("меч",60);
        Player player = new Player("player",weapon2,200);
        Enemy enemy1 = new Enemy("гоблин", weapon1, 60);
        player.attack(enemy1);
        System.out.println(enemy1.getHp());
    }
}


//Задача 1
class Person{
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void view(){
        System.out.println(name + " " + age + " " + gender);
    }

    public void setName(String name){
        this.name = name;
    }
}


//Задача 2
class Worker extends Person{
    private int salary;
    public Worker(String name, int age, String gender){
        super(name, age, gender);
    }
}
class Manager extends Worker{
    private Worker[] workers;
    public Manager(String name, int age, String gender){
        super(name, age, gender);
    }
}

//Задача 3
interface Animal{
    String makeSound();
}

class Dog implements Animal{
    public String makeSound() {
        return "Woof!";
    }
}
class Cat implements Animal{
    public String makeSound() {
        return "Meow!";
    }
}
class Cow implements Animal{
    public String makeSound() {
        return "Moo!";
    }
}


//Задача 4
abstract class Transport{
    abstract void move();
}
class Car extends Transport{
    public void move() {
        System.out.println("Car is moving");
    }
}
class Bike extends Transport{
    public void move() {
        System.out.println("Bike is moving");
    }
}

//Задача 5
class Book{
    @Getter
    private String title;
    @Getter
    private String author;
    @Getter
    private int year;

    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

}
class Library{
    private Book[] books;
    public Library(Book[] books){
        this.books = books;
    }

    public void addBook(Book book){
        Book[] newBooks = new Book[books.length + 1];
        for (int i = 0; i < books.length; i++) {
            newBooks[i] = books[i];
        }
        newBooks[books.length] = book;
        books = newBooks;
    }

    public void searchBook(String author, int year){
        for (Book book : books) {
            if (book.getAuthor().equals(author) && book.getYear() == year) {
                System.out.println(book.getTitle() + " " + book.getAuthor()+ " " + book.getYear());
            }
    }
}
}

//Задача 6
class BankAccount{
    private String accountName;
    private double balance;
    public BankAccount(String accountName, double balance){
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
    }
}


//Задача 7
class Counter{
    private static int count = 0;
    public Counter(){
        count++;
    }
    public static int getCount() {
        return count;
    }
}

//Задача 8
abstract class Shape{
    abstract double getArea();
}

class Circle extends Shape{
    private double radius;
    public Circle(double radius){
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape{
    private double length;
    private double width;
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }
}

//Задача 9
class Animal2{
    public void move() {
        System.out.println("Животное двигается");
    }
}

class Fish extends Animal2{
    public void move() {
        System.out.println("Рыба плывёт");
    }
}

class Bird extends Animal2{
    public void move() {
        System.out.println("Птица летает");
    }
}

class Dog2 extends Animal2{
    public void move() {
        System.out.println("Собака бегает");
    }
}

//Задача 10
class Student{
    @Getter
    private String name;
    @Getter
    private String group;
    @Getter
    private double grade;
    public Student(String name, String group, double grade){
        this.name = name;
        this.group = group;
        this.grade = grade;
    }

}

class University{
    private ArrayList<Student> students;
    public University(ArrayList<Student> students){
        this.students = students;
    }

    public void addStudent(Student student){
        students.add(student);
    }


    public void sortStudents(){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

    }

    public void printStudents(){
        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getGrade() + " " + student.getGroup());
        }
    }

    public void sortStudentsGrade(){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o2.getGrade(), o1.getGrade());
            }
        });
    }
}

//Задача 11
class Product{
    @Getter
    private String name;
    @Getter
    private double price;
    @Getter
    private int quantity;
    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

class Store{
    private ArrayList<Product> products;
    public Store(ArrayList<Product> products){
        this.products = products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void deleteProduct(Product product){
        products.remove(product);
    }

    public void searchProduct(String name){
        for (Product product : products) {
            if (product.getName().equals(name)) {
                System.out.println(product.getName() + " " + product.getPrice() + " " + product.getQuantity());
            }
        }
    }

    public void printProducts(){
        for (Product product : products) {
            System.out.println(product.getName() + " " + product.getPrice() + " " + product.getQuantity());
        }
    }
}


//Задача 12
interface PaymentSystem{
    public void pay(double amount);
    public void refund(double amount);
}

class CreditCard implements PaymentSystem{
    public void pay(double amount){
        System.out.println("Оплата с помощью кредитной карты");
    }

    public void refund(double amount) {
        System.out.println("Возврат средств с помощью кредитной карты");
    }
}

class PayPal implements PaymentSystem{
    public void pay(double amount){
        System.out.println("Оплата с помощью PayPal");
    }

    public void refund(double amount) {
        System.out.println("Возврат средств с помощью PayPal");
    }
}

//Задача 13
class UniqueID{
    private static int ID= 0;
    private int id;
    public UniqueID(){
        id = generateID();
    }
    public int getID(){
        return id;
    }

    public static int generateID(){
        return ID++;
    }
}

//Задача 14
class Point{
    @Getter
    private int x;
    @Getter
    private int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Rectangle2{
    private Point topLeft;
    private Point bottomRight;
    public Rectangle2(Point topLeft, Point bottomRight){
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public double getArea(){
        return (bottomRight.getX() - topLeft.getX()) * (bottomRight.getY() - topLeft.getY());
    }
}

//Задача 15
class ComplexNumber{
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber summ(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumber sub(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public ComplexNumber share(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double realPart = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double imaginaryPart = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(realPart, imaginaryPart);
    }
}

//Задача 16
class Matrix{
    private final int rows;
    private final int cols;
    private final double[][] data;

    public Matrix(double[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = data;
    }

    public Matrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }


    public Matrix sum(Matrix other) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        Matrix result = new Matrix(rows, other.cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < cols; k++) {
                    result.data[i][j] += data[i][k] * other.data[k][j];
                }
            }
        }
        return result;
    }
}

//Задача 18
class Customer{
    @Getter
    private String name;
    private String surname;
    private int age;
    public Customer(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}

class Product2{
    @Getter
    private String name;
    private double price;
    public Product2(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order{
    private Customer customer;
    private Product2 product;
    private int kolichestvo;
    private int price;
    static ArrayList<Order> orders = new ArrayList<>();

    public Order(Customer customer, Product2 product, int kolichestvo, int price) {
        this.customer = customer;
        this.product = product;
        this.kolichestvo = kolichestvo;
        this.price = price;
        orders.add(this);
    }

    public static void printOrderHistory() {
        for(Order o : orders){
            System.out.println(o.kolichestvo + " " + o.price + " " + o.product.getName() + " " + o.customer.getName());
        }
    }
}

//Задача 17
class Weapon{
    @Getter@Setter
    private String name;
    @Getter@Setter
    private int power;

    public Weapon(String name, int power){
        this.name = name;
        this.power = power;
    }
}
class Character{
    @Getter@Setter
    private String name;
    @Getter@Setter
    private Weapon weapon;
    @Getter@Setter
    private int hp;
    public Character(String name, Weapon weapon, int hp){
        this.name = name;
        this.weapon = weapon;
        this.hp = hp;
    }
}

class Player extends Character{

    public Player(String name, Weapon weapon, int hp){
        super(name, weapon, hp);
    }

    public void takeDamage(int damage) {
        int temp = getHp() - damage;
        setHp(temp);
    }

    public int attack() {
        return getWeapon().getPower();
    }

    public int attack(Enemy enemy) {
        int damage = getWeapon().getPower();
        enemy.takeDamage(damage);
        return damage;
    }
}

class Enemy extends Character{
    public Enemy(String name, Weapon weapon, int hp){
        super(name, weapon, hp);
    }

    public void attackPlayer(Player player) {
        int damage = getWeapon().getPower();
        player.takeDamage(damage);
    }

    public void takeDamage(int damage) {
        int temp = getHp() - damage;
        setHp(temp);
    }
}

//Задача 19
class Device {
    @Getter@Setter
    private String brand;

    public Device(String brand) {
        this.brand = brand;
    }

    public void turnOn() {
        System.out.println(brand + " включен");
    }

    public void turnOff() {
        System.out.println(brand + " выключен");
    }
}

class Smartphone extends Device {
    public Smartphone(String brand) {
        super(brand);
    }

    public void takePhoto() {
        System.out.println(getBrand() + " ФОТО");
    }
}

class Laptop extends Device {
    public Laptop(String brand) {
        super(brand);
    }

    public void tap() {
        System.out.println(getBrand() + " печатает");
    }
}

//Задача 20
class Player2{
    @Getter
    private String name;
    @Getter
    private String step;
}

class Game{
    private String[][] field;

    public Game(){
        field = new String[3][3];
    }

    public void hod(int x, int y, Player2 p){
        System.out.println("Игрок "+ p.getName()+" ставит "+p.getStep()+" на точку "+x+" "+y);
        field[x][y] = p.getStep();
    }

    public void printfield(){
        for(int i = 0; i<3;i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(field[i][j]);
            System.out.println();
        }
    }
}