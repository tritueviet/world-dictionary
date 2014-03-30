/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.nokia.mid.ui.CategoryBar;
import com.nokia.mid.ui.ElementListener;
import com.nokia.mid.ui.IconCommand;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;
import event.Event;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Image;
import views.LoadScreen;
import views.ViewHome;

/**
 *
 * @author TRITUEVIET
 */
public class Controller {

    private static Controller instance = null;
    public CategoryBar categoryBar;
    private Image icon;
    private Main main;
    public static Resources theme = null;
    public static  int size=401;
    public ViewHome viewHome;
    public static Vector items=null;
    private Controller() {
        init();
    }

    public static void loadTheme() {
        System.out.println(" size: "+size);
        try {
            if( size>350) theme = Resources.open("/themes/full_touch_theme.res");
            else theme = Resources.open("/themes/asha2013_theme.res");
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
        } catch (Throwable ex) {
             System.out.println("loi load theme");
        }
    }

    public void init() {
        IconCommand[] iconCommands = new IconCommand[2];
        for (int i = 0; i < iconCommands.length; i++) {
            try {
                icon = Image.createImage("/images/icon" + (i + 1) + ".png");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            iconCommands[i] = new IconCommand("", icon, icon, Command.SCREEN, 1);

        }
        categoryBar = new CategoryBar(iconCommands, true);
        // categoryBar.setHighlightColour(bankId);

        categoryBar.setElementListener(new CategoryElementListener());

        //categoryBar.setVisibility(true);

    }
     public void loadData() {
        items = new Vector();
        DataInputStream data = new DataInputStream(getClass().getResourceAsStream("/models/word.wall"));
        try {
            for (int i = 0; i < 3466; i++) {
                items.addElement(data.readUTF());
            }
            data.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
            for (int i = 0; i < 3466; i++) {
                System.out.println("\n"+items.elementAt(i).toString());
            }
    }
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void chay(Main main) {
        this.main = main;
        if (0 == 0) {
            LoadScreen load = new LoadScreen(main);
            javax.microedition.lcdui.Display.getDisplay(main).setCurrent(load);
            load.start();
            load = null;
        }
        loadData();
        categoryBar.setVisibility(false);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        categoryBar.setVisibility(true);
        loadTheme();
        //  show in here
        showHome();
    }

    public void categorry() {
        if (categoryBar.getVisibility() == true) {
            categoryBar.setVisibility(false);
        } else {
            categoryBar.setVisibility(true);
        }
    }

    public void handleEvent(int eventType, Event evt) {
        switch (eventType) {

        }
    }

    public void exit() {
        //   saveConfig();
        main.destroyApp(true);
    }

    public void showAbout() {
        // hiển thị giới thiệu
    }
    public void showHome() {
        viewHome = new ViewHome();
        viewHome.show();
    }
    
    class CategoryElementListener implements ElementListener {

        public void notifyElementSelected(CategoryBar bar, int selectedIndex) {
            if (bar == categoryBar) {
                if (selectedIndex == 0) {
                    // showFindATMView();
                } else if (selectedIndex == 1) {
                    // autoFinder();
                } else if (selectedIndex == 2) {
                    // showLocationATM();
                } else if (selectedIndex == 3) {
                    // showOptionATM();
                } else {
                    try {
                        exit();
                    } catch (Exception ex) {
                        System.out.println("k thoats ddc ");
                    }
                }

            }
        }
    }
}