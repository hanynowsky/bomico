package com.otika.gtk;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.gnome.gdk.Event;
import org.gnome.gdk.Pixbuf;
import org.gnome.gtk.*;

/**
 *
 * @author <a href="mailto:hanynowsky@gmail.com">Hanynowsky - OTIKA</a>
 */
public class GtkGUI extends Window {

    // Declarations
    Window window;
    VBox vbox, vbox2, vbox3;
    HBox hbox, hbox2, hbox3, hbox4, hbox5, hbox6;
    ToolButton exitTB, computeTB, helpTB;
    Button computeBut;
    Toolbar toolbar;
    MenuBar menubar;
    Menu fileMenu, viewMenu, helpMenu;
    MenuItem fullsMI;
    VSeparator separator;
    HScale weightScale, heightScale, ageScale;
    Label resultL, transL;
    AboutDialog about;
    Pixbuf iconWindow, icon2, icon3, icon4;

    public GtkGUI() {
        try {
            // Widget Creation
            iconWindow = new Pixbuf(this.getClass().getResource("/resource/pingu.png").getFile(), 48, 48, true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GtkGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        window = new Window();
        window.setDefaultSize(600, 400);
        window.setIcon(iconWindow);
        window.setTitle("Body Mass Index Computer - Bomico");
        window.showAll();
        window.connect(new Window.DeleteEvent() {
            @Override
            public boolean onDeleteEvent(Widget source, Event event) {
                Gtk.mainQuit();
                return false;
            }
        });

        menubar = new MenuBar();
        

    } // End of Constructor

    public static void main(String[] args) {
        Gtk.init(args);
        GtkGUI gui = new GtkGUI();
        gui.showme();

    }

    private void showme() {
        Gtk.main();
    }
}
