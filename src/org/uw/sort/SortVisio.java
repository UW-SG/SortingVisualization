/* 
 * Sort demo main class
 * 
 * Color legend:
 * - Blue: Normal
 * - Green: In final position
 * - Yellow: Comparing
 * - Gray: Inactive
 */

package org.uw.sort;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("serial")
public final class SortVisio extends Frame implements ActionListener {

	private List<Sort> algorithms;

	private TextField arraySizeInput;
	private TextField scaleInput;
	private TextField speedInput;
	private Choice algorithmInput;
	private Button runButton;

	public static void main(String[] args) {
		// Set up list of algorithms and go
		List<Sort> algos = new ArrayList<Sort>();
		Collections.addAll(algos,
				new BubbleSort(),
				new SelectionSort(),
				new InsertionSort(),
				new MergeSort(),
				new QuickSort());
		new SortVisio(algos);
	}

	public void actionPerformed(ActionEvent ev) 
	{
		int count = 0;
		List<Sort> algos = new ArrayList<Sort>();
		Collections.addAll(algos,
				new BubbleSort(),
				new SelectionSort(),
				new InsertionSort(),
				new MergeSort(),
				new QuickSort());
		while(count < 5) 
		{
			try {

				int size = 30;
				int scale = 10;
				double speed = Double.parseDouble("25.5");

				DrawArray array = new DrawArray(size, scale, speed);
				Sort algorithm = algos.get(count);
				array.print();
				new DisplaySort(array, algorithm).start();
				count++;
			} catch (NumberFormatException e) {}
		}
	}

	public SortVisio(List<Sort> algos) {
		super("Sort Demo");

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// Add widgets
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbl);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbc.insets = new Insets(4, 4, 4, 4);
		gbc.weighty = 0;

		// Labels
		Label label;
		gbc.gridx = 0;
		label = new Label("Algorithm:");
		gbc.weightx = 1;
		gbc.gridy = 0;
		gbl.setConstraints(label, gbc);
		add(label);

		label = new Label("Array size:");
		gbc.gridy = 1;
		gbl.setConstraints(label, gbc);
		add(label);

		label = new Label("Scale:");
		gbc.gridy = 2;
		gbl.setConstraints(label, gbc);
		add(label);

		label = new Label("Speed:");
		gbc.gridy = 3;
		gbl.setConstraints(label, gbc);
		add(label);

		// Algorithm
		gbc.gridx = 1;
		gbc.weightx = 2;
		algorithms = new ArrayList<Sort>(algos);
		algorithmInput = new Choice();
		for (Sort algo : algos)
			algorithmInput.add(algo.getName());
		gbc.gridy = 0;
		gbl.setConstraints(algorithmInput, gbc);
		add(algorithmInput);

		// Array size
		arraySizeInput = new TextField("9");
		arraySizeInput.addActionListener(this);
		gbc.gridy = 1;
		gbl.setConstraints(arraySizeInput, gbc);
		add(arraySizeInput);

		// Scale
		scaleInput = new TextField("15");
		scaleInput.addActionListener(this);
		gbc.gridy = 2;
		gbl.setConstraints(scaleInput, gbc);
		add(scaleInput);

		// Speed
		speedInput = new TextField("10");
		speedInput.addActionListener(this);
		gbc.gridy = 3;
		gbl.setConstraints(speedInput, gbc);
		add(speedInput);

		// Run button
		runButton = new Button("Run");
		runButton.addActionListener(this);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.weighty = 1;
		gbl.setConstraints(runButton, gbc);
		add(runButton);

		// Do layout and show
		pack();
		Rectangle rect = getGraphicsConfiguration().getBounds();
		setLocation((rect.width - getWidth()) / 2, (rect.height - getHeight()) / 3);
		setVisible(true);
	}
}
