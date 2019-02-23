package test.pattern.combination;

import java.util.ArrayList;

//文件夹类，容器构件
public class Folder extends AbstractFile{
    //定义集合filelist, 用于存储该文件夹下AbstractFile类型的成员
    private ArrayList<AbstractFile> filelist = new ArrayList<>();
    private String name;
    
    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        filelist.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        filelist.remove(file);
    }

    @Override
    public AbstractFile getChile(int index) {
        return filelist.get(index);
    }

    @Override
    public void killVirus() {
        //模拟杀毒
        System.out.println("---对文件夹 '" + name + "' 进行杀毒");
        
        //递归调用成员构件的killVirus方法
        for(AbstractFile file : filelist) {
            file.killVirus();
        }
    }

}
