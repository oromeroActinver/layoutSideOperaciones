package layout.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import layout.component.LayoutConponent;

public class ExcelService {

    public void generateXLSX(String filePath, List<LayoutConponent> layouts, String descrip) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(descrip);

        // Crear estilos para el encabezado
        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);

        // Crear estilos para celdas de fecha
        CellStyle dateStyle = workbook.createCellStyle();
        CreationHelper creationHelper = workbook.getCreationHelper();
        dateStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd"));

        // Crear estilos para celdas de moneda
        CellStyle currencyStyle = workbook.createCellStyle();
        currencyStyle.setDataFormat(creationHelper.createDataFormat().getFormat("#,##0.00"));

        // Crear encabezado
        String[] headers = {"Periodo", "Fecha", "Institucion", "ID Operacion", "Producto", "Divisa/Moneda", "Monto"};
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // Rellenar datos
        int rowNum = 1;
        for (LayoutConponent layout : layouts) {
            Row row = sheet.createRow(rowNum++);
            Cell cell0 = row.createCell(0);
            cell0.setCellValue(layout.getPeriodo());
            cell0.setCellStyle(dateStyle);

            Cell cell1 = row.createCell(1);
            cell1.setCellValue(layout.getFecha());
            cell1.setCellStyle(dateStyle);

            row.createCell(2).setCellValue(layout.getInstitucion());
            row.createCell(3).setCellValue(layout.getIdOperacion());
            row.createCell(4).setCellValue(layout.getProducto());
            row.createCell(5).setCellValue(layout.getDivisaMoneda());

            Cell cell6 = row.createCell(6);
            cell6.setCellValue(layout.getMonto());
            cell6.setCellStyle(currencyStyle);
        }

        // Autoajustar ancho de columnas
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Guardar el archivo
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } finally {
            workbook.close();
        }
    }

}
