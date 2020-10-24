import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class itemmanage {
    private static String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if(nValue == null)
            return null;
        return nValue.getNodeValue();
    }

    public static void main(String[] args) throws Exception {
        //여기서 시작 n 부터 최대 n+100까지 책 리스트 받아오기 가능. 책 리스트 다 받으려면
        //while문 돌면서 n + 100*i 해서 계속 돌리면서 db에 넣어야 할 듯?
        String url = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey=ttbsonsh53641858001&QueryType=ItemNewAll&MaxResults=10&start=1&SearchTarget=Book&output=xml&Version=20131101";

        DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
        Document doc = dBuilder.parse(url);

// root tag
        doc.getDocumentElement().normalize();
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); // Root element: result

// 파싱할 tag
        NodeList nList = doc.getElementsByTagName("item");
        System.out.println("파싱할 리스트 수 : "+ nList.getLength());  // 파싱할 리스트 수 :  기본 10개


        for(int temp = 0; temp < nList.getLength(); temp++){
            Node nNode = nList.item(temp);
            if(nNode.getNodeType() == Node.ELEMENT_NODE){

                Element eElement = (Element) nNode;
                System.out.println("######################");
//                System.out.println(eElement.getTextContent());
                System.out.println("제목  : " + getTagValue("title", eElement));
                System.out.println("url주소  : " + getTagValue("link", eElement));
                System.out.println("저자/아티스트 : " + getTagValue("author", eElement));
                System.out.println("상품설명 : " + getTagValue("description", eElement));
                System.out.println("정가 : " + getTagValue("priceStandard", eElement));
                System.out.println("커버 : " + getTagValue("cover", eElement));
                System.out.println("출파낫  : " + getTagValue("publisher", eElement));
            }	// for end
        }	// if end

    }
}
