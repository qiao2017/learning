package test.pattern.creator;

public class Actor {
    private String type;//定义部件，部件可以是任意类型，包括值类型和引用类型
    private String sex;
    private String face;
    private String costume;
    private String hairStyle;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getFace() {
        return face;
    }
    public void setFace(String face) {
        this.face = face;
    }
    public String getCostume() {
        return costume;
    }
    public void setCostume(String costume) {
        this.costume = costume;
    }
    public String getHairStyle() {
        return hairStyle;
    }
    public void setHairStyle(String hairStyle) {
        this.hairStyle = hairStyle;
    }
}
