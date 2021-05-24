public class NBody {

    public static double readRadius(String fn){

        In file = new In(fn);
        file.readInt();
        double secondLine = file.readDouble();
        file.close();
        return secondLine;

    }

    public static Body[] readBodies(String fn){

        In file = new In(fn);
        Body[] bodies = new Body[5];
        int i = 0;
        file.readInt();
        file.readDouble();

        while(i < 5){
    
            double xP = file.readDouble();
            double yP = file.readDouble();
            double xV = file.readDouble();
            double yV = file.readDouble();
            double m = file.readDouble();
            String img = file.readString();
            bodies[i] = new Body(xP,yP,xV,yV,m,img);
            i++;

        }

        file.close();

        return bodies;
    }


}
