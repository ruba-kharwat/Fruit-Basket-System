package javaapplication17;

import java.util.ArrayList;
import java.util.List;

class Fruit<T>{
    private String name;
    private T weight;
    
    public Fruit(String name, T weight) {
        this.name = name;
        this.weight = weight;
    }
    public String getName() {
        return name;
    }
    public T getWeight() {
        return weight;
    }
    public String toString() {
        return "Fruit{" + "name=" + name + ", weight=" + weight + '}';
    }
}
class Basket<T>{
    private List<Fruit<T>> fruits = new ArrayList<>();
    
    public void add(Fruit<T> fruit){
        fruits.add(fruit);
    }
    public void exportWeights(List < ? super T > destination){
        for(Fruit<T> f : fruits){
         destination.add(f.getWeight());
        }
    }
    public void copyTo(List < ? super Fruit<T>> destination){
         destination.addAll(fruits);
    }
}
class WeightManager{
    public static void addDefaultWeight(List<? super Number> weightList){
        weightList.add(150);
        weightList.add(250.5);
        weightList.add(500L);
    }
    public static double calculateTotal(List<Number>weights){
        double total = 0;
        for(Number w : weights){
            total += w.doubleValue();
        }
        return total;
    }
}
public class FruitBasket {
    public static void main(String[] args) {
    Basket<Integer> smallBasket = new Basket<>();

    smallBasket.add(new Fruit<>("Apple", 150));
    smallBasket.add(new Fruit<>("Banana", 120));
    Basket<Double> bigBasket = new Basket<>();
    bigBasket.add(new Fruit<>("Mango", 450.5));
    bigBasket.add(new Fruit<>("Melon", 1200.0));
    List<Number> allWeights = new ArrayList<>();
    smallBasket.exportWeights(allWeights);
    bigBasket.exportWeights(allWeights);
    System.out.println("**********************************************");
    System.out.println("        Welcome To Fruit Basket System        ");
    System.out.println("**********************************************");
    System.out.println("\n=== Fruit Weights ===");
    System.out.println("All weights: " + allWeights);
    System.out.println("\n=== Total Weight ===");
    double total = WeightManager.calculateTotal(allWeights);
    System.out.println("Total weight = " + total + "g");
    System.out.println("\n=== Fruit Details ===");
    List<Object> allFruits = new ArrayList<>();
    smallBasket.copyTo(allFruits);
    bigBasket.copyTo(allFruits);
    for(Object fruit : allFruits){
    System.out.println(" * "+ fruit);
    }
    System.out.println("\n=== Default Weight ===");
    List<Object> defaults = new ArrayList<>();
    WeightManager.addDefaultWeight(defaults);
    System.out.println("Default weights: " + defaults);
    }
}
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         