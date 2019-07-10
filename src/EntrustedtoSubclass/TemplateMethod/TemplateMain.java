package EntrustedtoSubclass.TemplateMethod;

/**
 * Template Method模式实现逻辑
 * 在父类中定义处理流程的框架，在子类中实现具体处理
 */
public class TemplateMain {
    public static void main(String[] args){
        AbstractDisplay display1=new CharDisplay('H');
        AbstractDisplay display2=new StringDisplay("hello,world");
        AbstractDisplay display3=new StringDisplay("你好，世界。");
        display1.display();
        display2.display();
        display3.display();
    }
}
