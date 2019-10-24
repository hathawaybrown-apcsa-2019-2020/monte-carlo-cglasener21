
/**
 * AirlineMonteCarlo simulates a 
 *
 * @Carolyn Glasener
 * @19/24/10
 */
public class AirlineMonteCarlo
{
    private int numTickets; //total number of tickets sold
    private int numSeats; //total number of seats on the plane
    private double percentageNoshow; //percentage of people that won't show
    private final int NUM_SIMULATIONS = 100000; //total number of simulations
    private double average = 0; //average number of seats filled
    private double totalSeats; //total seats filled over all simulations
    private int seatsFilled; //seats filled on a flight
    private int timesOverbooked = 0; //times the flight was overfilled
    private double percentOverbooked = 0; //percentage of time the flight was overfilled
    /** The constructor for the AirlineMonteCarlo class.
     * @param numTickets The number of tickets the airline sold.
     * @param numSeats The number of seats on the airplane.
     * @param percentageNoshow The percentage of people that will not show up. 
     */
    public AirlineMonteCarlo(int numTickets, int numSeats, double percentageNoshow)
    {
        this.numTickets = numTickets;
        this.numSeats = numSeats;
        this.percentageNoshow = percentageNoshow;
    }
    /**
     * Runs through 100,000 simulations for flights. 
     * It uses a second for loop to see how many people will show up. 
     * If there are more seats filled than the total number of seats, the flight is overbooked
     * The total seats for all simulations is recorded. 
     * The average seast filled and the percent that the flight is overbooked is caclculated. 
     */
    public void runSimulation()
    {
        for(int i = 0; i < NUM_SIMULATIONS; i++)
       {
        seatsFilled = 0;
        for(int k = 0; k < numTickets; k++)
        {
            if(Math.random() > percentageNoshow)
            {
                seatsFilled++;
            }
        }
            if(seatsFilled > numSeats)
            {
                timesOverbooked++;
            }
            totalSeats += seatsFilled;
        }
        average = (double)totalSeats/NUM_SIMULATIONS;
        percentOverbooked = ((double)timesOverbooked/NUM_SIMULATIONS) * 100;
    }
    /**
     * @return A string containing all of the information for the simulations. 
     */
    public String reportResults()
    {
        
        return("Simulation: " + numTickets + " sold for " + numSeats + "; No show probability: " + percentageNoshow + "\n" +
        "Based on 100,000 simulations:" + "\n" + "Average seats filled: " + average + "\n" + "Number of times overbooked: " + timesOverbooked + " (" 
        + percentOverbooked + " percent).");
    }
    /**
     * The main method for AirlineMonteCarlo.
     */
    public static void main(String [] args)
    {
        AirlineMonteCarlo mySim = new AirlineMonteCarlo(140, 136, 0.04);
        mySim.runSimulation();
        System.out.print(mySim.reportResults());
    }
}
