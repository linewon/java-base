package line.xml.dom4j;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import line.entity.reflect.StringsBean;
import line.reflect.mapBean.MapAndBean;

/**
 * http://blog.csdn.net/yyywyr/article/details/38359049
 * @author line
 *
 */
public class Dom4JTest {

	public static void main(String[] args) throws Exception {
		test1();
//		System.out.println(test2());
	}
	
	/**
	 * 新建Document对象，并添加节点
	 * @return 
	 * @throws Exception 
	 */
	public static  String test2() throws Exception {
		Document doc = DocumentHelper.createDocument();
		Element root = DocumentHelper.createElement("p");
		doc.setRootElement(root);
		
		
		StringsBean bean = new StringsBean("line", "18", "China");
		Map<String, String> pairs = MapAndBean.parseMapToBean(bean);
		for (Entry<String, String> entry : pairs.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			Element e = DocumentHelper.createElement("s");
			e.addAttribute(key, val);
			root.add(e);
		}
		return doc.asXML();
	}
	
	/**
	 * 根据已有的xml文本生成document，然后转成jsonObj
	 * @throws DocumentException 
	 */
	public static void test1() throws DocumentException {
		String xmlStr = "<?xml version=\"1.0\" encoding=\"GBK\"?><p><s typelistforprocessinstances=\"piid:s,pdid:s,pdlabel:s,endtime:s,bjbjgid:s,orgname:s\" /><s _lesb__errcode_=\"0\" /><s errtext=\"\" /><s errcode=\"0\" /><d k=\"processinstances\" ><r endtime=\"20161020162847\" piid=\"165064019\" pdlabel=\"泰安在职职工减少\" pdid=\"SiZzzgjs_3709\" orgname=\"市直企业\" bjbjgid=\"37090101\" /><r endtime=\"20161020093449\" piid=\"164718794\" pdlabel=\"泰安在职职工减少\" pdid=\"SiZzzgjs_3709\" orgname=\"市直企业\" bjbjgid=\"37090101\" /></d></p>";
		
		Document document = DocumentHelper.parseText(xmlStr);
		Element root = document.getRootElement();
//		document.setXMLEncoding("GBK");
//		System.out.println(document.asXML());
		visitElement(root);
	}
	
    //遍历当前节点下的所有节点  
    private static void visitElement(Element node){  
        System.out.println("当前节点的名称：" + node.getName());  
        //首先获取当前节点的所有属性节点  
        List<Attribute> list = node.attributes();  
        //遍历属性节点  
        for(Attribute attribute : list){  
            System.out.println("属性"+attribute.getName() +":" + attribute.getValue());  
        }  
        //如果当前节点内容不为空，则输出  
        if(!(node.getTextTrim().equals(""))){  
             System.out.println( node.getName() + "：" + node.getText());    
        }  
        //同时迭代当前节点下面的所有子节点  
        //使用递归  
        Iterator<Element> iterator = node.elementIterator();  
        while(iterator.hasNext()){  
            Element e = iterator.next();  
            visitElement(e);  
        }  
    }
}
