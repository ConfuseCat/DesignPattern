package Simplify.Mediator;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ColleagueTextField extends TextField implements TextListener,Colleague {
    private Mediator mediator;
    public ColleagueTextField(String text,int columns){
        super(text,columns);
    }
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator=mediator;
    }
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
        setBackground(enabled ? Color.white : Color.lightGray);
    }

    /**
     * Invoked when the value of the text has changed.
     * The code written for this method performs the operations
     * that need to occur when text changes.
     *
     * @param e
     */
    @Override
    public void textValueChanged(TextEvent e) {
        mediator.colleagueChanged();
    }
}
