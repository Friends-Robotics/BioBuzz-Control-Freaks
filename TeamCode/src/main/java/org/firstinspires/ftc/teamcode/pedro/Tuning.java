package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.pedropathing.tuning.autotune.Procedure;
import com.pedropathing.tuning.autotune.Tuner;


import org.firstinspires.ftc.teamcode.pedro.procedure.ForesightTuner;
import org.firstinspires.ftc.teamcode.pedro.procedure.MecanumTuner;
import org.firstinspires.ftc.teamcode.pedro.procedure.PinpointTuner;
import org.firstinspires.ftc.teamcode.pedro.procedure.Tests;


public class Tuning {

    @Tuner
    public static Procedure mecanumTuner() {
        return new MecanumTuner();
    } //While connected to the Robot Controller, open the following address in your browser: http://192.168.43.1:10158 select Mecanum Procedure.

    @Tuner
    public static Procedure pinpointTuner() {
        return new PinpointTuner();
    } //While connected to the Robot Controller, open the following address in your browser: http://192.168.43.1:10158 Select Pinpoint Procedure.

    @Tuner
    public static Procedure foresightTuner() {
        return new ForesightTuner((hardwareMap) -> new PinpointLocalizer(hardwareMap, Constants.localizerConfig), (hardwareMap) -> new Mecanum(hardwareMap, Constants.drivetrainConfig));
    } //While connected to the Robot Controller, open the following address in your browser: http://192.168.43.1:10158 select foresight procedure

    @Tuner
    public static Procedure tests() {
        return new Tests(hardwareMap -> new Mecanum(hardwareMap, Constants.drivetrainConfig), (hardwareMap -> new PinpointLocalizer(hardwareMap, Constants.localizerConfig)), () -> new Foresight(Constants.foresightConfig));
    } // While connected to the Robot Controller, open the following address in your browser: http://192.168.43.1:10158 Select Tests Procedure.




}
