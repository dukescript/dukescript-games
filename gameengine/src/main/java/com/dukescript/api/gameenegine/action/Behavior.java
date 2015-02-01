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

/**
 *
 * @author antonepple
 */
public class Behavior {
    protected long evaluationInterval = 1000;

    /**
     *
     * @return the evaluation interval in nanos
     */
    public long getEvaluationInterval() {
        return evaluationInterval;
    }



    /**
     * Set the EvaluationInterval in Nanos. At each game pulse the Sprite
     * will check it's Behaviours and invoke the ones where the
     * EvaluationInterval is exceeded. The resolution is limited by the
     * Framerate.
     *
     */
    public void setEvaluationInterval(long evaluationInterval) {
        this.evaluationInterval = evaluationInterval;
    }

    public boolean perform(Level canvas, long nanos) {
        return true;
    }
    
}
