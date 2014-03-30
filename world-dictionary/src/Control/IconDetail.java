/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import models.Var;

/**
 *
 * @author TRITUEVIET
 */
public class IconDetail extends Form {

    //Command login = new Command(Var.dangNhap);
    //Command signUp = new Command(Var.dangKi);
    Command exit = new Command(Var.thoat);
    Command about = new Command(Var.gioiThieu);
    /*Command timerApp = new Command(Var.henGio);
    Command category = new Command(Var.theLoai);
    Command lastHeard = new Command(Var.ngheGanDay);
    Command ringback = new Command(Var.nhacCho);
    Command playlist = new Command(Var.playlistCaNhan);
    Command logout = new Command(Var.dangXuat);
*/
    public IconDetail() {
  //      addCommand(timerApp);
//        addCommand(category);
        addCommand(about);
//        addCommand(signUp);
//        addCommand(login);
        addCommand(exit);

    }
/*
    public void logined() {
        this.removeCommand(exit);
        this.removeCommand(login);
        this.removeCommand(signUp);
        addCommand(lastHeard);
        addCommand(ringback);
        addCommand(playlist);
        addCommand(logout);
 
 
        addCommand(exit);
    }
*/
   

}
