package org.demo.seminar17_20240809.solid.interface_segregation_principle.ex01;

public class Program {
    public static void main(String[] args) {
        // Пример использования можно добавить здесь
    }
}

interface ISLine {
    Characteristic getSLinePackage();
}

interface IInfotainment {
    Characteristic getInfotainmentPackage();
}

interface IAudiPreSenseFront {
    Characteristic getAudiPreSenseFrontPackage();
}

interface IAdvanceLine extends IAudiCare, IAudiConnect, IHeadlights {
}

interface IAudiExclusive extends ISportLine, IDesignLine, IAmbientLighting {
}

interface IDesignLine extends IHeadlightsMatrixLed, IInfotainment, ITowingPackage {
}

interface ISportLine extends ISLine, IAudiConnect, IAudiPreSenseFront {
}

interface IAluminumDoorSillInlays {
    Characteristic getAluminumDoorSillInlaysPackage();
}

interface IAmbientLighting {
    Characteristic getAmbientLightingPackage();
}

interface IAudiCare {
    Characteristic getAudiCarePackage();
}

interface IAudiConnect {
    Characteristic getAudiConnectPackage();
}

interface IAudiDesignSelection {
    Characteristic getAudiDesignSelectionPackage();
}

interface IHeadlights {
    Characteristic getHeadlightsPackage();
}

interface IHeadlightsLed {
    Characteristic getHeadlightsLedPackage();
}

interface IHeadlightsMatrixLed {
    Characteristic getHeadlightsMatrixLedPackage();
}

interface IPowerPanoramicSunroof {
    Characteristic getPowerPanoramicSunroofPackage();
}

interface ITowingPackage {
    Characteristic getTowingPackagePackage();
}

abstract class Audi extends Car {
    public Audi(String model, String brand) {
        super(model, brand);
    }
}

abstract class AudiA5 extends Audi {
    public AudiA5(String model, String brand) {
        super(model, brand);
    }
}

class MyAudiA5 extends AudiA5 implements IAudiExclusive {
    public MyAudiA5(String model, String brand) {
        super(model, brand);
    }

    public Characteristic getSLinePackage() {
        return new Characteristic();
    }

    public Characteristic getAudiConnectPackage() {
        return new Characteristic();
    }

    public Characteristic getAudiPreSenseFrontPackage() {
        return new Characteristic();
    }

    public Characteristic getHeadlightsMatrixLedPackage() {
        return new Characteristic();
    }

    public Characteristic getInfotainmentPackage() {
        return new Characteristic();
    }

    public Characteristic getTowingPackagePackage() {
        return new Characteristic();
    }

    public Characteristic getAmbientLightingPackage() {
        return new Characteristic();
    }
}

interface IVesta {
    Characteristic getBodyWheelArrangementTractionWheels();

    Characteristic getBodyEngineLocation();

    Characteristic getBodyTypeNumberOfDoors();

    Characteristic getBodysuits();

    Characteristic getBodyLengthWidthHeight();

    Characteristic getBodyWheelbase();

    Characteristic getBodyFrontRearTrack();

    Characteristic getBodyRoadClearance();

    Characteristic getBodyRearTrunkCapacity();

    Characteristic getSuspensionFront();

    Characteristic getSuspensionBack();

    Characteristic getSteeringControlSteeringMechanism();

    Characteristic getTiresGeneralProportions();
}

abstract class Lada extends Car {
    public Lada(String model, String brand) {
        super(model, brand);
    }
}

abstract class Vesta extends Lada {
    public Vesta(String model, String brand) {
        super(model, brand);
    }
}

class Vesta113hp extends Vesta implements IVesta {
    public Vesta113hp(String model, String brand) {
        super(model, brand);
    }

    public Characteristic getBodyWheelArrangementTractionWheels() {
        throw new UnsupportedOperationException();
    }

    public Characteristic getBodyEngineLocation() {
        throw new UnsupportedOperationException();
    }

    public Characteristic getBodyTypeNumberOfDoors() {
        throw new UnsupportedOperationException();
    }

    public Characteristic getBodysuits() {
        return Characteristic.set("5");
    }

    public Characteristic getBodyLengthWidthHeight() {
        return Characteristic.set("4410/1764/1497 mm");
    }

    public Characteristic getBodyWheelbase() {
        return Characteristic.set("2635 mm");
    }

    public Characteristic getBodyFrontRearTrack() {
        return Characteristic.set("1510/1510 mm");
    }

    public Characteristic getBodyRoadClearance() {
        return Characteristic.set("178 mm");
    }

    public Characteristic getBodyRearTrunkCapacity() {
        return Characteristic.set("480 mm");
    }

    public Characteristic getSuspensionFront() {
        throw new UnsupportedOperationException();
    }

    public Characteristic getSuspensionBack() {
        throw new UnsupportedOperationException();
    }

    public Characteristic getSteeringControlSteeringMechanism() {
        throw new UnsupportedOperationException();
    }

    public Characteristic getTiresGeneralProportions() {
        return Characteristic.set("185/65 R15 (88/92, H/T); 195/55 R16 (91, H)");
    }
}

class Vesta122hp extends Vesta implements IVesta {
    public Vesta122hp(String model, String brand) {
        super(model, brand);
    }

    public Characteristic getBodyWheelArrangementTractionWheels() {
        return Characteristic.set("4x2/front");
    }

    public Characteristic getBodyEngineLocation() {
        return Characteristic.set("front lateral");
    }

    public Characteristic getBodyTypeNumberOfDoors() {
        return Characteristic.set("sedan/4");
    }

    public Characteristic getBodysuits() {
        return Characteristic.set("5");
    }

    public Characteristic getBodyLengthWidthHeight() {
        return Characteristic.set("4410/1764/1497 mm");
    }

    public Characteristic getBodyWheelbase() {
        return Characteristic.set("2635 mm");
    }

    public Characteristic getBodyFrontRearTrack() {
        return Characteristic.set("1510/1510 mm");
    }

    public Characteristic getBodyRoadClearance() {
        return Characteristic.set("178 mm");
    }

    public Characteristic getBodyRearTrunkCapacity() {
        return Characteristic.set("480 mm");
    }

    public Characteristic getSuspensionFront() {
        return Characteristic.set("Independent suspension, MacPherson type, spring-mounted, with an anti-roll bar");
    }

    public Characteristic getSuspensionBack() {
        return Characteristic.set(
                "Half-independent, lever type, spring-actuated, with oil-actuated or gas-filled telescopic shock absorbers");
    }

    public Characteristic getSteeringControlSteeringMechanism() {
        return Characteristic.set("Piston-rack");
    }

    public Characteristic getTiresGeneralProportions() {
        return Characteristic.set("185/65 R15 (88/92, H/T); 195/55 R16 (91, H)");
    }
}

abstract class Car {
    private String model;
    private String brand;

    public Car(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }
}

class Characteristic {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static Characteristic set(String arg) {
        Characteristic characteristic = new Characteristic();
        characteristic.setValue(arg);
        return characteristic;
    }
}
