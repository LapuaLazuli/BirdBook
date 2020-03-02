import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Packager {

   public Bird Package(String filename, String query) throws ParserConfigurationException, IOException, SAXException {
       //initializes Bird object
        Bird bird = new Bird();

        boolean found = false;

        //Opens file stream
       File file = new File(filename + ".xml");

       //DocumentBuilderFactory that creates document builder that parses the xml
       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

       //Transforms xml into something that can be parsed
       DocumentBuilder db = dbf.newDocumentBuilder();
       Document doc = db.parse(file);
       doc.getDocumentElement().normalize();

       //Makes a list of nodes out of the doc
       NodeList nl = doc.getElementsByTagName("bird");

       //searches nodeList for query of bird
       int iter = 0;
       Node node;
       while (!found){
           node = nl.item(iter);
           if (node.getNodeType() == Node.ELEMENT_NODE){
               Element e = (Element) node;
               String testName = e.getElementsByTagName("name").item(0).getTextContent();
               if (testName.equals(query)){
                   found = true;
                   bird.setName(testName);
                   bird.setBehavior(e.getElementsByTagName("behavior").item(0).getTextContent());
                   bird.setConservation(e.getElementsByTagName("conservation").item(0).getTextContent());
                   bird.setDescription(e.getElementsByTagName("description").item(0).getTextContent());
                   bird.setDiet(e.getElementsByTagName("diet").item(0).getTextContent());
                   bird.setNest(e.getElementsByTagName("nest").item(0).getTextContent());
                   bird.setFinding(e.getElementsByTagName("finding").item(0).getTextContent());
                   bird.setHabitat(e.getElementsByTagName("habitat").item(0).getTextContent());
               }
           }
           iter++;
       }
       
        return bird;
   }

}
