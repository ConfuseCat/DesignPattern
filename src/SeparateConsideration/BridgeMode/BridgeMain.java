package SeparateConsideration.BridgeMode;

public class BridgeMain {
    public static void main(String[] args){
        Display display1=new Display(new StringDisplayImpl("hello,China"));
        Display display2=new Display(new StringDisplayImpl("Hello,world"));
        CountDisplay countDisplay=new CountDisplay(new StringDisplayImpl("hello,Universe."));
        display1.display();
        display2.display();
        countDisplay.display();
        countDisplay.multiDisplay(5);
    }
}
