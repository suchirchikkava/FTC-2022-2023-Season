package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "Testing")
public class Suchir extends OpMode
{
    private DcMotor arm;

    @Override
    public void init() {
        arm = hardwareMap.get(DcMotor.class, "arm");
    }

    @Override
    public void loop() {
        if (gamepad1.left_stick_y < -0.3) {
           arm.setPower(-0.7);
        }
        if (gamepad1.left_stick_y > 0.3) {
            arm.setPower(0.7);
        }
    }
}
