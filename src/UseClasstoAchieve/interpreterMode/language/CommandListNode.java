package UseClasstoAchieve.interpreterMode.language;

import java.util.ArrayList;
import java.util.Iterator;

public class CommandListNode extends Node {
    private ArrayList list=new ArrayList();

    @Override
    public void parse(Context context) throws ParseException {
        while (true){
            if(context.getCurrentToken()==null){
                throw new ParseException("Missing 'end'");
            }else if(context.getCurrentToken().equals("end")){
                context.skipToken("end");
                break;
            }else{
                Node commandNode=new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
            }
        }
    }

    public String toString(){
        return list.toString();
    }

    @Override
    public void execute() throws ExecutionException {
        Iterator it = list.iterator();
        while(it.hasNext()){
            ((CommandNode)it.next()).execute();
        }
    }
}
