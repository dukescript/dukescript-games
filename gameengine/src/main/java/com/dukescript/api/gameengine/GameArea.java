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

import net.java.html.js.JavaScriptBody;

/**
 *
 * @author antonepple
 */
public class GameArea {

    private Object cached;

    public GameArea(String name) {
        cached = getElement(name);
        assert (cached != null);
    }

    @JavaScriptBody(args = {"name"}, body = "return document.getElementById(name);")
    private static native Object getElement(String name);

    public void setWidth(double width) {
        _setWidthImpl(cached, width);
    }

    @JavaScriptBody(args = {"div", "w"}, body = "div.style.width = w+'px'")
    private static native void _setWidthImpl(Object div, double w);

    public void setHeight(double height) {
        _setHeightImpl(cached, height);
    }

    @JavaScriptBody(args = {"div", "h"}, body = "div.style.height = h+'px'")
    private static native void _setHeightImpl(Object div, double h);
    
    public void setTopMargin(double m){
        _setTopMarginImpl(cached, m);
    }

    @JavaScriptBody(args = {"div", "m"}, body = "div.style.marginTop = m+'px'")
    private static native void _setTopMarginImpl(Object div, double m);
    
    public void setBottomMargin(double m){
        _setBottomMarginImpl(cached, m);
    }

    @JavaScriptBody(args = {"div", "m"}, body = "div.style.marginBottom = m+'px'")
    private static native void _setBottomMarginImpl(Object div, double m);
    
    public void setLeftMargin(double m){
        _setLeftMarginImpl(cached, m);
    }

    @JavaScriptBody(args = {"div", "m"}, body = "div.style.marginLeft = m+'px'")
    private static native void _setLeftMarginImpl(Object div, double m);
    
    public void setRightMargin(double m){
        _setRightMarginImpl(cached, m);
    }

    @JavaScriptBody(args = {"div", "m"}, body = "div.style.marginRight = m+'px'")
    private static native void _setRightMarginImpl(Object div, double m);
    
}
