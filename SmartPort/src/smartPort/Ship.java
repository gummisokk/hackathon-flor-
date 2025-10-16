package smartPort;

import java.util.ArrayList;

public class Ship {
    private String ShipName;
    private String StartPort;
    private int StartTime;
    private ArrayList<Request> requests;

    public Ship (String ShipName, String StartPort, int StartTime){
        this.ShipName = ShipName;
        this.StartPort = StartPort;
        this.StartTime = StartTime;
        this.requests = new ArrayList<>();
    }
    public void addRequest (String request){
        String[] parts = request.split(":");
        if (parts.length == 3) {
            String navn = parts[1];
            int antall = Integer.parseInt(parts[2]);
            requests.add(new Request(navn, antall));
        }
    }

    public int getRequestCount(){
        return requests.size();
    }

    private class Request {
        private String navn;
        private int antall;

        public Request(String navn, int antall){
            this.navn = navn;
            this.antall = antall;
        }
        public String getNavn() {
            return navn;
        }
        public int getAntall(){
            return antall;
        }


        
    }
}

