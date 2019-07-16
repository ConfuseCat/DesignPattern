package BuildInstance.ProtoType.framework;

public interface Product extends Cloneable {
    public abstract void use(String e);
    public abstract Product createClone();
}
