package UseClasstoAchieve.CommandMode.drawer;

import UseClasstoAchieve.CommandMode.command.Command;
import UseClasstoAchieve.CommandMode.drawer.Drawable;

import java.awt.*;

public class ColorCommand implements Command {
    //绘制对象
    private Drawable drawable;
    private Color color;
    public ColorCommand(Drawable drawable,Color color){
        this.drawable=drawable;
        this.color=color;
    }
    @Override
    public void execute() {
        drawable.setColor(color);
    }
}
