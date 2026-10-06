package org.firstinspires.ftc.teamcode.pedroPathing.Paths;


import static com.pedropathing.api.Paths.line;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;

public class BluePaths {

    private final PoseFactory poseFactory = PoseFactory.degrees();
    // Poses
    public final Pose startPose = poseFactory.of(24, 24, 0);
    private final Pose scorePose = poseFactory.of(48, 48, 90);
    private final Pose parkPose = poseFactory.of(72, 48, 90);
    private final Pose flowerPose = poseFactory.of(72, 48, 90);


    public Path startToScore() {
        return line(startPose, scorePose).linear(startPose, scorePose);
    }
    private Path park(){
        return line(scorePose, parkPose).linear(scorePose, parkPose);
    }

}
