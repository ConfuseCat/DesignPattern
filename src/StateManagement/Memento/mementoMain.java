package StateManagement.Memento;

import StateManagement.Memento.game.Gamer;
import StateManagement.Memento.game.Memento;

import java.io.*;

public class mementoMain {
    public static void main(String[] args){
        Gamer gamer=new Gamer(100);
        Memento memento=read("game.dat");
        if(memento!=null) {
            gamer.restoreMemento(memento);
        }else{
            memento=gamer.createMemento();
        }
        for(int i=0;i<100;i++){
            System.out.println("===== "+i);
            System.out.println("当前状态："+gamer);

            gamer.bet();

            System.out.println("所持金钱为"+gamer.getMoney()+"元。");
            if(gamer.getMoney()>memento.getMoney()){
                System.out.println(" （所持金钱增加了许多，因此保存游戏当前的状态）");
                memento=gamer.createMemento();
                write("game.dat",memento);
            }else if(gamer.getMoney()<memento.getMoney()/2){
                System.out.println(" （所持金钱减少了许多，因此将游戏恢复至以前的状态）");
                gamer.restoreMemento(memento);
            }
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println();
        }

    }
    public static void write(String filePath,Memento memento){
        //write Obj to File
        ObjectOutputStream oos=null;
        try{
            oos=new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(memento);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static Memento read(String filePath){
        //Read Obj from File
        File file=new File(filePath);
        if(!file.exists())
            return null;
        Memento memento=null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            memento =(Memento) ois.readObject();
            System.out.println(memento);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return memento;
    }
}
