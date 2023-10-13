/*Suppose,a small tailorshop nearby zindabazar concern a particular pattern which allows requests to be encapsulated as objects, 
 .Implement a design pattern which will further help clients to be parametrized with different requests*/



import java.util.ArrayList;
import java.util.List;


class TailorMaster {
    public void stitchShirt() {
        System.out.println("Tailormaster stitches a shirt.");
    }
    public void stitchPant() {
        System.out.println("Tailormaster stitches a pant.");
    }
}


interface Command {
    void execute();
}


class ShirtCommand implements Command {
    private TailorMaster tailorMaster;
    public ShirtCommand(TailorMaster tailorMaster) {
        this.tailorMaster =tailorMaster;
    }

    @Override
    public void execute() {
        tailorMaster.stitchShirt();
    }
}


class PantCommand implements Command {
    private TailorMaster tailorMaster;
    public PantCommand(TailorMaster tailorMaster) {
        this.tailorMaster= tailorMaster;
    }

    @Override
    public void execute() {
        tailorMaster.stitchPant();
    }
}

class Owner {
    private List<Command> orders = new ArrayList<>();
    public void takeOrder(Command command) {
        orders.add(command);
    }

    public void submitOrders() {
        for (Command command : orders) {
            command.execute();
        }
        orders.clear();
    }
}
public class Main {
    public static void main(String[] args) {
        TailorMaster tailorMaster = new TailorMaster();

        Command ShirtCommand = new ShirtCommand(tailorMaster);
        Command PantCommand = new PantCommand(tailorMaster);

        Owner o = new Owner();
        o.takeOrder(ShirtCommand);
        o.takeOrder(PantCommand);
        o.submitOrders();
    }
}