package pl.edu.agh.cs.ds.smartDevice;

import com.zeroc.Ice.Current;
import lombok.extern.slf4j.Slf4j;
import smarthome.Specs;
import smarthome.Type;

@Slf4j
public class Speaker extends Audio implements smarthome.Speaker{

    private final Specs speakerInfo = new Specs(2, "BY135", "Speaker device", Type.PORTABLE, "Producer", true);
    private boolean bluetoothState = false;

    @Override
    public Specs getSpecs(Current current) {
        return speakerInfo;
    }

    @Override
    public void connectBluetooth(Current current) {
        log.info("Speaker: connectBluetooth");
        assertAudioState();
        bluetoothState = true;
    }

    @Override
    public void disconnectBluetooth(Current current) {
        log.info("Speaker: disconnectBluetooth");
        assertAudioState();
        bluetoothState = false;
    }

    @Override
    public int getCurrentVolume(Current current) throws Error {
        log.info("Speaker: current volume");
        assertBluetoothState();
        return super.getCurrentVolume(current);
    }

    @Override
    public void turnUp(Current current) throws Error {
        log.info("Speaker: turning volume up");
        assertBluetoothState();
        super.turnUp(current);
    }

    @Override
    public void turnDown(Current current) throws Error {
        log.info("Speaker: turning volume down");
        assertBluetoothState();
        super.turnDown(current);
    }


    @Override
    public void startTrack(Current current) throws Error {
        log.info("Speaker: startTrack");
        assertBluetoothState();
        super.startTrack(current);
    }

    @Override
    public void stopTrack(Current current) throws Error {
        log.info("Speaker: stopTrack");
        assertBluetoothState();
        super.stopTrack(current);
    }

    @Override
    public String getTrackName(Current current) throws Error {
        log.info("Speaker: getTrackName");
        assertBluetoothState();
        return super.getTrackName(current);
    }

    private void assertBluetoothState() throws Error {
        if (!bluetoothState) {
            throw new Error("Bluetooth not connected");
        }
    }
}
