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

/**
 *
 * @author antonepple
 */
public class Rectangle2D {
    private final double x;
    private final double y;
    private final double width;
    private final double height;

    public Rectangle2D(double x, double y, double width, double height) {
       this.x = x;
       this.y = y;
       this.width = width;
       this.height = height;
    }

    public double getMinX() {
        return x;
    }

    public double getMinY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    boolean isCollision(double x0, double y0, double w0, double h0, double x2, double y2, double w1, double h1) {
        double x1 = x0 + w0;
        double y1 = y0 + h0;

        double x3 = x2 + w1;
        double y3 = y2 + h1;

        return !(x1 < x2 || x3 < x0 || y1 < y2 || y3 < y0);
    }

    public boolean intersects(Rectangle2D collisionBox) {
        return isCollision(x, y, width, height, collisionBox.getMinX(), collisionBox.getMinY(), collisionBox.getWidth(), collisionBox.getHeight());
    }
    
    
    
}
