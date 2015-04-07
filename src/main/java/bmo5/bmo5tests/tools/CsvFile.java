package bmo5.bmo5tests.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class CsvFile {

    private static final String VALUES_FIELD_NAME = "values";

    private CSVParser csvParser;

    private List<CSVRecord> csvRecords;

    private CSVFormat csvFormat;

    private File file;

    public CsvFile(String filePath, CSVFormat csvFormat) throws IOException {
        file = new File(filePath);
        this.csvFormat = csvFormat;
        csvParser = CSVParser.parse(file, StandardCharsets.UTF_8, csvFormat);
        csvRecords = csvParser.getRecords();
    }

    public int getRecordsNumber(){
        return csvRecords.size();
    }

    public int getColumnsNumber(){
        if(csvRecords.size() > 0){
            return csvRecords.get(0).size();
        }
        return 0;
    }
    
    public void write(int line, String value) throws Exception {
        CSVRecord record = csvRecords.get(line);

        String[] values = (String[]) ReflectionUtils.getFieldValue(CSVRecord.class, VALUES_FIELD_NAME, record);
        int c = getColumnsNumber() - 1;
        System.out.println(c);
        values[c] = value;
        ReflectionUtils.setFieldValue(CSVRecord.class, VALUES_FIELD_NAME, record, values);

        Appendable out = new OutputStreamWriter(new FileOutputStream(file));
        CSVPrinter printer = csvFormat.print(out);
        printer.printRecords(csvRecords);
        printer.flush();
        printer.close();
    }

    public String read(int line, int column) {
        return csvRecords.get(line).get(column);
    }
}
