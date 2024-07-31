package layout.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.xml.bind.JAXBException;

import layout.component.LayoutConponent;
import layout.dto.DataLayout;

public class LayoutService {
	
	DataLayout dataLayout = new DataLayout();
	
	public List<LayoutConponent> getData() {
		return  dataLayout.creteDate();
	}
	
	ExcelService excelService = new ExcelService();
	String nameFile = "SIDE_SEC1_";
	String descrip = "";
	
	/*Metodo Dirio*/
	public String generateDailyOperationsReport(String path) throws JAXBException {
		 List<LayoutConponent> layouts = dataLayout.creteDate();// Se cambiara por datos Diarios del Script
		 String nameFileFech = nameFile + getCurrentDateInYYYYMMDD() + ".xlsx";
		 descrip = "Operaciones-SIDE-Diarias";
		 try {
			excelService.generateXLSX(path+nameFileFech, layouts, descrip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return nameFileFech;
	}
	
	/*Metodo Mensual*/
	public String generateMonthlyOperationsReport(String path) throws JAXBException {
		 List<LayoutConponent> layouts = dataLayout.creteDate();// Se cambiara por datos Mensuales del Script
		 String nameFileFech = nameFile + getCurrentDateInYYYYMMDD() + ".xlsx";
		 descrip = "Operaciones-SIDE-Mensuales";
		 try {
				excelService.generateXLSX(path+nameFileFech, layouts, descrip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		return nameFileFech;
	}
	
	public String getCurrentDateInYYYYMMDD() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return currentDate.format(formatter);
    }

}
