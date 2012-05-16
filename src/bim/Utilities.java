package bim;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * @version 1.0
 * @author Hanynowsky
 */
public class Utilities {

    String p = System.getProperty("user.home");
    String separator = File.separator;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    DateFormat monthFormat = new SimpleDateFormat("MM");
    DateFormat yearFormat = new SimpleDateFormat("yyyy");
    DateFormat dayFormat = new SimpleDateFormat("dd");
    Date date = new Date();
    String year = yearFormat.format(date).toString();
    String month = monthFormat.format(date).toString();
    String day = dayFormat.format(date).toString();
    String time = timeFormat.format(date).toString();
    Calendar cal = Calendar.getInstance();
    private String version;
    private String vendor;
    private String title;
    private String build;
    protected static String metallaf = "javax.swing.plaf.metal.MetalLookAndFeel";
    protected static String gtklaf = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
    protected static String nimbuslaf = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
    protected static String motiflaf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
    protected static String laf = UIManager.getSystemLookAndFeelClassName();
    int i = 0;

    /**
     * Creates a new instance of this object class
     */
    public Utilities() {
    }

    public static String getMotiflaf() {
        return motiflaf;
    }

    public static void setMotiflaf(String motiflaf) {
        Utilities.motiflaf = motiflaf;
    }

    public static String getNimbuslaf() {
        return nimbuslaf;
    }

    public static void setNimbuslaf(String nimbuslaf) {
        Utilities.nimbuslaf = nimbuslaf;
    }

    public static String getLaf() {
        return laf;
    }

    public static void setLaf(String laf) {
        Utilities.laf = laf;
    }

    public String getVendor() {
        // vendor = Bim.class.getPackage().getImplementationVendor();
        vendor = "Otika";
        return vendor;
    }

    public String getBuild() {
        build = "20";
        return build;
    }

    public String getTitle() {
        title = "Bomico";
        return title;
    }

    public String getVersion() {
        // version = Bim.class.getPackage().getImplementationVersion();
        version = "1.0";
        return version;
    }

    public String getGtklaf() {
        return gtklaf;
    }

    public void setGtklaf(String gtklaf) {
        Utilities.gtklaf = gtklaf;
    }

    public String getMetallaf() {
        return metallaf;
    }

    public void setMetallaf(String metallaf) {
        Utilities.metallaf = metallaf;
    }

    public String getAppInfos() {
        String infos = "Version: "+getVersion() +"\n"+"Application: " 
                +getTitle() +"\n"+"Vendor: " + getVendor() +"\n"
                +"Build: "+ getBuild()+"\n"+"User Home: "+p+"\n"+"User Directory: "
                +System.getProperty("user.dir")
                +"\n"+"System: "+System.getProperty("os.name")+" "+System.getProperty("os.version")
                +" "+System.getProperty("os.arch")+"\n"+"Java: "+System.getProperty("java.version")
                +" "+System.getProperty("java.vendor");
        return infos;
    }

    public void appendInXML(String bmival) {

        System.out.println(dateFormat.format(cal.getTime()));
        try {
            /*
             * InputStream input =
             * Utilities.class.getResourceAsStream("/config/followup.xml");
             * ClassLoader classLoader =
             * Thread.currentThread().getContextClassLoader(); URL aurl =
             * classLoader.getResource("/config/followup.xml"); URL url =
             * getClass().getResource("/config/followup.xml"); File xFile = new
             * File(url.toURI()); System.out.println("---");
             * System.out.println(xFile.getPath());
             * System.out.println(xFile.getAbsolutePath());
             * System.out.println(xFile.getCanonicalPath());
             * System.out.println("---");
             */


            String localpath = p + separator + ".bomico"
                    + separator + "config" + separator + "followup.xml";
            System.out.println(localpath);
            File xmlFile = new File(localpath);
            try {
                if (!xmlFile.exists()) {
                    new File(p + separator + ".bomico" + separator + "config").mkdirs();
                    xmlFile.createNewFile();
                    FileWriter fstream = new FileWriter(xmlFile, true);
                    try (BufferedWriter out = new BufferedWriter(fstream)) {
                        String xmlString = "<?xml version=\"1.0\" "
                                + "encoding=\"UTF-8\" standalone=\"no\"?>"
                                + "<followup></followup>";
                        out.write(xmlString);
                    }
                    System.out.println("- Followup.xml File Created");
                }
            } catch (IOException ex) {
                Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
            }

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile); // xmlFile
            //Get the root element of the xml Document;
            Element documentElement = document.getDocumentElement();
            System.out.println("documentElement:" + documentElement.toString());
            Element valueNode = document.createElement("value");
            Element yearNode = document.createElement("year");
            Element monthNode = document.createElement("month");
            Element dayNode = document.createElement("day");
            Element timeNode = document.createElement("time");
            //Text value = document.createTextNode("2");
            valueNode.setTextContent(bmival);
            yearNode.setTextContent(year);
            monthNode.setTextContent(month);
            dayNode.setTextContent(day);
            timeNode.setTextContent(time);
            //Create a Node element
            Element nodeElement = document.createElement("bmi");

            try {

                int idv = document.getLastChild().getChildNodes().getLength();
                String iv;
                if (document.getLastChild() != null) {

                    if (idv == 0) {
                        i = 1;
                    } else {
                        i = idv + 1; // i = (idv + 1) / 2;
                    }
                    iv = String.valueOf(i);

                    nodeElement.setAttribute("id", iv);
                    System.out.println("- XML Document Child nodes length is: " + idv);
                    System.out.println("- Added Element is " + iv);
                    System.out.println("- Last Child is: " + document.getLastChild().getLocalName());
                    System.out.println("- Doc URI: " + document.getDocumentURI());
                    System.out.println("- Doc Element: " + document.getDocumentElement());
                } else {
                    System.err.println("- Something is wrong with XML parsing/Appending : " + idv);
                }
            } catch (NumberFormatException | DOMException e) {
                System.err.println(e);
            }

            //append textNode to Node element;
            nodeElement.appendChild(valueNode);
            nodeElement.appendChild(yearNode);
            nodeElement.appendChild(monthNode);
            nodeElement.appendChild(dayNode);
            nodeElement.appendChild(timeNode);
            //append Node to rootNode element
            documentElement.appendChild(nodeElement);
            document.replaceChild(documentElement, documentElement);
            Transformer tFormer = TransformerFactory.newInstance().newTransformer();
            //  Set output file to xml
            tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
            // Write the document back to the file
            Source source = new DOMSource(document);
            Result result = new StreamResult(xmlFile); // xmlFile
            tFormer.transform(source, result);

        } catch (TransformerException | SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("- Success: Info appended in XML");
    }

    /**
     * Read XML data
     */
    public void readXML() {
        // TODO
    }

    public void pasteSplashFile() {
        InputStream is = getClass().getResourceAsStream("/resource/Bomico.png");
        File splash = new File(p + separator + ".bomico" + separator + "splash" + separator + "Bomico.png");
        if (!splash.exists()) {
            try {
                new File(p + separator + ".bomico" + separator + "splash").mkdirs();
                splash.createNewFile();
                try (OutputStream output = new FileOutputStream(splash)) {
                    int read = 0; // Assigned value is never used?
                    byte[] bytes = new byte[1024];

                    while ((read = is.read(bytes)) != -1) {
                        output.write(bytes, 0, read);
                    }
                    is.close();
                    output.flush();
                }

                System.out.println("New Splash file created!");
            } catch (IOException ex) {
                Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
} // END OF CLASS