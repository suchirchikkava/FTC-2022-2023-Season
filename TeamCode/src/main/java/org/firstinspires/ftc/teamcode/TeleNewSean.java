package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "TeleNewSean")
public class TeleNewSean extends OpMode {
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

        if (
                (gamepad1.left_stick_y > -0.3 && gamepad1.left_stick_y < 0.3) ||
                (gamepad1.left_stick_x > -0.3 && gamepad1.left_stick_x < 0.3) ||
                (gamepad1.right_stick_y > -0.3 && gamepad1.right_stick_y < 0.3) ||
                (gamepad1.right_stick_x > -0.3 && gamepad1.left_stick_x < 0.3)
            ) { wheelsSetPower(0); }

        if (gamepad1.left_stick_y > 0.3) { wheelsSetPower( 0.7, -0.7, 0.7, -0.7 ); }
        else if (gamepad1.left_stick_y < -0.3) { wheelsSetPower( -0.7, 0.7, -0.7, 0.7 ); }
        if (gamepad1.left_stick_x > 0.3) { wheelsSetPower( 0.7, -0.7 ); }
        else if (gamepad1.left_stick_x < -0.3) { wheelsSetPower( -0.7, 0.7 ); }

        if (gamepad1.left_trigger ==1) { wheelsSetPower( 0.6 ); }
        if (gamepad1.right_trigger == 1) { wheelsSetPower( -0.6 ); }

        if (gamepad1.right_stick_y > 0.3) { wheelsSetPower( 0.35, -0.35 ); }
        else if (gamepad1.right_stick_y < -0.3) { wheelsSetPower( -0.35, 0.35 ); }
        if (gamepad1.right_stick_x > 0.3) { wheelsSetPower( 0.35, -0.35 ); }
        else if (gamepad1.right_stick_x < -0.3) { wheelsSetPower( -0.35, 0.35 ); }

        if (gamepad1.left_bumper) { claw.setPosition(openClaw); }
        if (gamepad1.right_bumper) { claw.setPosition(closeClaw); }
        if (gamepad2.left_bumper) { claw.setPosition(openClaw); }
        if (gamepad2.right_bumper) { claw.setPosition(closeClaw); }
        if (gamepad2.y) { moveSlides(3338); }
        if (gamepad2.b) { moveSlides(2475); }
        if (gamepad2.x) { moveSlides(1875); }
        if (gamepad2.a) { moveSlides(0); }
        if (gamepad2.left_stick_y > 0.3) { manualSlides(true); }
        if (gamepad2.left_stick_y < -0.3) { manualSlides(false); }

    }

    public void wheelsSetPower( int p1, int p2, int p3, int p4 ) {
        wheel1.setPower(p1);
        wheel2.setPower(p2);
        wheel3.setPower(p3);
        wheel4.setPower(p4);
    }

    public void wheelsSetPower (int p1, int p3 ) {
        wheelsSetPower( p1, p1, p3, p3 );
    }

    public void wheelsSetPower (int p1 ) {
        wheelsSetPower( p1, p1, p1, p1 );
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
