
public class Body{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(Body b){

        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;

    }

    public Body(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public double calcDistance(Body b){
        //this method will take the distance between two bodies.
        //will take a single body should return a double equal to the 
        //distance between the supplied body and the body that is doint the calculation 

        double dX = b.xxPos - this.xxPos;
        double dY = b.yyPos - this.yyPos;

        double displacement = Math.pow(dX,2) + Math.pow(dY,2);


        return Math.sqrt(displacement);

    }

    public double calcForceExertedBy(Body b){
        return ((6.67e-11)*(b.mass)*(this.mass))/(Math.pow(this.calcDistance(b),2));
    }

    

}