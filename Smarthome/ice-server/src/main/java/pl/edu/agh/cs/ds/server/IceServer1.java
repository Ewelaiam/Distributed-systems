package pl.edu.agh.cs.ds.server;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import pl.edu.agh.cs.ds.smartDevice.Radio;
import pl.edu.agh.cs.ds.smartDevice.Speaker;
import pl.edu.agh.cs.ds.smartDevice.WeatherStation;

public class IceServer1 {
    public void t1(String[] args)
    {
        int status = 0;
        Communicator communicator = null;

        try	{
            // 1. Inicjalizacja ICE - utworzenie communicatora
            communicator = Util.initialize(args);

            // 2. Konfiguracja adaptera
            // METODA 1 (polecana produkcyjnie): Konfiguracja adaptera Adapter1 jest w pliku konfiguracyjnym podanym jako parametr uruchomienia serwera
            //ObjectAdapter adapter = communicator.createObjectAdapter("Adapter1");

            // METODA 2 (niepolecana, dopuszczalna testowo): Konfiguracja adaptera Adapter1 jest w kodzie �r�d�owym
            //ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("Adapter1", "tcp -h 127.0.0.1 -p 10000");
            //ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("Adapter1", "tcp -h 127.0.0.1 -p 10000 : udp -h 127.0.0.1 -p 10000");
            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("Adapter1", " tcp -h 127.0.0.1 -p 10000 -z : udp -h 127.0.0.1 -p 10000 -z");

            // 3. Stworzenie serwanta/serwant�w
            WeatherStation weatherStationServant = new WeatherStation();
            Speaker speakerServant = new Speaker();
            Radio radioServant = new Radio();

            // 4. Dodanie wpis�w do tablicy ASM, skojarzenie nazwy obiektu (Identity) z serwantem
            adapter.add(weatherStationServant, new Identity("weatherStation1", "weatherStation"));
            adapter.add(speakerServant, new Identity("speaker1", "speaker"));
            adapter.add(radioServant, new Identity("radio1", "radio"));

            // 5. Aktywacja adaptera i wej�cie w p�tl� przetwarzania ��da�
            adapter.activate();

            System.out.println("Entering event processing loop...");

            communicator.waitForShutdown();

        }
        catch (Exception e) {
            System.err.println(e);
            status = 1;
        }
        if (communicator != null) {
            try {
                communicator.destroy();
            }
            catch (Exception e) {
                System.err.println(e);
                status = 1;
            }
        }
        System.exit(status);
    }


    public static void main(String[] args)
    {
        IceServer1 app = new IceServer1();
        app.t1(args);
    }
}
