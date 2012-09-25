package com.otika.gtkgui;

import bim.Computer;
import java.io.*;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.gnome.gdk.Event;
import org.gnome.gdk.Pixbuf;
import org.gnome.gtk.*;

/**
 * @version 1.0.2
 * @author <a href="mailto:hanynowsky@gmail.com">Hanine HAMZIOUI - OTIKA</a>
 * Graphical user interface using GTK Library (Tested in Ubuntu Linux 12.04).
 */
public class GtkGUI extends Window {

    Window window;
    VBox vbox, vbox2, vbox3, vbox4, vbox5;
    HBox hbox, hbox2, hbox3, hbox4, hbox5;
    Alignment align, align2, align3;
    MenuBar menubar;
    AboutDialog about;
    Fixed fixed, fixed2, fixed3;
    Toolbar toolbar;
    ToolButton quitTB, aboutTB, computeTB;
    Pixbuf quitIcon, windowIcon, aboutIcon, computeIcon;
    Image image;
    Border border;
    HSeparator hsep;
    Label introLabel, weightLabel, heightLabel, ageLabel;
    HScale weightScale, ageScale, heightScale;
    Notebook notebook, stomaNB;
    Button computeBut;
    TextView textView;
    MenuItem aboutItem, fileItem, helpItem, fsItem, viewItem, quitItem;
    Menu fileMenu, viewMenu, helpMenu;
    Computer c = new Computer();

    /**
     * Constructor
     */
    public GtkGUI() {

        // Widget Creation
        try {
            computeIcon = new Pixbuf(getClass().getResource("/resource/114.png").getFile(), 20, 20, false);
            quitIcon = new Pixbuf(getClass().getResource("/resource/53.png").getFile(), 20, 20, false);
            windowIcon = new Pixbuf(getClass().getResource("/resource/pingu.png").getFile(), 48, 48, false);
            aboutIcon = new Pixbuf(getClass().getResource("/resource/info.png").getFile(), 20, 20, false);
            //quitIcon.scale(16, 16, InterpType.BILINEAR);
            image = new Image(quitIcon);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GtkGUI.class.getName()).log(Level.SEVERE, null, ex);
        }


        computeBut = new Button("Compute");
// new Image(computeIcon)
        //    computeBut.setLabel("Compute");
        introLabel = new Label("Adjust the sliders and click on <b>'Compute'</b> button.");
        introLabel.setUseMarkup(true);
        introLabel.setSelectable(true);

        //introLabel.setSizeRequest(290, 20);
        align = new Alignment(0, 0, 0, 0);
        window = new Window();
        window.setTitle("Bomico - Body Mass Index Computer ");
        window.setDefaultSize(600, 250);
        window.setSizeRequest(600, 250);
        window.setBorderWidth(1);
        window.setResizable(true);
        window.setIcon(windowIcon);
        window.setFullscreen(false);
        window.setMaximize(false);


        weightScale = new HScale(40, 200, 100);
        weightScale.setDigits(1);
        heightScale = new HScale(140, 210, 100);
        heightScale.setDigits(1);
        ageScale = new HScale(18, 80, 100);
        //ageScale.setDigits(1);
        menubar = new MenuBar();

        fileMenu = new Menu();
        viewMenu = new Menu();
        helpMenu = new Menu();

        aboutItem = new MenuItem("About");
        fileItem = new MenuItem("File");
        helpItem = new MenuItem("Help");
        fsItem = new MenuItem("View Fullscreen");
        viewItem = new MenuItem("View");
        helpMenu.append(aboutItem);
        quitItem = new MenuItem("Quit");
        viewMenu.append(fsItem);
        fileMenu.append(quitItem);

        fileItem.setSubmenu(fileMenu);
        viewItem.setSubmenu(viewMenu);
        helpItem.setSubmenu(helpMenu);

        menubar.append(fileItem);
        menubar.append(viewItem);
        menubar.append(helpItem);

        toolbar = new Toolbar();
        toolbar.setOrientation(Orientation.HORIZONTAL);
        toolbar.setStyle(ToolbarStyle.BOTH);
        toolbar.setSizeRequest(window.getWidth() - 2, 40);
        quitTB = new ToolButton(image, "Quit");
        quitTB.setLabel("Quit");
        //quitTB.setSizeRequest(160, 48);
        aboutTB = new ToolButton(new Image(aboutIcon), null);
        aboutTB.setLabel("About");
        computeTB = new ToolButton(new Image(computeIcon), null);
        computeTB.setLabel("Compute");
        toolbar.add(quitTB);
        toolbar.add(computeTB);
        toolbar.add(aboutTB);
        hsep = new HSeparator();
        weightLabel = new Label("<b>Weight</b>");
        weightLabel.setUseMarkup(true);
        weightLabel.setExpandHorizontal(false);
        heightLabel = new Label("<b>Height</b>");
        heightLabel.setUseMarkup(true);
        ageLabel = new Label("<b>Age</b>");
        ageLabel.setUseMarkup(true);
        TextBuffer infoBuffer = new TextBuffer();
        infoBuffer.setText("Body Mass Index is a numerical value that indicates whether a person is healthy or not"
                + " depending on his/her body weight and height.");
        textView = new TextView(infoBuffer);
        //textView.attachSpell("en");
        textView.setEditable(false);
        textView.setWrapMode(WrapMode.WORD);



        // About Dialog
        about = new AboutDialog();
        String[] people = {"Hanine HAMZIOUI <hanynowsky@gmail.com>", "Gnome <www.gnome.org>"};
        about.setArtists(people);
        about.setAuthors(people);
        about.setCopyright("@ 2012 - Copyright");
        about.setLicense("GNU GPL v3");
        about.setProgramName("Bomico - Body Mass Index Computer");
        about.setWebsite("http://hanynowsky.wordpress.com");
        about.setLogo(windowIcon);
        about.setVersion("1.0.2");
        about.setModal(true);
        //


// CONTAINERS

