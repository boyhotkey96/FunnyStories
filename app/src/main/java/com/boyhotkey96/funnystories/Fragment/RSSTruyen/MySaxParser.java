package com.boyhotkey96.funnystories.Fragment.RSSTruyen;

import android.util.Log;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParserFactory;

public class MySaxParser {

    public static ArrayList<Item> xmlParser(InputStream is) {
        ArrayList<Item> items = null;
        try {
            //tao xmlreader tu xmlparser
            XMLReader xmlreader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            //tao saxhandler
            MySaxHandler saxhandler = new MySaxHandler();
            //luu handler vao xmlreader
            xmlreader.setContentHandler(saxhandler);
            xmlreader.parse(new InputSource(is));
            //lay danh sach cac item bo vao items
            items = saxhandler.getItems();
        } catch (Exception e) {
            Log.d("Loi", "Lay khong duoc: " + e.toString());
        }
        return items;
    }
}

