package AdapttoDesignMode.Adapter.ObjectAdapter;

public class DdapterMain {
    public static void main(String[] args){
        Print p=new PrintBanner("hello");
        p.printWeak();
        p.printStrong();
    }
}
