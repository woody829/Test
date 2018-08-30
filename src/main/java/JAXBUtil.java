import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JAXBUtil {

    private static final Log logger = LogFactory.getLog(JAXBUtil.class);
    private static Map<String,JAXBContext> map = new ConcurrentHashMap<String,JAXBContext>();

    /**
     *
     * @param clazz  xml绑定的对象的类
     * @param object xml绑定的对象
     * @return 解析后字符编码为UTF-8的xml字符串
     * @throws Exception
     */
    public static <T> String toXml(Class<T> clazz,Object object) throws Exception {
        // 组装xml
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Marshaller marshaller = null;
        JAXBContext context = null;
        String returnString = null;
        try{
            try {
                context = map.get(clazz.toString());
                if(context==null)
                {
                    context = JAXBContext.newInstance(clazz);
                    map.put(clazz.toString(), context);
                }
                marshaller = context.createMarshaller();
                //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                //marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");                
                marshaller.marshal(object, os);
            } catch (Exception e) {
                logger.error("组装消息报文错误：" + e.getMessage());
                logger.error(e);
                throw e;
            }

            //转换为UTF-8的字符串
            if (os != null) {
                returnString = os.toString("UTF-8");
            }
        } finally{
            marshaller = null;
            if (os != null)
            {
                os.close();
            }
            os = null;
        }
        return returnString;

    }



    public static void main(String[] args) throws Exception {
        TestXml test = new TestXml();
        test.setStrId("123");
        test.setStrAttr("abc");
        test.setStrValue("你好");
        String str1 = JAXBUtil.toXml(TestXml.class, test);

        System.out.println("封装Xml：\n"+str1);

//        TestXml test2 = JAXBUtil.toObject(TestXml.class, str1);
//        System.out.println("解析Xml:"+test2.getStrId()+"|||||"+test2.getStrValue());
    }

}