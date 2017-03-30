import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import models.Records;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ListPrenomStreamerTest {

    @Test
    public void size_should_be_14() throws Exception {
        // Given
        ListPrenomStreamer listPrenomStreamer = new ListPrenomStreamer("liste_des_prenoms_2004_a_2012_short.json");

        // Then
        assertThat(listPrenomStreamer.getSize(), is(17));
    }
    
    @Test
    public void Top_3_of_best_name_in_2010() throws Exception {
        // Given
        ListPrenomStreamer listPrenomStreamer = new ListPrenomStreamer("liste_des_prenoms_2004_a_2012_short.json");
        
        List<String> res = listPrenomStreamer.getTop3_2010();

        // Then
        assertThat(res, containsInAnyOrder("Kevin", "Brams", "Juan"));
    }

    @Test
    public void Top_3_of_best_Girl_name_in_2009() throws Exception {
        // Given
        ListPrenomStreamer listPrenomStreamer = new ListPrenomStreamer("liste_des_prenoms_2004_a_2012_short.json");

        List<String> resGirl = listPrenomStreamer.getTop3_bestGirl2009();
        // Then
        assertThat(resGirl, containsInAnyOrder("Adama", "Victoria", "Liama"));
    }

    @Test
    public void Top_3_of_best_Boy_name_in_2012() throws Exception {
        // Given
        ListPrenomStreamer listPrenomStreamer = new ListPrenomStreamer("liste_des_prenoms_2004_a_2012_short.json");

        List<String> resGirl = listPrenomStreamer.getTop3_bestBoy2012();
        // Then
        assertThat(resGirl, containsInAnyOrder("Jean", "Juan", "Kevin"));
    }

    @Test
    public void Top_5_of_best_name_in_2009_2016() throws Exception {
        // Given
        ListPrenomStreamer listPrenomStreamer = new ListPrenomStreamer("liste_des_prenoms_2004_a_2012_short.json");

        List<String> restop5 = listPrenomStreamer.getTop5_bestName2009_2016();
        // Then
        assertThat(restop5, containsInAnyOrder("Flo", "Ismo", "Kevin", "Adama", "Jean"));
    }
}