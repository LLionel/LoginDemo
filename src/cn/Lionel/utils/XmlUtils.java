package cn.Lionel.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class XmlUtils {

	private static String filepath;
	static{
		
		filepath = XmlUtils.class.getClassLoader().getResource("users.xml").getPath();
		System.out.println(filepath);
	}
	
	public static Document getDocument() throws Exception
	{
		SAXReader reader = new SAXReader();
        Document document = reader.read(new File(filepath));
        return document;
	}
	
	public static void write2Xml(Document document) throws Exception
	{
		// Pretty print the document to System.out
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8") ;
        XMLWriter writer = new XMLWriter(new FileOutputStream(filepath), format );
        writer.write( document );
        writer.close();
	}
	
}
