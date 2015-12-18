package gov.alaska.escdataloader.app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author mhspellecacy
 */
public class CSVImport {

    private static final Logger log = Logger.getGlobal();
    private static final String csvLocation = "C:\\workspace\\EscDataLoader\\nush_2015_counts.csv";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private static final NumberFormat usFormat = NumberFormat.getNumberInstance(Locale.US);

    public CSVImport() {
        log.log(Level.INFO, "In CSV Importer...");
    }

    /**
     *
     * @return @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     * @throws java.text.ParseException
     */
    public static Map<Date, FishCounts> getCounts() throws FileNotFoundException, IOException, ParseException {
        Map<Date, FishCounts> fishCountsMap = new HashMap<>();
        Reader in = new FileReader(csvLocation);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);

        for (CSVRecord rec : records) {
            Date countDate = dateFormat.parse(rec.get("date"));
            FishCounts fishCounts = new FishCounts(
              usFormat.parse(rec.get("chin_count")).intValue(),
              usFormat.parse(rec.get("sock_count")).intValue(),
              usFormat.parse(rec.get("chum_count")).intValue());

            fishCountsMap.put(countDate, fishCounts);
        }
        return fishCountsMap;
    }

}
