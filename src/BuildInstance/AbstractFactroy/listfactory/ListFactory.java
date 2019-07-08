package BuildInstance.AbstractFactroy.listfactory;

import BuildInstance.AbstractFactroy.factory.Factory;
import BuildInstance.AbstractFactroy.factory.Link;
import BuildInstance.AbstractFactroy.factory.Page;
import BuildInstance.AbstractFactroy.factory.Tray;

public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption,url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title,author);
    }
}
