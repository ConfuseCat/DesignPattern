package AdapttoDesignMode.Adapter.AdapeterHomework;

import java.io.IOException;

public class homeMain {
    public static void main(String[] args){
        FileIO fileIO=new FileProperties();
        try{
            fileIO.readFromFile("src\\AdapttoDesignMode\\Adapter\\AdapeterHomework\\file.txt");
            fileIO.setValue("year","2004");
            fileIO.setValue("month","4");
            fileIO.setValue("day","21");
            fileIO.writeToFile("newfile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
