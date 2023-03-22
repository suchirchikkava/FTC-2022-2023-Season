package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "ConePlacement")
public class ConePlacement extends OpMode {
    private DcMotor wheel1;
    private DcMotor wheel2;
    private DcMotor wheel3;
    private DcMotor wheel4;
    private DcMotor slide;
    private Servo frontClaw;
    private Servo backClaw;
    private Servo frontArm;
    private Servo backArm;

    private final double closeBack = 1;
    private final double openBack = -0.1;
    private final double closeFront = 1;
    private final double openFront = -0.1;

    private boolean test = false;

    @Override
    public void init() {
        wheel1 = hardwareMap.get(DcMotor.class, "frontRight");
        wheel2 = hardwareMap.get(DcMotor.class, "frontLeft");
        wheel3 = hardwareMap.get(DcMotor.class, "backRight");
        wheel4 = hardwareMap.get(DcMotor.class, "backLeft");

        slide = hardwareMap.get(DcMotor.class, "slide");
        frontClaw = hardwareMap.get(Servo.class, "frontClaw");
        backClaw = hardwareMap.get(Servo.class, "backClaw");
        frontArm = hardwareMap.get(Servo.class, "frontArm");
        backArm = hardwareMap.get(Servo.class, "backArm");

        slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


    }

