package ie.tudublin;

import processing.core.PApplet;
import java.util.ArrayList;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	ArrayList<Task> tasks = new ArrayList<Task>();

	
	float taskBorder;
	float gantBorder;
	
	float bh;
	float end;
	public void settings()
	{
		size(800, 600);

		taskBorder = width * 0.05f;
		gantBorder = width * 0.2f;

		bh = 20;
		end=width-20;
	}

	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header");
        for(TableRow row:table.rows())
        {
            Task ts = new Task(row);
            tasks.add(ts);
        }
	}

	public void printTasks()
	{
		for(Task ts:tasks)
        {
            System.out.println(ts);
        }
	}
	
	public void displayTasks()
	{
		int y=50;
		int space=50;
		int gantSize=30;
		int it=0;
		float blocksize;
		for(int i=1;i<gantSize+1;i++)
		{
			fill(255);
			text(i,map(i,0,gantSize,gantBorder,end),10);
			stroke(155);
			line(map(i,0,gantSize,gantBorder,end),15,map(i,0,gantSize,gantBorder,end),height-80);
		}
		for(Task ts:tasks)
		{
			fill(255);
			text(ts.getTask(),taskBorder,y);
			fill(map(it,0,tasks.size(),0,255),255,255);
			blocksize=map(ts.getEnd()-ts.getStart(),0,gantSize,0,end);
			rect(map(ts.getStart(),0,gantSize,gantBorder,end), y-10, blocksize , bh);
			y+=space;
			it++; 
		}
		
	}

	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
		colorMode(HSB);
	}
	
	public void draw()
	{			
		background(0);
		displayTasks();
	}
}
