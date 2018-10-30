/*
 * #%L
 * DukeScript Game Engine - a library from the "DukeScript GameEngine" project.
 * Visit http://dukescript.com for support and commercial license.
 * %%
 * Copyright (C) 2015 Eppleton IT Consulting
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */
package com.dukescript.api.gameengine;

import com.dukescript.api.canvas.Style.Color;




/**
 *
 * @author antonepple
 */
public class DebugLayer extends Layer{

    private final Color fill;
    private final Level canvas;
//    private final PerformanceTracker perfTracker;

    public DebugLayer(Color textFill, Level canvas) {
        super("debug");
        this.fill = textFill;
        this.canvas = canvas;
//        Scene scene = canvas.getScene();
//        perfTracker =  PerformanceTracker.getSceneTracker(scene);
    }

    @Override
    public void draw( double x, double y, double width, double height) {
        graphicsContext.clearRect(0, 0, width, height);
//        graphicsContext.setFont(Font.font("Monospaced", FontWeight.BOLD, 10));
        graphicsContext.setFillStyle(fill);
        graphicsContext.fillText("#pulses "+canvas.getPulses() , x, y+12);
        graphicsContext.fillText("skipped "+canvas.getCleanCounter() , x, y+24);
//        graphicsContext.fillText("AveragePulses "+perfTracker.getAveragePulses() , x, y+36);
//        graphicsContext.fillText("AverageFPS "+perfTracker.getAverageFPS() , x, y+48);
//        
//        graphicsContext.fillText("InstantFPS "+perfTracker.getInstantFPS() , x, y+60);
//        graphicsContext.fillText("InstantPulses "+perfTracker.getInstantPulses(), x, y+72);
        graphicsContext.fillText("StutterPulses "+canvas.getStutter() , x, y+84);
        graphicsContext.fillText("LastSlowness "+canvas.getLastSlowness(), x, y+96);
        graphicsContext.fillText("Maxdelta "+canvas.getMaxTimePassed(), x, y+108);
        graphicsContext.fillText("Camera (x,y) "+canvas.camera.xProperty.doubleValue()+","+canvas.camera.yProperty.doubleValue(), x, y+120);
        
    }
    
}
