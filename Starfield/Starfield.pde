Star[] stars = new Star[800];

void setup(){
  size(800, 800);
  background(0);
  for(int i = 0; i < stars.length; i++){
   stars[i] = new Star();
  }
  
}


void draw(){
    clear();
    translate(400,400);
    for(int i = 0; i < stars.length; i++){
      stars[i].display();
      stars[i].update();
    }
}

class Star{

  float x;
  float y;
  float d;
  int spd = 10;
  
  float initialx;
  float initialy;
  
  public Star(){
    x = random(-width, width);
    y = random(-height, height);
    initialx = x;
    initialy = y;
    d = random(width);
  }
  
  void update(){
    d-=spd;
    if(d < 0){
      d = random(width);
      x = random(-width, width);
      y = random(-height, height);
      initialx = x;
      initialy = y;
    }
  }
  
  void display(){
    noStroke();
    fill(255);
    
    float sx = map(x/d, 0, 1, 0, width);
    float sy = map(y/d, 0, 1, 0, height);
    float r = map(d, width, 0, 0, 16);
    ellipse(sx, sy, r, r);
    /*if(sx < width && sy < height){
      stroke(255);
      strokeWeight(4);
      line(initialx, initialy, sx, sy);
    }*/
    
  }  
  
}
