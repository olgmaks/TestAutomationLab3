package epam.com.lab.model;

import jdk.nashorn.internal.runtime.Version;

import java.text.SimpleDateFormat;


//import javax.security.cert.Certificate;
//import javax.xml.stream.XMLInputFactory;
//import javax.xml.stream.XMLStreamConstants;
//import javax.xml.stream.XMLStreamReader;
//import java.io.FileReader;
//import java.text.SimpleDateFormat;
//import java.util.*;


public class ParserUser {
//    public static  void main(String[] args) throws Exception{
//        System.out.println(parserUser().get(1));
//    }
//
//
//
//    public static List<User> parserUser() throws Exception {
//
//        List<User> prList = null;
//        User pr = null;
//        String tag = null;
//
//
//        XMLInputFactory factory = XMLInputFactory.newInstance();
//        XMLStreamReader reader = factory.createXMLStreamReader
//                (new FileReader("src/main/resources/User.xml"));
//        while (reader.hasNext()) {
//            int event = (int) reader.next();
//            switch (event) {
//                case XMLStreamConstants.START_ELEMENT:
//                    if ("catalog".equals(reader.getLocalName())) {
//                        prList = new ArrayList<>();
//                    }
//                    if ("user".equals(reader.getLocalName())) {
//                        pr = new User();
//
//                    }
//
//                    break;
//                case XMLStreamConstants.CHARACTERS:
//                    tag = reader.getText().trim();
//                    break;
//                case XMLStreamConstants.END_ELEMENT:
//                    switch (reader.getLocalName()) {
//                        case "login":
//                            pr.setLogin(tag);
//                            break;
//                        case "password":
//                            pr.setPassword(tag);
//                            break;
//
//                    }
//            }
//        }
//        return prList;
//    }}
}