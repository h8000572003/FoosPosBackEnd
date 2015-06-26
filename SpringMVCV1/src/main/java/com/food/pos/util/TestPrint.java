package com.food.pos.util;

import java.awt.print.*;
import java.awt.*;

import javax.print.PrintService;

public class TestPrint {

//	final static double PAPER_WIDTH = 325.944;
//	final static double PAPER_HEIGHT = 504;
	final static String PRINTERNAME = "Canon iR5055/5065"; // 印表機名稱

	private int PrinterIndex;
	private PrintService[] printservice = java.awt.print.PrinterJob
			.lookupPrintServices();

	public static void main(String[] args) {
		TestPrint tp = new TestPrint();
		tp.print();

	}

	public void print() {
		for (int i = 0; i < printservice.length; i++) {
			if (printservice[i].getName().equals(PRINTERNAME))
				PrinterIndex = i;
		}

		PrinterJob pjob = PrinterJob.getPrinterJob();

		
		PageFormat pf = new PageFormat();
	    pf.setOrientation(PageFormat.PORTRAIT); // 設定橫印
		Book pBook = new Book();
		PrintPage p1 = new PrintPage();
		pBook.append(p1, pf);
		pjob.setPageable(pBook);
		
	
		try {
			pjob.setPrintService(printservice[PrinterIndex]);
		} catch (PrinterException ex) {
			ex.printStackTrace();
			return;
		}
		pjob.setPrintable(p1, pf);
		pjob.setCopies(1);
		try {
			 boolean doPrint = pjob.printDialog();
			    if (doPrint) {
			        try {
			        	pjob.print();
			        }catch (PrinterException e) {
			            System.out.println(e.getMessage());
			        }
			    }
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(0);
		}
	}

	class PrintPage implements Printable {
		public int print(Graphics g, PageFormat pf, int pageIndex) {
			if (pageIndex > 0)
				return Printable.NO_SUCH_PAGE;
			Graphics2D g2d = (Graphics2D) g;
			g2d.translate(pf.getImageableX(), pf.getImageableY());

			g2d.drawString("1VVVVVVVVVVVVVVVVV", 10, 10);
			g2d.drawString("2DDDDDDDDDDDDDDDDD", 10, 120);
			g2d.drawString("3EEEEEEEEEEEEEEEEE",130, 20);
			g2d.drawString("4GGGGGGGGGGGGGGGGG",130, 130);

			return Printable.PAGE_EXISTS;
		}
	}

}