        fixed = new Fixed();
        fixed2 = new Fixed();
        fixed3 = new Fixed();
        hbox = new HBox(false, 10);
        hbox2 = new HBox(false, 10);
        hbox3 = new HBox(false, 10);
        hbox5 = new HBox(false, 10);
        hbox4 = new HBox(Boolean.FALSE, 10);
        vbox5 = new VBox(Boolean.FALSE, 10); // recheck this box
        vbox = new VBox(false, 1);
        vbox.setSizeRequest(window.getWidth() - 2, window.getHeight() - 2);
        vbox.setBorderWidth(1);
        vbox2 = new VBox(true, 3);
        notebook = new Notebook();

// Container packing//////////////////////////

        //vbox.packStart(fixed, false, false, 0);
        //fixed3.add(toolbar);
        vbox.packStart(menubar, false, false, 0);
        //vbox.packStart(toolbar, false, false, 0);

        vbox.packStart(fixed2, false, false, 0);
        vbox.packStart(introLabel, false, false, 10);
        vbox.packStart(hbox, false, false, 0);
        vbox.packStart(hbox2, false, false, 0);
        vbox.packStart(hbox3, false, false, 0);
        vbox.packStart(hsep, false, false, 10);
        // vbox.add(fixed3);
        vbox.packStart(hbox4, false, false, 1);
        vbox2.packStart(textView, false, true, 1);

        hbox4.packStart(computeBut, true, false, 1);
        //fixed3.move(computeBut, (window.getWidth() / 2) - (computeBut.getAllocatedWidth() / 2), 0);
        notebook.appendPage(vbox, new Label("Body Mass Index"));
        //  align.add(vbox);
        notebook.appendPage(vbox2, new Label("Infos"));
        notebook.setBorderWidth(15);


        hbox.packStart(weightLabel, false, false, 1); // use Fixed instead
        hbox.packEnd(weightScale, true, true, 1);

        hbox2.packStart(heightLabel, false, false, 1);
        hbox2.packEnd(heightScale, true, true, 1);

        hbox3.packStart(ageLabel, false, false, 1);
        hbox3.packEnd(ageScale, true, true, 1);

        vbox5.packStart(toolbar, false, false, 1);
        vbox5.packStart(hbox5, false, false, 1);

        vbox5.packStart(new Label("Hello"), false, false, 1);
        window.add(vbox5);
        window.showAll();
        //window.present(); // May not be necessary
/////////////////////////////////////////////   


// Widget Events
        aboutTB.connect(new ToolButton.Clicked() {
            @Override
            public void onClicked(ToolButton source) {
                about.run();
                about.hide();
            }
        });

        window.connect(new Window.DeleteEvent() {
            @Override
            public boolean onDeleteEvent(Widget widget, Event event) {
                Gtk.mainQuit();
                return false;
            }
        });

        aboutItem.connect(new MenuItem.Activate() {
            @Override
            public void onActivate(MenuItem source) {
                about.run();
                about.hide();
            }
        });
        quitItem.connect(new MenuItem.Activate() {
            @Override
            public void onActivate(MenuItem source) {
                Gtk.mainQuit();
            }
        });
        viewItem.connect(new MenuItem.Activate() {
            @Override
            public void onActivate(MenuItem source) {
                // Does not work if Window is set to maximizable FALSE
                // Todo: handle conditional behavior here
                window.setFullscreen(true);
            }
        });

        quitTB.connect(new ToolButton.Clicked() {
            @Override
            public void onClicked(ToolButton source) {
                System.out.println("Application shut down");
                Gtk.mainQuit();
            }
        });

        heightScale.connect(new HScale.ValueChanged() {
            @Override
            public void onValueChanged(Range source) {
                introLabel.setLabel(String.valueOf(heightScale.getValue()));
            }
        });

        computeBut.connect(new Button.Clicked() {
            @Override
            public void onClicked(Button source) {
                compute();
            }
        });

        computeTB.connect(new ToolButton.Clicked() {
            @Override
            public void onClicked(ToolButton source) {
                compute();
            }
        });
//

        // Testing
        test();
        //

    } // END OF CONSTRUCTOR

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        Gtk.init(args);
        GtkGUI gtkgui = new GtkGUI();
        gtkgui.showWindow();

        System.out.println("GTK_GUI Invoked ");
        System.out.println(System.getProperty("os.name"));

    }

    /**
     * Displays the main GUI window
     */
    private void showWindow() {
        Gtk.main();
    }

    /**
     * This method allows us to test some attributes and properties
     */
    private void test() {
        System.out.println(computeBut.getPreferredWidthMinimum());
        System.out.println(computeBut.getAlignmentX());

        try {
            //        byte[] bytes = new byte[1024];
            Process process = Runtime.getRuntime().exec("uname -a");
            InputStream is = process.getInputStream();
            // is.read(b, 0, len)


            System.out.println(is);
            // outstream.write(bytes);
            //outstream.close();

        } catch (IOException ex) {
            Logger.getLogger(GtkGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void compute() {
        c.computer(heightScale.getValue(), weightScale.getValue());
        String bmi = new DecimalFormat("#.##").format(c.getResult());
        introLabel.setLabel("BMI = <b>" + bmi + "</b>");
        try {
            if (System.getProperty("os.name").toLowerCase().contains("linux")) {
                Runtime.getRuntime().exec("notify-send -t 3600 BMI " + bmi);
            }
        } catch (IOException ex) {
            Logger.getLogger(GtkGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
} // END OF CLASS
