package UseClasstoAchieve.CommandMode;

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
    //构造函数
    public CommandMain(String title){
        super(title);
        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(this);

        Box buttonBox=new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
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
    //main函数
    public static void main(String[] args){
        new CommandMain("Command Pattern Sample");
    }
}
