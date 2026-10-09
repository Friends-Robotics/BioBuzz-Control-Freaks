package org.firstinspires.ftc.teamcode.pedroPathing.Paths;


import static com.pedropathing.api.Paths.*;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;

public class BluePaths {

    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose start = poseFactory.of(57.5, 9.8, 90);
    private final Pose path1 = poseFactory.of(9, 9.2, -91.8576);
    private final Pose path1Control1 = poseFactory.of(9.9, 44.5, 0);
    private final Pose point2 = poseFactory.of(59, 128.3793, 270);
    private final Pose point2Control1 = poseFactory.of(19.4213, 97.3835, 0);
    private final Pose point3 = poseFactory.of(47.5405, 132.2159, 90);
    private final Pose point3Control1 = poseFactory.of(50.6518, 118.3738, 0);
    private final Pose point4 = poseFactory.of(57.5, 113, 90);
    private final Pose point4Control1 = poseFactory.of(47.103, 113.1146, 0);
    private final Pose point5 = poseFactory.of(57.5, 113, 270);

    public Path path1() {
        return curve(start, path1Control1, path1).tangent();
    }

    public Path path2() {
        return curve(path1, point2Control1, point2).constant(point2);
    }

    public Path path3() {
        return curve(point2, point3Control1, point3).constant(point3);
    }

    public Path path4() {
        return curve(point3, point4Control1, point4).constant(point4);
    }

    public Path path5() {
        return line(point4, point5).constant(point5);
    }
}
