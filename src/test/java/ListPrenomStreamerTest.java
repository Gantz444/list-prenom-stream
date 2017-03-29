import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import models.Records;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ListPrenomStreamerTest {

    @Test
    public void size_should_be_14() throws Exception {
        // Given
        ListPrenomStreamer listPrenomStreamer = new ListPrenomStreamer("liste_des_prenoms_2004_a_2012_short.json");

        // Then
        assertThat(listPrenomStreamer.getSize(), is(14));
    }
    
    @Test
    public void Top_3_of_best_name_in_2010() throws Exception {
        // Given
        ListPrenomStreamer listPrenomStreamer = new ListPrenomStreamer("liste_des_prenoms_2004_a_2012_short.json");
        
        List<Records> res = listPrenomStreamer.getTop3_2010();

        Function<Records, String> nameFunc = records -> records.getFields().getPrenoms();
        
        List<String> nomTop3 = res.stream().map(nameFunc).collect(Collectors.toList());
        // Then
        assertThat(nomTop3, contains("Kevin", "Brams", "Juan"));
    }

}