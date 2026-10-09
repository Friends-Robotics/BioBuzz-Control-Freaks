package org.firstinspires.ftc.teamcode.pedroPathing.Paths;


import static com.pedropathing.api.Paths.*;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;

public class BluePaths {

    private final PoseFactory poseFactory = PoseFactory.degrees();

    public final Pose start = poseFactory.of(57.5, 9.8, 90); //is also start
    private final Pose intake = poseFactory.of(9, 9.2, -91.8576);
    private final Pose startIntakeControl = poseFactory.of(9.9, 44.5, 0);
    private final Pose shoot = poseFactory.of(59, 113, 270);
    private final Pose intakeShootControl = poseFactory.of(19.4213, 97.3835, 0);
    private final Pose flower = poseFactory.of(47.5405, 132.2159, 90);
    private final Pose shootFlowerControl = poseFactory.of(50.6518, 118.3738, 0);
    private final Pose shootInverted = poseFactory.of(57.5, 113, 90);
    private final Pose flowerShootControl = poseFactory.of(47.103, 113.1146, 0);

    public Path startIntake() {
        return curve(start, startIntakeControl, intake).tangent();
    }

    public Path intakeShoot() {
        return curve(intake, intakeShootControl, shoot).constant(shoot);
    }

    public Path shootFlower() {
        return curve(shoot, shootFlowerControl, flower).constant(flower);
    }

    public Path flowerShoot() {
        return curve(flower, flowerShootControl, shoot).constant(shoot);
    }

    public Path ShootTurn180() {
        return line(shoot, shootInverted).constant(shootInverted);
    }
}
