package connection.concretes;

import connection.abstracts.RockScrapy;
import exception.InvalidURLFormatException;

import java.net.MalformedURLException;
import java.net.URL;

public class Scrapy implements RockScrapy {

    private URL url;
    private PatternURL patternURL;

    private static volatile Scrapy scrapy;

    private Scrapy(PatternURL patternURL) throws MalformedURLException {
        this.patternURL = patternURL;
        this.url = new URL(patternURL.getUrlAddress());;
    }

    public static Scrapy factory(String urlAddress) throws MalformedURLException, InvalidURLFormatException {
        if(scrapy ==null)
            synchronized (Scrapy.class){
                if (scrapy ==null)
                    scrapy = new Scrapy(PatternURL.factory(urlAddress));
            }
        return scrapy;
    }

    @Override
    public RockScrapy scan() {

        return null;
    }


}
