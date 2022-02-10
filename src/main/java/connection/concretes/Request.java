package connection.concretes;

import connection.abstracts.RockScrapy;

import java.net.MalformedURLException;
import java.net.URL;

public class Request implements RockScrapy {

    private final URL url;
    private URLFormat urlFormat;

    public Request(URLFormat urlFormat) throws MalformedURLException {
        this.urlFormat=urlFormat;
        this.url = new URL(urlFormat.getAddress());;
    }

    @Override
    public RockScrapy scan() {
        this.choiceProtocol();
        
        return null;
    }

    private ConProtocol choiceProtocol(){
        ConProtocol[] conProtocols = ConProtocol.values();
        for(ConProtocol url : conProtocols ){
            if(url.getValue().equalsIgnoreCase(this.urlFormat.getProtocol()))
                return url;
        }
        return ConProtocol.HTTP;
    }
}
