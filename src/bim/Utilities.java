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
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 * * Compute the Body Mass Index Copyright (C) 2012 - OTIKA –
 * hanynowsky@gmail.com
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see http://www.gnu.org/licenses/.
 *
 * Bomico - Copyright (C) 2012 <OTIKA – hanynowsky@gmail.com> This program comes
 * with ABSOLUTELY NO WARRANTY. This is free software, and you are welcome to
 * redistribute it under certain conditions.
 *
 * @version 1.0
 * @author Hanynowsky
 */
public class Utilities {

    static String p = System.getProperty("user.home");
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
    static String localpath;
    static File xmlFile;

    /**
     * Creates a new instance of this object class
     */
    public Utilities() {
    }

    public static String getLocalpath() {
        localpath = p + File.separator + "bomico"
                + File.separator + "config" + File.separator + "followup.xml";
        return localpath;
    }

    public static File getXmlFile() {
        xmlFile = new File(getLocalpath());
        return xmlFile;
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

        String infos = "<html><b>Version</b>: " + getVersion() + "<html><br></br>" + "<html><b>Application:</b> "
                + getTitle() + "<html><br></br>" + "<html><b>Vendor:</b> " + getVendor() + "<html><br></br>"
                + "<html><b>Build:</b> " + getBuild() + "<html><br></br>" + "<html><b>User Home:</b> " + p + "<html><br></br>"
                + "<html><b>User Directory:</b> " + System.getProperty("user.dir")
                + "<html><br></br>" + "<html><b>System:</b> " + System.getProperty("os.name") + " " + System.getProperty("os.version")
                + " " + System.getProperty("os.arch") + "<html><br></br>" + "<html><b>Java:</b> " + System.getProperty("java.version")
                + " " + System.getProperty("java.vendor");
        return infos;
    }

    public void createFile() {
        try {
            if (!xmlFile.exists()) {
                new File(p + separator + "bomico" + separator + "config").mkdirs();
                xmlFile.createNewFile();
                FileWriter fstream = new FileWriter(xmlFile, true);
                try (BufferedWriter out = new BufferedWriter(fstream)) {
                    String xmlString = "<?xml version=\"1.0\" "
                            + "encoding=\"UTF-8\" standalone=\"no\"?>"
                            + "<followup></followup>";
                    out.write(xmlString);
                }
                System.out.println("- Followup.xml File Created in " + localpath);
            }
        } catch (IOException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }
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

            createFile(); // Check if the file exists, if not create it.

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile); // xmlFile
            //Get the root element of the xml Document;
            Element documentElement = document.getDocumentElement();
            System.out.println("documentElement:" + documentElement.toString());
            Element userNode = document.createElement("user");
            Element valueNode = document.createElement("value");
            Element yearNode = document.createElement("year");
            Element monthNode = document.createElement("month");
            Element dayNode = document.createElement("day");
            Element timeNode = document.createElement("time");
            //Text value = document.createTextNode("2");
            userNode.setTextContent(System.getProperty("user.name"));
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
            nodeElement.appendChild(userNode);
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
    public void readXML(String v, String y, String m, String d, String t) {

        try {
            File xFile = new File(p + separator + "bomico"
                    + separator + "config" + separator + "followup.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("bmi");
            System.out.println("Getting Sub Root -----------------------" + nList.item(0));


            for (i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;

                    NodeList userList = element.getElementsByTagName("user");
                    Element userElement = (Element) userList.item(0);
                    NodeList textuserList = userElement.getChildNodes();
                    System.out.println(v + ((Node) textuserList.item(0)).getNodeValue().trim());

                    NodeList valueList = element.getElementsByTagName("value");
                    Element valueElement = (Element) valueList.item(0);
                    NodeList textvalueList = valueElement.getChildNodes();
                    System.out.println(v + ((Node) textvalueList.item(0)).getNodeValue().trim());

                    NodeList yearList = element.getElementsByTagName("year");
                    Element yearElement = (Element) yearList.item(0);
                    NodeList textyearList = yearElement.getChildNodes();
                    System.out.println(y + ((Node) textyearList.item(0)).getNodeValue().trim());

                    NodeList monthList = element.getElementsByTagName("month");
                    Element monthElement = (Element) monthList.item(0);
                    NodeList textmonthList = monthElement.getChildNodes();
                    System.out.println(m + ((Node) textmonthList.item(0)).getNodeValue().trim());

                    NodeList dayList = element.getElementsByTagName("day");
                    Element dayElement = (Element) dayList.item(0);
                    NodeList textdayList = dayElement.getChildNodes();
                    System.out.println(d + ((Node) textdayList.item(0)).getNodeValue().trim());

                    NodeList timeList = element.getElementsByTagName("time");
                    Element timeElement = (Element) timeList.item(0);
                    NodeList texttimeList = timeElement.getChildNodes();
                    System.out.println(t + ((Node) texttimeList.item(0)).getNodeValue().trim());

                    System.out.println("\n------------------\n");

                    /**
                     * System.out.println("First Name : " +
                     * getTagValue("firstname", element));
                     * System.out.println("Last Name : " +
                     * getTagValue("lastname", element));
                     * System.out.println("Nick Name : " +
                     * getTagValue("nickname", element));
                     * System.out.println("Salary : " + getTagValue("salary",
                     * element));
                     */
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    /**
     * Copy Splash Picture in local folder
     */
    public void pasteSplashFile() {
        InputStream is = getClass().getResourceAsStream("/resource/Bomico.png");
        File splash = new File(p + separator + "bomico" + separator + "splash" + separator + "Bomico.png");
        if (!splash.exists()) {
            try {
                new File(p + separator + "bomico" + separator + "splash").mkdirs();
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

