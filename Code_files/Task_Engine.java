package Task_queue;

public class Task_Engine {
    // Airplane Related Tasks
    Task landingTask = new Task("AIRPLANE", "Land_an_Airplane_Task");
    Task exitingTask = new Task("AIRPLANE", "Exit_a_Link_Task");
    Task enteringLink = new Task("AIRPLANE", "Enter_a_Link_Task");

    // Traffic Network Related Tasks
    Task receivingObject = new Task("TRAFFIC_NETWORK", "Receive_an_Object_Task");
    Task releasingObject = new Task("TRAFFIC_NETWORK", "Releasing an Object Task");
    Task closeThisLink = new Task("TRAFFIC_NETWORK", "Release_an_Object_Task");
    Task openThisLink = new Task("TRAFFIC_NETWORK", "Close_This_Link_Task");

    // Traffic Control Related Tasks
    ControllTask movingAirplane = new ControllTask("TRAFFIC_CONTROL", "Move_an_Airplane");
    ControllTask holdingAirplane = new ControllTask("TRAFFIC_CONTROL", "Hold_an_Airplane_in_Position");
    ControllTask parkingAirplane = new ControllTask("TRAFFIC_CONTROL", "Park_an_Airplane");
}
