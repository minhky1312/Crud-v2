package pack;

public class City {
    public int id;
    public String sname;
    public String name;
    public String area;
    public String flag;

    public City(int id, String sname, String name, String area, String flag )
    {
        this.id = id;
        this.sname = sname;
        this.name = name;
        this.area = area;
        this.flag = flag;
    }

    public int getId() { return this.id;}

    public String getName() {
        return this.name;
    }

    public String getsName() {
        return this.sname;
    }

    public String getArea() {
        return this.area;
    }

    public String getFlag() {
        return this.flag;
    }

    @Override
    public String toString() {
        return this.name;
    }




}
