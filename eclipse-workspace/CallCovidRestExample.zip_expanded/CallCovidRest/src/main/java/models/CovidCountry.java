
package models;


public class CovidCountry {

    private long updated;
    private String country;
    private CountryInfo countryInfo;
    private long cases;
    private long todayCases;
    private long deaths;
    private long todayDeaths;
    private long recovered;
    private long todayRecovered;
    private long active;
    private long critical;
    private long casesPerOneMillion;
    private long deathsPerOneMillion;
    private long tests;
    private long testsPerOneMillion;
    private long population;
    private String continent;
    private long oneCasePerPeople;
    private long oneDeathPerPeople;
    private long oneTestPerPeople;
    private double activePerOneMillion;
    private double recoveredPerOneMillion;
    private double criticalPerOneMillion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CovidCountry() {
    }

    /**
     * 
     * @param continent
     * @param country
     * @param recoveredPerOneMillion
     * @param cases
     * @param critical
     * @param oneCasePerPeople
     * @param active
     * @param testsPerOneMillion
     * @param population
     * @param oneDeathPerPeople
     * @param recovered
     * @param oneTestPerPeople
     * @param tests
     * @param criticalPerOneMillion
     * @param deathsPerOneMillion
     * @param todayRecovered
     * @param casesPerOneMillion
     * @param countryInfo
     * @param updated
     * @param deaths
     * @param activePerOneMillion
     * @param todayCases
     * @param todayDeaths
     */
    public CovidCountry(long updated, String country, CountryInfo countryInfo, long cases, long todayCases, long deaths, long todayDeaths, long recovered, long todayRecovered, long active, long critical, long casesPerOneMillion, long deathsPerOneMillion, long tests, long testsPerOneMillion, long population, String continent, long oneCasePerPeople, long oneDeathPerPeople, long oneTestPerPeople, double activePerOneMillion, double recoveredPerOneMillion, double criticalPerOneMillion) {
        super();
        this.updated = updated;
        this.country = country;
        this.countryInfo = countryInfo;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.todayRecovered = todayRecovered;
        this.active = active;
        this.critical = critical;
        this.casesPerOneMillion = casesPerOneMillion;
        this.deathsPerOneMillion = deathsPerOneMillion;
        this.tests = tests;
        this.testsPerOneMillion = testsPerOneMillion;
        this.population = population;
        this.continent = continent;
        this.oneCasePerPeople = oneCasePerPeople;
        this.oneDeathPerPeople = oneDeathPerPeople;
        this.oneTestPerPeople = oneTestPerPeople;
        this.activePerOneMillion = activePerOneMillion;
        this.recoveredPerOneMillion = recoveredPerOneMillion;
        this.criticalPerOneMillion = criticalPerOneMillion;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CountryInfo getCountryInfo() {
        return countryInfo;
    }

    public void setCountryInfo(CountryInfo countryInfo) {
        this.countryInfo = countryInfo;
    }

    public long getCases() {
        return cases;
    }

    public void setCases(long cases) {
        this.cases = cases;
    }

    public long getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(long todayCases) {
        this.todayCases = todayCases;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    public long getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(long todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public long getRecovered() {
        return recovered;
    }

    public void setRecovered(long recovered) {
        this.recovered = recovered;
    }

    public long getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(long todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public long getActive() {
        return active;
    }

    public void setActive(long active) {
        this.active = active;
    }

    public long getCritical() {
        return critical;
    }

    public void setCritical(long critical) {
        this.critical = critical;
    }

    public long getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(long casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public long getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(long deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public long getTests() {
        return tests;
    }

    public void setTests(long tests) {
        this.tests = tests;
    }

    public long getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(long testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public long getOneCasePerPeople() {
        return oneCasePerPeople;
    }

    public void setOneCasePerPeople(long oneCasePerPeople) {
        this.oneCasePerPeople = oneCasePerPeople;
    }

    public long getOneDeathPerPeople() {
        return oneDeathPerPeople;
    }

    public void setOneDeathPerPeople(long oneDeathPerPeople) {
        this.oneDeathPerPeople = oneDeathPerPeople;
    }

    public long getOneTestPerPeople() {
        return oneTestPerPeople;
    }

    public void setOneTestPerPeople(long oneTestPerPeople) {
        this.oneTestPerPeople = oneTestPerPeople;
    }

    public double getActivePerOneMillion() {
        return activePerOneMillion;
    }

    public void setActivePerOneMillion(double activePerOneMillion) {
        this.activePerOneMillion = activePerOneMillion;
    }

    public double getRecoveredPerOneMillion() {
        return recoveredPerOneMillion;
    }

    public void setRecoveredPerOneMillion(double recoveredPerOneMillion) {
        this.recoveredPerOneMillion = recoveredPerOneMillion;
    }

    public double getCriticalPerOneMillion() {
        return criticalPerOneMillion;
    }

    public void setCriticalPerOneMillion(double criticalPerOneMillion) {
        this.criticalPerOneMillion = criticalPerOneMillion;
    }

	@Override
	public String toString() {
		return "CovidCountry [updated=" + updated + ", country=" + country + ", countryInfo=" + countryInfo + ", cases="
				+ cases + ", todayCases=" + todayCases + ", deaths=" + deaths + ", todayDeaths=" + todayDeaths
				+ ", recovered=" + recovered + ", todayRecovered=" + todayRecovered + ", active=" + active
				+ ", critical=" + critical + ", casesPerOneMillion=" + casesPerOneMillion + ", deathsPerOneMillion="
				+ deathsPerOneMillion + ", tests=" + tests + ", testsPerOneMillion=" + testsPerOneMillion
				+ ", population=" + population + ", continent=" + continent + ", oneCasePerPeople=" + oneCasePerPeople
				+ ", oneDeathPerPeople=" + oneDeathPerPeople + ", oneTestPerPeople=" + oneTestPerPeople
				+ ", activePerOneMillion=" + activePerOneMillion + ", recoveredPerOneMillion=" + recoveredPerOneMillion
				+ ", criticalPerOneMillion=" + criticalPerOneMillion + "]";
	}

	
    

}
