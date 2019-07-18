package Simplify.Mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener,Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    public LoginFrame(String title){
        super(title);
        setBackground(Color.lightGray);
        setLayout(new GridLayout(4,2));
        createColleagues();
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);
        colleagueChanged();
        pack();
        show();
    }
    @Override
    public void createColleagues() {
        CheckboxGroup group =new CheckboxGroup();
        checkGuest=new ColleagueCheckbox("Guest",group,true);
        checkLogin=new ColleagueCheckbox("Login",group,false);
        textUser=new ColleagueTextField("",10);
        textPass=new ColleagueTextField("",10);
        textPass.setEchoChar('*');
        buttonOk=new ColleagueButton("OK");
        buttonCancel=new ColleagueButton("Cancel");
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textPass.addTextListener(textPass);
        textUser.addTextListener(textUser);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    @Override
    public void colleagueChanged() {
        if(checkGuest.getState()){
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        }else{
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }

    private void userpassChanged() {
        if(textUser.getText().length()>0){
            textPass.setColleagueEnabled(true);
            if(textPass.getText().length()>0){
                buttonOk.setColleagueEnabled(true);
            }else{
                buttonOk.setColleagueEnabled(false);
            }
        }else{
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    /**
     * Invoked when an action occurs.
     *
     *
     * @param e
     */
    @Override

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
