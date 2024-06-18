import net.datastructures.AdjacencyMapGraph;
import interfaces.Node;
import interfaces.Edge;
import models.Router;
import models.Computer;
import models.Location;

public class App {
    public static void main(String[] args) throws Exception {
        
        AdjacencyMapGraph<Node, Edge> network = new AdjacencyMapGraph<>(false);

        Location ventas = new Location("location1", "Edificio A", "Piso 1", "Oficina Ventas");
        Location deposito = new Location("location2", "Edificio B", "Piso 2", "Depósito");

        Computer pc1 = new Computer("pc1", "192.168.0.101", "58:af:b3:b7:a8:19", true, ventas);
        Computer pc2 = new Computer("pc2", "192.168.0.102", "58:af:b3:b7:a8:20", true, ventas);
        Computer pc3 = new Computer("pc3", "192.168.0.103", "58:af:b3:b7:a8:21", true, ventas);

        Router router1 = new Router("router1", "192.168.0.1", "58:af:b3:b7:a8:1", "Cisco ISR 921", "15.9", true, 150, ventas);
        Router router2 = new Router("router2", "192.168.0.2", "58:af:b3:b7:a8:2", "Cisco 890 Series", "15.9.3M", true, 75, deposito);

        network.insertVertex(pc1);
        network.insertVertex(pc2);
        network.insertVertex(pc3);

        network.insertVertex(router1);
        network.insertVertex(router2);

    }
    
}
