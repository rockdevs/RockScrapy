package connection.concretes;

import exception.InvalidURLFormatException;

public class URLFormat {
    private String request = "GET";
    private String protocol = ConProtocol.HTTP.getValue();
    private String url;

    private String address;

    private URLFormat urlFormat;

    private URLFormat(String protocol,String request, String url) {
        this.request = request;
        this.protocol=protocol;
        this.url = url;
    }

    private URLFormat(String protocol,String url) {
        this.protocol = protocol;
        this.url = url;
    }

    private URLFormat(String url) {
        this.url = url;
    }

    private URLFormat(){}

    public String getProtocol() {
        return protocol;
    }

    public String getAddress() {
        return address;
    }

    public URLFormat factory(String url){
        urlFormat = new URLFormat(url);
        return urlFormat;
    }

    private void generateAddress(){
        try {
            this.checkUrl();
        } catch (InvalidURLFormatException e) {
            this.url.replace("http://","").replace("https://","");
            e.printStackTrace();
        }
    }

    private void checkUrl() throws InvalidURLFormatException {
        if(!(this.url.contains("http://") ^ this.url.contains("https://")))
            throw new InvalidURLFormatException();
    }

}
