package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="ColorTest")
public class ColorTest extends LinearOpMode {

    ColorSensor sensor;

    int i = 0;

    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();

        sensor = hardwareMap.get(ColorSensor.class, "sensor");

        while (i<100) {
            sleep(1000);
            getColor();
            telemetry.update();
            sleep(1000);
            i++;
            telemetry.addData("red", sensor.red());
            telemetry.addData("green", sensor.green());
            telemetry.addData("blue", sensor.blue());
        }

    }

    public void getColor() {
        int redCone = sensor.red();
        int greenCone = sensor.green();
        int blueCone = sensor.blue();
    }
}
