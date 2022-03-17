//package core;
//
//import java.io.*;
//
//import org.w3c.dom.*;
//import org.xml.sax.SAXException;
//
//import javax.xml.parsers.*;
//import javax.xml.transform.*;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//
//public class ReadXML {
//    public static void main(String[] args) {
//
//        try {
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // Фабрика по производству папок
//            DocumentBuilder bf = factory.newDocumentBuilder(); // Создать папку с фабрикой
//            Document doc = bf.parse("data.xml"); // Используйте метод parse () объекта класса DocumentBuilder для анализа файла XML и возврата объекта Document
//
//            NodeList channels = doc.getElementsByTagName("channel");
//            for (int i = 0; i < channels.getLength(); i++) {
//                Element channel = (Element) channels.item(i);
//
//                Attr idAttr = doc.createAttribute("id");
//                idAttr.setValue("hello");
//                channel.setAttributeNode(idAttr);
//                NodeList childs = channel.getChildNodes();
//                for (int j = 0; j < childs.getLength(); j++) {
//                    Node child = childs.item(j);
//                    if (child.getNodeName().equals("title"))
//                        System.out.println("<title> название канала:" + child.getFirstChild().GetNodeValue());
//                    if (child.getNodeName().equals("description"))
//                        System.out.println("<описание> сведения о канале:" + child.getFirstChild().GetNodeValue());
//                    if (child.getNodeName().equals("item")) {
//                        NodeList items = child.getChildNodes();
//                        for (int k = 0; k < items.getLength(); k++) {
//                            Node item = items.item(k);
//                            if (item.getNodeName().equals("title"))
//                                System.out.println("Содержимое <title> является заголовком новости:" + item.getFirstChild().GetNodeValue());
//                            if (item.getNodeName().equals("link"))
//                                System.out.println("Содержимое <link> является ссылкой на новость:" + item.getFirstChild().GetNodeValue());
//                            if (item.getNodeName().equals("description"))
//                                System.out.println("<item> / <description> - это новость:" + item.getFirstChild().GetNodeValue());
//                        }
//                    }
//                }
//            }
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        }
//    }
//}