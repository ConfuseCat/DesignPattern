package BuildInstance.ProtoType.framework;

import java.util.HashMap;

public class Manager {
    private HashMap showCase=new HashMap();
    public void register(String name,Product proto){
        showCase.put(name,proto);
    }
    public Product create(String protoName){
        Product p=(Product)showCase.get(protoName);
        return p.createClone();
    }
}
