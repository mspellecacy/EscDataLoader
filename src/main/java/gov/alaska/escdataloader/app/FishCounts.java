package gov.alaska.escdataloader.app;

/**
 *
 * @author mhspellecacy
 */
public class FishCounts {
    
    private Integer chinCount;
    private Integer sockCount;
    private Integer chumCount;

    /**
     *
     * @param chins
     * @param socks
     * @param chums
     */
    public FishCounts(Integer chins, Integer socks, Integer chums) {
        this.chinCount = chins;
        this.sockCount = socks;
        this.chumCount = chums;
    }
    
    /**
     * Get the value of chumCount
     *
     * @return the value of chumCount
     */
    public Integer getChumCount() {
        return chumCount;
    }

    /**
     * Set the value of chumCount
     *
     * @param chumCount new value of chumCount
     */
    public void setChumCount(Integer chumCount) {
        this.chumCount = chumCount;
    }

    /**
     * Get the value of sockCount
     *
     * @return the value of sockCount
     */
    public Integer getSockCount() {
        return sockCount;
    }

    /**
     * Set the value of sockCount
     *
     * @param sockCount new value of sockCount
     */
    public void setSockCount(Integer sockCount) {
        this.sockCount = sockCount;
    }


    /**
     * Get the value of chinCount
     *
     * @return the value of chinCount
     */
    public Integer getChinCount() {
        return chinCount;
    }

    /**
     * Set the value of chinCount
     *
     * @param chinCount new value of chinCount
     */
    public void setChinCount(Integer chinCount) {
        this.chinCount = chinCount;
    }

}
