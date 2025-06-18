package design_patterns;

class Computer {
    // Required parameters
    private String CPU;
    private String motherboard;

    // Optional parameters
    private int RAM;
    private int storage;
    private boolean hasGraphicsCard;
    private boolean hasWiFi;

    // Private constructor
    private Computer(ComputerBuilder builder) {
        this.CPU = builder.CPU;
        this.motherboard = builder.motherboard;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.hasWiFi = builder.hasWiFi;
    }

    public void showSpecs() {
        System.out.println("Computer Specs:");
        System.out.println("CPU: " + CPU);
        System.out.println("Motherboard: " + motherboard);
        System.out.println("RAM: " + RAM + " GB");
        System.out.println("Storage: " + storage + " GB");
        System.out.println("Graphics Card: " + (hasGraphicsCard ? "Yes" : "No"));
        System.out.println("WiFi: " + (hasWiFi ? "Yes" : "No"));
    }

    // Builder Class
    public static class ComputerBuilder {
        private String CPU;
        private String motherboard;
        private int RAM;
        private int storage;
        private boolean hasGraphicsCard;
        private boolean hasWiFi;

        public ComputerBuilder(String CPU, String motherboard) {
            this.CPU = CPU;
            this.motherboard = motherboard;
        }

        public ComputerBuilder setRAM(int RAM) {
            this.RAM = RAM;
            return this;
        }

        public ComputerBuilder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public ComputerBuilder setWiFi(boolean hasWiFi) {
            this.hasWiFi = hasWiFi;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
public class Builder {
    public static void main(String[] args) {
        Computer myPC = new Computer.ComputerBuilder("Intel i7", "ASUS B460")
                            .setRAM(16)
                            .setStorage(512)
                            .setGraphicsCard(true)
                            .setWiFi(false)
                            .build();

        myPC.showSpecs();
    }
}
