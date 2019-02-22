package test.pattern.creator;

public class ActorController {
    //逐步构建复杂产品对象
    public Actor construct(ActorBuilder ab) {
        Actor actor;
        ab.buildCostume();
        ab.buildFace();
        ab.buildHairstyle();
        ab.buildSex();
        ab.buildType();
        actor = ab.createActor();
        return actor;
    }
}
