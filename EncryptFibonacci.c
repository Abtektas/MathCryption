#include<stdio.h>
 
int main()
{
    char message[53], letter;
    int i;
    int fibonacci[] = {0,1,1,2,3,5,8,1,3,2,1,3,4,5,5,8,9,1,4,4,2,3,3,3,7,7,6,1,0,9,8,7,1,5,9,7,2,5,8,4,4,1,8,1,6,7,6,5,1,0,9,4,6};

    printf("Input message: ");
    gets(message);
    
    for(i = 0; message[i] != '\0'; ++i){
        letter = message[i];
        
        if(letter >= 'a' && letter <= 'z'){             

            letter = letter + fibonacci[i];
            
            if(letter > 'z'){
                letter = letter - 'z' + 'a' - 1;
            }
            
            message[i] = letter;
        }
        else if(letter >= 'A' && letter <= 'Z'){
            letter = letter + fibonacci[i];
            
            if(letter > 'Z'){
                letter = letter - 'Z' + 'A' - 1;
            }
            
            message[i] = letter;
        }
    }
    
    printf("Encrypted message: %s\n", message);
    
    return 0;
}