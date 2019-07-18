package Simplify.Mediator;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements ItemListener,Colleague {
    private Mediator mediator;
    public ColleagueCheckbox(String caption,CheckboxGroup group,boolean state){
        super(caption,group,state);
    }
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator=mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }

    /**
     * Invoked when an item has been selected or deselected by the user.
     * The code written for this method performs the operations
     * that need to occur when an item is selected (or deselected).
     *
     * @param e
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        mediator.colleagueChanged();
    }
}
