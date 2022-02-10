package connection.concretes;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public enum ConProtocol {
    HTTP("http://"){
        @Override
        HttpURLConnection connect(URL url) throws IOException {
            urlConnection = url.openConnection();
            return (HttpURLConnection) urlConnection;
        }
    },
    HTTPS("https://"){
        @Override
        HttpsURLConnection connect(URL url) throws IOException {
            urlConnection = url.openConnection();
            return (HttpsURLConnection) urlConnection;
        }
    }
    ;
    private final String value;

    ConProtocol(String value) {
        this.value=value;
    }

    public URLConnection urlConnection;

    abstract URLConnection connect(URL url) throws IOException;

    public String getValue() {
        return value;
    }
}
