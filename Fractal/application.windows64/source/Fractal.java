import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import controlP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Fractal extends PApplet {

//uses sliders from controlP5


ControlP5 controller;
int branches = 2;
float angle = PI/3;
int startLen = 100;
float proportion = 2;
int sliderHeight = 15;

public void setup(){
  
  background(0);
  stroke(255);
  
  push();
  translate(width/2,height);
  controller = new ControlP5(this);
  /*controller.addSlider("branches")
  .setRange(2, 4)
  .setPosition(0,0)
  .snapToTickMarks(true)
  .setNumberOfTickMarks(1)
  .setHeight(sliderHeight);*/
  
  
  controller.addSlider("angle")
  .setRange(0, 2*PI)
  .setPosition(0, sliderHeight)
  .setSliderMode(Slider.FLEXIBLE)
  .setHeight(sliderHeight);
  
  controller.addSlider("startLen")
  .setRange(50, 600)
  .setSliderMode(Slider.FLEXIBLE)
  .setPosition(0, sliderHeight*2)
  .setHeight(sliderHeight);
  
  controller.addSlider("proportion")
  .setRange(1.5f, 3)
  .setSliderMode(Slider.FLEXIBLE)
  .setPosition(0, sliderHeight*3)
  .setHeight(sliderHeight);
  pop();
}

public void draw(){
  clear();
  push();
  translate(width/2, height);
  branch(startLen);
  /*line(0, 0, 0, -startLen);
  translate(0, -startLen);
  rotate(PI/3);
  line(0, 0, 0, -startLen/2);*/
  pop();
}

public void branch(float len){
  if(len < 1){return;}
  line(0, 0, 0, -len);
  translate(0, -len);
  float newLen = len/proportion;
  
  for(int i = 1; i <= branches/2; i++){
    push();
    rotate(angle*i);
    branch(newLen);
    pop();
    push();
    rotate(-angle*i);
    branch(newLen);
    pop();
  }
}



  public void settings() {  size(800, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Fractal" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
