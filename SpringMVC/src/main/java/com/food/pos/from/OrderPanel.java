package com.food.pos.from;

import java.awt.Panel;

import javax.swing.JButton;

import org.springframework.stereotype.Controller;

@Controller
public class OrderPanel extends Panel {

	public OrderPanel() {
		
		JButton btnNewButton_2 = new JButton("New button");
		add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("New button");
		add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("New button");
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		add(btnNewButton_4);

		JButton btnNewButton = new JButton("New button");

	}

}
