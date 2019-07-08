package BuildInstance.AbstractFactroy.listfactory;

import BuildInstance.AbstractFactroy.factory.Item;
import BuildInstance.AbstractFactroy.factory.Page;

import java.util.Iterator;

public class ListPage extends Page {
    public ListPage(String title,String author){
        super(title,author);
    }
    @Override
    protected String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html><head><title>"+title+"</title></head>");
        buffer.append("<body>\n");
        buffer.append("<h1>"+title+"</h1>\n");
        buffer.append("<u1>\n");
        Iterator it=content.iterator();
        while (it.hasNext()){
            Item item=(Item)it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</u1>\n");
        buffer.append("<hr><address>"+author+"</address>");
        buffer.append("</body></html>\n");
        return buffer.toString();
    }
}
