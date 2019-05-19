package AvoidWaste.FlyWeight;

import java.util.HashMap;

public class BigCharFactory {
    //管理已经生成的BigChar的实例
    private HashMap pool=new HashMap();
    //Singleton模式
    private static BigCharFactory singleton=new BigCharFactory();
    //获取唯一的实例
    public static BigCharFactory getInstance(){
        return singleton;
    }
    //生成BigChar类的实例
    public synchronized BigChar getBigChar(char charName){
        BigChar bo=(BigChar)pool.get(""+charName);
        if(null==bo){
            bo=new BigChar(charName);
            pool.put(""+charName,bo);
        }
        return bo;
    }
}
