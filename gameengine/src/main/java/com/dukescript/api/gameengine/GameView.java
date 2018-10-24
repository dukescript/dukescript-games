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

import com.dukescript.api.gameenegine.event.EventRegistration;
import com.dukescript.api.gameenegine.event.KeyCode;
import com.dukescript.api.gameenegine.event.KeyEvent;
import com.dukescript.api.gameenegine.event.MouseEvent;
import com.dukescript.api.gameenegine.event.TouchEvent;
import com.dukescript.api.gameenegine.event.TouchEvent.Touch;
import java.util.ArrayList;
import java.util.List;
import net.java.html.js.JavaScriptBody;
import net.java.html.json.Model;
import net.java.html.json.Models;

/**
 * A base implementation of Game.
 *
 * @author antonepple
 */
@Model(className = "GameViewModel", properties = {})
public class GameView implements Game {

    static {
        EventRegistration.registerTouch();
        EventRegistration.registerMouseBinding();
        EventRegistration.registerKeyEvents();
    }

    private static Level running;
    private final GameArea gameArea;
    private List<Level> levels = new ArrayList<Level>();
    private int index = 0;
    private double gameWidth;
    private double gameHeight;
    private static double scaleX;
    private static double scaleY;

    public GameView(double width, double height) {
        this.gameHeight = height;
        this.gameWidth = width;
        this.gameArea = new GameArea("game-canvas");
        GameViewModel data = new GameViewModel();
        Models.applyBindings(data, "game-canvas");
        resize();
        addResizeListener(this);
    }

    @JavaScriptBody(args = {"level"}, body = "window.onresize = function(){ gameView.@com.dukescript.api.gameengine.GameView::resize()();}", javacall = true)
    private static native void addResizeListener(GameView gameView);

    public void resize() {
        double widthToHeight = gameWidth / gameHeight;
        double newWidth = windowInnerWidth();
        double newHeight = windowInnerHeight();
        double newWidthToHeight = newWidth / newHeight;
        if (newWidthToHeight > widthToHeight) {
            newWidth = newHeight * widthToHeight;
        } else {
            newHeight = newWidth / widthToHeight;
        }
        gameArea.setWidth(newWidth);
        gameArea.setHeight(newHeight);
        gameArea.setTopMargin((windowInnerHeight() - newHeight) / 2);
        gameArea.setLeftMargin((windowInnerWidth() - newWidth) / 2);
        gameArea.setBottomMargin((windowInnerHeight() - newHeight) / 2);
        gameArea.setRightMargin((windowInnerWidth() - newWidth) / 2);
        scaleX = gameWidth / newWidth;
        scaleY = gameHeight / newHeight;
    }

    @JavaScriptBody(args = {}, body = "return window.innerWidth;")
    public static native double windowInnerWidth();

    @JavaScriptBody(args = {}, body = "return window.innerHeight;")
    public static native double windowInnerHeight();

    @Override
    public Level getCurrentLevel() {
        return getLevel(index);
    }

    @Override
    public void addLevel(Level level) {
        levels.add(level);
        running = level;
    }

    @Override
    public void nextLevel() {
        if (index <= levels.size() - 1) {
            index++;
        }
    }

    @Override
    public Level getLevel(int index) {
        return levels.get(index);
    }

    public static void keyPress(int keyCode) {
        if (running != null) {
            running.dispatchEvent(new KeyEvent(running, KeyEvent.KEY_PRESSED, KeyCode.getKeyCode(keyCode)));
        }
    }

    public static void keyUp(int keyCode) {
        if (running != null) {
            running.dispatchEvent(new KeyEvent(running, KeyEvent.KEY_RELEASED, KeyCode.getKeyCode(keyCode)));
        }
    }

    public static void keyDown(int keyCode) {
        if (running != null) {
            running.dispatchEvent(new KeyEvent(running, KeyEvent.KEY_TYPED, KeyCode.getKeyCode(keyCode)));
        }
    }

    public static void touchStarted(Object[] touches) {
        if (running != null) {
            ArrayList<Touch> touchList = new ArrayList<Touch>();
            for (int i = 0; i < touches.length; i++) {
                Object touchX = touches[i];
                Object touchY = touches[++i];
                TouchEvent.Touch touch = new TouchEvent.Touch((Double) touchX * scaleX, (Double) touchY * scaleY);
                touchList.add(touch);
            }
            running.dispatchEvent(new TouchEvent(running,
                    TouchEvent.TOUCH_STARTED,
                    touchList
            ));
        }
    }

    public static void touchCancel(Object[] touches) {
        if (running != null) {
            ArrayList<Touch> touchList = new ArrayList<Touch>();
            for (int i = 0; i < touches.length; i++) {
                Object touchX = touches[i];
                Object touchY = touches[++i];
                TouchEvent.Touch touch = new TouchEvent.Touch((Double) touchX * scaleX, (Double) touchY * scaleY);
                touchList.add(touch);
            }
            running.dispatchEvent(new TouchEvent(running,
                    TouchEvent.TOUCH_END,
                    touchList
            ));
        }
    }

    public static void touchMove(Object[] touches) {
        if (running != null) {
            ArrayList<Touch> touchList = new ArrayList<Touch>();
            for (int i = 0; i < touches.length; i++) {
                Object touchX = touches[i];
                Object touchY = touches[++i];
                TouchEvent.Touch touch = new TouchEvent.Touch((Double) touchX * scaleX, (Double) touchY * scaleY);
                touchList.add(touch);
            }
            running.dispatchEvent(new TouchEvent(running,
                    TouchEvent.TOUCH_MOVED,
                    touchList
            ));
        }
    }

    public static void touchEnd(Object[] touches) {
        if (running != null) {
            ArrayList<Touch> touchList = new ArrayList<Touch>();
            for (int i = 0; i < touches.length; i++) {
                Object touchX = touches[i];
                Object touchY = touches[++i];
                TouchEvent.Touch touch = new TouchEvent.Touch((Double) touchX * scaleX, (Double) touchY * scaleY);
                touchList.add(touch);
            }
            running.dispatchEvent(new TouchEvent(running,
                    TouchEvent.TOUCH_END,
                    touchList
            ));
        }
    }
//  mousedown, mouseenter, mouseleave, mousemove, mouseout, mouseover, mouseup,

    public static void mouseClick(int realX, int realY) {
        if (running != null) {
            running.dispatchEvent(new MouseEvent(running, MouseEvent.MOUSE_CLICKED, realX * scaleX, realY * scaleY));
        }
    }

    public static void mouseDown(int realX, int realY) {
        if (running != null) {
            running.dispatchEvent(new MouseEvent(running, MouseEvent.MOUSE_PRESSED, realX, realY));
        }
    }

    public static void mouseUp(int realX, int realY) {
        if (running != null) {
            running.dispatchEvent(new MouseEvent(running, MouseEvent.MOUSE_RELEASED, realX, realY));
        }
    }

    

}
