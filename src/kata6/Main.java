/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import static java.util.stream.Collectors.joining;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
//import sun.misc.BASE64Encoder;
import static sun.security.krb5.Confounder.bytes;

/**
 *
 * @author Entrar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException, JAXBException {
        URL url = new URL("https://api.dictionaryapi.dev/api/v2/entries/en/learning");
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(read(url), JsonArray.class)
                .get(0).getAsJsonObject()
                .get("meanings").getAsJsonArray()
                .get(0).getAsJsonObject();               
        Meaning meaning = gson.fromJson(jsonObject, Meaning.class);
        System.out.println(meaning.toString());
        JAXBContext context = JAXBContext.newInstance(Meaning.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(meaning, System.out);        
        /*System.out.println(phonetic.txt);
        System.out.println(phonetic.audio);
        System.out.println(phonetic.sourceURL);*/
    }

    private static String read(URL url) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.lines().collect(joining());
        }           
    }
    
}
