/*
 * EditConfigFileMenuHandler.java
 *
 * This work is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2 of the License,
 * or (at your option) any later version.
 *
 * This work is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 *
 * Copyright (c) 2010-2016 iTransformers Labs. All rights reserved.
 */

package net.itransformers.topologyviewer.menu.handlers.snmpDiscovery;

import net.itransformers.topologyviewer.gui.TopologyManagerFrame;
import net.itransformers.utils.JEditorPane;

import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Date: 12-4-27
 * Time: 23:30
 * To change this template use File | Settings | File Templates.
 */
public class EditConfigFileMenuHandler implements ActionListener {

    private TopologyManagerFrame frame;
    String pathToResource;
    public EditConfigFileMenuHandler(TopologyManagerFrame frame, String path) throws HeadlessException {

        this.frame = frame;
        this.pathToResource = path;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String filePath = frame.getPath()+ File.separator+ pathToResource;
        String dir = new File(frame.getPath()+ File.separator+ pathToResource).getParent();
        JEditorPane resourceEditor = new JEditorPane(filePath,dir,"xml");
        try {
            resourceEditor.init();
        } catch (IOException e1) {
            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (BadLocationException e1) {
            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }


}
