//Parking only aligned to the right













package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

@Autonomous (name="AutonomousBlueA5RedF2")
public class AutonomousBlueA5RedF2 extends LinearOpMode {
    private DcMotor wheel1;
    private DcMotor wheel2;
    private DcMotor wheel3;
    private DcMotor wheel4;
    ColorSensor sensor;
    private DcMotor slide;

    private Servo claw;

    private final double closeClaw = 1;
    private final double openClaw = 0;

    //1 foot = 1000
    //Arm moves up to a foot
    //1 inch is 83.3


    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();
        wheel1 = hardwareMap.get(DcMotor.class, "frontRight");
        wheel2 = hardwareMap.get(DcMotor.class, "frontLeft");
        wheel3 = hardwareMap.get(DcMotor.class, "backRight");
        wheel4 = hardwareMap.get(DcMotor.class, "backLeft");
        sensor = hardwareMap.get(ColorSensor.class, "sensor");

        claw = hardwareMap.get(Servo.class, "claw");

        slide = hardwareMap.get(DcMotor.class, "slide");

        wheel1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        wheel2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        wheel3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        wheel4.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        wheel1.setPower(0.5);
        wheel2.setPower(0.5);
        wheel3.setPower(0.5);
        wheel4.setPower(0.5);

        slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        moveForward(780);
        sleep(750);
        moveLeft(100);
        sleep(750);
        getColor();
        sleep(750);

    }

    public void runWheels() {
        while (wheel1.getCurrentPosition() != wheel1.getTargetPosition()) {

            wheel1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            wheel2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            wheel3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            wheel4.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    }

    public void reset() {
        wheel1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        wheel2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        wheel3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        wheel4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void moveForward(int distance) {
        reset();
        wheel1.setTargetPosition(-distance);
        wheel2.setTargetPosition(distance);
        wheel3.setTargetPosition(-distance);
        wheel4.setTargetPosition(distance);
        runWheels();
    }

    public void moveBack(int distance) {
        reset();
        wheel1.setTargetPosition(distance);
        wheel2.setTargetPosition(-distance);
        wheel3.setTargetPosition(distance);
        wheel4.setTargetPosition(-distance);

        runWheels();
    }

    public void moveLeft(int distance) {
        reset();
        wheel1.setTargetPosition(-distance);
        wheel2.setTargetPosition(-distance);
        wheel3.setTargetPosition(distance);
        wheel4.setTargetPosition(distance);

        runWheels();
    }

    public void moveRight(int distance) {
        reset();
        wheel1.setTargetPosition(distance);
        wheel2.setTargetPosition(distance);
        wheel3.setTargetPosition(-distance);
        wheel4.setTargetPosition(-distance);

        runWheels();
    }

    public void rotateRight(int distance) {
        reset();
        wheel1.setTargetPosition(-distance);
        wheel2.setTargetPosition(-distance);
        wheel3.setTargetPosition(-distance);
        wheel4.setTargetPosition(-distance);

        runWheels();
    }

    public void rotateLeft(int distance) {
        reset();
        wheel1.setTargetPosition(distance);
        wheel2.setTargetPosition(distance);
        wheel3.setTargetPosition(distance);
        wheel4.setTargetPosition(distance);

        runWheels();
    }

    /*public void placeCone() {

    }*/

    public void getColor() {
        reset();
        int redCone = sensor.red();
        int greenCone = sensor.green();
        int blueCone = sensor.blue();

        if (redCone > blueCone && redCone > greenCone){
            telemetry.addData("color", "red");
            telemetry.update();

            sleep(750);
            moveForward(550);
            sleep(750);
            moveLeft(1150);
            sleep(750);

        }
        else if (greenCone > redCone && greenCone > blueCone){
            telemetry.addData("color", "green");
            telemetry.update();

            sleep(750);
            moveForward(500);
            sleep(750);
            moveRight(1200);
            sleep(750);

        }
        else if (blueCone > redCone && blueCone > greenCone){
            telemetry.addData("color", "blue");
            telemetry.update();

            sleep(750);
            moveForward(500);
            sleep(750);

        }
        telemetry.addData("red", sensor.red());
        telemetry.addData("green", sensor.green());
        telemetry.addData("blue", sensor.blue());

        telemetry.update();
    }

    public void moveSlides (int distance) {
        slide.setTargetPosition(distance*-1);
        slide.setPower(0.4);
        slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

}

