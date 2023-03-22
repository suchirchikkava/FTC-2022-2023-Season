package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.LinkedList;
import java.util.Queue;

@TeleOp (name = "TeleTime")
public class TeleTime extends OpMode {
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

    private boolean active = false;
    public long startTime = 0;
    public long targetTime = 0;
    Queue<Move> queue = new LinkedList<Move>();

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
        wheels();
        if (!active) {
            buttons();
        }
        else {
            if (System.currentTimeMillis() - startTime > targetTime && !queue.isEmpty()) {
                Move current = queue.remove();
                targetTime = current.time;
                startTime = System.currentTimeMillis();
                if (current.run() /*finished is true*/) {
                    active = false;
                }
            }
        }
    }
    public void wheels () {
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
            wheel1.setPower(-0.8);
            wheel2.setPower(0.8);
            wheel3.setPower(-0.8);
            wheel4.setPower(0.8);
        }
        if (gamepad1.left_stick_y < -0.3) {
            wheel1.setPower(0.8);
            wheel2.setPower(-0.8);
            wheel3.setPower(0.8);
            wheel4.setPower(-0.8);
        }
        if (gamepad1.left_stick_x > 0.3) {
            wheel1.setPower(-0.8);
            wheel2.setPower(-0.8);
            wheel3.setPower(0.8);
            wheel4.setPower(0.8);
        }
        if (gamepad1.left_stick_x < -0.3) {
            wheel1.setPower(0.8);
            wheel2.setPower(0.8);
            wheel3.setPower(-0.8);
            wheel4.setPower(-0.8);
        }
        if (gamepad1.right_trigger == 1) {
            wheel1.setPower(-0.8);
            wheel2.setPower(-0.8);
            wheel3.setPower(-0.8);
            wheel4.setPower(-0.8);
        }
        if (gamepad1.left_trigger == 1) {
            wheel1.setPower(0.8);
            wheel2.setPower(0.8);
            wheel3.setPower(0.8);
            wheel4.setPower(0.8);
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
            wheel1.setPower(-0.25);
            wheel2.setPower(0.25);
            wheel3.setPower(-0.25);
            wheel4.setPower(0.25);
        }
        if (gamepad1.right_stick_y < -0.3) {
            wheel1.setPower(0.25);
            wheel2.setPower(-0.25);
            wheel3.setPower(0.25);
            wheel4.setPower(-0.25);
        }
        if (gamepad1.right_stick_x > 0.3) {
            wheel1.setPower(-0.25);
            wheel2.setPower(-0.25);
            wheel3.setPower(0.25);
            wheel4.setPower(0.25);
        }
        if (gamepad1.right_stick_x < -0.3) {
            wheel1.setPower(0.25);
            wheel2.setPower(0.25);
            wheel3.setPower(-0.25);
            wheel4.setPower(-0.25);
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
            wheel1.setPower(-0.25);
            wheel2.setPower(0.25);
            wheel3.setPower(-0.25);
            wheel4.setPower(0.25);
        }
        if (gamepad1.right_stick_y < -0.3) {
            wheel1.setPower(0.25);
            wheel2.setPower(-0.25);
            wheel3.setPower(0.25);
            wheel4.setPower(-0.25);
        }
        if (gamepad1.right_stick_x > 0.3) {
            wheel1.setPower(-0.25);
            wheel2.setPower(-0.25);
            wheel3.setPower(0.25);
            wheel4.setPower(0.25);
        }
        if (gamepad1.right_stick_x < -0.3) {
            wheel1.setPower(0.25);
            wheel2.setPower(0.25);
            wheel3.setPower(-0.25);
            wheel4.setPower(-0.25);
        }
    }
    public void buttons() {
        if (gamepad1.a) {
            queue.add(new Move(-2));
            queue.add(new Move(-1));
            queue.add(new Move(99));
            active = true;
        }
        if (gamepad2.a) {
            queue.add(new Move(0));
            queue.add(new Move(1));
            queue.add(new Move(2));
            queue.add(new Move(3));
            queue.add(new Move(4));
            queue.add(new Move(5));
            queue.add(new Move(61));
            queue.add(new Move(99));
            active = true;

        }
        if (gamepad2.b) {
            queue.add(new Move(0));
            queue.add(new Move(1));
            queue.add(new Move(2));
            queue.add(new Move(3));
            queue.add(new Move(4));
            queue.add(new Move(5));
            queue.add(new Move(62));
            queue.add(new Move(99));
            active = true;
            targetTime = -1;

        }
        if (gamepad2.x) {
            queue.add(new Move(0));
            queue.add(new Move(1));
            queue.add(new Move(2));
            queue.add(new Move(3));
            queue.add(new Move(4));
            queue.add(new Move(5));
            queue.add(new Move(63));
            queue.add(new Move(99));
            active = true;
            targetTime = -1;

        }
        if (gamepad2.y) {
            queue.add(new Move(7));
            queue.add(new Move(8));
            queue.add(new Move(99));
            active = true;
            targetTime = -1;
        }
    }
    public void conePlacement() {
        //move front arm out
        if (gamepad1.a) {
            rotateBack(0.5);
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
        if (gamepad1.y) {
            rotateBack(0.33);
        }
        //**
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
        if (gamepad2.left_stick_button) {
            frontArm.setPosition(0.8);
        }
        //**
        //open front claw
        if (gamepad2.right_stick_button) {
            moveSlides(0);
            //moveFrontArm to position up there
            //moveBackArm to position up there
            //openBackClaw
            //closeFrontClaw
        }

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
    class Move {
        int step;
        long time;

        Move(int step) {
            this.step = step;
            this.time = 2000;
        }
        public boolean run () {
            boolean finished = false;
            //initial set up
            if (step == -2) {
                rotateBack(0.3);
                rotateFront(0.65);
            }
            if (step == -1) {
                backClaw.setPosition(openBack);
                rotateBack(0);
            }
            //**
            if (step == 0) {
                backClaw.setPosition(closeBack);
            }
            if (step == 1) {
                rotateBack(0.8);//??
                frontClaw.setPosition(openFront);
            }
            if (step == 2) {
                rotateFront(0.15);
            }
            if (step == 3) {
                frontClaw.setPosition(closeFront);
            }
            if (step == 4) {
                backClaw.setPosition(openBack);
            }
            if (step == 5) {
                rotateFront(0.7);
            }
            if (step == 61) {
                moveSlides(0);
                frontArm.setPosition(0.8);
            }
            if (step == 62) {
                moveSlides(800);
                frontArm.setPosition(0.8);
            }
            if (step == 63) {
                moveSlides(2100);
                frontArm.setPosition(0.8);
            }
            //**
            if (step == 7) {
                frontClaw.setPosition(openFront);
            }
            //resetting
            if (step == 8) {
                moveSlides(0);
                rotateBack(0.33);
                rotateFront(0.65);
            }

            if (step == 99)
            {
                return true;
            }
            return false;
        }

    }
}
