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

import com.dukescript.api.canvas.GraphicsContext2D;

/**
 * A class used to render a Sprite.
 *
 * @author antonepple
 */
public interface Renderer {

    
     public boolean prepare(Sprite sprite, long time);
    /**
     * Implement this to render a Sprite. For animations it's suggested to use 
     * the alpha and time value to calculate the progress.
     * @param sprite the Sprite to be rendererd
     * @param context the GraphiscContext used to render
     * @param alpha a value between 0 and 1 allowing to draw interpolated values
     * if framerate is faster than update rate. not supported yet, currently always 1
     * @param time the nano time delivered by the pulse 
     */
    public void render(Sprite sprite, GraphicsContext2D context, float alpha, long time);
}
