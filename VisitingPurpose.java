package cs146project1;

public enum VisitingPurpose {
    PB(1, "Pay Bill", 4),
    DL(2, "Drivers License", 5),
    VR(3, "Vehicle Registration", 5),
    MA(4, "Make Appointment for Driving Test", 8);

    private int menuOption;
    private String displayString;
    private int watingScore;

    VisitingPurpose(int menuOption, String displayString, int watingScore) {
        this.menuOption = menuOption;
        this.displayString = displayString;
        this.watingScore = watingScore;
    }

    public int getMenuOption() {
        return menuOption;
    }

    public String getDisplayString() {
        return displayString;
    }

    public int getWaitingScore() {
        return watingScore;
    }

    public static VisitingPurpose valueOf(int menuOption) {
        for(VisitingPurpose visitingPurpose: VisitingPurpose.values()) {
            if(visitingPurpose.getMenuOption() == menuOption) {
                return visitingPurpose;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "VisitingPurpose{" +
                "displayString='" + displayString + '\'' +
                '}';
    }
}
