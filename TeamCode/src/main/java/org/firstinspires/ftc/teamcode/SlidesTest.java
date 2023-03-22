package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp(name = "SlidesTest")
public class SlidesTest extends OpMode {

    private DcMotor slides;
    @Override
    public void init() {
        slides = hardwareMap.get(DcMotor.class, "slide");

        slides.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    @Override
    public void loop() {

       if (gamepad1.y) {
           moveSlides(0);
       }

       if (gamepad1.x) {
           moveSlides(2000);
       }

    }
    public void moveSlides (int distance) {
        slides.setTargetPosition(distance*-1);
        slides.setPower(0.4);
        slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}
