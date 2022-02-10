package connection.concretes;

import connection.abstracts.RockScrapy;
import exception.InvalidURLFormatException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Scrapy implements RockScrapy {

    private URL url;
    private PatternURL patternURL;
    private URLConnection urlConnection;
    private StringBuilder content;

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
    public RockScrapy proceed() throws IOException {
        scrapy.setConnection();
        scrapy.printContent();
        return null;
    }

    private void setConnection() throws IOException {
        scrapy.urlConnection = scrapy.patternURL.getConProtocol().connect(scrapy.url);
        BufferedReader in = new BufferedReader(new InputStreamReader(scrapy.urlConnection.getInputStream()));
        String inputLine;
        content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
    }

    private void printContent(){
        String html = scrapy.content.toString();
        Document doc = Jsoup.parseBodyFragment(html);
        doc.outputSettings().prettyPrint(true);
        System.out.println(doc.html());
    }

}
