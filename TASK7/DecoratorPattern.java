interface Shape 
{
   void draw();
}

class Circle implements Shape 
{

   @Override
   public void draw() 
   {
      System.out.println("Circle");
   }
}
class ShapeDecorator implements Shape 
{
   protected Shape decoratedShape;

   public ShapeDecorator(Shape decoratedShape)
   {
      this.decoratedShape = decoratedShape;
   }

   public void draw()
   {
      decoratedShape.draw();
   }	
}


class DecoratorPattern 
{
    public static void main(String[] args) 
    {
        ShapeDecorator testShape = new ShapeDecorator(new Circle());
        testShape.draw();
    }
}