package layout.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import layout.component.LayoutConponent;

public class DataLayout {
	
public List<LayoutConponent> creteDate() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<LayoutConponent> layouts = null;
		try {
			layouts = Arrays.asList(
			        new LayoutConponent("id_1", dateFormat.parse("2024-03-01"), dateFormat.parse("2024-03-01"), "COLATERALOTC", "PESO", 80000.00, "Institucion A"),
			        new LayoutConponent("id_2", dateFormat.parse("2024-03-01"), dateFormat.parse("2024-03-01"), "COLATERALOTC", "DOLAR", 747483.00, "Institucion A"),
			        new LayoutConponent("id_3", dateFormat.parse("2024-03-01"), dateFormat.parse("2024-03-01"), "OTROS", "PESO", 993933.00, "Institucion B"),
			        new LayoutConponent("id_4", dateFormat.parse("2024-03-01"), dateFormat.parse("2024-03-01"), "OTROS", "DOLAR", 93983.00, "Institucion B"),
			        new LayoutConponent("id_1", dateFormat.parse("2024-03-04"), dateFormat.parse("2024-03-04"), "COLATERALOTC", "PESO", 80000.00, "Institucion A"),
			        new LayoutConponent("id_2", dateFormat.parse("2024-03-04"), dateFormat.parse("2024-03-04"), "COLATERALOTC", "DOLAR", 747483.00, "Institucion A"),
			        new LayoutConponent("id_3", dateFormat.parse("2024-03-04"), dateFormat.parse("2024-03-04"), "OTROS", "PESO", 993933.00, "Institucion B"),
			        new LayoutConponent("id_4", dateFormat.parse("2024-03-04"), dateFormat.parse("2024-03-04"), "OTROS", "DOLAR", 93983.00, "Institucion B")
			    );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return layouts;
	}

}
