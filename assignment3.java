class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class CombustionEngine extends Engine {
    public CombustionEngine() {
        super("Combustion Engine");
    }
}

class ElectricEngine extends Engine {
    public ElectricEngine() {
        super("Electric Engine");
    }
}

class HybridEngine extends Engine {
    public HybridEngine() {
        super("Hybrid Engine");
    }
}

class Manufacture {
    private String name;

    public Manufacture(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

abstract class Vehicle {
    private Manufacture manufacture;
    private Engine engine;

    public Vehicle(Manufacture manufacture, Engine engine) {
        this.manufacture = manufacture;
        this.engine = engine;
    }

    public abstract void ShowCharacteristics();
}

class ICEV extends Vehicle {
    public ICEV(Manufacture manufacture, Engine engine) {
        super(manufacture, engine);
    }

    @Override
    public void ShowCharacteristics() {
        System.out.println("Vehicle Type: ICEV");
        System.out.println("Manufacturer: " + getManufacture().getName());
        System.out.println("Engine Type: " + getEngine().getType());
    }
}

class BEV extends Vehicle {
    public BEV(Manufacture manufacture, Engine engine) {
        super(manufacture, engine);
    }

    @Override
    public void ShowCharacteristics() {
        System.out.println("Vehicle Type: BEV");
        System.out.println("Manufacturer: " + getManufacture().getName());
        System.out.println("Engine Type: " + getEngine().getType());
    }
}

class HybridV extends Vehicle {
    public HybridV(Manufacture manufacture, Engine engine) {
        super(manufacture, engine);
    }

    @Override
    public void ShowCharacteristics() {
        System.out.println("Vehicle Type: HybridV");
        System.out.println("Manufacturer: " + getManufacture().getName());
        System.out.println("Engine Type: " + getEngine().getType());
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Manufacture toyota = new Manufacture("Toyota");
        Manufacture tesla = new Manufacture("Tesla");

        Engine combustionEngine = new CombustionEngine();
        Engine electricEngine = new ElectricEngine();

        Vehicle[] vehicles = {
            new ICEV(toyota, combustionEngine),
            new BEV(tesla, electricEngine),
            new HybridV(toyota, electricEngine)
        };

        for (Vehicle vehicle : vehicles) {
            vehicle.ShowCharacteristics();
            System.out.println();
        }
    }
}

