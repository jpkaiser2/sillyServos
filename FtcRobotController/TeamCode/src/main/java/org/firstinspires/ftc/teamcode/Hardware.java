package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
//Created by Jacob Kaiserman
public class Hardware {

    /* Declare OpMode members. */
    private LinearOpMode myOpMode = null;   // gain access to methods in the calling OpMode.

    // Define Motor and Servo objects  (Make them private so they can't be accessed externally)

    private DcMotor frontLeft = null;
    private DcMotor backLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backRight = null;
    private DcMotor arm = null;
   // private DcMotor hanger = null;



    // Define a constructor that allows the OpMode to pass a reference to itself.
    public Hardware (LinearOpMode opmode) {
        myOpMode = opmode;
    }

    public void init(){
        frontLeft = myOpMode.hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft = myOpMode.hardwareMap.get(DcMotor.class, "backLeft");
        frontRight = myOpMode.hardwareMap.get(DcMotor.class, "frontRight");
        backRight = myOpMode.hardwareMap.get(DcMotor.class, "backRight");
       // hanger = myOpMode.hardwareMap.get(DcMotor.class, "hanger");
        //arm = myOpMode.hardwareMap.get(DcMotor.class, "arm");

        // To drive forward, the motor on one side needs to be reversed because the axles point in opposite directions.
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        myOpMode.telemetry.addData(">", "Hardware Initialized");
        myOpMode.telemetry.update();
    }


    //call drive function to drive in x direction for n ticks
    public void drive(String direction, int ticks) {
        //switch statement for different directions
        switch(direction){
            case "forward":
                 //code for forward
                frontLeft.setTargetPosition(ticks);
                backLeft.setTargetPosition(ticks);
                frontRight.setTargetPosition(ticks);
                backRight.setTargetPosition(ticks);
                myOpMode.telemetry.addData(">", "moved forward");
                break;
            case "backward":
                //code for backward
                frontLeft.setTargetPosition(-ticks);
                backLeft.setTargetPosition(-ticks);
                frontRight.setTargetPosition(-ticks);
                backRight.setTargetPosition(-ticks);
                break;
            case "left":
                //code for left
                frontLeft.setTargetPosition(-ticks);
                backLeft.setTargetPosition(ticks);
                frontRight.setTargetPosition(ticks);
                backRight.setTargetPosition(-ticks);
                break;
            case "right":
                //code for right
                frontLeft.setTargetPosition(ticks);
                backLeft.setTargetPosition(-ticks);
                frontRight.setTargetPosition(-ticks);
                backRight.setTargetPosition(ticks);
                break;
            default:
                myOpMode.telemetry.addData(">", "no direction set");
                myOpMode.telemetry.update();
        }
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //power is set
        frontLeft.setPower(1);
        frontRight.setPower(1);
        backLeft.setPower(1);
        backRight.setPower(1);
    }


}
