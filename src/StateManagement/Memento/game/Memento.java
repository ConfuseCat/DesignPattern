package StateManagement.Memento.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Java 语言可见性
 * public 所有类都可以访问
 * protected 同一包中的类或是该类的子类可以访问
 * 无 同一包中的类可以访问
 * private 只有该类自身可以访问
 */

public class Memento implements Serializable {
    int money;
    ArrayList fruits;
    public int getMoney(){
        return this.money;
    }
    Memento(int money){
        this.money=money;
        this.fruits=new ArrayList();
    }
    void addFruit(String fruit){
        this.fruits.add(fruit);
    }
    List getFruits(){
        return (List)fruits.clone();
    }
}
