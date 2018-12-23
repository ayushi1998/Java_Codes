#include <string.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>


void echo_command(char arg[1024][1024])
{


	  
	
	if(strcmp(arg[1],"-n")==0)
	{
		if(strcmp(arg[2],"end")==0)
      	{
      		printf("\n");

      	}
      	else{
		int j=2;
		while(strcmp(arg[j],"end")!=0)
		{

		
		char * word;
       
        word= strtok(arg[j],"");
       // printf("%c",word[0]);
        unsigned long len=strlen(word);
        int i=0;
        while(i<len)
        { 
        	//printf("%d\n",strcmp(&word[i],"\"") );
        if(strncmp(&word[i],"\"",1)!=0)
        {

        	//printf("%d\n",i );
             printf("%c",word[i]);
        }
       // word= strtok (NULL, "");  

        i=i+1;
        }
        printf(" ");
        j=j+1; 
		



	    }
         
     }

	}
	else if(strcmp(arg[1],"-E")==0)
	{
		if(strcmp(arg[2],"end")==0)
      	{
      		printf("\n");

      	}
      	else{
		int j=2;
		while(strcmp(arg[j],"end")!=0)
		{

		
		char * word;
       
        word= strtok(arg[j],"");
       // printf("%c",word[0]);
        unsigned long len=strlen(word);
        int i=0;
        while(i<len)
        { 
        	//printf("%d\n",strcmp(&word[i],"\"") );
        if(strncmp(&word[i],"\"",1)!=0)
        {

        	//printf("%d\n",i );
             printf("%c",word[i]);
        }
       // word= strtok (NULL, "");  

        i=i+1;
        }
        printf(" ");
        j=j+1; 
		



	    }
         printf("\n");
     }
}
      else
      {
      	if(strcmp(arg[1],"end")==0)
      	{
      		printf("\n");

      	}
      	else
      	{
        int j=1;
		while(strcmp(arg[j],"end")!=0)
		{

		
		char * word;
       
        word= strtok(arg[j],"");
       // printf("%c",word[0]);
        unsigned long len=strlen(word);
        int i=0;
        while(i<len)
        { 
        	//printf("%d\n",strcmp(&word[i],"\"") );
        if(strncmp(&word[i],"\"",1)!=0)
        {

             printf("%c",word[i]);
        }

        i=i+1;
        }
        printf(" ");
        j=j+1; 
		



	    }
         printf("\n");
       }
   }
	

}


void pwd(char directory[])   // The current working directory passed by value
{
	
	getcwd(directory, 1024);

}

int main ()
{

  char directory[1024];

  char hist[1024][1024];
  int his_i=0;

  while(1)
{	
  char input[1024];
  char prev_directory[1024];
  gets(input); 
  char * word;
  strcpy(hist[his_i],input);
   his_i=his_i+1;
 char *present;

 
  char arg[1024][1024];
  char *argv[1024];  
  
  word= strtok (input," ");

  int i=0;

      while(word!= NULL)
     { 
        strcpy(arg[i],word);
        argv[i]=word;  // Words array

        word= strtok (NULL, " "); 
   
        
        i=i+1;
     } 

     strcpy(arg[i],"end");
     pwd(directory);
     argv[i]=directory;
     


         if(strcmp(arg[0],"pwd")==0)
         {
    	    pwd(directory);
    	    printf("%s\n", directory);
    	    argv[i]=directory;
         }

        else if(strcmp(arg[0],"cd")==0)
        {  
    	  const char *target_directory = (arg[1]);
    	

    	  if((strcmp(target_directory,"end")==0) || (strcmp(target_directory,"~")==0) )
    	  {
    	  	present=directory;
    	  	//printf("%s\n",present );
    	  	chdir(getenv("HOME"));
    	  	pwd(directory);


    	  }
    	  else if((strcmp(target_directory,"-")==0))
    	  {
    	  	 
    	  	char* togdir=directory;
    	  	//printf("%s\n",present );
    	  	chdir(present);
    	  	present=togdir;


    	  	

    	  }
    	  else if(chdir(target_directory) == 0) 
    	  {
    	  	present=directory;
            getcwd(directory, sizeof(directory));
            printf("Present in %s\n", directory);
            argv[i]=directory;
          }
           
           else
          {
          	printf("%s\n","Directory doesn't exist." );

        
          }

         }

        else if(strcmp(arg[0],"exit")==0)
        {
    	     break;
        }

        else if(strcmp(arg[0],"echo")==0)
        {
            echo_command(arg);
		  

        }
       

        else if(strcmp(arg[0],"history")==0)
        {
        	//printf("%s\n",arg[2] );

        	if(strcmp(arg[1],"end")==0)
        	{
        		//printf("%s\n","hi" );
        		
        		for(int j=0;j<his_i;j++)
        		{
        			printf("%s\n",hist[j] );

        		}
        	}

        	if(strcmp(arg[1],"-c")==0)
        	{

        		his_i=0;


        	}



        }
        else if(strcmp(arg[0],"date")==0)
        {
	         int id=fork();

			 if(id==0)
			  {

				printf("%d",execve("/Users/ayushi/Desktop/OS/date",argv,NULL));

				exit(1);

			  }

			 else
			  {
				wait(NULL);
			  }
			 
			
		}

		else if(strcmp(arg[0],"cat")==0)
		{
			int id=fork();

			 if(id==0)
			  {

				printf("%d",execve("/Users/ayushi/Desktop/OS/cat",argv,NULL));

				exit(1);

			  }

			 else
			  {
				wait(NULL);
			  }
		}
		else if(strcmp(arg[0],"ls")==0)
		{
			int id=fork();

			 if(id==0)
			  {

				printf("%d",execve("/Users/ayushi/Desktop/OS/ls",argv,NULL));

				exit(1);

			  }

			 else
			  {
				wait(NULL);
			  }
		}
		else if(strcmp(arg[0],"rm")==0)
		{
			int id=fork();

			 if(id==0)
			  {

				printf("%d",execve("/Users/ayushi/Desktop/OS/rm",argv,NULL));
				exit(1);

			  }

			 else
			  {
				wait(NULL);
			  }
		}
		else if(strcmp(arg[0],"mkdir")==0)
		{
			int id=fork();

			 if(id==0)
			  {

				printf("%d",execve("/Users/ayushi/Desktop/OS/mkdir",argv,NULL));
				exit(1);

			  }

			 else
			  {
				wait(NULL);
			  }
		}
       



  }

  return 0;

}
