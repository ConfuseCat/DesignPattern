package AvoidWaste.ProxyMode;

public class Printer implements Printable{
    private String name;

    public Printer(){
        heavyJod("正在生成Printer的实例");
    }
    public Printer(String name){
        this.name=name;
        heavyJod("正在生成Printer的实例（"+name+"）");
    }

    @Override
    public void setPrinterName(String name) {
        this.name=name;
    }

    @Override
    public String getPrinterName() {
        return this.name;
    }

    @Override
    public void print(String string) {
        System.out.println("==="+name+"===");
        System.out.println(string);
    }
    private void heavyJod(String msg){
        System.out.print(msg);
        for(int i=0;i<5;i++){
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.print("-");
        }
        System.out.println("结束。");
    }
}
