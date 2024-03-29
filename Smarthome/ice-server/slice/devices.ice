module smarthome {

    exception Error {
        int errorCode;
        string errorMessage;
    };

    const int minVolume = 0;
    const int maxVolume = 10;

    enum Type { PORTABLE, STATIONARY };


    struct Specs {
        int id;
        string producentId;
        string name;
        Type type;
        string producer;
        bool isBluetooth;
    };

	interface Audio {
        Specs getSpecs();
        idempotent int getCurrentVolume() throws Error;
        void turnUp() throws Error;
        void turnDown() throws Error;
        void turnOn();
        void turnOff();
        void startTrack() throws Error;
        string getTrackName() throws Error;
        void stopTrack() throws Error;
    };

    interface Speaker extends Audio {
        void connectBluetooth() throws Error;
        void disconnectBluetooth() throws Error;
    };

    interface Radio extends Audio {
        void turnOnRadioMode() throws Error;
        void turnOffRadioMode() throws Error;
        void changeStation() throws Error;
    };

    struct Location {
        double latitude;
        double longitude;
    };


    sequence<double> WeeklyInsideTemperatures;
    sequence<double> WeeklyOutsideTemperatures;


    interface WeatherStation {
        Specs getSpecs();
        Location getLocation();
        double getAverageWeeklyInsideTemperature() throws Error;
        double getAverageWeeklyOutsideTemperature() throws Error;
        idempotent double getInsideTemperature();
        idempotent double getOutsideTemperature();
        idempotent double getPressure();
        idempotent double getHumidity();
        idempotent double getWindSpeed();
    };

};