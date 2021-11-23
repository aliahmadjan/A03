import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

     //   System.out.println("Working Directory = "+ System.getProperty("user.dir"));
        ArrayList<Word> wordArrayList=new ArrayList<Word>();
        List<FileHandling> filehandler= new ArrayList<>();
        List<Thread>thread=new ArrayList<>();

     System.out.println("Length "+args.length);
      if(args.length>0)
       {

        for(int i=0;i< args.length;i++)
        {

               FileHandling FH=new FileHandling(args[i]);
               Thread thread1=new Thread(FH);
               thread1.start();
               filehandler.add(FH);
               thread.add(thread1);

         }
      }

        for(int i=0;i<thread.size();i++)
        {
            try{
                thread.get(i).join();
                System.out.println("Thread Joined");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int i=0;i< filehandler.size();i++)
        {
            if(filehandler.get(i).getFilename().compareTo("vocab.txt")==0)
            {
                for(int j=0;j< filehandler.size();j++)
                {
                    if(filehandler.get(j).getFilename().compareTo("vocab.txt")!=0)
                    {

                        filehandler.get(j).MatchingWords(filehandler.get(i).getBst(),wordArrayList);
                    }
                }
            }
        }
        int key = 0;
     //   while (true) {


            System.out.println("1. Displaying BST Build from Vocabulary File");
            System.out.println("2. Displaying vectors build from Input Files");
            System.out.println("3. Viewing Match words and its frequency");
            System.out.println("4. Displaying all files (number and names)  ");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            Scanner input1 = new Scanner(System.in);
            key = input1.nextInt();

            switch (key) {
                case 1:


                    for(int i=0;i< filehandler.size();i++)
                    {

                        if(filehandler.get(i).getFilename().equals("vocab.txt"))
                        {

                            filehandler.get(i).DisplayingBST();
                        }
                    }
                    break;
                case 2:
                    for(int i=0;i<filehandler.size();i++)
                    {
                        System.out.println("hello");
                        if(filehandler.get(i).getFilename().compareTo("vocab.txt")!=0)
                        {
                            System.out.println("ji");
                            filehandler.get(i).DiplayingVectors();
                        }
                    }

                   break;

                case 5:
                    System.exit(0);
            }

        }

   // }

    }



