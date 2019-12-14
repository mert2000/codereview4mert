package sample;

import java.util.ArrayList;

public class ProdNames {
    private String pName;
    private String quantity;
    private String descr;
    private double oldprice;
    private double newprice;
    private String img;

    public ProdNames(String pName, String quantity, String descr, double oldprice, double newprice, String img) {
        this.pName = pName;
        this.quantity = quantity;
        this.descr = descr;
        this.oldprice = oldprice;
        this.newprice = newprice;
        this.img = img;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public double getOldprice() {
        return oldprice;
    }

    public void setOldprice(double oldprice) {
        this.oldprice = oldprice;
    }

    public double getNewprice() {
        return newprice;
    }

    public void setNewprice(double newprice) {
        this.newprice = newprice;
    }

    public ArrayList<String> getImg() {
        ArrayList<String> ar=new ArrayList<>();
        ar.add("/cheese_salakis__600x600.jpg");
        ar.add("/pfeffer__600x600.jpg" );
        ar.add("/voslauer__600x600.jpg");
        ar.add("/zucker__600x600.jpg");
        return ar;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return getpName() + " " + "Old Price:" + getOldprice() + " " + "New Price:" + " " + getNewprice();
    }

}
