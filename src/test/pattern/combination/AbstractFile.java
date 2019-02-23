package test.pattern.combination;

public abstract class AbstractFile {
    public abstract void add(AbstractFile file);
    public abstract void remove(AbstractFile file);
    public abstract AbstractFile getChile(int index);
    public abstract void killVirus();
}
