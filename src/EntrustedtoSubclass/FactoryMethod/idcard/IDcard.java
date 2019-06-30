package EntrustedtoSubclass.FactoryMethod.idcard;

import EntrustedtoSubclass.FactoryMethod.framework.Product;

public class IDcard extends Product {
    private String owner;
    IDcard(String owner){
        System.out.println("制作"+owner+"的ID卡。");
        this.owner=owner;
    }
    @Override
    public void use() {
        System.out.println("使用"+owner+"的ID卡。");
    }
    public String getOwner(){
        return owner;
    }
    public String toString(){
        return this.owner;
    }
}
