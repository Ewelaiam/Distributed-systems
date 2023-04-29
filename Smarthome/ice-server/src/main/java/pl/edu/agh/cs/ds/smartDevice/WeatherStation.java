package pl.edu.agh.cs.ds.smartDevice;

import com.zeroc.Ice.Current;
import lombok.extern.slf4j.Slf4j;
import smarthome.Location;
import smarthome.Specs;

import java.util.Random;

@Slf4j
public class WeatherStation implements smarthome.WeatherStation{

    private final double[] weeklyInsideTemperatures = {20.1, 23.2, 19.3, 23.4, 21.5, 21.6, 23.7};
    private final double[] weeklyOutsideTemperatures = {10.1, 13.2, 14.3, 13.4, 11.5, 11.6, 13.7};

    private final Random random = new Random();
    private final Specs weatherStationInfo = new Specs(3, "WS123", "Weather station device", smarthome.Type.STATIONARY, "Producer", false);
    private final Location location = new Location(50.06, 19.93);

    @Override
    public Specs getSpecs(Current current) {
        return weatherStationInfo;
    }

    @Override
    public Location getLocation(Current current) {
        return location;
    }

    @Override
    public double getAverageWeeklyInsideTemperature(Current current) {
        if (weeklyInsideTemperatures.length == 0) {
            throw new Error("No temperatures available");
        }
        double sumOfTemperatures = 0;
        for (double weeklyInsideTemperature : weeklyInsideTemperatures) {
            sumOfTemperatures += weeklyInsideTemperature;
        }
        return sumOfTemperatures / weeklyInsideTemperatures.length;
    }

    @Override
    public double getAverageWeeklyOutsideTemperature(Current current) {
        if (weeklyOutsideTemperatures.length == 0) {
            throw new Error("No temperatures available");
        }
        double sumOfTemperatures = 0;
        for (double weeklyOutsideTemperature : weeklyOutsideTemperatures) {
            sumOfTemperatures += weeklyOutsideTemperature;
        }
        return sumOfTemperatures / weeklyOutsideTemperatures.length;
    }


    @Override
    public double getInsideTemperature(Current current) {
        log.info("Weather station: getInsideTemperature");
        return random.nextDouble(19, 24);
    }

    @Override
    public double getOutsideTemperature(Current current) {
        log.info("Weather station: getOutsideTemperature");
        return random.nextDouble(10, 15);
    }

    @Override
    public double getPressure(Current current) {
        log.info("Weather station: getPressure");
        return random.nextDouble(1000, 1025);
    }

    @Override
    public double getHumidity(Current current) {
        log.info("Weather station: getHumidity");
        return random.nextDouble(0, 100);
    }

    @Override
    public double getWindSpeed(Current current) {
        log.info("Weather station: getWindSpeed");
        return random.nextDouble(0, 300);
    }

}
