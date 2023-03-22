package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "AngleMoveCleb")
public class AngleMove extends OpMode
{
    private DcMotor wheel1;
    private DcMotor wheel2;
    private DcMotor wheel3;
    private DcMotor wheel4;

    private double xDirection;
    private double yDirection;
    private double turn;
    private double theta;
    private double power;
    private double sin;
    private double cos;
    private double max;

    @Override
    public void init()
    {
        wheel1 = hardwareMap.get(DcMotor.class, "frontLeft");
        wheel2 = hardwareMap.get(DcMotor.class, "frontRight");
        wheel3 = hardwareMap.get(DcMotor.class, "backLeft");
        wheel4 = hardwareMap.get(DcMotor.class, "backRight");
    }

    @Override
    public void loop()
    {
        //setting the joystick direction to direction
        xDirection = gamepad1.left_stick_x;
        yDirection = gamepad1.left_stick_y;
        turn = gamepad1.right_stick_x;

        //angle at which we are pushing the joystick
        theta =  Math.atan2(yDirection, xDirection);

        //how far we are pushing the joystick
        power = Math.hypot(xDirection, yDirection);

        //orient the angle so that the wheel directions correspond to horizontal and vertical
        sin = Math.sin(theta - Math.PI/4);
        cos = Math.cos(theta - Math.PI/4);

        //maximum value so it doesn't go past pi pretty sure hopefully
        max = Math.max(Math.abs(sin), Math.abs(cos));

        //moving wheels
        wheel1.setPower((power * cos/max) + turn);
        wheel2.setPower((power * sin/max) + turn);
        wheel3.setPower((power * sin/max) + turn);
        wheel4.setPower((power * cos/max) + turn);

        //just in case if the wheels go past power of 1
        if((power + Math.abs(turn)) > 1)
        {
            wheel1.setPower(wheel1.getPower()/(power * cos/max));
            wheel2.setPower(wheel2.getPower()/(power * sin/max));
            wheel3.setPower(wheel3.getPower()/(power * sin/max));
            wheel4.setPower(wheel4.getPower()/(power * cos/max));
        }
    }
}