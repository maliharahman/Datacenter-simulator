package core;

import domain.Response;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataLoader {
    private static Logger log = LoggerFactory.getLogger(DataLoader.class);
    private static final String FILE_NAME = ".\\data-small.xlsx";
    ResponseDataHandler responseDataHandler = ResponseDataHandler.getResponseDataHandlerInstance();
    List<Response> responseList = new ArrayList<Response>();

    public void loadData() {
        try {
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                Response response = new Response();

                int i = 0;
                int yearComponent = 2018;
                int monthComponent = 0;
                int dayComponent = 0;
                int hourComponent = 0;
                int minuteComponent = 0;
                int secondComponent = 0;
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();

                    if (i < 5) {
                        if (i == 0) {
                            monthComponent = (int) currentCell.getNumericCellValue();
                        } else if (i == 1) {
                            dayComponent = (int) currentCell.getNumericCellValue();
                        } else if (i == 2) {
                            hourComponent = (int) currentCell.getNumericCellValue();
                        } else if (i == 3) {
                            minuteComponent = (int) currentCell.getNumericCellValue();
                        } else if (i == 4) {
                            secondComponent = (int) currentCell.getNumericCellValue();
                            response.setTimestamp(Utils.getDate(yearComponent, monthComponent - 1, dayComponent, hourComponent, minuteComponent, secondComponent));
                        }
                    } else if (i == 5 ) {
                        response.setResponseSize(currentCell.getNumericCellValue());
                    } else if (i == 6) {
                        response.setEnergyConsumed(currentCell.getNumericCellValue());
                    } else if (i == 7) {
                        response.setPvGeneration(currentCell.getNumericCellValue());
                    }
                    i++;
                }
                responseList.add(response);
            }
            responseDataHandler.setResponseList(responseList);
            log.info("Data has been successfully loaded.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
