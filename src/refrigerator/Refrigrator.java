
package refrigerator;

public class Refrigrator {

    public enum States {
        DOOR_CLOSED_STATE, DOOR_OPENED_STATE, COOLING_STATE
    }

    ;

    private static Refrigrator instance;
    private RefrigratorDisplay display;

    private int roomTemp;
    // fridge
    private States currentState;
    private int fridgeDesiredTemp;
    private int fridgeTemp;
    private int fridgeRateLossDoorOpen;
    private int FridgeRateLossDoorClosed;
    private int fridgeCoolRate;
    private int timeRemaining;

    // freezer
    private States freezerstate;
    private int freezerDesiredTemp;
    private int freezerTemp;
    private int freezerRateLossDoorOpen;
    private int FreezerRateLossDoorClosed;
    private int freezerCoolRate;
    private int ftimeRemaining;

    public Refrigrator() {
        currentState = States.DOOR_CLOSED_STATE;
        freezerstate = States.DOOR_CLOSED_STATE;

        display = new GUIDisplay();
        display.setRefrigrator(this);

        display.fridgeturnLightOff();
        display.freezerturnLightOff();
        display.fridgeidle();
        display.freezeridle();
        roomTemp = 70;

        fridgeTemp = 41;
        freezerTemp = 0;
        display.setFridgeTemp(fridgeTemp);
        display.setFreezerTemp(freezerTemp);
        fridgeDesiredTemp = 41;
        freezerDesiredTemp = 0;
        fridgeCoolRate = 0;

        timeRemaining = 20;
        ftimeRemaining = 30;

    }

    public static Refrigrator instance() {
        if (instance == null) {
            return instance = new Refrigrator();
        }
        return instance;
    }

    public void processDoorClose() {
        if (currentState == States.DOOR_OPENED_STATE) {
            currentState = States.DOOR_CLOSED_STATE;
            display.fridgeturnLightOff();

        }
    }

    public void processDoorOpen() {
        if (currentState == States.DOOR_CLOSED_STATE || currentState == States.COOLING_STATE) {
            fridgeRateLossDoorOpen = 0;
            currentState = States.DOOR_OPENED_STATE;

            display.fridgeidle();
            display.fridgeturnLightOn();
        }

    }

    public void setDesiredFridgeTemp(int fridgeDesiredTemp) {
        this.fridgeDesiredTemp = fridgeDesiredTemp;
    }

    // freezer
    public void fprocessDoorClose() {

        if (freezerstate == States.DOOR_OPENED_STATE) {
            freezerstate = States.DOOR_CLOSED_STATE;
            display.freezerturnLightOff();

        }
    }

    public void fprocessDoorOpen() {
        if (freezerstate == States.DOOR_CLOSED_STATE || freezerstate == States.COOLING_STATE) {
            freezerRateLossDoorOpen = 0;
            freezerstate = States.DOOR_OPENED_STATE;

            display.freezeridle();
            display.freezerturnLightOn();
        }

    }

    public void setDesiredFreezerTemp(int freezerDesiredTemp) {
        this.freezerDesiredTemp = freezerDesiredTemp;
    }

    public void setRoomTemp(int roomTemp) {
        this.roomTemp = roomTemp;
    }

    public void clockTicked() {
        if (fridgeTemp > fridgeDesiredTemp && currentState != States.DOOR_OPENED_STATE) {
            // cooling active
            currentState = States.COOLING_STATE;
            display.fridgestartCooling();
        }

        if (currentState == States.DOOR_OPENED_STATE) {
            fridgeRateLossDoorOpen++;
            if (fridgeRateLossDoorOpen == 2) {
                if (fridgeTemp != roomTemp) {
                    fridgeTemp++;
                }
                display.setFridgeTemp(fridgeTemp);
                fridgeRateLossDoorOpen = 0;
            }
        }

        if (currentState == States.DOOR_CLOSED_STATE && fridgeDesiredTemp > fridgeTemp) {
            fridgeRateLossDoorOpen++;
            if (fridgeRateLossDoorOpen == 2) {
                if (fridgeDesiredTemp != fridgeTemp) {
                    fridgeTemp++;
                }
                display.setFridgeTemp(fridgeTemp);
                fridgeRateLossDoorOpen = 0;
            }

        }
        if (currentState == States.DOOR_CLOSED_STATE && freezerDesiredTemp > freezerTemp) {
            freezerRateLossDoorOpen++;
            if (freezerRateLossDoorOpen == 2) {
                if (freezerDesiredTemp != freezerTemp) {
                    freezerTemp++;
                }
                display.setFreezerTemp(freezerTemp);
                freezerRateLossDoorOpen = 0;
            }


        }
        if (fridgeTemp > 41 && currentState != States.DOOR_OPENED_STATE) {
            // processCoolRequest();
            currentState = States.COOLING_STATE;
            display.fridgestartCooling();
        }
        if (currentState == States.COOLING_STATE) {

            timeRemaining--;
            if (timeRemaining == 0) {
                fridgeTemp--;
                display.setFridgeTemp(fridgeTemp);
                currentState = States.DOOR_CLOSED_STATE;
                // display.fridgeidle();
                timeRemaining = 20;
                // display.fridgeturnLightOff();
            }
        }
        if (currentState != States.COOLING_STATE) {
            display.fridgeidle();
        }

        // freezer
        if (freezerTemp > freezerDesiredTemp && freezerstate != States.DOOR_OPENED_STATE) {
            // cooling active
            freezerstate = States.COOLING_STATE;
            display.freezerstartCooling();
        }

        if (freezerstate == States.DOOR_OPENED_STATE) {
            freezerRateLossDoorOpen++;
            if (freezerRateLossDoorOpen == 1) {
                if (freezerTemp != roomTemp) {
                    freezerTemp++;
                }
                display.setFreezerTemp(freezerTemp);
                freezerRateLossDoorOpen = 0;
            }

        }
        if (freezerTemp > 0 && freezerstate != States.DOOR_OPENED_STATE) {
            // processCoolRequest();
            freezerstate = States.COOLING_STATE;
            display.freezerstartCooling();
        }

        if (freezerstate == States.COOLING_STATE) {

            ftimeRemaining--;

            if (ftimeRemaining == 0) {
                freezerTemp--;
                display.setFreezerTemp(freezerTemp);
                freezerstate = States.DOOR_CLOSED_STATE;
                // display.freezeridle();
                ftimeRemaining = 30;

            }
        }
        if (freezerstate != States.COOLING_STATE) {
            display.freezeridle();
        }

    }

}
