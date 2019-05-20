/*--------------------------------------------------------------------------------------*/
/*  MPP.java  -  Description                                                            */
/*  The purpose of the program is to teach grade 6 students how to calculate the area   */
/*  of irregular shapes and reinforce their knowledge. The program is divided into two  */
/*  parts: the lesson and the quiz. The purpose of the lesson is to demonstrate two     */
/*  methods that can be used to calculate the area of an irregular shape. It should let */
/*  the students be involved in the lesson as well as stimulate their interests in      */
/*  learning and exploring math. The quiz is designed to test students' understanding.  */
/*  At the same time, it gives students chances to practice and apply their knowledge.  */
/*  The program is aimed to let the students have a better understanding of the topic   */
/*  after they go through the program.                                                  */
/*--------------------------------------------------------------------------------------*/
/*  Author: Elena Yiran Cao                                                             */
/*  Date: 23/01/2018                                                                    */
/*--------------------------------------------------------------------------------------*/
/*  Input:                                                                              */
/*  1. Clicking the "menu" buttons (Home, Warm-up, Lesson, Quiz)                        */
/*  2. Clicking the "next" button                                                       */
/*  3. Clicking the "back" button                                                       */
/*  4. Entering the answer of multiple choice problem by selecting one radio button and */
/*  clicking the "check" button                                                         */
/*  5. Entering the answer of fill-in-the-blank problem into the textbox and clicking   */
/*  the "check" button                                                                  */
/*                                                                                      */
/*  Output:                                                                             */
/*  images                                                                              */
/*  context                                                                             */
/*  feedback message                                                                    */
/*  pop-up window                                                                       */
/*--------------------------------------------------------------------------------------*/

