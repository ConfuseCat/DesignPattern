package UseClasstoAchieve.CommandMode.drawer;

import java.awt.*;

public interface Drawable {
    public abstract void init();
    public abstract void draw(int x,int y);
    public abstract void setColor(Color color);
}
