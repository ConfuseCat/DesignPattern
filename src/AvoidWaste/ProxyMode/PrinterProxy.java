package AvoidWaste.ProxyMode;


public class PrinterProxy implements Printable{
    private String name;
    private Printer real;
    public PrinterProxy(){}
    public PrinterProxy(String name){
        this.name=name;
    }
    @Override
    public synchronized void setPrinterName(String name) {
        if(real!=null){
            real.setPrinterName(name);
        }
        this.name=name;
    }

    @Override
    public String getPrinterName() {
        return this.name;
    }

    @Override
    public void print(String string) {
        realize();
        real.print(string);
    }
    private synchronized void realize(){
        if(real==null){
            real=new Printer(this.name);
        }
    }
}
