package BuildInstance.ProtoType;

import BuildInstance.ProtoType.framework.Manager;
import BuildInstance.ProtoType.framework.Product;

public class protoTypeMain {
    public static void main(String[] args){
        Manager manager=new Manager();
        UnderlinePen upen=new UnderlinePen('~');
        MessageBox mBox=new MessageBox('*');
        MessageBox sBox=new MessageBox('/');
        manager.register("Strong message",upen);
        manager.register("warning box",mBox);
        manager.register("slash box",sBox);

        Product p1=manager.create("Strong message");
        p1.use("hello,world");
        Product p2=manager.create("warning box");
        p2.use("hello,world");
        Product p3=manager.create("slash box");
        p3.use("hello,world");

    }
}
