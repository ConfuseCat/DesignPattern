package BuildInstance.AbstractFactroy.tablefactory;

import BuildInstance.AbstractFactroy.factory.Factory;
import BuildInstance.AbstractFactroy.factory.Link;
import BuildInstance.AbstractFactroy.factory.Page;
import BuildInstance.AbstractFactroy.factory.Tray;

public class TableFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new TableLink(caption,url);
    }

    @Override
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new TablePage(title,author);
    }
}
