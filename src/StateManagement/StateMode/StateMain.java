package StateManagement.StateMode;

public class StateMain {
    public static void main(String[] args){
        safeFrame frame=new safeFrame("State Sample");
//        while (true){
            for(int hour=0;hour<24;hour++){
                frame.setClock(hour);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
//        }
    }
}
