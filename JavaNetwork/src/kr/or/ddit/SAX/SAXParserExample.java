package kr.or.ddit.SAX;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserExample {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean bName = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("name")) {
                        bName = true;
                    }
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    if (bName) {
                        System.out.println("Name: " + new String(ch, start, length));
                        bName = false;
                    }
                }
            };

            saxParser.parse("input.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}