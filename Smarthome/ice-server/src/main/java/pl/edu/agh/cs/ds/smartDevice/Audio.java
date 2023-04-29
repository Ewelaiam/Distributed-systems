package pl.edu.agh.cs.ds.smartDevice;

import com.zeroc.Ice.Current;
import lombok.extern.slf4j.Slf4j;
import smarthome.maxVolume;
import smarthome.minVolume;

@Slf4j
public abstract class Audio implements smarthome.Audio, minVolume, maxVolume {

    private int volumeState = 5;
    private boolean audioState = false;
    protected boolean trackState = false;

    @Override
    public int getCurrentVolume(Current current) throws Error {
        log.info("Audio: current volume is: {}", volumeState);
        assertAudioState();
        return volumeState;
    }

    @Override
    public void turnUp(Current current) throws Error {
        log.info("Audio: turning volume up");
        assertAudioState();
        if (volumeState < maxVolume.value) {
            volumeState++;
        } else {
            throw new Error("Max Volume reached");
        }
    }

    @Override
    public void turnDown(Current current) throws Error {
        log.info("Audio: turning volume down");
        assertAudioState();
        if (volumeState > minVolume.value) {
            volumeState--;
        } else {
            throw new Error("Min Volume reached");
        }
    }

    @Override
    public void turnOn(Current current) {
        log.info("Audio: turning on");
        audioState = true;
    }

    @Override
    public void turnOff(Current current) {
        log.info("Audio: turnOff");
        audioState = false;
    }

    @Override
    public void startTrack(Current current) throws Error {
        log.info("Audio: startTrack");
        assertAudioState();
        trackState = true;
    }

    @Override
    public void stopTrack(Current current) throws Error {
        log.info("Audio: stopTrack");
        assertAudioState();
        trackState = false;

    }

    @Override
    public String getTrackName(Current current) throws Error {
        log.info("Audio: getTrackName");
        assertAudioState();
        if (trackState) {
            return "Track name";
        } else {
            throw new Error("Track not started");
        }
    }

    protected void assertAudioState() throws Error {
        if (!audioState) {
            throw new Error("Device not turned on");
        }
    }

}
