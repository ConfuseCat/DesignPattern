package BuildInstance.AbstractFactroy.listfactory;

import BuildInstance.AbstractFactroy.factory.Item;
import BuildInstance.AbstractFactroy.factory.Tray;

import java.util.Iterator;

public class ListTray extends Tray {
    public ListTray(String caption){
        super(caption);
    }
    @Override
    public String makeHTML() {
        StringBuffer buffer=new StringBuffer();
        buffer.append("<li>\n");
        buffer.append(caption+"\n");
        buffer.append("<u1>\n");
        Iterator it=tray.iterator();
        while(it.hasNext()){
            Item item=(Item) it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</u1>\n");
        buffer.append("</li>\n");
        return buffer.toString();
    }
}
