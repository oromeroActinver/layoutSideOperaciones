package layout;

import javax.xml.bind.JAXBException;
import layout.service.LayoutService;

public class Inicio {

	public static void main(String[] args) throws JAXBException {
		
		if(args.length != 1) {
			System.out.println("Use. java -jar layout.jar <0|1>");
		}
		
		LayoutService layoutService = new LayoutService();
		String path = "C:\\Users\\orlando.romero\\Documents\\SIDE\\Archivos\\";//recuperarlo de algun otro lugar que no este en codigo
		String fileName = "";

        int mode = Integer.parseInt(args[0]);

        if (mode == 0) {
            /*Generar Xslx diario*/
        	fileName = layoutService.generateDailyOperationsReport(path);
        } else if (mode == 1) {
           /* Gererar xslx mensual*/
        	fileName = layoutService.generateMonthlyOperationsReport(path);
        } else {
            System.out.println("Invalid argument. Use 0 for daily data and 1 for monthly data.");
            System.exit(1);
        }

        System.out.println("File generated: " + fileName);
        
	}
}
