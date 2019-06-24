package AccessDataStructure.ChainOfResponsibility;

public class LimitSupport extends Support{
    private int Limit;
    public LimitSupport(String name,int limit){
        super(name);
        this.Limit=limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber()<this.Limit){
            return true;
        }else
            return false;
    }
}
