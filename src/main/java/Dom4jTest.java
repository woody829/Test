/**
 * Created by woody on 2017/3/23.
 */

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

/**
 * 用DOM4J创建xml文档
 *
 *
 */

public class Dom4jTest {

    public static void main(String[] args) throws Exception {
        //创建一篇文档
        Document doc = DocumentHelper.createDocument();

        //添加一个元素
        Element root = doc.addElement("MsgText");


        /****MsgHdr开始****/
        //创建元素MsgHdr
        Element MsgHdr = new BaseElement("MsgHdr");
        root.add(MsgHdr);

        //创建元素BkInst
        Element BkInst = new BaseElement("BkInst");
        BkInst.setText("");
        MsgHdr.add(BkInst);

        //创建元素Date
        Element date = new BaseElement("Date");
        date.setText("20170208");
        MsgHdr.add(date);

        //创建元素Time
        Element time = new BaseElement("Time");
        time.setText("142117");
        MsgHdr.add(time);

        //创建元素InstrCd
        Element instrCd = new BaseElement("InstrCd");
        instrCd.setText("46701");
        MsgHdr.add(instrCd);

        //创建元素LstFrag
        Element lstFrag = new BaseElement("LstFrag");
        lstFrag.setText("N");
        MsgHdr.add(lstFrag);



        //创建元素RqRef
        Element rqRef = new BaseElement("RqRef");
        rqRef.addElement("Ref").addText("20170208142117313313");
        MsgHdr.add(rqRef);

        //创建元素SvInst
        Element svInst = new BaseElement("SvInst");
        svInst.addElement("InstId").addText("P0003000");
        svInst.addElement("InstType").addText("0");
        MsgHdr.add(svInst);

        //创建元素SysType
        Element sysType = new BaseElement("SysType");
        sysType.setText("4");
        MsgHdr.add(sysType);

        //创建元素TradSrc
        Element tradSrc = new BaseElement("TradSrc");
        tradSrc.setText("0");
        MsgHdr.add(tradSrc);

        //创建元素Ver
        Element ver = new BaseElement("Ver");
        ver.setText("V3.0.0.27");
        MsgHdr.add(ver);

        /****MsgHdr结束****/

        //创建元素BusType
        Element busType = new BaseElement("BusType");
        busType.setText("4");
        root.add(busType);

        //创建元素Ccy
        Element ccy = new BaseElement("Ccy");
        ccy.setText("0");
        root.add(ccy);


        //创建元素Cust
        Element cust = new BaseElement("Cust");
        cust.addElement("CertId").addText("420684198612066412");
        cust.addElement("CertType").addText("1");
        cust.addElement("Name").addText("阿凡达");
        cust.addElement("Type").addText("0");
        root.add(cust);

        //创建元素MgeAcct
        Element mgeAcct = new BaseElement("MgeAcct");
        mgeAcct.addElement("Id").addText("20170208003");
        root.add(mgeAcct);

        //创建元素OPFlag
        Element oPFlag = new BaseElement("OPFlag");
        oPFlag.setText("0");
        root.add(oPFlag);








        doc.setXMLEncoding("GB2312");
        System.out.println(doc.asXML());












    }

}
