package uploadCsv.CSVHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import uploadCsv.Entity.EntityClass;

public class HelperClass {
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "Id", "Name", "Age", "Date of Birth" };

  public static boolean hasCSVFormat(MultipartFile file) {
    if (!TYPE.equals(file.getContentType())) {
      return false;
    } 
    return true;
  }
  
  public static List<EntityClass> csvToTable(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<EntityClass> entityclass = new ArrayList<EntityClass>();
      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        EntityClass entityClass = new EntityClass(
              Integer.parseInt(csvRecord.get("Id")),
              csvRecord.get("Name"),
              Integer.parseInt(csvRecord.get("Age")),
              csvRecord.get("Date of Birth")
              );
        entityclass.add(entityClass);
      }
      return entityclass;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }
}