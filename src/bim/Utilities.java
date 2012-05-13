package bim;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author hanynowsky
 */
public class Utilities {

    private String version = "1.0";
    private String vendor = "Otika";
    private String title = "Bomico";
    private String build = "21";
    protected static String metallaf = "javax.swing.plaf.metal.MetalLookAndFeel";
    protected static String gtklaf = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
    int i;

    /**
     * Creates a new instance of this object class
     */
    public Utilities() {
    }

    public String getVendor() {
        vendor = Bim.class.getPackage().getImplementationVendor();
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getBuild() {

        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getTitle() {
        title = Bim.class.getPackage().getImplementationTitle();
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        version = Bim.class.getPackage().getImplementationVersion();
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
        String infos = getVersion() + " \n " + getTitle() + " \n " + getVendor() + "\n" + getBuild();
        return infos;
    }

    public void appendinXML(String bmival) throws URISyntaxException {
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

        //get current date time with Calendar()
        Calendar cal = Calendar.getInstance();
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

            String p = System.getProperty("user.home");
            String localpath = p + File.separator + ".bomico"
                    + File.separator + "config" + File.separator + "followup.xml";
            System.out.println(localpath);
            File xmlFile = new File(localpath);
            // File f = new File("/home/hanine/.bomico/test.txt");
            try {
                if (!xmlFile.exists()) {
                    new File(p + "/.bomico/config").mkdirs();

                    xmlFile.createNewFile();
                    FileWriter fstream = new FileWriter(xmlFile, true);
                    try (BufferedWriter out = new BufferedWriter(fstream)) {
                        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><followup><bmi id=\"1\"><value>20</value><year>2012</year><month>05</month><day>11</day><time>11:20:03</time></bmi></followup>";
                        out.write(xmlString);
                    }
                    System.out.println("Followup.xml File Created");
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

                if (document.getLastChild() != null) {
                    int idv = document.getLastChild().getChildNodes().getLength();
                    i = (idv + 1) / 2;
                    String iv = String.valueOf(i);
                    nodeElement.setAttribute("id", iv);
                    System.out.println("XML Document Child nodes length is: " + document.getLastChild().getChildNodes().getLength());
                } else {
                    System.out.println("Something is wrong with XML parsing/Appending : " + document.getLastChild().getChildNodes().getLength());
                }
            } catch (NumberFormatException | DOMException e) {
                System.out.println(e);
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
            //s  Write the document back to the file
            Source source = new DOMSource(document);

            Result result = new StreamResult(xmlFile); // xmlFile
            tFormer.transform(source, result);




        } catch (TransformerException | SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Info appended in XML");
    }

    /**
     * Read XML data
     */
    public void readXML() {
        // TODO
    }
}
