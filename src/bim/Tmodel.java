/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bim;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * * Compute the Body Mass Index Copyright (C) 2012 - OTIKA –
 *
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
 * This Class is the data model for a JTable
 *
 * @version 1.0
 * @author Hanynowsky
 */
public final class Tmodel extends AbstractTableModel {

    int i = 0;
    String p = System.getProperty("user.home");
    String separator = File.separator;
    //private String[] columnLabels = {"BMI", "Year", "Month", "Day", "Time"};
    private ArrayList data;
    private ArrayList columnNames;

    public Tmodel() {
        int j = 0;
        try {
            // new File(p + separator + "bomico" + separator + "config" + separator + "followup.xml");

            File xFile = Utilities.getXmlFile();
            if (!xFile.exists()) {
                new Utilities().createFile();
            }
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("bmi");
            System.out.println("Getting Sub Root -----------------------" + nList.item(0));
            System.out.println("Follow-up file has " + nList.getLength()+" entries");

            columnNames = new ArrayList();
            columnNames.add("User");
            columnNames.add("BMI");
            columnNames.add("Year");
            columnNames.add("Month");
            columnNames.add("Day");
            columnNames.add("Time");

            data = new ArrayList();

// TODO Wrap the following code in another loop to shorten the code

            for (i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;

                    NodeList userList = element.getElementsByTagName("user");
                    Element userElement = (Element) userList.item(0);
                    NodeList textuserList = userElement.getChildNodes();
                    data.add(0, ((Node) textuserList.item(0)).getNodeValue().trim());
                    // System.out.println("User is " + ((Node) textuserList.item(0)).getNodeValue().trim());

                    NodeList valueList = element.getElementsByTagName("value");
                    Element valueElement = (Element) valueList.item(0);
                    NodeList textvalueList = valueElement.getChildNodes();
                    data.add(1, ((Node) textvalueList.item(0)).getNodeValue().trim());
                    //setValueAt(((Node) textvalueList.item(0)).getNodeValue().trim(), i, 0);
                    // System.out.println("Value is " + ((Node) textvalueList.item(0)).getNodeValue().trim());

                    NodeList yearList = element.getElementsByTagName("year");
                    Element yearElement = (Element) yearList.item(0);
                    NodeList textyearList = yearElement.getChildNodes();
                    data.add(2, ((Node) textyearList.item(0)).getNodeValue().trim());
                    //  System.out.println("Year is " + ((Node) textyearList.item(0)).getNodeValue().trim());

                    NodeList monthList = element.getElementsByTagName("month");
                    Element monthElement = (Element) monthList.item(0);
                    NodeList textmonthList = monthElement.getChildNodes();
                    data.add(3, ((Node) textmonthList.item(0)).getNodeValue().trim());
                    //  System.out.println("Month is " + ((Node) textmonthList.item(0)).getNodeValue().trim());

                    NodeList dayList = element.getElementsByTagName("day");
                    Element dayElement = (Element) dayList.item(0);
                    NodeList textdayList = dayElement.getChildNodes();
                    data.add(4, ((Node) textdayList.item(0)).getNodeValue().trim());
                    //   System.out.println("Day is " + ((Node) textdayList.item(0)).getNodeValue().trim());

                    NodeList timeList = element.getElementsByTagName("time");
                    Element timeElement = (Element) timeList.item(0);
                    NodeList texttimeList = timeElement.getChildNodes();
                    data.add(5, ((Node) texttimeList.item(0)).getNodeValue().trim());
                    //   System.out.println("Time is " + ((Node) texttimeList.item(0)).getNodeValue().trim());

                    j = i; // increment J to use later for system printing

                }
            }
            if (Utilities.getXmlFile().exists()) {
                if (nList.getLength() != 0 && nList.getLength() != -1) {
                    System.out.println("\n------------------\n");
                    Node nNode = nList.item(j);
                    Element element = (Element) nNode;
                    NodeList valueList = element.getElementsByTagName("value");
                    Element valueElement = (Element) valueList.item(0);
                    NodeList textvalueList = valueElement.getChildNodes();
                    System.out.println("Last recorded BMI Value is " + ((Node) textvalueList.item(0)).getNodeValue().trim() + "\n");
                }
            }

        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getColumnName(int col) {
        return (String) columnNames.get(col);
    }

    @Override
    public int getRowCount() {
        return data.size() / getColumnCount();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        return (String) data.get((row * getColumnCount()) + column);
    }

    /*
     * @Override public void setValueAt(Object o, int row, int column) {
     * data.setElementAt(o, (row * getColumnCount()) + column);
     * this.fireTableCellUpdated(row, column); }
     *
     */
    @Override
    public boolean isCellEditable(int row, int col) {
// please modify the int value if the number of columns changes
        if (col != 6 && row != 6) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @test
     */
    public void test() {

        System.out.println("row count is " + getRowCount());
        System.out.println("column count is " + getColumnCount());
        System.out.println("Column name at index 4 is  " + getColumnName(4));

    }
} // END OF CLASS
