package weather;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.net.URL;

public class Program {
    private static Document getPage() throws IOException {
        String url = "https://www.gismeteo.ru/weather-kazan-4364/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static void main(String[] args) throws IOException {
        Document page = getPage();
        Element doc = page.select("a[class=weathertab weathertab-link tooltip]").first();
        Element temp = doc.select("span[class=unit unit_temperature_c]").first();
        System.out.println("Температура в Казани " + temp.text());
        }
    }

