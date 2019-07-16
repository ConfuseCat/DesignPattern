package BuildInstance.ProtoType;

import BuildInstance.ProtoType.framework.Product;

public class MessageBox implements Product {
    private char decochar;
    public MessageBox(char decochar){
        this.decochar=decochar;
    }
    @Override
    public void use(String e) {
        int length=e.getBytes().length;
        for(int i=0;i<length+4;i++){
            System.out.print(decochar);
        }
        System.out.println("");
        System.out.println(decochar+" "+e+" "+decochar);
        for(int i=0;i<length+4;i++){
            System.out.print(decochar);
        }
        System.out.println("");
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
