package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "TeleOpSuchir")
public class Suchir extends OpMode
{

    private DcMotor wheel1;
    private DcMotor wheel2;
    private DcMotor wheel3;
    private DcMotor wheel4;



    private final double closeBack = 1;
    private final double openBack = 0;
    private final double closeFront = 1;
    private final double openFront = -0;

    @Override
    public void init() {
        wheel1 = hardwareMap.get(DcMotor.class, "frontRight");
        wheel2 = hardwareMap.get(DcMotor.class, "frontLeft");
        wheel3 = hardwareMap.get(DcMotor.class, "backRight");
        wheel4 = hardwareMap.get(DcMotor.class, "backLeft");

        //slide = hardwareMap.get(DcMotor.class, "slide");
        /*frontClaw = hardwareMap.get(Servo.class, "frontClaw");
        backClaw = hardwareMap.get(Servo.class, "backClaw");
        frontArm = hardwareMap.get(Servo.class, "frontArm");
        backArm = hardwareMap.get(Servo.class, "backArm");
        claw = hardwareMap.get(Servo.class, "claw");
        clawtwo = hardwareMap.get(Servo.class, "claw");*/
        /*slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);*/
    }

    @Override
    public void loop() {
        if (gamepad1.left_stick_y < -0.3) {
           wheel1.setPower(1);
           wheel2.setPower(1);
           wheel3.setPower(1);
           wheel4.setPower(1);
        }
        if (gamepad1.left_stick_y > 0.3) {
            wheel1.setPower(0);
            wheel2.setPower(0);
            wheel3.setPower(0);
            wheel4.setPower(0);
        }
    }
}
