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
package com.dukescript.api.gameenegine.action;

import com.dukescript.api.gameengine.Level;
import com.dukescript.api.gameengine.Level.MoveValidator;
import com.dukescript.api.gameengine.Sprite;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author antonepple
 */
public class DefaultMoveBehavior extends Behavior {
    private long lastUpdate;
    private long delay = -1;
    private double factor;

    public DefaultMoveBehavior() {
        this.moveValidators = new ArrayList<MoveValidator>();
        setEvaluationInterval(1);
    }

    @Override
    public boolean perform(Level canvas, long l) {
//        boolean dirty;
        if (delay == -1) {
            delay = 17l;
        } else {
            delay = l - lastUpdate;
        }
        Collection<Sprite> sprites1 = canvas.getSprites();
        for (Sprite sprite : sprites1) {
            if (updateSpritePosition(sprite)) {
//                dirty = true;
            }
        }
        lastUpdate = l;
        return true;
    }

    private boolean updateSpritePosition(Sprite sprite) {
        boolean dirty = true;
        factor = (double) delay / 17;
        double velocityX = sprite.getVelocityX() * factor;
        double velocityY = sprite.getVelocityY() * factor;
        if (velocityX == 0 && velocityY == 0) {
            return false;
        }
        com.dukescript.api.gameengine.Rectangle2D moveBox = sprite.getMoveBox();
        double x = sprite.getX();
        double y = sprite.getY();
        double newX = velocityX + x;
        double newY = velocityY + y;
        if (isValidMove(newX + moveBox.getMinX(), newY + moveBox.getMinY(), moveBox.getWidth(), moveBox.getHeight())) {
            sprite.setX(newX);
            sprite.setY(newY);
//            System.out.println("x: "+x+"->"+newX);
        } else {
            sprite.invalidMove();
            dirty = false;
        }
        return dirty;
    }

    /**
     * Check if this is a valid move by calling all registered
     * {@link MoveValidator MoveValidators}
     *
     * @param xProperty
     * @param yProperty
     * @param width
     * @param height
     * @return true, if this is a valid move, false otherwise
     */
    private boolean isValidMove(double x, double y, double width, double height) {
        for (Level.MoveValidator moveValidator : moveValidators) {
            if (!moveValidator.isValidMove(x, y, width, height)) {
                return false;
            }
        }
        return true;
    }
    private ArrayList<Level.MoveValidator> moveValidators;

    public void addMoveValidator(Level.MoveValidator moveValidator) {
        moveValidators.add(moveValidator);
    }

    public void removeMoveValidator(Level.MoveValidator moveValidator) {
        moveValidators.remove(moveValidator);
    }
    
}
