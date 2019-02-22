package test.pattern.creator;

public abstract class ActorBuilder {
    //创建产品对象
    protected Actor actor = new Actor();

    public abstract void buildType();
    public abstract void buildSex();
    public abstract void buildFace();
    public abstract void buildCostume();
    public abstract void buildHairstyle();
    
    //返回一个完整的角色对象
    public Actor createActor() {
        return actor;
    };
}
