package UseClasstoAchieve.CommandMode;

import UseClasstoAchieve.CommandMode.drawer.ColorCommand;
import UseClasstoAchieve.CommandMode.command.Command;
import UseClasstoAchieve.CommandMode.command.MacroCommand;
import UseClasstoAchieve.CommandMode.drawer.DrawCanvas;
import UseClasstoAchieve.CommandMode.drawer.DrawCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CommandMain extends JFrame implements ActionListener, MouseMotionListener, WindowListener {
    //绘制的历史纪录
    private MacroCommand history=new MacroCommand();
    //绘制区域
    private DrawCanvas canvas=new DrawCanvas(400,400,history);
    //删除按钮
    private JButton clearButton=new JButton("clear");
    //撤销按钮
    private JButton undoButton=new JButton("undo");
    //绿色按钮
    private JButton greenButton=new JButton("green");
    //蓝色按钮
    private JButton blueButton=new JButton("blue");
    //红色按钮
    private JButton redButton=new JButton("red");
    //构造函数
    public CommandMain(String title){
        super(title);
        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(this);
        undoButton.addActionListener(this);
        redButton.addActionListener(this);
        blueButton.addActionListener(this);
        greenButton.addActionListener(this);

        Box buttonBox=new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(undoButton);
        buttonBox.add(blueButton);
        buttonBox.add(redButton);
        buttonBox.add(greenButton);
        Box mainBox=new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        show();
    }
    //ActionListener接口中的方法
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==clearButton){
            history.clear();
            canvas.repaint();
        }else if(e.getSource()==undoButton){
            history.undo();
            canvas.repaint();
        }else if(e.getSource()==blueButton){
            Command cmd=new ColorCommand(canvas,Color.blue);
            history.append(cmd);
            cmd.execute();
        }else if(e.getSource()==redButton){
            Command cmd=new ColorCommand(canvas,Color.red);
            history.append(cmd);
            cmd.execute();
        }else if(e.getSource()==greenButton){
            Command cmd=new ColorCommand(canvas,Color.green);
            history.append(cmd);
            cmd.execute();
        }
    }
    //MouseMotionListener中的方法
    @Override
    public void mouseDragged(MouseEvent e) {
        Command cmd=new DrawCommand(canvas,e.getPoint());
        history.append(cmd);
        cmd.execute();
    }
    @Override
    public void mouseMoved(MouseEvent e) {}
    //WindowListener接口中的方法
    @Override
    public void windowOpened(WindowEvent e) {}
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    @Override
    public void windowClosed(WindowEvent e) {}
    @Override
    public void windowIconified(WindowEvent e) { }
    @Override
    public void windowDeiconified(WindowEvent e) { }
    @Override
    public void windowActivated(WindowEvent e) { }
    @Override
    public void windowDeactivated(WindowEvent e) { }
    public static void main(String[] args){
        new CommandMain("Command Pattern Sample");
    }
}
