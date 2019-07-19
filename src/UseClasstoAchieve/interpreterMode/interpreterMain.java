package UseClasstoAchieve.interpreterMode;

import UseClasstoAchieve.interpreterMode.language.*;
import UseClasstoAchieve.interpreterMode.turtle.TurtleCanvas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class interpreterMain extends Frame implements ActionListener {

    private TurtleCanvas canvas=new TurtleCanvas(400,400);
    private InterpreterFacade facade=new InterpreterFacade(canvas);
    private TextField programTextField=new TextField("program repeat 3 go right go left end end");

    public interpreterMain(String title){
        super(title);
        canvas.setExecutor(facade);
        setLayout(new BorderLayout());
        programTextField.addActionListener(this);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        add(programTextField,BorderLayout.NORTH);
        add(canvas,BorderLayout.CENTER);
        pack();
        parseAndExecute();
        show();
    }
    private void parseAndExecute() {
        String programText=programTextField.getText();
        System.out.println("programText = "+programText);
        facade.parse(programText);
        canvas.repaint();
    }

    public static void main(String[] args){
        new interpreterMain("Interpreter Pattern Sample");
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==programTextField){
            parseAndExecute();
        }
    }
    public void Discard(){
        try(BufferedReader reader=new BufferedReader(new FileReader("program.txt"))){
            String text;
            while((text=reader.readLine())!=null){
                System.out.println("text= \""+text+"\"");
                Node node=new ProgramNode();
                node.parse(new Context(text));
                System.out.println("node= "+node);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
