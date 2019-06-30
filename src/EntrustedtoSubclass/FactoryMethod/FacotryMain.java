package EntrustedtoSubclass.FactoryMethod;

import EntrustedtoSubclass.FactoryMethod.framework.Factory;
import EntrustedtoSubclass.FactoryMethod.framework.Product;
import EntrustedtoSubclass.FactoryMethod.idcard.IDCardFactory;

public class FacotryMain {
    public static void main(String[] args){
        Factory factory=new IDCardFactory();
        Product card1=factory.create("小红");
        Product card2=factory.create("小明");
        Product card3=factory.create("小刚");
        card1.use();
        card2.use();
        card3.use();
    }
}
