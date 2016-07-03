package ecg.imaginatio.subin.miniecg;


public class Smooth {
    public void smooth(double ip[],double op[])
    {
        op[0]=ip[0];
        op[1]=(ip[0]+ip[1]+ip[2])/3;
        for(int i=2;i<1998;i++){
            op[i]=(ip[i-2]+ip[i-1]+ip[i]+ip[i+1]+ip[i+2])/5;
        }
        op[1999]=(ip[1997]+ip[1998]+ip[1999])/3;
        op[1998]=(ip[1996]+ip[1997]+ip[1998])/3;

    }
}
