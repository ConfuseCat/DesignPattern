package AvoidWaste.FlyWeight;

public class FlyWeightMain {
    public static void mian(String[] args){
        if(args.length==0){
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Mian 1212123");
            System.exit(0);
        }
        BigString bigString=new BigString(args[0]);
        bigString.print();
    }
}
