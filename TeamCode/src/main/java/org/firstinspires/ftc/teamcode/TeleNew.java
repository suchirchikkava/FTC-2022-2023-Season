package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "TeleNewFran")
public class TeleNew extends OpMode {
    private DcMotor wheel1;
    private DcMotor wheel2;
    private DcMotor wheel3;
    private DcMotor wheel4;
    private DcMotor slide;
    private Servo claw;

    private final double closeClaw = 1;
    private final double openClaw = 0;

    @Override
    public void init() {
        wheel1 = hardwareMap.get(DcMotor.class, "frontRight");
        wheel2 = hardwareMap.get(DcMotor.class, "frontLeft");
        wheel3 = hardwareMap.get(DcMotor.class, "backRight");
        wheel4 = hardwareMap.get(DcMotor.class, "backLeft");

        claw = hardwareMap.get(Servo.class, "claw");

        slide = hardwareMap.get(DcMotor.class, "slide");

        slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slide.setTargetPosition(0);
        slide.setPower(0.1);
        slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);


    }

    @Override
    public void loop() {
            //Neutral condition for vertical
        if (gamepad1.left_stick_y > -0.3 && gamepad1.left_stick_y < 0.3) { wheelMove (0, 0, 0, 0); }

            //Neutral condition for horizontal
        if (gamepad1.left_stick_x > -0.3 && gamepad1.left_stick_x < 0.3) { wheelMove (0, 0, 0, 0); }

            //Go up
        if (gamepad1.left_stick_y < 0.3) { wheelMove (0.7, -0.7, 0.7, -0.7); }

            //Go down
        if (gamepad1.left_stick_y > -0.3) { wheelMove (-0.7, 0.7, -0.7, 0.7); }

            //Go right
        if (gamepad1.left_stick_x < 0.3) { wheelMove (0.7, 0.7, -0.7, -0.7); }

            //Go left
        if (gamepad1.left_stick_x > -0.3) { wheelMove (-0.7, -0.7, 0.7, 0.7); }

            //Rotate Left
        if (gamepad1.left_bumper) { wheelMove (0.6, 0.6, 0.6, 0.6); }

            //Rotate Right
        if (gamepad1.right_bumper) { wheelMove (-0.6, -0.6, -0.6, -0.6); }

            //Neutral For Slow Move for vertical
        if (gamepad1.right_stick_y > -0.3 && gamepad1.right_stick_y < 0.3) { wheelMove (0, 0, 0, 0); }

            //Neutral For Slow Move for horizontal
        if (gamepad1.right_stick_x > -0.3 && gamepad1.left_stick_x < 0.3) { wheelMove (0, 0, 0, 0); }

            //Move Up For Slow Move
        if (gamepad1.right_stick_y < 0.3) { wheelMove (0.35, -0.35, 0.35, -0.35); }

            //Move Down For Slow Move
        if (gamepad1.right_stick_y > -0.3) { wheelMove (-0.35, 0.35, -0.35, 0.35); }

            //Move Right For Slow Move
        if (gamepad1.right_stick_x < 0.3) { wheelMove (0.35, 0.35, -0.35, -0.35); }

            //Move Left For Slow Move
        if (gamepad1.right_stick_x > -0.3) { wheelMove (-0.35, -0.35, 0.35, 0.35); }

            //Open Claw
        if (gamepad1.left_trigger == 1) { claw.setPosition(openClaw); }

            //Close Claw
        if (gamepad1.right_trigger == 1) { claw.setPosition(closeClaw); }

            //Gamepad 2 Open Claw
        if (gamepad2.left_bumper) { claw.setPosition(openClaw); }

            //Gamepad 2 Close Claw
        if (gamepad2.right_bumper) { claw.setPosition(closeClaw); }

            //Slides all the way up
        if (gamepad2.y) { moveSlides(3338); }

            //Slides middle up
        if (gamepad2.b) { moveSlides(2475); }

            //Slides low up
        if (gamepad2.x) { moveSlides(1875); }

            //Slides down/reset
        if (gamepad2.a) { moveSlides(0); }

            //Manual slide move up
        if (gamepad2.left_stick_y > 0.3) { manualSlides(true); }

            //Manual slide move down
        if (gamepad2.left_stick_y < -0.3) { manualSlides(false); }

    }


    public void wheelMove (double p1, double p2, double p3, double p4)
    {
        wheel1.setPower(p1);
        wheel1.setPower(p2);
        wheel1.setPower(p3);
        wheel1.setPower(p4);
    }

    public void moveSlides (int distance) {
        telemetry.addData("position", slide.getTargetPosition());
        telemetry.update();
        slide.setTargetPosition(distance*-1);
        slide.setPower(0.9);
        slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    public void manualSlides (boolean up) {
        telemetry.addData("position", slide.getTargetPosition());
        telemetry.update();
        if (!up && slide.getTargetPosition() > -3335 + 12)
        {
            slide.setTargetPosition(slide.getTargetPosition() - 12);
            slide.setPower(0.85);
            slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        if (up && slide.getTargetPosition() < 0 - 12)
        {
            slide.setTargetPosition(slide.getTargetPosition() + 12);
            slide.setPower(0.85);
            slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    }

}