//feedback message using popup window instead of drawstring

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class MPP extends Applet implements ActionListener
{
    Font titleFont, textFont, solutionFont;
    int pageNum = 0;
    Image correctImage;

    //control buttons
    Button check = new Button ("Check");
    Button next = new Button ("Next");
    Button back = new Button ("Back");

    //HOMEPAGE:
    Image homeImage1, homeImage2;
    //menu
    Button homepage = new Button ("Home");
    Button warmup = new Button ("Warm-up");
    Button lesson = new Button ("Lesson");
    Button quiz = new Button ("Quiz");

    //MARMUP:
    int wpNum = 1;
    int answerNum = 0;
    boolean checkBoo, correctBoo;
    Image wpImage1, wpImage2, wpImage3, wpImage4;

    //checkbox (multiple choice problem)
    CheckboxGroup warmupCB = new CheckboxGroup ();
    Checkbox a = new Checkbox ("a) A = 1/2b × h ", warmupCB, false);
    Checkbox b = new Checkbox ("b) A = s² ", warmupCB, false);
    Checkbox c = new Checkbox ("c) A = w × h ", warmupCB, false);
    Checkbox d = new Checkbox ("d) A = pi × r²", warmupCB, false);

    //LESSON:
    int lesNum = 0;
    Image lesImage1, lesImage2;

    //QUIZ:
    int quizNum = 1;
    Image quizImage1, quizImage2, quizImage3, quizImage4, quizImage5;
    //textfield (fill in the blank)
    TextField txt = new TextField ("0", 20);

    public void init ()
    {
	//set size, background, font
	setSize (800, 400);
	setBackground (Color.white);
	titleFont = new Font ("Serif", Font.BOLD, 24);
	textFont = new Font ("Serif", Font.PLAIN, 18);
	solutionFont = new Font ("Serif", Font.PLAIN, 12);

	//set the layout to null
	setLayout (null);
	//set the position of the buttons and textboxes
	homepage.setBounds (50, 100, 80, 20);
	warmup.setBounds (50, 140, 80, 20);
	lesson.setBounds (50, 180, 80, 20);
	quiz.setBounds (50, 220, 80, 20);
	a.setBounds (190, 125, 120, 20);
	b.setBounds (190, 155, 120, 20);
	c.setBounds (190, 185, 120, 20);
	d.setBounds (190, 215, 120, 20);
	check.setBounds (350, 300, 60, 20);
	next.setBounds (600, 360, 60, 20);
	back.setBounds (520, 360, 60, 20);
	txt.setBounds (220, 300, 60, 20);

	//initialize the counters
	answerNum = 0;
	checkBoo = false;

	//add buttons
	add (homepage);
	add (warmup);
	add (lesson);
	add (quiz);
	add (a);
	add (b);
	add (c);
	add (d);
	add (check);
	add (next);
	add (back);
	add (txt);

	//add action listener to the buttons
	homepage.addActionListener (this);
	warmup.addActionListener (this);
	lesson.addActionListener (this);
	quiz.addActionListener (this);
	check.addActionListener (this);
	next.addActionListener (this);
	back.addActionListener (this);

	//get image from the folder
	correctImage = getImage (getDocumentBase (), "correctImage.jpg");
	homeImage1 = getImage (getDocumentBase (), "homeImage1.jpg");
	homeImage2 = getImage (getDocumentBase (), "homeImage2.jpg");
	wpImage1 = getImage (getDocumentBase (), "wpImage1.jpg");
	wpImage2 = getImage (getDocumentBase (), "wpImage2.jpg");
	wpImage3 = getImage (getDocumentBase (), "wpImage3.jpg");
	wpImage4 = getImage (getDocumentBase (), "wpImage4.jpg");
	lesImage1 = getImage (getDocumentBase (), "lesImage1.jpg");
	lesImage2 = getImage (getDocumentBase (), "lesImage2.jpg");
	quizImage1 = getImage (getDocumentBase (), "quizImage1.jpg");
	quizImage2 = getImage (getDocumentBase (), "quizImage2.jpg");
	quizImage3 = getImage (getDocumentBase (), "quizImage3.jpg");
	quizImage4 = getImage (getDocumentBase (), "quizImage4.jpg");
	quizImage5 = getImage (getDocumentBase (), "quizImage5.jpg");

	//set the buttons that are not on the homepage invisible
	a.setVisible (false);
	b.setVisible (false);
	c.setVisible (false);
	d.setVisible (false);
	check.setVisible (false);
	next.setVisible (false);
	back.setVisible (false);
	txt.setVisible (false);
    }


    //methods for each page; set the buttons visible or invisible
    public void homepage ()
    {
	a.setVisible (false);
	b.setVisible (false);
	c.setVisible (false);
	d.setVisible (false);
	check.setVisible (false);
	next.setVisible (false);
	back.setVisible (false);
	txt.setVisible (false);
    }


    public void warmup ()
    {
	wpNum = 1;
	correctBoo = false;
	a.setVisible (true);
	b.setVisible (true);
	c.setVisible (true);
	d.setVisible (true);
	check.setVisible (true);
	next.setVisible (true);
	back.setVisible (true);
	txt.setVisible (false);
    }


    public void lesson ()
    {
	lesNum = 0;
	a.setVisible (false);
	b.setVisible (false);
	c.setVisible (false);
	d.setVisible (false);
	check.setVisible (false);
	next.setVisible (true);
	back.setVisible (true);
	txt.setVisible (false);
    }


    public void quiz ()
    {
	quizNum = 1;
	correctBoo = false;
	a.setVisible (false);
	b.setVisible (false);
	c.setVisible (false);
	d.setVisible (false);
	check.setVisible (true);
	next.setVisible (true);
	back.setVisible (true);
	txt.setVisible (true);
    }


    public void paint (Graphics g)
    {
	//set up the columns
	g.setColor (Color.darkGray);
	g.fillRect (30, 80, 740, 2);
	g.fillRect (150, 30, 2, 320);

	switch (pageNum) //display different pages by using the counter
	{
		//HOME PAGE
	    case 0:
		g.setFont (titleFont);
		g.drawString ("The Area of Irregular Shapes", 300, 60);
		g.drawImage (homeImage1, 190, 120, this);
		g.drawImage (homeImage2, 600, 100, this);
		break;

		//WARMUP
	    case 1:
		g.setFont (titleFont);
		g.drawString ("Warm-up", 400, 60);

		switch (wpNum) //display different questions
		{
			//multiple choice problems
			//question 1
		    case 1:
			g.setFont (textFont);
			g.drawString ("1. How to calculate the area of a square? ", 180, 110);
			g.drawImage (wpImage1, 400, 140, this);

			if (checkBoo == false)
			{
			}
			else if (checkBoo = true) //when the check button is clicked
			{
			    g.setFont (textFont);
			    g.setColor (Color.red);
			    switch (answerNum)
			    {
				    //wrong answer
				case 1:
				    g.drawString ("Wrong! Try again!", 430, 315); //display the feedback message
				    correctBoo = false; //set the correct boolean equals to false so that the user cannot go to the next question
				    break;

				    //correct answer
				case 2:
				    g.setColor (Color.green);
				    g.drawString ("Correct! Go to the next question! :) ", 430, 315); //display the feedback message
				    g.drawImage (correctImage, 600, 120, this);
				    correctBoo = true; //set the correct boolean equals to true so that the user can go to the next question
				    break;

				case 3:
				    g.drawString ("Wrong! Try again!", 430, 315);
				    correctBoo = false;
				    break;
				case 4:
				    g.drawString ("Wrong! Try again!", 430, 315);
				    correctBoo = false;
				    break;
			    }
			    checkBoo = false; // reset the boolean
			}
			break;

		    case 2:
			g.setFont (textFont);
			g.drawString ("2. How to calculate the area of a triangle? ", 180, 110);
			g.drawImage (wpImage2, 400, 140, this);

			if (checkBoo == false)
			{
			}
			else if (checkBoo = true)
			{
			    g.setFont (textFont);
			    g.setColor (Color.red);
			    switch (answerNum)
			    {
				case 1:
				    g.setColor (Color.green);
				    g.drawString ("Correct! Go to the next question! :) ", 430, 315);
				    g.drawImage (correctImage, 600, 120, this);
				    correctBoo = true;
				    break;
				case 2:
				    g.drawString ("Wrong! Try again!", 430, 315);
				    correctBoo = false;
				    break;
				case 3:
				    g.drawString ("Wrong! Try again!", 430, 315);
				    correctBoo = false;
				    break;
				case 4:
				    g.drawString ("Wrong! Try again!", 430, 315);
				    correctBoo = false;
				    break;
			    }
			    checkBoo = false;
			}
			break;

		    case 3:
			g.setFont (textFont);
			g.drawString ("3. How to calculate the area of a circle? ", 180, 110);
			g.drawImage (wpImage3, 400, 140, this);
			if (checkBoo == false)
			{
			}
			else if (checkBoo = true)
			{
			    g.setFont (textFont);
			    g.setColor (Color.red);
			    switch (answerNum)
			    {
				case 1:
				    g.drawString ("Wrong! Try again!", 430, 315);
				    correctBoo = false;
				    break;
				case 2:
				    g.drawString ("Wrong! Try again!", 430, 315);
				    correctBoo = false;
				    break;
				case 3:
				    g.drawString ("Wrong! Try again!", 430, 315);
				    correctBoo = false;
				    break;
				case 4:
				    g.setColor (Color.green);
				    g.drawString ("Correct! Go to the next question! :) ", 430, 315);
				    g.drawImage (correctImage, 600, 120, this);
				    correctBoo = true;
				    break;
			    }
			    checkBoo = false;
			}
			break;

		    case 4:
			g.setFont (textFont);
			g.drawString ("4. How to calculate the area of a rectangle? ", 180, 110);
			g.drawImage (wpImage4, 400, 140, this);
			if (checkBoo == false)
			{
			}
			else if (checkBoo = true)
			{
			    g.setFont (textFont);
			    g.setColor (Color.red);
			    switch (answerNum)
			    {
				case 1:
				    g.drawString ("Wrong! Try again!", 430, 315);
				    break;
				case 2:
				    g.drawString ("Wrong! Try again!", 430, 315);
				    break;
				case 3:
				    g.setColor (Color.green);
				    g.drawString ("Correct! Go to the lesson! :) ", 430, 315);
				    g.drawImage (correctImage, 600, 120, this);
				    break;
				case 4:
				    g.drawString ("Wrong! Try again!", 430, 315);
				    break;
			    }
			    checkBoo = false;
			}
			break;
		}
		break;

		//LESSON
	    case 2:
		g.setFont (titleFont);
		g.drawString ("Lesson", 420, 60);

		switch (lesNum) //display different steps by using the counter
		{
		    case 0: //introduction page, explain the first method
			g.setFont (textFont);
			g.setColor (Color.black);
			g.drawString ("Method 1:", 170, 110);
			g.drawString ("        To find the area of irregular shapes, the first thing to do is to divide the ", 170, 140);
			g.drawString ("irregular shape into regular shapes that you can recognize such as triangles, ", 170, 170);
			g.drawString ("rectangles, circles, squares and so forth. . .", 170, 200);
			g.drawString ("        Then, find the area of these individual shapes and add them up!", 170, 235);
			break;

		    case 1: //display the example problem
			g.setFont (textFont);
			g.setColor (Color.black);
			g.drawString ("Example: Find the area of the following shape.", 170, 110);
			g.drawString ("Method 1: Divide the shape into smaller shapes that you know well.", 180, 340);
			g.drawImage (lesImage1, 190, 120, this);
			break;

		    case 2: //divide the shape by drawing rectangles
			g.setFont (textFont);
			g.setColor (Color.black);
			g.drawString ("Example: Find the area of the following shape.", 170, 110);
			g.drawString ("Method 1: Divide the shape into smaller shapes that you know well.", 180, 340);
			g.drawImage (lesImage1, 190, 120, this);
			g.setColor (Color.lightGray);
			g.fillRect (195, 142, 31, 68);
			g.fillRect (195, 212, 82, 70);
			g.setColor (Color.red);
			g.fillRect (193, 210, 35, 2);
			g.drawString ("A1", 200, 185);
			g.drawString ("A2", 225, 250);
			break;

		    case 3: //animation
			g.setFont (textFont);
			g.setColor (Color.black);
			g.drawString ("Example: Find the area of the following shape.", 170, 110);
			g.drawString ("Method 1: Divide the shape into smaller shapes that you know well.", 180, 340);
			g.setColor (Color.lightGray);
			g.fillRect (195, 142, 31, 68);
			g.fillRect (195, 212, 82, 70);
			g.setColor (Color.red);
			g.drawString ("A1", 200, 185);
			g.drawString ("A2", 225, 250);

			//move the first rectangle horizontally by adding values to the x position
			for (int x = 0 ; x <= 100 ; x = x + 5)
			{
			    //covers the previous one
			    g.setColor (Color.white);
			    g.fillRect (195 + x, 142, 31, 68);
			    g.drawString ("A1", 200 + x, 185);

			    //move to the right and draw a new rectangle
			    g.setColor (Color.lightGray);
			    g.fillRect (200 + x, 142, 31, 68);
			    g.setColor (Color.red);
			    g.drawString ("A1", 205 + x, 185);

			    try
			    {
				//pause for 0.005s
				Thread.sleep (40);
			    }
			    catch (InterruptedException ex)
			    {
			    }
			}

			//move the first rectangle vertically by adding values to the y position
			for (int x = 0 ; x >= -10 ; x = x - 2)
			{
			    g.setColor (Color.white);
			    g.fillRect (300, 142 + x, 31, 68);
			    g.drawString ("A1", 305, 185 + x);

			    g.setColor (Color.lightGray);
			    g.fillRect (300, 140 + x, 31, 68);
			    g.setColor (Color.red);
			    g.drawString ("A1", 305, 183 + x);

			    try
			    {
				Thread.sleep (40);
			    }
			    catch (InterruptedException ex)
			    {
			    }
			}

			//move the second rectangle
			for (int x = 0 ; x <= 280 ; x = x + 5)
			{
			    g.setColor (Color.white);
			    g.fillRect (195 + x, 212, 82, 70);
			    g.drawString ("A2", 225 + x, 250);

			    g.setColor (Color.lightGray);
			    g.fillRect (200 + x, 212, 82, 70);
			    g.setColor (Color.red);
			    g.drawString ("A2", 230 + x, 250);

			    try
			    {
				Thread.sleep (40);
			    }
			    catch (InterruptedException ex)
			    {
			    }
			}

			for (int x = 0 ; x >= -80 ; x = x - 2)
			{
			    g.setColor (Color.white);
			    g.fillRect (480, 212 + x, 82, 70);
			    g.drawString ("A2", 510, 250 + x);

			    g.setColor (Color.lightGray);
			    g.fillRect (480, 210 + x, 82, 70);
			    g.setColor (Color.red);
			    g.drawString ("A2", 510, 248 + x);

			    try
			    {
				Thread.sleep (40);
			    }
			    catch (InterruptedException ex)
			    {
			    }
			}
			g.drawImage (lesImage1, 190, 120, this); //display the original image
			g.setColor (Color.lightGray);
			g.fillRect (300, 130, 31, 68);
			g.setColor (Color.red);
			g.drawString ("A1", 305, 173);
			break;

		    case 4: //display the calculation of individual part
			g.setFont (textFont);
			g.setColor (Color.black);
			g.drawString ("Example: Find the area of the following shape.", 170, 110);
			g.drawString ("Then, calculate the area of all the smaller shapes.", 180, 340);
			g.drawImage (lesImage1, 190, 120, this);
			g.setColor (Color.lightGray);
			g.fillRect (300, 130, 31, 68);
			g.fillRect (480, 130, 82, 70);
			g.setColor (Color.red);
			g.drawString ("A1", 305, 173);
			g.drawString ("A2", 510, 168);

			g.setFont (solutionFont);
			g.setColor (Color.black);
			g.drawString ("A1 = w × h", 350, 140);
			g.drawString ("      = 2 cm × 5 cm", 350, 160);
			g.drawString ("      = 10 cm²", 350, 180);
			g.drawString ("A2 = s²", 580, 140);
			g.drawString ("      = (6 cm)²", 580, 160);
			g.drawString ("      = 36 cm²", 580, 180);
			break;

		    case 5: //diaplay the calculation of finding the total area
			g.setFont (textFont);
			g.setColor (Color.black);
			g.drawString ("Example: Find the area of the following shape.", 170, 110);
			g.drawString ("Finally, add them together.", 180, 340);
			g.drawImage (lesImage1, 190, 120, this);
			g.setColor (Color.lightGray);
			g.fillRect (300, 130, 31, 68);
			g.fillRect (480, 130, 82, 70);
			g.setColor (Color.red);
			g.drawString ("A1", 305, 173);
			g.drawString ("A2", 510, 168);
			g.setFont (solutionFont);
			g.setColor (Color.black);
			g.drawString ("A1 = w × h", 350, 140);
			g.drawString ("      = 2 cm × 5 cm", 350, 160);
			g.drawString ("      = 10 cm²", 350, 180);
			g.drawString ("A2 = s²", 580, 140);
			g.drawString ("      = (6 cm)²", 580, 160);
			g.drawString ("      = 36 cm²", 580, 180);
			g.drawString ("A = A1 + A2", 450, 240);
			g.drawString ("    = 10 cm² + 36 cm²", 450, 260);
			g.drawString ("    = 46 cm²", 450, 280);
			g.drawString ("The total area is 46 cm²", 450, 300);
			break;

		    case 6: //introduction page, explain the second method
			g.setFont (textFont);
			g.setColor (Color.black);
			g.drawString ("Method 2:", 170, 110);
			g.drawString ("        To find the area of irregular shapes, you fill up the irregular shape ", 170, 140);
			g.drawString ("to make a regular shape that you can recognize such as triangles, rectangles, ", 170, 170);
			g.drawString ("circles, squares and so forth. . .", 170, 200);
			g.drawString ("        Then, find the area of these individual shapes and subtract the part ", 170, 235);
			g.drawString ("that wasn't there before.", 170, 265);
			break;

		    case 7: //display the example problem
			g.setFont (textFont);
			g.setColor (Color.black);
			g.drawString ("Example: Find the area of the following shape.", 170, 110);
			g.drawString ("Method 2: Fill up to make a regular shape.", 180, 340);
			g.drawImage (lesImage1, 190, 120, this);
			break;

		    case 8: //display solution
			g.setFont (textFont);
			g.drawString ("Example: Find the area of the following shape.", 170, 110);
			g.drawImage (lesImage1, 190, 120, this);
			g.setColor (Color.lightGray);
			g.fillRect (228, 142, 48, 68);
			g.setColor (Color.red);
			g.fillRect (228, 140, 48, 2);
			g.fillRect (276, 140, 2, 71);
			g.drawString ("A1", 225, 250);
			g.drawString ("A2", 240, 185);
			g.setColor (Color.black);
			g.drawString ("Method 2: Fill up to make a regular shape.", 180, 340);
			break;

		    case 9: //animation
			g.setFont (textFont);
			g.setColor (Color.black);
			g.drawString ("Example: Find the area of the following shape.", 170, 110);
			g.setColor (Color.lightGray);
			g.fillRect (195, 142, 82, 140); //a1
			g.fillRect (230, 142, 46, 68); //a2
			g.setColor (Color.red);
			g.fillRect (228, 210, 48, 2);
			g.fillRect (228, 142, 2, 70);
			g.drawString ("A1", 225, 250);
			g.drawString ("A2", 240, 185);

			//move the second rectangle
			for (int x = 0 ; x <= 325 ; x = x + 5)
			{
			    g.setColor (Color.white);
			    g.fillRect (230 + x, 142, 46, 68);
			    g.drawString ("A2", 240 + x, 185);

			    g.setColor (Color.lightGray);
			    g.fillRect (235 + x, 142, 46, 68);
			    g.setColor (Color.red);
			    g.drawString ("A2", 245 + x, 185);

			    try
			    {
				Thread.sleep (40);
			    }
			    catch (InterruptedException ex)
			    {
			    }
			}
			g.setColor (Color.lightGray);
			g.fillRect (195, 142, 82, 140); //a1
			g.drawString ("A1", 225, 220);

			for (int x = 0 ; x <= 120 ; x = x + 5)
			{
			    g.setColor (Color.white);
			    g.fillRect (195 + x, 142, 82, 140);
			    g.drawString ("A1", 225 + x, 220);

			    g.setColor (Color.lightGray);
			    g.fillRect (200 + x, 142, 82, 140);
			    g.setColor (Color.red);
			    g.drawString ("A1", 230 + x, 220);

			    try
			    {
				Thread.sleep (40);
			    }
			    catch (InterruptedException ex)
			    {
			    }
			}
			g.drawImage (lesImage1, 190, 120, this); //display the orignial image

			break;

		    case 10: //display the calculation
			g.setFont (textFont);
			g.drawString ("Example: Find the area of the following shape.", 170, 110);
			g.drawString ("Then, calculate the area of all the smaller shapes.", 180, 340);
			g.drawImage (lesImage1, 190, 120, this);
			g.setColor (Color.lightGray);
			g.fillRect (320, 142, 82, 140);
			g.fillRect (560, 142, 46, 68);
			g.setColor (Color.red);
			g.drawString ("A1", 350, 220);
			g.drawString ("A2", 570, 185);

			g.setFont (solutionFont);
			g.setColor (Color.black);
			g.drawString ("A1 = w × h", 420, 150);
			g.drawString ("      = 6 cm × ( 5 cm +6 cm)", 420, 170);
			g.drawString ("      = 66 cm²", 420, 190);
			g.drawString ("A2 = w × h", 620, 150);
			g.drawString ("      = 4 cm × 5 cm", 620, 170);
			g.drawString ("      = 20 cm²", 620, 190);
			break;

		    case 11: //display the calculation
			g.setFont (textFont);
			g.drawString ("Example: Find the area of the following shape.", 170, 110);
			g.drawString ("Finally, subtract the area that we added at the beginning.", 180, 340);
			g.drawImage (lesImage1, 190, 120, this);
			g.setColor (Color.lightGray);
			g.fillRect (320, 142, 82, 140); //a1
			g.fillRect (560, 142, 46, 68); //a2
			g.setColor (Color.red);
			g.drawString ("A1", 350, 220);
			g.drawString ("A2", 570, 185);

			g.setFont (solutionFont);
			g.setColor (Color.black);
			g.drawString ("A1 = w × h", 420, 150);
			g.drawString ("      = 6 cm × ( 5 cm +6 cm)", 420, 170);
			g.drawString ("      = 66 cm²", 420, 190);
			g.drawString ("A2 = w × h", 620, 150);
			g.drawString ("      = 4 cm × 5 cm", 620, 170);
			g.drawString ("      = 20 cm²", 620, 190);
			g.drawString ("A = A1 - A2", 520, 250);
			g.drawString ("    = 66 cm² - 20 cm²", 520, 270);
			g.drawString ("    = 46 cm²", 520, 290);
			g.drawString ("The total area is 46 cm²", 520, 310);
			break;

		    case 12: //display the summary
			g.setFont (textFont);
			g.setColor (Color.black);
			g.drawString ("Summary: ", 170, 110);
			g.drawString ("  Method 1: Divide & Add ", 170, 140);
			g.drawString ("    1). Divide the irregularshpe", 170, 170);
			g.drawString ("    2). Calculate the area of individual part", 170, 200);
			g.drawString ("    3). Sum up to find the total area", 170, 230);
			g.drawString ("  Method 2: Fill up & Subtract ", 170, 270);
			g.drawString ("    1). Fill up the irregularshpe", 170, 300);
			g.drawString ("    2). Calculate the area of individual part", 170, 330);
			g.drawString ("    3). Subtract the area that wasn't there before", 170, 360);
			g.drawImage (lesImage2, 550, 120, this);
			break;
		}
		break;

		//QUIZ
	    case 3:
		g.setFont (titleFont);
		g.drawString ("Quiz", 430, 60);

		switch (quizNum) //display different questions
		{
			//fill in the blank question
		    case 1:
			g.setFont (textFont);
			g.drawString ("1. Find the area of the shape below.", 180, 110);
			g.drawString (" cm²", 285, 315);
			g.drawImage (quizImage1, 190, 120, this);

			if (checkBoo == false)
			{
			}
			else if (checkBoo == true)
			{
			    try
			    {
				//get text from the textbox, check the answer
				if (Integer.parseInt (txt.getText ()) == 65) //if the answer is correct
				{
				    g.setColor (Color.green);
				    g.drawString ("Correct! Go to the next question! :) ", 430, 315); //display the feedback message
				    g.drawImage (correctImage, 500, 120, this);
				}
				else //if the answer is wrong
				{
				    g.setColor (Color.red);
				    g.drawString ("Wrong! The correct answer is 65.", 430, 315); //display the feedback message and the correct answer
				}
			    }
			    catch (NumberFormatException t)  //validation, the user can only enter numbers
			    {
				JOptionPane.showMessageDialog (null, "Please enter a NUMBER!", "Exception or Error", 0);
				txt.setText ("0");
			    }
			    checkBoo = false;
			}
			break;

		    case 2:
			g.setFont (textFont);
			g.drawString ("2. Find the area of the shape below.", 180, 110);
			g.drawString (" cm²", 285, 315);
			g.drawImage (quizImage2, 210, 120, this);

			if (checkBoo == false)
			{
			}
			else if (checkBoo == true)
			{
			    try
			    {
				if (Integer.parseInt (txt.getText ()) == 84)
				{
				    g.setColor (Color.green);
				    g.drawString ("Correct! Go to the next question! :) ", 430, 315);
				    g.drawImage (correctImage, 500, 120, this);
				}
				else
				{
				    g.setColor (Color.red);
				    g.drawString ("Wrong! The correct answer is 84.", 430, 315);
				}
			    }
			    catch (NumberFormatException t)
			    {
				JOptionPane.showMessageDialog (null, "Please enter a NUMBER!", "Exception or Error", 0);
				txt.setText ("0");
			    }
			    checkBoo = false;
			}
			break;

		    case 3:
			g.setFont (textFont);
			g.drawString ("3. Find the area of the shape below.", 180, 110);
			g.drawString (" m²", 285, 315);
			g.drawImage (quizImage3, 210, 120, this);
			if (checkBoo == false)
			{
			}
			else if (checkBoo == true)
			{
			    try
			    {
				if (Integer.parseInt (txt.getText ()) == 568)
				{
				    g.setColor (Color.green);
				    g.drawString ("Correct! Go to the next question! :) ", 430, 315);
				    g.drawImage (correctImage, 500, 120, this);
				}
				else
				{
				    g.setColor (Color.red);
				    g.drawString ("Wrong! The correct answer is 568.", 430, 315);
				}
			    }
			    catch (NumberFormatException t)
			    {
				JOptionPane.showMessageDialog (null, "Please enter a NUMBER!", "Exception or Error", 0);
				txt.setText ("0");
			    }
			    checkBoo = false;
			}
			break;

		    case 4:
			g.setFont (textFont);
			g.drawString ("4. Find the area of the shape below.", 180, 110);
			g.drawString (" m²", 285, 315);
			g.drawImage (quizImage4, 210, 120, this);
			if (checkBoo == false)
			{
			}
			else if (checkBoo == true)
			{
			    try
			    {
				if (Integer.parseInt (txt.getText ()) == 22)
				{
				    g.setColor (Color.green);
				    g.drawString ("Correct! Go to the next question! :) ", 430, 315);
				    g.drawImage (correctImage, 500, 120, this);
				}
				else
				{
				    g.setColor (Color.red);
				    g.drawString ("Wrong! The correct answer is 22.", 430, 315);
				}
			    }
			    catch (NumberFormatException t)
			    {
				JOptionPane.showMessageDialog (null, "Please enter a NUMBER!", "Exception or Error", 0);
				txt.setText ("0");
			    }
			    checkBoo = false;
			}
			break;

		    case 5:
			g.setFont (textFont);
			g.drawString ("5. Find the area of the shape below.", 180, 110);
			g.drawString (" m²", 285, 315);
			g.drawImage (quizImage5, 210, 120, this);
			if (checkBoo == false)
			{
			}
			else if (checkBoo == true)
			{
			    try
			    {
				if (Integer.parseInt (txt.getText ()) == 84)
				{
				    g.setColor (Color.green);
				    g.drawString ("Correct! Go to the next question! :) ", 430, 315);
				    g.drawImage (correctImage, 500, 120, this);
				}
				else
				{
				    g.setColor (Color.red);
				    g.drawString ("Wrong! The correct answer is 84.", 430, 315);
				}
			    }
			    catch (NumberFormatException t)
			    {
				JOptionPane.showMessageDialog (null, "Please enter a NUMBER!", "Exception or Error", 0);
				txt.setText ("0");
			    }
			    checkBoo = false;
			}
			break;
		}
		break;
	}
    }


    public void actionPerformed (ActionEvent evt)
    {
	//PAGE NUMBER CONTROL
	if (evt.getSource () == homepage) //if the homepage button is clicked
	{
	    pageNum = 0; //set pagenumber equal to 0
	    homepage (); //call the homepage method, display or hide buttons
	    repaint ();
	}
	else if (evt.getSource () == warmup)
	{
	    pageNum = 1;
	    warmup ();
	    repaint ();
	}
	else if (evt.getSource () == lesson)
	{
	    pageNum = 2;
	    lesson ();
	    repaint ();
	}
	else if (evt.getSource () == quiz)
	{
	    pageNum = 3;
	    quiz ();
	    repaint ();
	}

	//CHECKBOX CONTROL
	if (a.getState () == true) //if the option a is selected
	    answerNum = 1; //set answer number equal to 1
	else if (b.getState () == true)
	    answerNum = 2;
	else if (c.getState () == true)
	    answerNum = 3;
	else if (d.getState () == true)
	    answerNum = 4;

	//CHECK CONTROL
	if (evt.getSource () == check) //if check button is clicked
	{
	    checkBoo = true; //set check boolean equal to true
	    repaint ();
	}

	//WARMUP QUESTION NUMBER CONTROL
	//click the next button to go to the next question
	if (wpNum >= 1 && wpNum < 4 && correctBoo == true) //the user can only go to the next question if he gets the correct answer
	    if (evt.getSource () == next) //if the next button is clicked
	    {
		wpNum++; //counter number increase by 1
		correctBoo = false; //reset the correct boolean so that the user cannot keep going to the next question
		repaint ();
	    }

	//click the back button to go to the previous question
	if (wpNum > 1 && wpNum <= 4) //the user can go back whenever he needs
	    if (evt.getSource () == back) //if the back button is clicked
	    {
		wpNum--; //counter number decrease by 1
		correctBoo = false; //reset the correct boolean
		repaint ();
	    }

	//LESSON STEP NUMBER CONTROL
	if (lesNum >= 0 && lesNum < 12)
	    if (evt.getSource () == next)
	    {
		lesNum++;
		repaint ();
	    }

	if (lesNum > 0 && lesNum <= 12)
	    if (evt.getSource () == back)
	    {
		lesNum = lesNum - 1;
		repaint ();
	    }

	//QUIZ QUESTION NUMBER CONTROL
	if (quizNum >= 1 && quizNum < 5)
	    if (evt.getSource () == next)
	    {
		quizNum++;
		txt.setText ("0");
		repaint ();
	    }

	if (quizNum > 1 && quizNum <= 5)
	    if (evt.getSource () == back)
	    {
		quizNum--;
		txt.setText ("0");
		repaint ();
	    }
    }
}


