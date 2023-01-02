package kata6;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Meaning {
    String partOfSpeech;
    List<Definition> definitions;
    List<String> synonyms;
    List<String> antonyms;

    @Override
    public String toString() {
        return "Meaning{" + "partOfSpeech=" + partOfSpeech + 
                ", definitions=" + definitions.toString() + 
                ", synonyms=" + synonyms.toString() + 
                ", antonyms=" + antonyms.toString() + '}';
    }

    
    private static class Definition {
        String definition;
        List<String> synonyms;
        List<String> antonyms;

        @Override
        public String toString() {
            return "Definition{" + "definition=" + definition + 
                    ", synonyms=" + synonyms.toString() + 
                    ", antonyms=" + antonyms.toString() + '}';
        }
    }
}
