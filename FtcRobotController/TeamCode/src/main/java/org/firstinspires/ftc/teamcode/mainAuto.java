//Created by Jacob Kaiserman
//Silly Servos FTC Team #24213 - https://github.com/jpkaiser2/sillyServos
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
@Autonomous(name="testAuto", group="Linear Opmode")
// @Disabled
public class testAuto extends LinearOpMode {
    Hardware robot = new Hardware(this);
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        if (opModeIsActive()) {
            robot.init();
            robot.drive("forward",0.5,200);
            robot.stop();
            robot.drive("left",1,600);
            robot.stop();
            robot.drive("forward",1,600);
            robot.stop();
            robot.drive("left",1,700);
            robot.stop();
            robot.turn("left",1,400);
            robot.stop();
            robot.drive("forward",0.75,1000);
            robot.stop();
            robot.drive("backward",0.75,500);
            robot.stop();
            robot.drive("left",1,900);
            robot.stop();
            robot.drive("forward",0.75,800);
            robot.stop();
        }
    }
}