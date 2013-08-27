/*
 * iTransformer is an open source tool able to discover and transform
 *  IP network infrastructures.
 *  Copyright (C) 2012  http://itransformers.net
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.itransformers.topologyviewer.menu.handlers;

import net.itransformers.topologyviewer.gui.TopologyManagerFrame;
import net.itransformers.utils.JEditorPaneSave;

import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class ConfigureParametersMenuHandler implements ActionListener {

    private TopologyManagerFrame frame;

    public ConfigureParametersMenuHandler(TopologyManagerFrame frame) throws HeadlessException {

        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JEditorPaneSave discoveryParametersEditor = new JEditorPaneSave(frame.getPath()+ File.separator+"iDiscover/conf/xml/discoveryParameters.xml");
        try {
            discoveryParametersEditor.init();
        } catch (IOException e1) {
            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (BadLocationException e1) {
            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }


}
