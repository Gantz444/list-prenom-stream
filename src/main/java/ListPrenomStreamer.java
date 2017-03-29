import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.google.gson.Gson;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import models.ParisData;
import models.Records;

public class ListPrenomStreamer {

    private static final Gson GSON = new Gson();
    private ParisData parisData;

    public ListPrenomStreamer(String filename) {
        InputStreamReader inputStreamReader = new InputStreamReader(getClass().getResourceAsStream(filename));
        this.parisData = GSON.fromJson(inputStreamReader, ParisData.class);
    }

    public static void main(String[] args) throws IOException {
        ListPrenomStreamer listPrenomStreamer = new ListPrenomStreamer("liste_des_prenoms_2004_a_2012.json");
        System.out.println(listPrenomStreamer.getSize());
        System.out.println(listPrenomStreamer.top3name2008());
    }

    public int getSize() {
        return parisData.getRecords().size();
    }

    public List<String> top3name2008() {
        return null;
    }

    public List<Records> getTop3_2010() {

        Predicate<Records> pred = record -> record.getFields().getAnnee() == 2010;
        Stream<Records> streamRecords = this.parisData.getRecords().stream().filter(pred);
        
        Comparator<Records> comp = ( record1, record2) -> { return -((Integer)record2.getFields().getNombre()).compareTo(record1.getFields().getNombre());}; 
        
        return streamRecords.sorted(comp).limit(3).collect(Collectors.toList());
    }
}
