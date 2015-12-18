/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.alaska.escdataloader.app;

import gov.alaska.escdataloader.core.SEscCount;
import gov.alaska.escdataloader.core.SEscCountItem;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mhspellecacy
 */
public class Main {

    private static final EntityManager em = JpaManager.getEntityManager();
    private static final Logger log = Logger.getGlobal();
    private static final String obs_site = "003";
    private static final Integer obs_year = 2015;

    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        Main main = new Main();
        main.doStuff();
    }

    public Collection<SEscCount> getCounts() {
        String rawQuery = "SELECT * FROM DATA.S_ESC_COUNT s WHERE s.ESC_OBS_SITE_CODE = ? and s.YEAR = ?";
        Query nq = em.createNativeQuery(rawQuery, SEscCount.class);
        nq.setParameter(1, obs_site);
        nq.setParameter(2, obs_year);
        
        return nq.getResultList();
    }

    public void doStuff() throws IOException, FileNotFoundException, ParseException {
        log.log(Level.INFO, "Starting up...");
        
        //Import our replacement counts from CSV...
        Map<Date, FishCounts> fishCounts = CSVImport.getCounts();
        log.log(Level.INFO, "Found {0} CSV counts", fishCounts.size());
        
        // Find the database counts being updated...
        Collection<SEscCount> counts = getCounts();
        log.log(Level.INFO, "Found {0} DB counts", counts.size());

        //Start a new DB Transaction, so we can rollback if things go wonk.
        em.getTransaction().begin();
        
        //Loop over every day we found with a fish count
        for (SEscCount count : counts) {
            
            //Get all the Count Items linked to this Day's Count 
            Collection<SEscCountItem> items = count.getSEscCountItemCollection();

            //Loop over all the items for that count...
            for (SEscCountItem item : items) {
                
                //Determine what fish species this item count is for...
                switch (item.getSpeciesCode()) {
                    //Chinook
                    case "410":
                        //Update our Chinook count for this date...
                        item.setCountDaily(fishCounts.get(count.getCountDate()).getChinCount());
                        em.merge(item);
                        break;
                        
                    //Sockeye
                    case "420":
                        item.setCountDaily(fishCounts.get(count.getCountDate()).getSockCount());
                        em.merge(item);
                        //log.log(Level.INFO, "Sockeyes!!");
                        break;
                        
                    //Chum
                    case "450":
                        item.setCountDaily(fishCounts.get(count.getCountDate()).getChumCount());
                        em.merge(item);
                        //log.log(Level.INFO, "Chums!");
                        break;
                }

                //log.log(Level.INFO, "Count Date: {0}, Species: {1}, Count: {2}",
                 // new Object[]{count.getCountDate(), item.getSpeciesCode(), item.getCountDaily()});

            }
        }
        
        //Commit our updates to the database
        em.getTransaction().commit();
    }

}
