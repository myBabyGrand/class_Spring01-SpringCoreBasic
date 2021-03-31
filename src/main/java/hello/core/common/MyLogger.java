package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuid;
    private String requestUrl;

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public void log (String message){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(uuid);
        sb.append("]");
        if(requestUrl != null){
            sb.append("[");
            sb.append(requestUrl);
            sb.append("]");
        }
        sb.append(" ");
        sb.append(message);
        System.out.println(sb.toString());
    }
    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        StringBuffer sb = new StringBuffer();
        sb.append("request scope bean create: ");
        sb.append(this.toString());
        log(sb.toString());
    }
    @PreDestroy
    public void close(){
        StringBuffer sb = new StringBuffer();
        sb.append("request scope bean close: ");
        sb.append(this.toString());
        log(sb.toString());
    }


}
