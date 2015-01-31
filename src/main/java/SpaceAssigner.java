/**
 * The SpaceAssigner is responsible for assigning a space for an incoming
 * car to park in. This is done by calling the assignSpace() API.
 *
 * The SpaceAssigner responds to changes in space availability by 
 * implementing the GarageStatusListener interface.
 */
public class SpaceAssigner implements GarageStatusListener
{
  /**
   * Initiates the SpaceAssigner. This method is called only once per
   * app start-up.
   * @param garage The parking garage for which you are vending spaces.
   *
   * <<insert runtime and memory analysis here>>
   */
  public void initialize(ParkingGarage garage)
  {
    // insert code here
  }

  /**
   * Assigns a space to an incoming car and returns that space.
   * 
   * @param car The incoming car that needs a space.
   * @returns The space reserved for the incoming car.
   *
   * <<insert runtime and memory analysis here>>
   */
  public Space assignSpace(Car car)
  {
    return null;
    // insert code here
  }

  /**
   * {@inheritDoc}
   *
   * <<insert runtime and memory analysis here>>
   */
  public void onSpaceTaken(Car car, Space space)
  {
    // insert code here
  }

  /**
   * {@inheritDoc}
   *
   * <<insert runtime and memory analysis here>>
   */
  public void onSpaceFreed(Car car, Space space)
  {
    // insert code here
  }
  
  /**
   * {@inheritDoc}
   * 
   * <<insert runtime and memory analysis here>>
   */
  void onGarageExit(Car car)
  {
    // insert code here
  }
}

/**
 * The main app controlling the parking garage.
 */
public interface ParkingGarage
{
  /**
   * Registers the given garage status listener to receive notifications for
   * changes in the occupied status of a space.
   * @param assigner The GarageStatusListener responsible for issuing spaces.
   */
  void register(GarageStatusListener assigner);

  /**
   * @return the list of spaces in the parking garage. Note: This list may be 
   * very large and take a long time to iterate through.
   */
  Iterator<Space> getSpaces();
}



/**
 * Represents a car trying to park in the parking garage.
 */
public interface Car
{
  /**
   * @return The state in which the license plate was issued.
   */
  String getLicensePlateState();

  /**
   * @return The license plate number of the car.
   */
  String getLicensePlateNumber();
}

/**
 * Represents a space in the garage in which a car can park.
 */
public interface Space
{
  /**
   * @return A unique identifier for the given space.
   */
  int getID();

  /**
   * @return An integer representing the desirability of the space.
   *         Spaces with higher values are considered more desirable.
   */
  int getDesirability(); 

  /**
   * @return true if the space is currently occupied with a car; 
   *         false, otherwise. This returns the real world state of
   *         the Space.
   */
  boolean isOccupied();

  /**
   * @return the Car that is currently occupying the Space or null
   *         if no Car is currently present. This returns the real
   *         world state of the space.
   */
  Car getOccupyingCar();
}

/**
 * An interface used to receive callbacks about changes in the status
 * of Spaces and cars in the garage. Implementers will receive notifications
 * whenever a space becomes occupied or unoccupied and whenever a car 
 * leaves the garage.
 */
public interface GarageStatusListener
{
  /**
   * Invoked whenever a car parks in a space.
   * @param car The car parking in the space.
   * @param space The space being occupied.
   */
  void onSpaceTaken(Car car, Space space);

  /**
   * Invoked whenever a car leaves a space.
   * @param car The car leaving the space.
   * @param space The space that the car left.
   */
  void onSpaceFreed(Car car, Space space);
  
  /**
   * Invoked whenever a car leaves the garage.
   * @param car The car leaving the garage.
   */
  void onGarageExit(Car car);
}