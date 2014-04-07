/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import Control.Main;
import com.sun.lwuit.Form;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;

/**
 *
 * @author TRITUEVIET
 */
public class ViewHome extends javax.microedition.lcdui.Form implements CommandListener{
private Main main;
private ChoiceGroup fun = new ChoiceGroup("Chọn chức năng", ChoiceGroup.EXCLUSIVE);
private Command exit = new Command("EXIT", Command.ITEM, 2);
private Command next = new Command("NEXT", Command.ITEM, 1);
    public ViewHome(String title, Main main) {
        super(title);
        this.main = main;
        fun.append("E-v", null);
        fun.append("multi", null);
        fun.append("para", null);
        this.addCommand(exit);
        this.setCommandListener(this);
    }
// ke thua tu icondetail   de no co form exit va about do   cai exit    co the bo
    public void showHome(){
        Display.getDisplay(main).setCurrent(this);
    }

    public void commandAction(Command c, Displayable d) {
        if(c == next){
            switch(fun.getSelectedIndex()){
                
            }
        }
        else if( c == exit){
            main.destroyApp(true);
        }
    }
      
}
