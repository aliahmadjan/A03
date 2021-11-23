import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.StringTokenizer;
import java.util.Vector;
public class FileHandling implements Runnable {
    private String filename;
    private Vector<String> token;
    private BST bst;

    public FileHandling(String fname) {
        this.filename=fname;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Vector<String> getToken() {
        return token;
    }

    public void setToken(Vector<String> token) {
        this.token = token;
    }

    public BST getBst() {
        return bst;
    }

    public void setBst(BST bst) {
        this.bst = bst;
    }
    @Override
    public void run()
    {
        synchronized (this)
        {
            try{
               // System.out.println("Working Directory = "+ System.getProperty("user.dir"));
                String Dir=System.getProperty("user.dir");
                Path path= Paths.get(Dir,filename);
                File file=path.toFile();

                BufferedReader reader= new BufferedReader(new FileReader(file));
                String str;
                if(filename.equals("vocab.txt") && filename.equals("inputfile1.txt"))
                {
                    bst=new BST();
                    while((str=reader.readLine()) != null)
                    {
                        StringTokenizer token1=new StringTokenizer(str," ");
                        while(token1.hasMoreElements())
                        {
                            bst.insert(token1.nextToken());
                        }
                    }
                }
                    else{
                        token=new Vector<String>();
                        while((str= reader.readLine()) !=null)
                        {
                            StringTokenizer token2=new StringTokenizer(str," ");
                            while(token2.hasMoreElements())
                            {
                                token.add(token2.nextToken());
                            }
                        }
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    public void DiplayingVectors()
    {
        if(token!=null)
       {
            System.out.println("Tokens in " +filename + "are "+token);
        }
    }

    public void DisplayingBST()
    {
        if(bst!=null)
        {
            bst.inorder();
        }
    }


        public void MatchingWords(BST bst1,ArrayList<Word> words)
        {
            for(int i=0;i<token.size();i++)
            {
                System.out.println("Hello");
                if(bst1.search(token.get(i)))

                {
                    System.out.println("Hello");
                    boolean found=false;
                    for(int j=0;j< words.size();j++)
                    {
                        if(words.get(j).getWord().equals(token.get(i)))
                        {
                            found=true;
                            words.get(j).IncreaseFrequecy();
                        }
                    }
                    if(found==false)
                    {
                        Word w=new Word(token.get(i),1);
                        words.add(w);
                    }
                }
            }
        }

}
