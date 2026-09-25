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
        return new ForesightTuner((hardwareMap) -> new PinpointLocalizer(hardwareMap, PedroConstants.localizerConfig), (hardwareMap) -> new Mecanum(hardwareMap, PedroConstants.drivetrainConfig));
    } //While connected to the Robot Controller, open the following address in your browser: http://192.168.43.1:10158 select foresight procedure

    @Tuner
    public static Procedure tests() {
        return new Tests(hardwareMap -> new Mecanum(hardwareMap, PedroConstants.drivetrainConfig), (hardwareMap -> new PinpointLocalizer(hardwareMap, PedroConstants.localizerConfig)), () -> new Foresight(PedroConstants.foresightConfig));
    } // While connected to the Robot Controller, open the following address in your browser: http://192.168.43.1:10158 Select Tests Procedure.

    //FSL28564 WiFi password for robot



}
