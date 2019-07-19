package UseClasstoAchieve.interpreterMode.language;

public class PrimitiveCommandNode extends Node {
    private String name;
    private Executor executor;
    @Override
    public void parse(Context context) throws ParseException {
        name=context.getCurrentToken();
        context.skipToken(name);
//        if(!name.equals("go")&&!name.equals("right")&&!name.equals("left")){
//            throw new ParseException(name+" is undefined");
//        }
        executor=context.createExecutor(name);
    }
    public String toString(){
        return name;
    }

    @Override
    public void execute() throws ExecutionException {
        if(executor==null){
            throw new ExecutionException(name+": is not defined");
        }else{
            executor.execute();
        }
    }
}