    @Override
    public void loop() {

        if (gamepad1.left_stick_y > -0.3 && gamepad1.left_stick_y < 0.3) {
            wheel1.setPower(0);
            wheel2.setPower(0);
            wheel3.setPower(0);
            wheel4.setPower(0);
        }
        if (gamepad1.left_stick_x > -0.3 && gamepad1.left_stick_x < 0.3) {
            wheel1.setPower(0);
            wheel2.setPower(0);
            wheel3.setPower(0);
            wheel4.setPower(0);
        }
        if (gamepad1.left_stick_y > 0.3) {
            wheel1.setPower(0.5);
            wheel2.setPower(-0.5);
            wheel3.setPower(0.5);
            wheel4.setPower(-0.5);
        }
        if (gamepad1.left_stick_y < -0.3) {
            wheel1.setPower(-0.5);
            wheel2.setPower(0.5);
            wheel3.setPower(-0.5);
            wheel4.setPower(0.5);
        }
        if (gamepad1.left_stick_x > 0.3) {
            wheel1.setPower(0.5);
            wheel2.setPower(0.5);
            wheel3.setPower(-0.5);
            wheel4.setPower(-0.5);
        }
        if (gamepad1.left_stick_x < -0.3) {
            wheel1.setPower(-0.5);
            wheel2.setPower(-0.5);
            wheel3.setPower(0.5);
            wheel4.setPower(0.5);
        }
        if (gamepad1.right_bumper) {
            wheel1.setPower(-0.5);
            wheel2.setPower(-0.5);
            wheel3.setPower(-0.5);
            wheel4.setPower(-0.5);
        }
        if (gamepad1.left_bumper) {
            wheel1.setPower(0.5);
            wheel2.setPower(0.5);
            wheel3.setPower(0.5);
            wheel4.setPower(0.5);
        }
        //start of right stick
        if (gamepad1.right_stick_y > -0.3 && gamepad1.right_stick_y < 0.3) {
            wheel1.setPower(0);
            wheel2.setPower(0);
            wheel3.setPower(0);
            wheel4.setPower(0);
        }
        if (gamepad1.right_stick_x > -0.3 && gamepad1.right_stick_x < 0.3) {
            wheel1.setPower(0);
            wheel2.setPower(0);
            wheel3.setPower(0);
            wheel4.setPower(0);
        }
        if (gamepad1.right_stick_y > 0.3) {
            wheel1.setPower(0.2);
            wheel2.setPower(-0.2);
            wheel3.setPower(0.2);
            wheel4.setPower(-0.2);
        }
        if (gamepad1.right_stick_y < -0.3) {
            wheel1.setPower(-0.2);
            wheel2.setPower(0.2);
            wheel3.setPower(-0.2);
            wheel4.setPower(0.2);
        }
        if (gamepad1.right_stick_x > 0.3) {
            wheel1.setPower(0.2);
            wheel2.setPower(0.2);
            wheel3.setPower(-0.2);
            wheel4.setPower(-0.2);
        }
        if (gamepad1.right_stick_x < -0.3) {
            wheel1.setPower(-0.2);
            wheel2.setPower(-0.2);
            wheel3.setPower(0.2);
            wheel4.setPower(0.2);
        }
        if (gamepad1.right_stick_y > -0.3 && gamepad1.right_stick_y < 0.3) {
            wheel1.setPower(0);
            wheel2.setPower(0);
            wheel3.setPower(0);
            wheel4.setPower(0);
        }
        if (gamepad1.right_stick_x > -0.3 && gamepad1.right_stick_x < 0.3) {
            wheel1.setPower(0);
            wheel2.setPower(0);
            wheel3.setPower(0);
            wheel4.setPower(0);
        }
        if (gamepad1.right_stick_y > 0.3) {
            wheel1.setPower(0.2);
            wheel2.setPower(-0.2);
            wheel3.setPower(0.2);
            wheel4.setPower(-0.2);
        }
        if (gamepad1.right_stick_y < -0.3) {
            wheel1.setPower(-0.2);
            wheel2.setPower(0.2);
            wheel3.setPower(-0.2);
            wheel4.setPower(0.2);
        }
        if (gamepad1.right_stick_x > 0.3) {
            wheel1.setPower(0.2);
            wheel2.setPower(0.2);
            wheel3.setPower(-0.2);
            wheel4.setPower(-0.2);
        }
        if (gamepad1.right_stick_x < -0.3) {
            wheel1.setPower(-0.2);
            wheel2.setPower(-0.2);
            wheel3.setPower(0.2);
            wheel4.setPower(0.2);
        }

        //move front arm out
        if (gamepad1.a && backArm.getPosition() < 1) {
            backArm.setPosition(backArm.getPosition() + .005);
        }
        if (gamepad1.y && backArm.getPosition() > 0) {
            backArm.setPosition(backArm.getPosition() - .005);
        }
        //move back arm out of way
        if (gamepad1.b) {
            rotateFront(0.65);
        }
        //open back claw
        if (gamepad1.x) {
            backClaw.setPosition(openBack);
        }
        //move back arm down to grab
        //if (gamepad1.y) {
         //   backArm.setPosition(backArm.getPosition() - 0.05);
            //rotateBack(0.43);
        //}
        //close black claw
        if (gamepad2.a) {
            backClaw.setPosition(closeBack);
        }
        //move back arm up inside
        if (gamepad2.b) {
            rotateBack(0.94);//??
        }
        //open front claw
        if (gamepad2.x) {
            frontClaw.setPosition(openFront);
        }
        //move front arm down
        if (gamepad2.y) {
            rotateFront(0.1);
        }
        //close front claw
        if (gamepad1.left_trigger == 1)
        {
            frontClaw.setPosition(closeFront);
        }
        //open back claw
        if (gamepad1.right_trigger == 1) {
            backClaw.setPosition(openBack);
        }
        //move front arm up
        if (gamepad2.left_trigger == 1) {
            rotateFront(0.8);
        }
        if (gamepad2.right_trigger == 1) {
            moveSlides(2100);
        }
        if (gamepad2.dpad_right) {
            frontClaw.setPosition(openFront );
        }
        if (gamepad2.left_stick_button) {
            frontArm.setPosition(0);
        }
        if (gamepad2.right_stick_button) {
            moveSlides(0);
        }
        telemetry.addData("pos: ", backArm.getPosition());
        telemetry.update();

    }

    public void rotateBack (double position) {
        backArm.setPosition(position);
    }
    public void rotateFront (double position) {
        frontArm.setPosition(position);
    }
    public void moveSlides (int distance) {
        slide.setTargetPosition(distance*-1);
        slide.setPower(0.4);
        slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

}