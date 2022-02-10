package connection.concretes;

import exception.InvalidURLFormatException;

public class PatternURL {
    private String urlAddress;

    private static PatternURL patternURL;

    private PatternURL(String url){
        this.urlAddress=url;
    }

    public static PatternURL factory(String url) throws InvalidURLFormatException {
        if(patternURL ==null)
            synchronized (Scrapy.class){
                if (patternURL ==null)
                    patternURL = new PatternURL(isValid(url));
            }
        return patternURL;
    }

    private static String isValid(String urlAddress) throws InvalidURLFormatException {
        if(!(patternURL.urlAddress.startsWith("http://") || patternURL.urlAddress.startsWith("https://")))
            patternURL.urlAddress = "http://" + patternURL.urlAddress;
        if(!patternURL.urlAddress.contains("."))
            throw new InvalidURLFormatException();
        return patternURL.urlAddress;
    }

    public String getUrlAddress() {
        return urlAddress;
    }
}
