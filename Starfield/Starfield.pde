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
