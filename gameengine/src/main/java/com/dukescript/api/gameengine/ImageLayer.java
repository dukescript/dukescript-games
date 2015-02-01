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
import com.dukescript.api.canvas.Image;

/**
 *
 * @author antonepple
 */
public class ImageLayer extends Layer {

    private Image image;

    public ImageLayer(String name, Image image) {
        super(name);
        this.image = image;
    }

    @Override
    public void draw( double x, double y, double width, double height) {
        graphicsContext.drawImage(image, 0, 0);
    }
}
