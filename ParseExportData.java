
/**
 * Write a description of ParseExportData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class ParseExportData {
    void tester() {
        FileResource fr = new FileResource();
        //for (String s : fr.lines() ) {
          //  System.out.println(s);
        //}
        CSVParser parser = fr.getCSVParser();
        //for (CSVRecord record : parser ) {
            //System.out.print(record.get("Country") + " ");
            //System.out.print(record.get("Exports") + " ");
            //System.out.println(record.get("Value (dollars)") );
        //}
        //String record = countryInfo(parser, "Nauru");  
        //System.out.println(record);
        System.out.println("-------");
        listExportersTwoProducts(parser, "gold", "diamonds");
        System.out.println("-------");
        int count = numberOfExporters(parser, "gold");
        System.out.println(count);
        System.out.println("-------");
        //bigExporters(parser, "$999,999,999,999");
        //System.out.println("-------");
        //String amount = "$999,999,999";
        //System.out.println(amount.length());
        
        
    }
    
    String countryInfo(CSVParser parser, String country) {
        
        for (CSVRecord record : parser) {
            String countryRecord = record.get("Country");
            String export = record.get("Exports");
            String value = record.get("Value (dollars)");
            //System.out.println(countryRecord + ": " + export + ": " + value);
            //System.out.println("countryRecord: " + countryRecord);
            //System.out.println("country: " + country);
            if (countryRecord.equals(country) ) {
                String result = countryRecord + ": " + export + ": " + value;
                return result;
            }
        }
        return "NOT FOUND";
    }
    
    void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String country = record.get("Country");
            String export = record.get("Exports");
            String value = record.get("Value (dollars)");
            if (export.contains(exportItem1) && export.contains(exportItem2) ) {
                System.out.println(country);
            }
        }
    }
    
    int numberOfExporters(CSVParser parser, String exportItem) {
        int count = 0;
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportItem) ) {
                count++;
            }
        }
        return count;
    }
    
    void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String country = record.get("Country");
            String value = record.get("Value (dollars)");
            if (value.length() > amount.length() ) {
                System.out.print(country + " ");      
                System.out.println(value);
            }
        }
    }

}
