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

import java.util.ServiceLoader;
import com.dukescript.api.canvas.GraphicsContext2D;
import com.dukescript.canvas.html.HTML5GraphicsEnvironment;
import com.dukescript.spi.canvas.GraphicsEnvironment;
import com.dukescript.spi.canvas.GraphicsUtils;
import net.java.html.js.JavaScriptBody;

/**
 *
 * @author antonepple
 */
public abstract class Layer {

    private String name;
    private double opacity;
    private boolean visible = true;
    private float parallaxFactor = 1;
    protected final GraphicsContext2D graphicsContext;

    // required for serialization
    public Layer() {
        this("");
    }

    public Layer(String name) {
        this.name = name;
        createCanvas(name);
   
        graphicsContext = GraphicsUtils.getOrCreate(new HTML5GraphicsEnvironment(), name);
    }

    public abstract void draw(double x, double y, double width, double height);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOpacity() {
        return opacity;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public float getParallaxFactor() {
        return parallaxFactor;
    }

    public void setParallaxFactor(float parallaxFactor) {
        this.parallaxFactor = parallaxFactor;
    }

    @JavaScriptBody(args = {"name"}, body
            = "var canvas = document.createElement('canvas');"
            + "canvas.id = name;"
            + "canvas.className += 'layer';"
            + "canvas.width = window.innerWidth;\n"
            + "canvas.height = window.innerHeight;"
            + "var gameDiv = document.getElementById('game-canvas');"
            + "gameDiv.appendChild(canvas);")
    public static native void createCanvas(String name);

}
