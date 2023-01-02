package kata6;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Meaning {
    public String partOfSpeech;
    public List<Definition> definitions;
    public List<String> synonyms;
    public List<String> antonyms;

    @Override
    public String toString() {
        return "Meaning{" + "partOfSpeech=" + partOfSpeech + 
                ", definitions=" + definitions.toString() + 
                ", synonyms=" + synonyms.toString() + 
                ", antonyms=" + antonyms.toString() + '}';
    }

    
    public static class Definition {
        public String definition;
        public List<String> synonyms;
        public List<String> antonyms;

        @Override
        public String toString() {
            return "Definition{" + "definition=" + definition + 
                    ", synonyms=" + synonyms.toString() + 
                    ", antonyms=" + antonyms.toString() + '}';
        }
    }
}
