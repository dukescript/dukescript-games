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

import java.util.ArrayList;
import java.util.List;

/**
 * A base implementation of Game. Subclass this and add
 *
 * @ServiceProvider(service = Game.class) Annotation to register as game
 * @author antonepple
 */
public class AbstractGame implements Game {

    private List<Level> levels = new ArrayList<Level>();
    private int index = 0;

    @Override
    public Level getCurrentLevel() {
        return getLevel(index);
    }

    @Override
    public void addLevel(Level level) {
        levels.add(level);
    }

    @Override
    public void nextLevel() {
        if (index <= levels.size()-1) {
            index++;
        }
    }

    @Override
    public Level getLevel(int index) {
        return levels.get(index);
    }

}
