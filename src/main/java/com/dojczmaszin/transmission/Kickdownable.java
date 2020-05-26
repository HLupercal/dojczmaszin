package com.dojczmaszin.transmission;

import com.dojczmaszin.gears.Gear;

public interface Kickdownable {
    public Gear handleKickdown(double pedalDepth);
}
