package BuildInstance.AbstractFactroy;

import BuildInstance.AbstractFactroy.factory.Factory;
import BuildInstance.AbstractFactroy.factory.Link;
import BuildInstance.AbstractFactroy.factory.Page;
import BuildInstance.AbstractFactroy.factory.Tray;
import BuildInstance.AbstractFactroy.listfactory.ListFactory;
import BuildInstance.AbstractFactroy.tablefactory.TableFactory;

public class factoryMain {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if(args.length!=1){
            System.out.println("Usage: java Main class.name.of.ConcreteFactory");
            System.out.println("Example 1: java Main listFactory.ListFactory");
            System.out.println("Example 2: java Main tableFactory.TableFactory");
            System.exit(0);
        }
        ListFactory listFactory=null;
        TableFactory tableFactory=null;
        Factory factory=Factory.getFactory(args[0]);
        Link people=factory.createLink("人命日报","http://www.people.com.cn/");
        Link gmw=factory.createLink("光明日报","http://www.gmw.cn/");

        Link us_yahoo=factory.createLink("Yahoo!","http://www.yahoo.com/");
        Link jb_yahoo=factory.createLink("Yahoo!Japan","http://yahoo.co.jp/");
        Link excite=factory.createLink("Excite","http://excite.com/");
        Link google=factory.createLink("Google","http://www.google.com/");

        Tray traynews=factory.createTray("日报");
        traynews.add(people);
        traynews.add(gmw);

        Tray trayYahoo=factory.createTray("Yahoo!");
        trayYahoo.add(us_yahoo);
        trayYahoo.add(jb_yahoo);

        Tray traysearch=factory.createTray("搜索引擎");
        traysearch.add(trayYahoo);
        traysearch.add(excite);
        traysearch.add(google);

        Page page=factory.createPage("LinkPage","杨文轩");
        page.add(traynews);
        page.add(traysearch);
        page.output();
    }
}
