import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by woody on 2017/3/23.
 */
@XmlRootElement(name = "MsgText")
public class Tx40701Request {
    String MsgHdr;
    String BkInst;
    String Date;
    String RqRef;
    String Ref;

    @XmlElement(name = "MsgHdr")
    public String getMsgHdr() {
        return MsgHdr;
    }

    public void setMsgHdr(String msgHdr) {
        MsgHdr = msgHdr;
    }

    public String getBkInst() {
        return BkInst;
    }

    public void setBkInst(String bkInst) {
        BkInst = bkInst;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getRqRef() {
        return RqRef;
    }

    public void setRqRef(String rqRef) {
        RqRef = rqRef;
    }

    public String getRef() {
        return Ref;
    }

    public void setRef(String ref) {
        Ref = ref;
    }


}
