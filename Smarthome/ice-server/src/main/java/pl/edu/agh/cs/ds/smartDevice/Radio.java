package pl.edu.agh.cs.ds.smartDevice;

import com.zeroc.Ice.Current;
import lombok.extern.slf4j.Slf4j;
import smarthome.Error;
import smarthome.Specs;
import smarthome.Type;

@Slf4j
public class Radio extends Audio implements smarthome.Radio {

    private boolean radioState = false;
    private double station =  96.6;

    private final Specs radioInfo = new Specs(1, "AX123", "Radio device", Type.PORTABLE, "Producer", false);

    @Override
    public void startTrack(Current current) throws Error {
        log.info("Radio: startTrack");
        if (radioState) {
            throw new Error(7, "Radio mode is turned on");
        }
        super.startTrack(current);
    }

    @Override
    public Specs getSpecs(Current current) {
        return radioInfo;
    }

    @Override
    public void turnOnRadioMode(Current current) throws Error {
        log.info("Radio: turnOnRadioMode");
        assertAudioState();
        assertTrackState();
        radioState = true;
    }

    @Override
    public void turnOffRadioMode(Current current) throws Error {
        log.info("Radio: turnOffRadioMode");
        assertAudioState();
        radioState = false;
    }

    @Override
    public void changeStation(Current current) throws Error {
        log.info("Radio: changeStation");
        assertAudioState();
        assertRadioState();
        if (station == 101.6){
            station = 87.6;
        } else {
            station += 2;
        }
    }

    private void assertRadioState() throws Error {
        if (!radioState) {
            throw new Error(5, "Radio mode not turned on");
        }
    }

    private void assertTrackState() throws Error {
        if (trackState) {
            throw new Error(6, "Track mode is turned on");
        }
    }
}
