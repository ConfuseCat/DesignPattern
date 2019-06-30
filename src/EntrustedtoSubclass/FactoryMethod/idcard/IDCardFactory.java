package EntrustedtoSubclass.FactoryMethod.idcard;

import EntrustedtoSubclass.FactoryMethod.framework.Factory;
import EntrustedtoSubclass.FactoryMethod.framework.Product;

import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory {
    private List owners=new ArrayList();

    @Override
    protected Product createProduct(String owner) {
        return new IDcard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDcard)product).getOwner());
    }
    public List getOwners(){
        return owners;
    }
}
