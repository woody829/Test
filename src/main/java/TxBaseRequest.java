import org.w3c.dom.Document;

/**
 * Created by woody on 2017/3/24.
 */
public abstract class TxBaseRequest {

    protected String txCode;
    protected String requestPlainText;
    protected String requestMessage;
    protected String requestSignature;

    public TxBaseRequest() {
    }

    public String getRequestPlainText() {
        return this.requestPlainText;
    }

    public String getRequestMessage() {
        return this.requestMessage;
    }

    public String getRequestSignature() {
        return this.requestSignature;
    }

    public abstract void process() throws Exception;

    protected void postProcess(Document var1) throws Exception {


    }
}
