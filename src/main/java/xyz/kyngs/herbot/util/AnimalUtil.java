package xyz.kyngs.herbot.util;

import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import static java.nio.charset.StandardCharsets.UTF_8;

public class AnimalUtil {

    public static String getCat() {
        try {
            var inputStream = new URL("https://api.thecatapi.com/api/images/get?format=xml").openStream();
            var bufferedReader = new BufferedReader(new InputStreamReader(inputStream, UTF_8));

            var sb = new StringBuilder();
            int cp;
            while ((cp = bufferedReader.read()) != -1) {
                sb.append((char) cp);
            }
            bufferedReader.close();
            return sb.substring(sb.toString().indexOf("<url>") + "<url>".length(), sb.toString().indexOf("</url>"));
        } catch (Exception e) {
            e.printStackTrace();
            return "OOF! Nepodařilo se načíst kočičku :(";
        }

    }

    public static String getDuck() {
        try {
            var inputStream = new URL("https://random-d.uk/api/v2/random").openStream();
            return readJsonUrl(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return "OOF! Nepodařilo se načíst kachničku :(";
        }
    }

    public static String getDog() {
        try {
            var inputStream = new URL("https://random.dog/woof.json").openStream();
            return readJsonUrl(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return "OOF! Nepodařilo se načíst pejska :(";
        }
    }

    private static String readJsonUrl(InputStream inputStream) throws IOException {
        var bufferedReader = new BufferedReader(new InputStreamReader(inputStream, UTF_8));

        var sb = new StringBuilder();
        int cp;
        while ((cp = bufferedReader.read()) != -1) {
            sb.append((char) cp);
        }
        var root = JsonParser.parseString(sb.toString()).getAsJsonObject();
        bufferedReader.close();
        return root.getAsJsonPrimitive("url").getAsString();
    }

}