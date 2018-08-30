/**
 * Created by woody on 2017/3/23.
 */

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Test")
public class TestXml {
    private String strId;

    private String strAttr;

    private String strValue;

    @XmlElement(name="StrId")
    public String getStrId() {
        return strId;
    }

    public void setStrId(String strId) {
        this.strId = strId;
    }

    @XmlAttribute(name="StrAttr")
    public String getStrAttr() {
        return strAttr;
    }
    public void setStrAttr(String StrAttr) {
        this.strAttr = StrAttr;
    }


    @XmlElement(name="StrValue")
    public String getStrValue() {
        return strValue;
    }
    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }
}
