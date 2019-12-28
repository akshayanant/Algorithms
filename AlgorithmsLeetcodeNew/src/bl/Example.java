package bl;

/**
 * Created by Akshay Hegde on 5/23/2019.
 */
class Vehicle {
int num;
int wheels;
String name;

    public Vehicle(int num, int wheels, String name) {
        this.num = num;
        this.wheels = wheels;
        this.name = name;
    }
}

public class Example{
    public static void main(String[] args) {
        Vehicle myVehicle = new Vehicle(1234,4,"dfkgh");
        System.out.println("Name of the fkjasflkashflkwh : "+ myVehicle.name + "Number of wheels is : " + myVehicle.wheels );
        myVehicle.wheels = 2;
        System.out.println("number of wheels :" +myVehicle.wheels);

        Vehicle myVehicle2 = new Vehicle(2133,45,"sdgh");
        System.out.println(myVehicle2.name );
    }

    private void newMethod(){    }
}
