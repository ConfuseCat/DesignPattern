package AccessDataStructure.Visitor;

public class VisitorMain {
    public static void main(String[] args){
        try{
            System.out.println("Making root entries...");
            Directory roordir=new Directory("root");
            Directory bindir=new Directory("bin");
            Directory tmpdir=new Directory("tmp");
            Directory usrdir=new Directory("usr");
            roordir.add(bindir);
            roordir.add(tmpdir);
            roordir.add(usrdir);
            bindir.add(new File("vi",10000));
            bindir.add(new File("latex",20000));
            roordir.accept(new ListVisitor());

            System.out.println("");
            System.out.println("Making user entries...");
            Directory yuki=new Directory("yuki");
            Directory hanako=new Directory("hanako");
            Directory tomura=new Directory("tomura");
            usrdir.add(yuki);
            usrdir.add(hanako);
            usrdir.add(tomura);
            yuki.add(new File("diary.html",100));
            yuki.add(new File("Composite.java",300));
            hanako.add(new File("memo.tex",300));
            tomura.add(new File("game.doc",400));
            tomura.add(new File("junk.main",500));
            roordir.accept(new ListVisitor());
        }catch (FileTreatementException e){
            e.printStackTrace();
        }
    }
}
