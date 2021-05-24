
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

    public double calcForceExertedByX(Body b){

        double dispX = b.xxPos - this.xxPos;
        double netForce = this.calcForceExertedBy(b);

        return (netForce*dispX)/(this.calcDistance(b));


    }

    public double calcForceExertedByY(Body b){
        double dispY = b.yyPos - this.yyPos;
        double netForce = this.calcForceExertedBy(b);

        return (netForce*dispY)/(this.calcDistance(b));

    }

    public double calcNetForceExertedByX(Body[] b){
        double netForceX = 0.0;
        for(Body s : b){

            if(this.equals(s)){
                continue;
            }
            
            netForceX += this.calcForceExertedByX(s);
        }

        return netForceX;

    }

    public double calcNetForceExertedByY(Body[] b){
        double netForceY = 0.0;
        for(Body s : b){

            if(this.equals(s)){
                continue;
            }
            
            netForceY += this.calcForceExertedByY(s);
        }

        return netForceY;
        
    }

    //method that determines how much the forces exerted on the body will
    //cause that boy to accelerate
    public void update(double dt, double fX, double fY){

        double vNewX = this.xxVel + dt * (fX / this.mass);
        double vNewY = this.yyVel + dt * (fY / this.mass);
        double pNewX = this.xxPos + dt * vNewX;
        double pNewY = this.yyPos + dt * vNewY;

        xxVel = vNewX;
        yyVel = vNewY;
        xxPos = pNewX;
        yyPos = pNewY;

    }

}