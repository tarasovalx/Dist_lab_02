package bmstu.ru;

import java.io.IOException;

public class Flight{
    private static final int IS_CANCELLED = 19;
    private static final int DELAY_TIME = 18;
    private static final int AIRPORT_ID = 14;

    private static final String DELIMITER = ",";
    private static final String CANCELLED_FLAG = "1.00";

    private boolean isCancelled;
    private float delayTime;
    private int airportId;

    public Flight (String s) throws IOException {
        String[] data = s.split(DELIMITER);
        this.airportId = Integer.parseInt(data[AIRPORT_ID]);
        this.isCancelled = data[IS_CANCELLED].equals(CANCELLED_FLAG);
        this.delayTime = (data[DELAY_TIME].equals("")) ? 0 : Float.parseFloat(data[DELAY_TIME]);
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public float getDelayTime() {
        return delayTime;
    }

    public int getAirportId() {
        return airportId;
    }
}
