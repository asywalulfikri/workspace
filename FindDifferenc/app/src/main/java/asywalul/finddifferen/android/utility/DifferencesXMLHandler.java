package asywalul.finddifferen.android.utility;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class DifferencesXMLHandler extends DefaultHandler {
	boolean currentElement = false;
	String currentValue = "";

	DifferencePoint diffPoint;
	DifferencesInfo diffInfo;
	ArrayList<DifferencesInfo> diffList;

	public ArrayList<DifferencesInfo> getDiffList() {
		return diffList;
	}
	
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		currentElement = true;

		if (qName.equals("stages")) {
			diffList = new ArrayList<DifferencesInfo>();
		} else if (qName.equals("stage")) {
			diffInfo = new DifferencesInfo();
		}else if (qName.equals("difference")) {
			diffPoint = new DifferencePoint();
			diffPoint.setPosX(attributes.getValue("x"));
			diffPoint.setPosY(attributes.getValue("y"));
			diffPoint.setRadius(attributes.getValue("radius"));
			diffInfo.addPoint(diffPoint);
		}
	}
	
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		currentElement = false;

		if (qName.equalsIgnoreCase("image1"))
		{
			diffInfo.setImageLocation1(currentValue.trim());
		}
		else if (qName.equalsIgnoreCase("image2"))
		{
			diffInfo.setImageLocation2(currentValue.trim());
		}
		else if (qName.equalsIgnoreCase("stage"))
		{
			diffList.add(diffInfo);
		}

		currentValue = "";
	}
	
	public void characters(char[] ch, int start, int length)
			throws SAXException {

		if (currentElement) {
			currentValue = currentValue + new String(ch, start, length);
		}

	}
}
