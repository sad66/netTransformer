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

package net.itransformers.topologyviewer.dialogs.discovery;

import net.itransformers.resourcemanager.config.ResourcesType;
import net.itransformers.topologyviewer.gui.TopologyViewer;
import net.itransformers.utils.JaxbMarshalar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URISyntaxException;

public class DiscoveryResourceDialog extends JDialog {

	private final DiscoveryResourcePanel contentPanel;
    private TopologyViewer frame;

    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DiscoveryResourceDialog dialog = new DiscoveryResourceDialog(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DiscoveryResourceDialog(final TopologyViewer frame) {
        this.frame = frame;
        setModal(true);
		setTitle("Configure Discovery Resource");
		setBounds(100, 100, 580, 500);
		getContentPane().setLayout(new BorderLayout());
        contentPanel = new DiscoveryResourcePanel();
        ResourcesType resource = loadResource();
        if (resource == null) return;
        contentPanel.setResources(resource);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onOK();
                    }
                });
                buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        dispose();
                    }
                });
                buttonPane.add(cancelButton);
			}
		}

	}

    private void onOK() {
        ResourcesType resource = contentPanel.getResources();
        storeResource(resource);
        setVisible(false);
        dispose();
    }

    private void storeResource(ResourcesType resource) {
        FileOutputStream os = null;
        File file;
        try {
            file = new File(new File(frame.getPath().toURI()), "iDiscover/conf/xml/discoveryResource.xml");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }
        try {
            os = new FileOutputStream(file);
            JaxbMarshalar.marshal(resource, os,"resources");
            JOptionPane.showMessageDialog(this.frame, "Configuration Resource stored successful.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.frame,"Can not open file: "+file.getAbsolutePath());
        } catch (JAXBException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.frame,"Invalid file content: "+file.getAbsolutePath());
        } finally {
            if (os != null) try { os.close(); } catch (IOException e) {}
        }
    }

    private ResourcesType loadResource(){
        FileInputStream is = null;
        File file;
        try {
            file = new File(new File(frame.getPath().toURI()), "iDiscover/conf/xml/discoveryResource.xml");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
        try {
            is = new FileInputStream(file);

            ResourcesType resources = JaxbMarshalar.unmarshal(ResourcesType.class, is);
            return resources;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.frame,"Can not open file: "+file.getAbsolutePath());
        } catch (JAXBException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.frame,"Invalid file content: "+file.getAbsolutePath());
        } finally {
            if (is != null) try { is.close(); } catch (IOException e) {}
        }
        return null;
    }
}
