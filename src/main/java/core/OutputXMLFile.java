package core;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static core.Game.*;

public class OutputXMLFile {
    public static void dom(Player playerOne, Player playerTwo) {
        int playerWinId = -1;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = builder.newDocument();

        Element root = doc.createElement("GamePlay");
        List<Integer> list = getList(playerOne.getTurnList(), playerTwo.getTurnList());
        Element game2 = doc.createElement("Game");
        for (int i = 0; i < list.size(); i++) {
            Element game = doc.createElement("step");
            game.setTextContent(String.valueOf(list.get(i)));
            game.setAttribute("num", String.valueOf(i));
            game.setAttribute("playerId", String.valueOf(playerWinId = i % 2 == 0 ? 0 : 1));
            game2.appendChild(game);
        }
        root.appendChild(game2);
        Player player;
        if (playerWinId == 0) {
            player = playerOne;
        }else {
            player = playerTwo;
        }
        Element user2 = doc.createElement("GameResult");
        Element user = doc.createElement("GameResult");
        for (int i = 0; i < getWinnerList().size(); i++) {
            if (getWinnerList().get(i).equalsIgnoreCase("DRAW!")) {
                user.setTextContent("DRAW!!!");
                root.appendChild(user);
            } else {
                int id = Integer.parseInt(getWinnerList().get(i));
                Player p;
                if (id == 0) {
                    p = playerOne;
                } else {
                    p = playerTwo;
                }
                user2.setAttribute("id", String.valueOf(p.getId()));
                user2.setAttribute("name", String.valueOf(p.getName()));
                user2.setAttribute("symbol", String.valueOf(p.getSymbol()));
                root.appendChild(user2);
            }
        }
        doc.appendChild(root);
            writeDocument(doc, "data.xml");
        }

    private static void writeDocument(Document document, String path)
            throws TransformerFactoryConfigurationError {
        try {
            Transformer trf = TransformerFactory.newInstance()
                    .newTransformer();
            DOMSource src = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream(path);

            StreamResult result = new StreamResult(fos);
            trf.transform(src, result);
        } catch (TransformerException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    private static List<Integer> getList(List<Integer> listOne, List<Integer> listTwo) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; Math.min(listOne.size(), listTwo.size()) > i; i++) {
            list.add(listOne.get(i));
            list.add(listTwo.get(i));
        }
        if (listOne.size() > listTwo.size()) {
            list.add(listOne.get(listOne.size() - 1));
        } else {
            list.add(listTwo.get(listTwo.size() - 1));
        }
        return new ArrayList<>(list);
    }
}
