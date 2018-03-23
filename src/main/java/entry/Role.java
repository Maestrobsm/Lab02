package entry;

public class Role {

    private String name;
    private Integer id;
    private Integer read;
    private Integer write;

    public Role(){
    }

    public Role(String name, Integer id, Integer read, Integer write) {
        this.name = name;
        this.id = id;
        this.read = read;
        this.write = write;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }

    public Integer getWrite() {
        return write;
    }

    public void setWrite(Integer write) {
        this.write = write;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", read=" + read +
                ", write=" + write +
                '}';
    }
}
