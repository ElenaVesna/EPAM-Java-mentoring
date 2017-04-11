package com.epam.elena_bogomolova.FinalTest;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

//class MyException extends NoSuchElementException{
//
//    public MyException(String message) {
//        super(message);
//    }
//}

public class TestOtherTasks {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
//        Set<String> pets = new HashSet<>();
//        pets.add("Shar");
//        pets.add("Murziik");
//        pets.add("Enotic");
//
//        if (pets.contains("Murzik")) {
//            System.out.println("I've found Murzik!");
//        } else System.out.println("There's no Murzik in my set :(");

//        HashMap<Integer, Integer> m = new HashMap<>();
//        m.put(1,2);
//        m.put(2, -7);
//        m.put(-15, 2);
//        m.put(6, 12);
//        m.put(6, 9);
//        m.put(-3000, 2000);
//        int min = Integer.MAX_VALUE;
//        Collection<Integer> values = m.values();
//        for (Object v : values) {
//            if ((int)v < min) {
//                min = (int) v;
//            }
//        }
//        System.out.println(min);

//        ArrayList<String> myRoom = new ArrayList<>();
//        myRoom.add("bed");
//        myRoom.add("table");
//        myRoom.add("chair");
//
//        String furniture = "armchair";
//        try {
//            checkForUnit(myRoom, furniture);
//        } catch (MyException e) {
//            System.out.println("exception appeared");
//        }
//    }
//    private static void checkForUnit(ArrayList<String> myRoom, String furniture) {
//        if (myRoom.contains(furniture)) {
//            System.out.println("you've selected correct piece of furniture");
//        } else throw new MyException("no such furniture!");

//        String path = "C:\\Users\\elena_bogomolova\\Desktop\\JDBC_TEMPLATE.java";
//        BufferedReader br = new BufferedReader(new FileReader(path));
//        String fileToString = null;
//        try {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            while (line != null) {
//                sb.append(line);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//            }
//            fileToString = sb.toString();
//        } finally {
//            br.close();
//        }
//        int countA = 0;
//        for (int i = 0; i < fileToString.length(); i++) {
//            if (String.valueOf(fileToString.charAt(i)).equals("a")) {
//                countA += 1;
//            }
//        }
//        System.out.println(countA);

//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//        Document doc = dBuilder.parse("C:\\Users\\elena_bogomolova\\Desktop\\goods.xml");
//        doc.getDocumentElement().normalize();
//        NodeList nList = doc.getElementsByTagName("item");
//        List<Integer> weights = new ArrayList<>();
//        for (int i = 0; i < nList.getLength(); i++) {
//            Node nNode = nList.item(i);
//            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//                Element el = (Element) nNode;
//                weights.add(Integer.parseInt(el.getAttribute("weight")));
//            }
//            System.out.println(weights.get(i));
//        }
//        int sum = 0;
//        for (Integer weight : weights) {
//            sum += weight;
//        }
//        float average = (float) sum / weights.size();
//        System.out.println("average weight is " + average);


    }
}
