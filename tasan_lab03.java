public class tasan_lab03 {
        public static void main(String[] arg)
        {

                if( arg.length < 2 )
                {
                    System.out.println("format: tasan_lab3 \"input filename\" \"output filename\" \"<output unique sorted words>\"");
                    System.exit(0);
                }


                java.text.DecimalFormat df = new java.text.DecimalFormat("###,###,###,###,###");

                boolean outputWords = false;
                if( arg.length > 2 )
                {
                    if( arg[2].toLowerCase().startsWith("y") || arg[2].toLowerCase().startsWith("t") )
                    {
                        outputWords = true;
                    }
                }

                int countline = 0;
                int countword = 0;
                int countchar = 0;

                try
                {
                    java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(arg[0])));
                    java.io.PrintWriter output = new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.FileWriter(arg[1])));
                    java.util.TreeSet<String> uniqueStrings = new java.util.TreeSet<>();
                    java.util.ArrayDeque<String> stackOfCurrentStrings = new java.util.ArrayDeque<>();

                    String lines;
                    while((lines= input.readLine())!=null )
                    {
                        countline +=1;
                        java.util.StringTokenizer st = new java.util.StringTokenizer(lines, " ");
                        while(st.hasMoreTokens()  )
                        {
                            String token = st.nextToken();
                            countword += 1;
                            countchar += token.length();
                            stackOfCurrentStrings.addLast(token);
                            uniqueStrings.add(token);

                        }


                        while(!stackOfCurrentStrings.isEmpty())
                        {
                            String word = stackOfCurrentStrings.removeLast();
                            char[] word2 = word.toCharArray();
                            for(int i = word2.length -1; i>=0; i--)
                            {
                                output.print(word2[i]);

                            }
                            if(!stackOfCurrentStrings.isEmpty()  )
                            {
                                output.print(" ");
                            }
                        }

                        output.println();

                    }


                    input.close();
                    output.close();


                    System.out.println("line = "+df.format(countline));
                    System.out.println("word = "+df.format(countword));
                    System.out.println("char = "+df.format(countchar));
                    System.out.println("unique words = "+df.format(uniqueStrings.size()));

                    if( outputWords )
                    {
                        for(String w: uniqueStrings)
                        {
                            System.out.println(w);
                        }
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e.toString());
                    System.exit(0);
                }
            }
        }




