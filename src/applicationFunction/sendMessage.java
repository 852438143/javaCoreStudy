package applicationFunction;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * Created by 85243 on 2017/5/22.
 */
public class sendMessage {
    public static void main(String[] args) throws ApiException {
        String url ="http://gw.api.taobao.com/router/rest";
        String  appkey = "23856550";
        String secret = "d3a22d2ff151c6771d04620aa5076489";
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("123456");
        req.setSmsType("normal");
        req.setSmsFreeSignName("图志商城");
        req.setSmsParamString( "{product:'ylw',code:'1234'}" );
        req.setRecNum("17826866256");
        req.setSmsTemplateCode("SMS_67955119");
        AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
    }
}
