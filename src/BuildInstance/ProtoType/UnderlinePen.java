package BuildInstance.ProtoType;

import BuildInstance.ProtoType.framework.Product;

public class UnderlinePen implements Product {
    private char ulchar;
    public UnderlinePen(char ulchar){
        this.ulchar=ulchar;
    }
    @Override
    public void use(String e) {
        int length=e.getBytes().length;
        System.out.println("\""+e+"\"");
        for(int i=0;i<length;i++){
            System.out.print(ulchar);
        }
        System.out.println();
    }

    @Override
    public Product createClone() {
        Product p=null;
        try{
            p=(Product)clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return p;
    }
}
