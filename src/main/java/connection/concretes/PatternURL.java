package connection.concretes;

import exception.InvalidURLFormatException;

public class PatternURL {
    private String urlAddress;

    private ConProtocol conProtocol;

    private static PatternURL patternURL;

    private PatternURL(){}



    public String getUrlAddress() {
        return urlAddress;
    }

    public ConProtocol getConProtocol() {
        return conProtocol;
    }

    public static PatternURL factory(String url) throws InvalidURLFormatException {
        if(patternURL ==null)
            synchronized (Scrapy.class){
                if (patternURL ==null)
                    patternURL = new PatternURL();
            }
        isValid(url);
        return patternURL;
    }

    private static void isValid(String urlAddress) throws InvalidURLFormatException {
        patternURL.urlAddress=urlAddress;
        if(!(patternURL.urlAddress.startsWith("http://") || patternURL.urlAddress.startsWith("https://"))){
            patternURL.urlAddress = "http://" + patternURL.urlAddress;
            patternURL.conProtocol = ConProtocol.HTTP;
        }
        if(!patternURL.urlAddress.contains("."))
            throw new InvalidURLFormatException();
    }


}
