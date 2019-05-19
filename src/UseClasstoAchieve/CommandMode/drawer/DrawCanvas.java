package UseClasstoAchieve.CommandMode.drawer;

import UseClasstoAchieve.CommandMode.command.MacroCommand;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {
    //颜色
    private Color color=Color.red;
    //要绘制的圆点半径
    private int radius=6;
    //命令的历史纪录
    private MacroCommand history;
    //构造函数
    public DrawCanvas(int width,int height,MacroCommand history){
        setSize(width,height);
        setBackground(Color.white);
        this.history=history;
    }
    //全部重新绘制
    public void paint(Graphics g){
        history.execute();
    }
    @Override
    public void draw(int x, int y) {
        Graphics graphics=getGraphics();
        graphics.setColor(color);
        graphics.fillOval(x-radius,y-radius,radius*2,radius*2);
    }
}
